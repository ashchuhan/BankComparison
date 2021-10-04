package com.ratnaafin.bankcomparison.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MORTGAGE")
public class Mortgage {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mortgageId")
    private Long mortgageId;
	
	@Column(name = "mortgageFromAmt")
    private Double mortgageFromAmt;
	
	@Column(name = "mortgageToAmt")
    private Double mortgageToAmt;
	
	@Column(name = "mortgageCharges")
    private Double mortgageCharges;
	
	@Column(name = "mortgageMaximunAmtCharges")
    private Double mortgageMaximunAmtCharges;

	public Long getMortgageId() {
		return mortgageId;
	}

	public void setMortgageId(Long mortgageId) {
		this.mortgageId = mortgageId;
	}

	public Double getMortgageFromAmt() {
		return mortgageFromAmt;
	}

	public void setMortgageFromAmt(Double mortgageFromAmt) {
		this.mortgageFromAmt = mortgageFromAmt;
	}

	public Double getMortgageToAmt() {
		return mortgageToAmt;
	}

	public void setMortgageToAmt(Double mortgageToAmt) {
		this.mortgageToAmt = mortgageToAmt;
	}

	public Double getMortgageCharges() {
		return mortgageCharges;
	}

	public void setMortgageCharges(Double mortgageCharges) {
		this.mortgageCharges = mortgageCharges;
	}

	public Double getMortgageMaximunAmtCharges() {
		return mortgageMaximunAmtCharges;
	}

	public void setMortgageMaximunAmtCharges(Double mortgageMaximunAmtCharges) {
		this.mortgageMaximunAmtCharges = mortgageMaximunAmtCharges;
	}

	
}
