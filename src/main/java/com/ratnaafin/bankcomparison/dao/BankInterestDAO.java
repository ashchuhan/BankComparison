package com.ratnaafin.bankcomparison.dao;

import java.math.BigDecimal;
import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;

public interface BankInterestDAO {
	public List<BankInterestMaster> getBankInterest(Long custId, Long bankId);

	public void saveBankInterest(List<BankInterestMaster> interestDetails);

	public void deleteBankInterest(Long interestId);

	public void updateTotalInterest(BigDecimal totalInterestExpense, Long comparisonId, BigDecimal totalExpense, BigDecimal collectionAmnt);

	public void saveCutback(List<CutbackDetails> cutbackDetails);

	public void addMoratoriumRepayment(String moratoriumPeriodStartDate, String moratoriumPeriodEndDate,
			String repaymentPeriodStartDate, String repaymentPeriodEndDate, Long comparisonId);


}
