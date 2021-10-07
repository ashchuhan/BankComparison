package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankMaster;

public interface BankDAO {

	public List<BankMaster> getBankList();

	public BankMaster getBankByID(Long bankId);

	public void saveBank(BankMaster bank);

}
