package com.ratnaafin.bankcomparison.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratnaafin.bankcomparison.dao.BankComparisonDAO;
import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankMaster;

@Service
public class BankComparisonServiceImpl implements BankComparisonService {

	@Autowired
    private BankComparisonDAO bankComparisonDAO;
	
	@Override
	@Transactional
	public List<BankComparison> getBankComparison() {
		// TODO Auto-generated method stub
		return bankComparisonDAO.getBankComparison();
	}

	
	@Override
	@Transactional
	public void saveBankComparison(BankComparison theBankComparison) {
		// TODO Auto-generated method stub
		bankComparisonDAO.saveBankComparison(theBankComparison);
		
	}

	@Override
	@Transactional
	public BankComparison getBankComparison(Long comparisonId) {
		// TODO Auto-generated method stub
		return bankComparisonDAO.getBankComparison(comparisonId);
	}

	@Override
	@Transactional
	public void deleteBankComparison(Long comparisonId) {
		// TODO Auto-generated method stub
		bankComparisonDAO.deleteBankComparison(comparisonId);
	}

	@Override
	@Transactional
	public List<BankComparison> getBankComparisonByCustId(Long custId) {
		// TODO Auto-generated method stub
		return bankComparisonDAO.getBankComparisonByCustId(custId);
	}


	@Override
	@Transactional
	public List<BankMaster> getBankList() {
		return bankComparisonDAO.getBankList();
	}
}
