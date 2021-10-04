package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ratnaafin.bankcomparison.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
	@Override
    public List<Customer> getCustomers() {
    	Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from Customer o", Customer.class);
		return query.getResultList();
    }

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer book = session.byId(Customer.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(Long theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

	@Override
	public Customer getCustomerByName(String custName) {
		Session currentSession = sessionFactory.openSession();
		Query query = currentSession.createQuery("select o from Customer o where o.customerName = :custName", Customer.class);
		query.setParameter("custName", custName);
		if(query.getResultList().size() > 0) {
			return (Customer)query.getResultList().get(0);	
		} else {
			return null;
		}   
	}
}