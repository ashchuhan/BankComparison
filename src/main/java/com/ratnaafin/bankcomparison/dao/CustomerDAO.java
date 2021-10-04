package com.ratnaafin.bankcomparison.dao;

import java.util.List;

import com.ratnaafin.bankcomparison.entity.Customer;

public interface CustomerDAO {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(Long theId);
    
    public Customer getCustomerByName(String custName);

    public void deleteCustomer(int theId);
}