package com.ratnaafin.bankcomparison.service;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;


public interface BankInterestService {

	public List<BankInterestMaster> getBankInterest(Long custId, Long comparisonId);

	public void saveBankInterest(List<BankInterestMaster> interestDetails);

	public void deleteBankInterest(Long interestId);
	
	public void updateTotalInterest(double Total, Long comparisonId, double total1, double collectionAmnt);
	
	public void saveCutback(List<CutbackDetails> cutbackDetails);

	public void addMoratoriumRepayment(String moratoriumPeriodStartDate, String moratoriumPeriodEndDate,
			String repaymentPeriodStartDate, String repaymentPeriodEndDate, Long comparisonId);


}
