package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
	private BigDecimal principleAmountforInterest;
	
	@Column(name = "advancedCollection")
	private BigDecimal advancedCollection;
	
	@Column(name = "cumulativeCollection")
	private BigDecimal cumulativeCollection;
	
	@Column(name = "repaymentToBank")
	private BigDecimal repaymentToBank;
	
	@Column(name = "balanceOutsatanding")
	private BigDecimal balanceOutsatanding;
	
	@Column(name = "interest")
	private BigDecimal interest;
	
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

	public BigDecimal getPrincipleAmountforInterest() {
		return principleAmountforInterest;
	}

	public void setPrincipleAmountforInterest(BigDecimal principleAmountforInterest) {
		this.principleAmountforInterest = principleAmountforInterest;
	}

	public BigDecimal getRepaymentToBank() {
		return repaymentToBank;
	}

	public void setRepaymentToBank(BigDecimal repaymentToBank) {
		this.repaymentToBank = repaymentToBank;
	}

	public BigDecimal getBalanceOutsatanding() {
		return balanceOutsatanding;
	}

	public void setBalanceOutsatanding(BigDecimal balanceOutsatanding) {
		this.balanceOutsatanding = balanceOutsatanding;
	}

	
	public BigDecimal getAdvancedCollection() {
		return advancedCollection;
	}

	public void setAdvancedCollection(BigDecimal advancedCollection) {
		this.advancedCollection = advancedCollection;
	}

	public BigDecimal getCumulativeCollection() {
		return cumulativeCollection;
	}

	public void setCumulativeCollection(BigDecimal cumulativeCollection) {
		this.cumulativeCollection = cumulativeCollection;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	

	
}