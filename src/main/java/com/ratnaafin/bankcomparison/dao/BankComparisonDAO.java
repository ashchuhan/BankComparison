package com.ratnaafin.bankcomparison.dao;


import java.util.List;

import com.ratnaafin.bankcomparison.entity.BankMaster;
import com.ratnaafin.bankcomparison.entity.BankComparison;
public interface BankComparisonDAO {

	 	public List<BankComparison> getBankComparison();

	    public void saveBankComparison(BankComparison theBankComparison);

	    public BankComparison getBankComparison(Long comparisonId);
	    
	    public List<BankComparison> getBankComparisonByCustId(Long custId);

	    public void deleteBankComparison(Long comparisonId);
	    
	    public List<BankMaster> getBankList();
}
