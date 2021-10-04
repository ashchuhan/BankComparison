package com.ratnaafin.bankcomparison.service;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.CutbackDetails;

public interface CutbackService {
	
	public List<CutbackDetails> getCutbackDetails(Long comparisonId);
	
	public void deleteCutbackDetails(Long cutbackId);

}
