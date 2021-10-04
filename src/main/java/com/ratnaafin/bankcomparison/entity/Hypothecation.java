package com.ratnaafin.bankcomparison.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HYPOTHECATION")
public class Hypothecation {
private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hypothecationId")
    private Long hypothecationId;
	
	@Column(name = "hypothecationFromAmt")
    private Double hypothecationFromAmt;
	
	@Column(name = "hypothecationToAmt")
    private Double hypothecationToAmt;
	
	@Column(name = "hypothecationCharges")
    private Double hypothecationCharges;
	
	@Column(name = "hypothecationMaximunAmtCharges")
    private Double hypothecationMaximunAmtCharges;

	public Long getHypothecationId() {
		return hypothecationId;
	}

	public void setHypothecationId(Long hypothecationId) {
		this.hypothecationId = hypothecationId;
	}

	public Double getHypothecationFromAmt() {
		return hypothecationFromAmt;
	}

	public void setHypothecationFromAmt(Double hypothecationFromAmt) {
		this.hypothecationFromAmt = hypothecationFromAmt;
	}

	public Double getHypothecationToAmt() {
		return hypothecationToAmt;
	}

	public void setHypothecationToAmt(Double hypothecationToAmt) {
		this.hypothecationToAmt = hypothecationToAmt;
	}

	public Double getHypothecationCharges() {
		return hypothecationCharges;
	}

	public void setHypothecationCharges(Double hypothecationCharges) {
		this.hypothecationCharges = hypothecationCharges;
	}

	public Double getHypothecationMaximunAmtCharges() {
		return hypothecationMaximunAmtCharges;
	}

	public void setHypothecationMaximunAmtCharges(Double hypothecationMaximunAmtCharges) {
		this.hypothecationMaximunAmtCharges = hypothecationMaximunAmtCharges;
	}

	
}
