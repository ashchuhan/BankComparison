package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;

@Repository
public class CutbackDAOImpl implements CutbackDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CutbackDetails> getCutbackDetails(Long comparisonId) {
        Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from CutbackDetails o where o.comparisonId =:comparisonID", CutbackDetails.class);
		query.setParameter("comparisonID", comparisonId);
		if(query.getResultList().size() > 0) {
			return query.getResultList();	
		} else {
			return null;
		}   
	}

	@Override
	public void deleteCutbackDetails(Long cutbackId) {
		Session session = sessionFactory.getCurrentSession();
		CutbackDetails cutbackDetails = session.byId(CutbackDetails.class).load(cutbackId);
        session.delete(cutbackDetails);
	}

	
}
