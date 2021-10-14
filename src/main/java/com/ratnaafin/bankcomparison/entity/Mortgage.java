package com.ratnaafin.bankcomparison.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MORTGAGE")
public class Mortgage {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mortgageId")
    private Long mortgageId;
	
	@Column(name = "mortgageFromAmt")
    private BigDecimal mortgageFromAmt;
	
	@Column(name = "mortgageToAmt")
    private BigDecimal mortgageToAmt;
	
	@Column(name = "mortgageCharges")
    private BigDecimal mortgageCharges;
	
	@Column(name = "mortgageMaximunAmtCharges")
    private BigDecimal mortgageMaximunAmtCharges;

	public Long getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(Long mortgageId) {
		this.mortgageId = mortgageId;
	}

	public BigDecimal getMortgageFromAmt() {
		return mortgageFromAmt;
	}

	public void setMortgageFromAmt(BigDecimal mortgageFromAmt) {
		this.mortgageFromAmt = mortgageFromAmt;
	}

	public BigDecimal getMortgageToAmt() {
		return mortgageToAmt;
	}

	public void setMortgageToAmt(BigDecimal mortgageToAmt) {
		this.mortgageToAmt = mortgageToAmt;
	}

	public BigDecimal getMortgageCharges() {
		return mortgageCharges;
	}

	public void setMortgageCharges(BigDecimal mortgageCharges) {
		this.mortgageCharges = mortgageCharges;
	}

	public BigDecimal getMortgageMaximunAmtCharges() {
		return mortgageMaximunAmtCharges;
	}

	public void setMortgageMaximunAmtCharges(BigDecimal mortgageMaximunAmtCharges) {
		this.mortgageMaximunAmtCharges = mortgageMaximunAmtCharges;
	}

	
}
