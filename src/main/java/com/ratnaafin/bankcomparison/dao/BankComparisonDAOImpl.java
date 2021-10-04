package com.ratnaafin.bankcomparison.dao;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratnaafin.bankcomparison.entity.BankComparison;
import com.ratnaafin.bankcomparison.entity.BankMaster;

@Repository
public class BankComparisonDAOImpl implements BankComparisonDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BankComparison> getBankComparison() {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from BankComparison o", BankComparison.class);
		return query.getResultList();
	}

	@Override
	public void deleteBankComparison(Long comparisonId) {
		Session session = sessionFactory.getCurrentSession();
		BankComparison book = session.byId(BankComparison.class).load(comparisonId);
        session.delete(book);
		
	}
	
	@Override
	public void saveBankComparison(BankComparison theBankComparison) {
		Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theBankComparison);
	}

	@Override
	public BankComparison getBankComparison(Long comparisonId) {
		Session currentSession = sessionFactory.getCurrentSession();
		BankComparison bankComparison = currentSession.get(BankComparison.class, comparisonId);
        return bankComparison;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankComparison> getBankComparisonByCustId(Long custId) {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from BankComparison o where o.customerId = :custID", BankComparison.class);
		query.setParameter("custID", custId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankMaster> getBankList() {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from BankMaster o", BankMaster.class);
		return query.getResultList();
	}
}
