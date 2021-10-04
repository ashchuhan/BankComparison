package com.ratnaafin.bankcomparison.controller;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.Date;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.BankMaster;
import com.ratnaafin.bankcomparison.entity.Customer;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;
import com.ratnaafin.bankcomparison.service.BankComparisonService;
import com.ratnaafin.bankcomparison.service.BankInterestService;
import com.ratnaafin.bankcomparison.service.BankService;
import com.ratnaafin.bankcomparison.service.CustomerService;
import com.ratnaafin.bankcomparison.service.CutbackService;


@Controller
@RequestMapping("/bankcomparison/list")
public class BankComparisonController {

	@Autowired
	private BankService bankService;

	@Autowired
    private BankComparisonService bankComparisonService;
	
	@Autowired
	private BankInterestService bankInterestService;
	
	@Autowired
	private CutbackService cutbackService;
	
	@Autowired
    private CustomerService customerService;
	
	@GetMapping("/{id}")
	public String listCustomers(@PathVariable("id") Long custId, Model model) {
        List<BankComparison> bankComparisons = bankComparisonService.getBankComparisonByCustId(custId);
        model.addAttribute("custId", custId);
        Customer customer = customerService.getCustomer(custId);
        model.addAttribute("customer", customer);
        List<BankMaster> bankMasters = bankComparisonService.getBankList();
		for (BankComparison bankComparison : bankComparisons) {
			for (BankMaster bankMaster : bankMasters) {
				if (bankComparison.getBankId() == bankMaster.getBankId()) {
					bankComparison.setBankName(bankMaster.getBankName());
					break;
				}
			}
		}
		model.addAttribute("bankComparison", bankComparisons);
		List<BankMaster> list = new ArrayList<BankMaster>();
		for (BankComparison bankComparison : bankComparisons) {
			for (BankMaster bank : bankMasters) {
				if (bank.getBankId() == bankComparison.getBankId()) {
					list.add(bank);
				}

			}
		}
		bankMasters.removeAll(list);
		model.addAttribute("bankList", bankMasters);
		return "bankcomparison-list";
    }
	
	@PostMapping("/save")
    public String saveCustomer(@ModelAttribute("bankcomparison") BankComparison bankComparison) {
		bankComparisonService.saveBankComparison(bankComparison);
        return "redirect:/bankcomparison/list/"+bankComparison.getCustomerId();
    }
	
	@GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("bankcomparisonId") Long comparisonId, Model model) {
		BankComparison bankComparison = bankComparisonService.getBankComparison(comparisonId);
		BankMaster bankMaster = (BankMaster) bankService.getBankByID(bankComparison.getBankId());
		model.addAttribute("bankMaster", bankMaster); 
		model.addAttribute("bankComparisonUpdate", bankComparison);
        return "update-bankcompare";
    }
	

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("comparisonId") Long comparisonId, @RequestParam("customerId") Long customerId) {
    	List<BankInterestMaster> bankInterestMaster = bankInterestService.getBankInterest(customerId, comparisonId);
    	List<CutbackDetails> cutbackDetails = cutbackService.getCutbackDetails(comparisonId);
		if(bankInterestMaster != null && bankInterestMaster.size() > 0) {
			for (BankInterestMaster bankInterestMaster2 : bankInterestMaster) {
				bankInterestService.deleteBankInterest(bankInterestMaster2.getId());
			}
		}
		if(cutbackDetails != null && cutbackDetails.size() > 0) {
			for(CutbackDetails cutbackDetail : cutbackDetails)
			{
				cutbackService.deleteCutbackDetails(cutbackDetail.getId());
			}
		}
    	bankComparisonService.deleteBankComparison(comparisonId);
        return "redirect:/bankcomparison/list/"+customerId;
    }
    
    @GetMapping("/interest")
    public String interestBank(@RequestParam("customerId") int customerId,@RequestParam("comparisonId") Long comparisonId) {
    	return "redirect:/bankInterest/list/"+customerId+"/"+comparisonId;
    }
    
    @GetMapping("/export")
    public String exportexcel(@RequestParam("customerId") Long customerId){
    	export("bankcomparison", customerId);
    	return "redirect:/bankcomparison/list/"+customerId;
    }
    
    @SuppressWarnings("unused")
	private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("_%s.xlsx", dateTimeInfo));
    }
    
    public void export(String table, Long customerId) {
        String jdbcURL = "jdbc:mysql://localhost:3306/bankcomparison?useSSL=false";
        
        String username = "root";
        String password = "root";
 
        String excelFilePath = getFileName(table.concat("_Export"+customerId));
 
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM "+table+" WHERE customerId="+customerId;
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(table);
 
            writeHeaderLine(result, sheet);
 
            writeDataLines(result, workbook, sheet);
 
            File yourFile = new File("D:\\"+excelFilePath);
            yourFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(yourFile, false);
            workbook.write(outputStream);
            
            workbook.close();
            statement.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
    
    private void writeHeaderLine(ResultSet result, XSSFSheet sheet) throws SQLException {
        // write header line containing column names
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
 
        Row headerRow = sheet.createRow(0);
 
        // exclude the first column which is the ID field
        for (int i = 2; i <= numberOfColumns; i++) {
            String columnName = metaData.getColumnName(i);
            Cell headerCell = headerRow.createCell(i - 2);
            headerCell.setCellValue(columnName);
        }
    }
    
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet)
            throws SQLException {
        ResultSetMetaData metaData = result.getMetaData();
        int numberOfColumns = metaData.getColumnCount();
 
        int rowCount = 1;
 
        while (result.next()) {
            Row row = sheet.createRow(rowCount++);
 
            for (int i = 2; i <= numberOfColumns; i++) {
                Object valueObject = result.getObject(i);
 
                Cell cell = row.createCell(i - 2);
 
                if (valueObject instanceof Boolean)
                    cell.setCellValue((Boolean) valueObject);
                else if (valueObject instanceof Double)
                    cell.setCellValue((double) valueObject);
                else if (valueObject instanceof Long)
                    cell.setCellValue((Long) valueObject);
                else if (valueObject instanceof Float)
                    cell.setCellValue((float) valueObject);
                else if (valueObject instanceof Date) {
                    cell.setCellValue((Date) valueObject);
                    formatDateCell(workbook, cell);
                } else cell.setCellValue((String) valueObject);
 
            }
 
        }
    }
    
    private void formatDateCell(XSSFWorkbook workbook, Cell cell) {
        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
        cell.setCellStyle(cellStyle);
    }
}