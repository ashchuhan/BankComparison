package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.CutbackDetails;

public interface CutbackDAO {

	public List<CutbackDetails> getCutbackDetails(Long comparisonId);

	public void deleteCutbackDetails(Long cutbackId);

}
