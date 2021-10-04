package com.ratnaafin.bankcomparison.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ratnaafin.bankcomparison.entity.Customer;
import com.ratnaafin.bankcomparison.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
    	model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    	String custName= customer.getCustomerName().toLowerCase();
    	Customer customerObj = customerService.getCustomerByName(custName);
    	if (customerObj == null) {
    		customer.setCustomerName(custName);
			customerService.saveCustomer(customer);
			Customer customerObj2 = customerService.getCustomerByName(custName);
			return "redirect:/bankcomparison/list/"+customerObj2.getCustomerId();
		} else {
			return "redirect:/bankcomparison/list/"+customerObj.getCustomerId();
		}
    }

}