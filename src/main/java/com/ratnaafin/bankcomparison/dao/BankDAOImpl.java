package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratnaafin.bankcomparison.entity.BankMaster;

@Repository
public class BankDAOImpl implements BankDAO{

	
	@Autowired
    private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<BankMaster> getBankList() {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from BankMaster o", BankMaster.class);
		return query.getResultList();
	}
	@Override
	public BankMaster getBankByID(Long bankId) {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from BankMaster o where o.bankId = :bankID", BankMaster.class);
		query.setParameter("bankID", bankId);
		return (BankMaster) query.getResultList().get(0);	
	}

}
