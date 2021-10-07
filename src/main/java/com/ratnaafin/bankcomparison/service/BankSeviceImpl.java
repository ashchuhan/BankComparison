package com.ratnaafin.bankcomparison.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratnaafin.bankcomparison.dao.BankDAO;
import com.ratnaafin.bankcomparison.entity.BankMaster;

@Service
public class BankSeviceImpl implements BankService{

	@Autowired
	private BankDAO bankdao;
	
	@Override
	public List<BankMaster> getBankList() {
		
		return bankdao.getBankList();
	}

	@Override
	public BankMaster getBankByID(Long bankId) {
		// TODO Auto-generated method stub
		return bankdao.getBankByID(bankId);
	}

	@Transactional
	@Override
	public void saveBank(BankMaster bank) {
		bankdao.saveBank(bank);
	}

}
