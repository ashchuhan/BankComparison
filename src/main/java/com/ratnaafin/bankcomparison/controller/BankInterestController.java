package com.ratnaafin.bankcomparison.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.BankMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;
import com.ratnaafin.bankcomparison.service.BankComparisonService;
import com.ratnaafin.bankcomparison.service.BankInterestService;
import com.ratnaafin.bankcomparison.service.BankService;
import com.ratnaafin.bankcomparison.service.CutbackService;

@Controller
@RequestMapping("/bankInterest")
public class BankInterestController {

	@Autowired
	private BankInterestService bankinterestservice;

	@Autowired
	private BankService bankService;

	@Autowired
	private BankComparisonService bankComparisonService;
	
	@Autowired
	private CutbackService cutbackService;

	@GetMapping("/list/{customerId}/{comparisonId}")
	public String userForm(@PathVariable("customerId") Long customerId, @PathVariable("comparisonId") Long comparisonId, Model model)
	{
		BankInterestMaster bankInterestMaster1 = new BankInterestMaster();
		bankInterestMaster1.setCustomerId(customerId);
		bankInterestMaster1.setComparisonId(comparisonId);
		model.addAttribute("bankInterestMasterDetails", bankInterestMaster1);
		BankComparison bankComparison = bankComparisonService.getBankComparison(comparisonId);
		model.addAttribute("bankComparison", bankComparison);
		if(bankComparison != null)
		{
			BigDecimal loanTenure = bankComparison.getLoanTenure();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String date = bankComparison.getLoanStartDate();
	        LocalDate startDate = LocalDate.parse(date, dateFormat);
	        //int startMonth = startDate.getMonthValue();
	        //startDate = startDate.withMonth(startMonth).withDayOfMonth(1);
	        LocalDate currentDateStart = startDate;
	        List<String> interestSequenceDate = new ArrayList<>();
	        for(int i=0;i<loanTenure.doubleValue();i++)
	        {
	        	interestSequenceDate.add(currentDateStart.format(dateFormat));
	        	currentDateStart = currentDateStart.plusMonths(1);
	        }
	        System.err.println(interestSequenceDate);
	        model.addAttribute("interestSequenceDate", interestSequenceDate);
	        model.addAttribute("loanTenure", loanTenure);
		}
		BankMaster bankMaster = (BankMaster) bankService.getBankByID(bankComparison.getBankId());
		model.addAttribute("bankMaster", bankMaster); 
		
		List<BankInterestMaster> bankInterestMaster = bankinterestservice.getBankInterest(customerId, comparisonId);
		model.addAttribute("bankInterestMaster", bankInterestMaster);
		
		List<CutbackDetails> cutbackDetails = cutbackService.getCutbackDetails(comparisonId);
		model.addAttribute("cutbackDetails", cutbackDetails);
		
		BigDecimal totalPrincipalAmnt = BigDecimal.ZERO, totalRepaymentAmnt = BigDecimal.ZERO, totalIntr = BigDecimal.ZERO;
		if(bankInterestMaster != null && bankInterestMaster.size() > 0) {
			for (BankInterestMaster bankInterestMaster2 : bankInterestMaster) {
				totalPrincipalAmnt = totalPrincipalAmnt + bankInterestMaster2.getPrincipleAmountforInterest();
				totalRepaymentAmnt = totalRepaymentAmnt + bankInterestMaster2.getRepaymentToBank();
				totalIntr = totalIntr + bankInterestMaster2.getInterest();
				}
		}
		model.addAttribute("totalPrincipalAmnt", totalPrincipalAmnt);
		model.addAttribute("totalRepaymentAmnt", totalRepaymentAmnt);
		totalIntr = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(totalIntr));
		model.addAttribute("totalIntr", totalIntr);
		if(bankInterestMaster != null && bankInterestMaster.size() > 0) {
		String interestType = bankInterestMaster.get(0).getInterestType();
		model.addAttribute("interestType", interestType);}
		return "bank-interest-details";
	}

	@PostMapping("/saveFixedInterest")
	public String saveFixedInterest(@RequestParam(value = "customerId") Long customerId,
			@RequestParam(value = "comparisonId") Long comparisonId,
			@RequestParam(value = "monthEndingOn") String[] date,
			@RequestParam(value = "principleAmountforInterest") BigDecimal[] principalAmnt,
			@RequestParam(value = "repaymentToBank") BigDecimal[] repayBank,
			@RequestParam(value = "advancedCollection") BigDecimal[] advancedCollection,
			@RequestParam(value = "collectionAmnt") BigDecimal collectionAmnt,
			@RequestParam(value = "interestType") String interestType) {
		saveBankfixedInterest(customerId, comparisonId, date, principalAmnt, repayBank, advancedCollection, collectionAmnt, interestType);
		return "redirect:/bankInterest/list/" + customerId + "/" + comparisonId;
	}
	
	@PostMapping("/saveDate")
	public String saveDate(@RequestParam(value = "customerId") Long customerId,
			@RequestParam(value = "comparisonId") Long comparisonId,
			@RequestParam(value = "moratoriumPeriodStartDate") String moratoriumPeriodStartDate,
			@RequestParam(value = "moratoriumPeriodEndDate") String moratoriumPeriodEndDate,
			@RequestParam(value = "repaymentPeriodStartDate") String repaymentPeriodStartDate,
			@RequestParam(value = "repaymentPeriodEndDate") String repaymentPeriodEndDate,Model model) {
		bankinterestservice.addMoratoriumRepayment(moratoriumPeriodStartDate, moratoriumPeriodEndDate, repaymentPeriodStartDate, repaymentPeriodEndDate,comparisonId);
		BankComparison bankComparison = bankComparisonService.getBankComparison(comparisonId);
		model.addAttribute("bankComparison", bankComparison);
		BankInterestMaster bankInterestMaster1 = new BankInterestMaster();
		bankInterestMaster1.setCustomerId(customerId);
		bankInterestMaster1.setComparisonId(comparisonId);
		model.addAttribute("bankInterestMasterDetails", bankInterestMaster1);
		
		long monthsBetweenMoratoriumPeriod = ChronoUnit.MONTHS.between(
				LocalDate.parse(moratoriumPeriodStartDate).withDayOfMonth(1),
	            LocalDate.parse(moratoriumPeriodEndDate).withDayOfMonth(1));
		
		long monthsBetweenRepaymentPeriod = ChronoUnit.MONTHS.between(
				LocalDate.parse(repaymentPeriodStartDate).withDayOfMonth(1),
	            LocalDate.parse(repaymentPeriodEndDate).withDayOfMonth(1));
		
		model.addAttribute("monthsBetweenMoratoriumPeriod", monthsBetweenMoratoriumPeriod);
		model.addAttribute("monthsBetweenRepaymentPeriod", monthsBetweenRepaymentPeriod);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate moratoriumStartDate = LocalDate.parse(moratoriumPeriodStartDate, dateFormat);
	    LocalDate repaymentStartDate = LocalDate.parse(repaymentPeriodStartDate, dateFormat);
	    List<String> moratoriumPeriodSequenceDate = new ArrayList<>();
	    List<String> repaymentPeriodSequenceDate = new ArrayList<>();
	    for(int i=0;i<=monthsBetweenMoratoriumPeriod;i++)
	    {
	    	moratoriumPeriodSequenceDate.add(moratoriumStartDate.format(dateFormat));
	    	moratoriumStartDate = moratoriumStartDate.plusMonths(1);
	    }
	    model.addAttribute("moratoriumPeriodSequenceDate", moratoriumPeriodSequenceDate);
	    model.addAttribute("monthsBetweenRepaymentPeriod", monthsBetweenRepaymentPeriod);
	   
	    for(int i=0;i<=monthsBetweenRepaymentPeriod;i++)
	    {
	    	repaymentPeriodSequenceDate.add(repaymentStartDate.format(dateFormat));
	    	repaymentStartDate = repaymentStartDate.plusMonths(1);
	    }
	    model.addAttribute("repaymentPeriodSequenceDate", repaymentPeriodSequenceDate);
	    BigDecimal repaymentcalculate = (bankComparison.getLoanAmount()/(BigDecimal) (monthsBetweenRepaymentPeriod+1));
	    repaymentcalculate = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(repaymentcalculate));
	    model.addAttribute("repaymentcalculate", repaymentcalculate);	
		return "fixedinterest";
	}
	
	@GetMapping("/delete")
    public String deleteInterest(@RequestParam("comparisonId") Long comparisonId, @RequestParam("customerId") Long customerId, @RequestParam("totalInterest") BigDecimal totalInterest) {
		List<BankInterestMaster> bankInterestMaster = bankinterestservice.getBankInterest(customerId, comparisonId);
		List<CutbackDetails> cutbackDetails = cutbackService.getCutbackDetails(comparisonId);
		if(cutbackDetails != null && cutbackDetails.size() > 0) {
			for(CutbackDetails cutbackDetail : cutbackDetails){
				cutbackService.deleteCutbackDetails(cutbackDetail.getId());
			}
		}
		BankComparison bankComparison = bankComparisonService.getBankComparison(comparisonId);
		if(bankInterestMaster != null && bankInterestMaster.size() > 0) {
			for (BankInterestMaster bankInterestMaster2 : bankInterestMaster) {
				bankinterestservice.deleteBankInterest(bankInterestMaster2.getId());
				BigDecimal totalInterestExpense = 0.00 ;
				BigDecimal totalExpense =(bankComparison.getTotalExpenses()-totalInterest);
				BigDecimal collectionAmnt = bankComparison.getCollectionAmnt();
				bankinterestservice.updateTotalInterest(totalInterestExpense, comparisonId, totalExpense, collectionAmnt);
			}
		}
		return "redirect:/bankInterest/list/"+customerId+"/"+comparisonId;
    }
	
	@PostMapping("/saveAdvanceInterest")
	public String saveAdvanceInterest(@RequestParam(value = "customerId") Long customerId,
			@RequestParam(value = "comparisonId") Long comparisonId,
			@RequestParam(value = "monthEndingOn") String[] date,
			@RequestParam(value = "principleAmountforInterest") BigDecimal[] principalAmnt,
			@RequestParam(value = "repaymentToBank") BigDecimal[] repayBank,
			@RequestParam(value = "advancedCollection") BigDecimal[] advancedCollection,
			@RequestParam(value = "collectionAmnt") BigDecimal collectionAmnt,
			@RequestParam(value = "cumulativeCollection") BigDecimal[] cumulativeCollection,
			@RequestParam(value = "interestType") String interestType,
			@RequestParam(value = "cutbackFromAmount") BigDecimal[] cutbackFromAmount,
			@RequestParam(value = "cutbackToAmount") BigDecimal[] cutbackToAmount,
			@RequestParam(value = "cutbackRatio") BigDecimal[] cutbackRatio) {
		saveBankAdvanceInterest(customerId, comparisonId, date, principalAmnt, repayBank,advancedCollection, collectionAmnt,cumulativeCollection, interestType, cutbackFromAmount, cutbackToAmount, cutbackRatio);
		return "redirect:/bankInterest/list/" + customerId + "/" + comparisonId;
	}
	
	@PostMapping("/updateFixedInterest")
	public String updateFixedInterest(@RequestParam(value = "customerId") Long customerId,
			@RequestParam(value = "comparisonId") Long comparisonId,
			@RequestParam(value = "monthEndingOn") String[] date,
			@RequestParam(value = "principleAmountforInterest") BigDecimal[] principalAmnt,
			@RequestParam(value = "repaymentToBank") BigDecimal[] repayBank,
			@RequestParam(value = "advancedCollection") BigDecimal[] advancedCollection,
			@RequestParam(value = "collectionAmnt") BigDecimal collectionAmnt,
			@RequestParam(value = "interestType") String interestType)
	{
		List<BankInterestMaster> bankInterestMaster = bankinterestservice.getBankInterest(customerId, comparisonId);
		BigDecimal totalIntr = 0.0;
		if(bankInterestMaster != null && bankInterestMaster.size() > 0) {
			for (BankInterestMaster bankInterestMaster2 : bankInterestMaster) {
				totalIntr = totalIntr + bankInterestMaster2.getInterest();
				}
		}
		deleteInterest(comparisonId, customerId, totalIntr);
		saveBankfixedInterest(customerId, comparisonId, date, principalAmnt, repayBank, advancedCollection, collectionAmnt, interestType);
		return "redirect:/bankInterest/list/" + customerId + "/" + comparisonId;
	}
	
	@PostMapping("/updateAdvanceInterest")
	public String updateAdvanceInterest(@RequestParam(value = "customerId") Long customerId,
			@RequestParam(value = "comparisonId") Long comparisonId,
			@RequestParam(value = "monthEndingOn") String[] date,
			@RequestParam(value = "principleAmountforInterest") BigDecimal[] principalAmnt,
			@RequestParam(value = "repaymentToBank") BigDecimal[] repayBank,
			@RequestParam(value = "advancedCollection") BigDecimal[] advancedCollection,
			@RequestParam(value = "collectionAmnt") BigDecimal collectionAmnt,
			@RequestParam(value = "cumulativeCollection") BigDecimal[] cumulativeCollection,
			@RequestParam(value = "interestType") String interestType,
			@RequestParam(value = "cutbackFromAmount") BigDecimal[] cutbackFromAmount,
			@RequestParam(value = "cutbackToAmount") BigDecimal[] cutbackToAmount,
			@RequestParam(value = "cutbackRatio") BigDecimal[] cutbackRatio) {
		List<BankInterestMaster> bankInterestMaster = bankinterestservice.getBankInterest(customerId, comparisonId);
		BigDecimal totalIntr = 0.0;
		if(bankInterestMaster != null && bankInterestMaster.size() > 0) {
			for (BankInterestMaster bankInterestMaster2 : bankInterestMaster) {
				totalIntr = totalIntr + bankInterestMaster2.getInterest();
			}
		}
		deleteInterest(comparisonId, customerId, totalIntr);
		saveBankAdvanceInterest(customerId, comparisonId, date, principalAmnt, repayBank,advancedCollection, collectionAmnt,cumulativeCollection, interestType, cutbackFromAmount, cutbackToAmount, cutbackRatio);
		return "redirect:/bankInterest/list/" + customerId + "/" + comparisonId;
	}
	
	public void saveBankfixedInterest(Long customerId, Long comparisonId, String[] date, BigDecimal[] principalAmnt,
			BigDecimal[] repayBank, BigDecimal[] advancedCollection, BigDecimal collectionAmnt, String interestType) {
		List<BankInterestMaster> list = new ArrayList<BankInterestMaster>();
		BankComparison bankComparison = bankComparisonService.getBankComparison(comparisonId);
		BigDecimal balance = 0;
		BigDecimal totalInterest = 0;
		BigDecimal cumulativeCollection = 0;
		for (int i = 0; i < date.length; i++) {
			BankInterestMaster bankInterestMaster = new BankInterestMaster();
			bankInterestMaster.setCustomerId(customerId);
			bankInterestMaster.setComparisonId(comparisonId);
			bankInterestMaster.setMonthEndingOn(date[i]);
			bankInterestMaster.setPrincipleAmountforInterest(principalAmnt[i]);
			bankInterestMaster.setRepaymentToBank(repayBank[i]);
			bankInterestMaster.setInterestType(interestType);
			bankInterestMaster.setAdvancedCollection(advancedCollection[i]);
			bankInterestMaster.setCumulativeCollection(cumulativeCollection);

			BigDecimal balance_outsanding = ((principalAmnt[i] + balance) - repayBank[i]);
			balance_outsanding = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(balance_outsanding));
			bankInterestMaster.setBalanceOutsatanding(balance_outsanding);
			balance = balance_outsanding;

			BigDecimal interest = (balance_outsanding * (bankComparison.getInterestRate() / 100)) / 12;
			interest = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(interest));
			bankInterestMaster.setInterest(interest);
			totalInterest = totalInterest + interest;
			list.add(bankInterestMaster);
		}
		bankinterestservice.saveBankInterest(list);
		BigDecimal totalExpense = bankComparison.getTotalExpenses();
		BigDecimal total = totalExpense + totalInterest;
		total = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(total));
		totalExpense = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(totalExpense));
		totalInterest = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(totalInterest));
		bankinterestservice.updateTotalInterest(totalInterest, comparisonId, total, collectionAmnt);
	}
	
	public void saveBankAdvanceInterest(Long customerId, Long comparisonId, String[] date, BigDecimal[] principalAmnt,
			BigDecimal[] repayBank, BigDecimal[] advancedCollection, BigDecimal collectionAmnt, BigDecimal[] cumulativeCollection, String interestType,
			BigDecimal[] cutbackFromAmount, BigDecimal[] cutbackToAmount, BigDecimal[] cutbackRatio) 
	{
		 List<CutbackDetails> cutbackList = new ArrayList<CutbackDetails>(); 
		 for(int i=0; i < cutbackFromAmount.length; i++)
		  {
			 CutbackDetails cutbackDetails = new CutbackDetails();
			 cutbackDetails.setComparisonId(comparisonId);
			 cutbackDetails.setCutbackFromAmount(cutbackFromAmount[i]);
			 cutbackDetails.setCutbackToAmount(cutbackToAmount[i]);
			 cutbackDetails.setCutbackRatio(cutbackRatio[i]);
			 cutbackList.add(cutbackDetails);
		  }
		 bankinterestservice.saveCutback(cutbackList);
		 List<BankInterestMaster> bankMasterList = new ArrayList<BankInterestMaster>();
		 BankComparison bankComparison = bankComparisonService.getBankComparison(comparisonId);
		 List<CutbackDetails> cutbackDetails = cutbackService.getCutbackDetails(comparisonId);
		 BigDecimal balance = 0;
		 BigDecimal totalInterest = 0;
		 //BigDecimal cumulativeCollectionn= collectionAmnt;
		 for (int i = 0; i < date.length; i++) {
				BankInterestMaster bankInterestMaster = new BankInterestMaster();
				bankInterestMaster.setCustomerId(customerId);
				bankInterestMaster.setComparisonId(comparisonId);
				bankInterestMaster.setMonthEndingOn(date[i]);
				bankInterestMaster.setPrincipleAmountforInterest(principalAmnt[i]);
				bankInterestMaster.setInterestType(interestType);
				bankInterestMaster.setAdvancedCollection(advancedCollection[i]);
				//cumulativeCollectionn = cumulativeCollectionn + advancedCollection[i];
				bankInterestMaster.setCumulativeCollection(cumulativeCollection[i]);
				bankInterestMaster.setRepaymentToBank(repayBank[i]);
				
				BigDecimal balance_outsanding = ((principalAmnt[i] + balance) - repayBank[i]);
				balance_outsanding = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(balance_outsanding));
				bankInterestMaster.setBalanceOutsatanding(balance_outsanding);
				balance = balance_outsanding;

				BigDecimal interest = (balance_outsanding * (bankComparison.getInterestRate() / 100)) / 12;
				interest = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(interest));
				bankInterestMaster.setInterest(interest);
				totalInterest = totalInterest + interest;
				bankMasterList.add(bankInterestMaster);
			}
		 	bankinterestservice.saveBankInterest(bankMasterList);
			BigDecimal totalExpense = bankComparison.getTotalExpenses();
			BigDecimal total = totalExpense + totalInterest;
			total = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(total));
			totalExpense = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(totalExpense));
			totalInterest = BigDecimal.parseBigDecimal(new DecimalFormat("##.##").format(totalInterest));
			bankinterestservice.updateTotalInterest(totalInterest, comparisonId, total, collectionAmnt);
	}
	
	@GetMapping("/export")
    public String exportexcel(@RequestParam("comparisonId") Long comparisonId, @RequestParam("customerId") Long customerId){
    	export("bankinterestmaster", customerId, comparisonId);
    	return "redirect:/bankInterest/list/"+customerId+"/"+comparisonId;
    }
    
    @SuppressWarnings("unused")
	private String getFileName(String baseName) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String dateTimeInfo = dateFormat.format(new Date());
        return baseName.concat(String.format("_%s.xlsx", dateTimeInfo));
    }
    
    public void export(String table, Long customerId, Long comparisonId) {
        String jdbcURL = "jdbc:mysql://localhost:3306/bankcomparison?useSSL=false";
        String username = "root";
        String password = "root";
        String excelFilePath = getFileName(table.concat("_Export"+customerId));
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM "+table+" WHERE customerId="+customerId+" AND comparisonId="+comparisonId;
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
                else if (valueObject instanceof BigDecimal)
                    cell.setCellValue((BigDecimal) valueObject);
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