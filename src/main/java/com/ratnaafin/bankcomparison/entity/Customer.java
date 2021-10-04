package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "customerName")
    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)  
    @JoinColumn(name="customerId")
    private Set<BankComparison> bankComparison;
    	
	
	public Set<BankComparison> getUserGroups() {
	    return bankComparison;
	}
	
	public Set<BankComparison> getBankComparison() {
		return bankComparison;
	}

	public void setBankComparison(Set<BankComparison> bankComparison) {
		this.bankComparison = bankComparison;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
}