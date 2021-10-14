package com.ratnaafin.bankcomparison.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratnaafin.bankcomparison.dao.BankInterestDAO;
import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;

@Service
public class BankInterestServiceImpl implements BankInterestService {

	@Autowired
    private BankInterestDAO bankInterestDAO;
	
	@Override
	@Transactional
	public List<BankInterestMaster> getBankInterest(Long custId, Long comparisonId) {
		return bankInterestDAO.getBankInterest(custId,comparisonId);
	}

	@Override
	@Transactional
	public void saveBankInterest(List<BankInterestMaster> interestDetails) {
		bankInterestDAO.saveBankInterest(interestDetails);
	}
	
	@Transactional
	@Override
	public void deleteBankInterest(Long interestId) {
		bankInterestDAO.deleteBankInterest(interestId);
		
	}

	@Transactional
	@Override
	public void updateTotalInterest(BigDecimal totalInterestExpense, Long comparisonId, BigDecimal totalExpense, BigDecimal collectionAmnt) {
		bankInterestDAO.updateTotalInterest(totalInterestExpense,comparisonId, totalExpense, collectionAmnt);
		
	}

	@Transactional
	@Override
	public void saveCutback(List<CutbackDetails> cutbackDetails) {
		bankInterestDAO.saveCutback(cutbackDetails);
	}

	@Transactional
	@Override
	public void addMoratoriumRepayment(String moratoriumPeriodStartDate, String moratoriumPeriodEndDate,
			String repaymentPeriodStartDate, String repaymentPeriodEndDate, Long comparisonId) {
		bankInterestDAO.addMoratoriumRepayment(moratoriumPeriodStartDate, moratoriumPeriodEndDate, repaymentPeriodStartDate, repaymentPeriodEndDate,comparisonId);
		
	}

}
