package com.ratnaafin.bankcomparison.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratnaafin.bankcomparison.entity.BankMaster;
import com.ratnaafin.bankcomparison.service.BankService;
import static javax.swing.JOptionPane.showMessageDialog;

@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@GetMapping("/")
	public String getbank() {
		return "bank";
    }
	
	@PostMapping("/save")
	public String saveBank(@ModelAttribute("bank") BankMaster bank) {
		//String bankName = (bank.getBankName().toLowerCase()).replaceAll("\\s", "");
		List<BankMaster> bankMasters = bankService.getBankList();
		boolean flag = false;
		for (BankMaster bankMaster : bankMasters) {
			if ((bank.getBankName().toLowerCase()).replaceAll("\\s", "").equals((bankMaster.getBankName().toLowerCase()).replaceAll("\\s", ""))) {
				flag = true;
				JOptionPane.showMessageDialog(null, "Please Enter Numbers", "No Numbers", JOptionPane.ERROR_MESSAGE); 
			}
		}
		if(flag == false)
		{
			bankService.saveBank(bank);
		}
		//return Content("<script language='javascript' type='text/javascript'>alert('Thanks for Feedback!');</script>");
		return "bank";
	}
	
	@GetMapping("/update")
	public String updateBank(Model model) {
		List<BankMaster> bankMasters = bankService.getBankList();
		model.addAttribute("bankList", bankMasters);
		return "updatebank";
	}
	

	@PostMapping("/updatebank")
	public String updatebank(@ModelAttribute("bank") BankMaster bank) {
			bankService.saveBank(bank);
		return "bank";
	}
	
}
