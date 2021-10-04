package com.ratnaafin.bankcomparison.service;
import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankMaster;

public interface BankComparisonService {

	 	public List<BankComparison> getBankComparison();

	    public void saveBankComparison(BankComparison theBankComparison);
	    
	    public List<BankComparison> getBankComparisonByCustId(Long custId);

	    public BankComparison getBankComparison(Long comparisonId);

	    public void deleteBankComparison(Long comparisonId);
	    
	    public List<BankMaster> getBankList();
}
