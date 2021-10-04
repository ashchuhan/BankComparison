package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;

public interface BankInterestDAO {
	public List<BankInterestMaster> getBankInterest(Long custId, Long bankId);

	public void saveBankInterest(List<BankInterestMaster> interestDetails);

	public void deleteBankInterest(Long interestId);

	public void updateTotalInterest(double total, Long comparisonId, double total1, double collectionAmnt);

	public void saveCutback(List<CutbackDetails> cutbackDetails);


}
