package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANKINTERESTMASTER")
public class BankInterestMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "customerId")
	private Long customerId;
	
	@Column(name = "comparisonId")
	private Long comparisonId;
	
	@Column(name = "monthEndingOn")
	private String monthEndingOn;
	
	@Column(name = "principleAmountforInterest")
	private Double principleAmountforInterest;
	
	@Column(name = "advancedCollection")
	private Double advancedCollection;
	
	@Column(name = "cumulativeCollection")
	private Double cumulativeCollection;
	
	@Column(name = "repaymentToBank")
	private Double repaymentToBank;
	
	@Column(name = "balanceOutsatanding")
	private Double balanceOutsatanding;
	
	@Column(name = "interest")
	private Double interest;
	
	@Column(name = "interestType")
	private String interestType;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getComparisonId() {
		return comparisonId;
	}

	public void setComparisonId(Long comparisonId) {
		this.comparisonId = comparisonId;
	}

	public String getMonthEndingOn() {
		return monthEndingOn;
	}

	public void setMonthEndingOn(String monthEndingOn) {
		this.monthEndingOn = monthEndingOn;
	}

	public Double getPrincipleAmountforInterest() {
		return principleAmountforInterest;
	}

	public void setPrincipleAmountforInterest(Double principleAmountforInterest) {
		this.principleAmountforInterest = principleAmountforInterest;
	}

	public Double getRepaymentToBank() {
		return repaymentToBank;
	}

	public void setRepaymentToBank(Double repaymentToBank) {
		this.repaymentToBank = repaymentToBank;
	}

	public Double getBalanceOutsatanding() {
		return balanceOutsatanding;
	}

	public void setBalanceOutsatanding(Double balanceOutsatanding) {
		this.balanceOutsatanding = balanceOutsatanding;
	}

	
	public Double getAdvancedCollection() {
		return advancedCollection;
	}

	public void setAdvancedCollection(Double advancedCollection) {
		this.advancedCollection = advancedCollection;
	}

	public Double getCumulativeCollection() {
		return cumulativeCollection;
	}

	public void setCumulativeCollection(Double cumulativeCollection) {
		this.cumulativeCollection = cumulativeCollection;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	

	
}