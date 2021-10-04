package com.ratnaafin.bankcomparison.service;

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
	public void updateTotalInterest(double Total, Long comparisonId, double total1, double collectionAmnt) {
		bankInterestDAO.updateTotalInterest(Total,comparisonId, total1, collectionAmnt);
		
	}

	@Transactional
	@Override
	public void saveCutback(List<CutbackDetails> cutbackDetails) {
		bankInterestDAO.saveCutback(cutbackDetails);
	}

}
