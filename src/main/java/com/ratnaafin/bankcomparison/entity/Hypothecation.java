package com.ratnaafin.bankcomparison.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HYPOTHECATION")
public class Hypothecation {
@SuppressWarnings("unused")
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hypothecationId")
    private Long hypothecationId;
	
	@Column(name = "hypothecationFromAmt")
    private BigDecimal hypothecationFromAmt;
	
	@Column(name = "hypothecationToAmt")
    private BigDecimal hypothecationToAmt;
	
	@Column(name = "hypothecationCharges")
    private BigDecimal hypothecationCharges;
	
	@Column(name = "hypothecationMaximunAmtCharges")
    private BigDecimal hypothecationMaximunAmtCharges;

	public Long getHypothecationId() {
		return hypothecationId;
	}

	public void setHypothecationId(Long hypothecationId) {
		this.hypothecationId = hypothecationId;
	}

	public BigDecimal getHypothecationFromAmt() {
		return hypothecationFromAmt;
	}

	public void setHypothecationFromAmt(BigDecimal hypothecationFromAmt) {
		this.hypothecationFromAmt = hypothecationFromAmt;
	}

	public BigDecimal getHypothecationToAmt() {
		return hypothecationToAmt;
	}

	public void setHypothecationToAmt(BigDecimal hypothecationToAmt) {
		this.hypothecationToAmt = hypothecationToAmt;
	}

	public BigDecimal getHypothecationCharges() {
		return hypothecationCharges;
	}

	public void setHypothecationCharges(BigDecimal hypothecationCharges) {
		this.hypothecationCharges = hypothecationCharges;
	}

	public BigDecimal getHypothecationMaximunAmtCharges() {
		return hypothecationMaximunAmtCharges;
	}

	public void setHypothecationMaximunAmtCharges(BigDecimal hypothecationMaximunAmtCharges) {
		this.hypothecationMaximunAmtCharges = hypothecationMaximunAmtCharges;
	}

	
}
