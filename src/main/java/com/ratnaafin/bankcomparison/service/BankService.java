package com.ratnaafin.bankcomparison.service;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankMaster;

public interface BankService {

	 public List<BankMaster> getBankList();

	public BankMaster getBankByID(Long bankId);
	
	public void saveBank(BankMaster bank);
}
