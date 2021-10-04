package com.ratnaafin.bankcomparison.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ratnaafin.bankcomparison.dao.CutbackDAO;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;

@Service
public class CutbackServiceImpl implements CutbackService {

	@Autowired
    private CutbackDAO cutbackDAO;
	
	@Override
	@Transactional
	public List<CutbackDetails> getCutbackDetails(Long comparisonId) {
		return cutbackDAO.getCutbackDetails(comparisonId);
	}

	@Override
	@Transactional
	public void deleteCutbackDetails(Long cutbackId) {
		cutbackDAO.deleteCutbackDetails(cutbackId);
	}

}
