package com.ratnaafin.bankcomparison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankMaster;
import com.ratnaafin.bankcomparison.service.BankService;

@Controller
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService bankService;
	
	@PostMapping("/save")
    public String saveCustomer(@ModelAttribute("bank") BankMaster bank) {
		bankService.saveBank(bank);
		 String redirectUrl = "http://localhost:8081/bankcomparisoninterest/";
	     return "redirect:" + redirectUrl;
       // return "redirect:/bankcomparisoninterest/";
    }
}
