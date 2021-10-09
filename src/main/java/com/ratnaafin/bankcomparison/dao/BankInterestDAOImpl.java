package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratnaafin.bankcomparison.entity.BankInterestMaster;
import com.ratnaafin.bankcomparison.entity.CutbackDetails;

@Repository
public class BankInterestDAOImpl implements BankInterestDAO {

	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BankInterestMaster> getBankInterest(Long custId, Long comparisonId) {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from BankInterestMaster o where o.customerId = :custID AND o.comparisonId =:comparisonID", BankInterestMaster.class);
		query.setParameter("custID", custId);
		query.setParameter("comparisonID", comparisonId);
		if(query.getResultList().size() > 0) {
			return query.getResultList();	
		} else {
			return null;
		}   
	}

	@Override
	public void saveBankInterest(List<BankInterestMaster> interestDetails) {
		Session currentSession = sessionFactory.getCurrentSession();
		for (BankInterestMaster bankInterestMaster : interestDetails) {
			 currentSession.saveOrUpdate(bankInterestMaster);
		}
    }

	@Override
	public void deleteBankInterest(Long interestId) {
		Session session = sessionFactory.getCurrentSession();
		BankInterestMaster bankInterestMaster = session.byId(BankInterestMaster.class).load(interestId);
        session.delete(bankInterestMaster);
	}

	@Override
	public void updateTotalInterest(double total, Long comparisonId, double total1, double collectionAmnt) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update BankComparison c set c.interestExpense = :total , c.collectionAmnt = :collectionAmnt , c.totalExpenses =:total1 where c.id = :comparisonId";
		
		@SuppressWarnings("deprecation")
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setDouble("total",total )
		        .setDouble("total1", total1)
		        .setLong( "comparisonId", comparisonId )
		        .setDouble("collectionAmnt", collectionAmnt)
		        .executeUpdate();
		tx.commit();
		session.close();
	}

	@Override
	public void saveCutback(List<CutbackDetails> cutbackDetails) {
		Session currentSession = sessionFactory.getCurrentSession();
		for (CutbackDetails CutbackDetail : cutbackDetails) {
			 currentSession.saveOrUpdate(CutbackDetail);
		}
	}

	@Override
	public void addMoratoriumRepayment(String moratoriumPeriodStartDate, String moratoriumPeriodEndDate,
			String repaymentPeriodStartDate, String repaymentPeriodEndDate,Long comparisonId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String hqlUpdate = "update BankComparison c set c.moratoriumPeriodStartDate = :moratoriumPeriodStartDate , c.moratoriumPeriodEndDate = :moratoriumPeriodEndDate, c.repaymentPeriodStartDate = :repaymentPeriodStartDate , c.repaymentPeriodEndDate =:repaymentPeriodEndDate where c.id = :comparisonId";
		
		@SuppressWarnings("deprecation")
		int updatedEntities = session.createQuery( hqlUpdate )
				.setString("moratoriumPeriodStartDate", moratoriumPeriodStartDate)
				.setString("moratoriumPeriodEndDate", moratoriumPeriodEndDate)
				.setString("repaymentPeriodStartDate", repaymentPeriodStartDate)
				.setString("repaymentPeriodEndDate", repaymentPeriodEndDate)
				.setLong( "comparisonId", comparisonId )
		        .executeUpdate();
		tx.commit();
		session.close();
		
	}
}
