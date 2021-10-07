package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANKMASTER")
public class BankMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bankId")
	private Long bankId;

	@Column(name="bankName")
	private String bankName;
	
	@Column(name="bankType")
	private String bankType;

	@Column(name = "minimumCapitalClause")
	private String minimumCapitalClause;
	
	@Column(name = "furtherDisbursement")
	private String furtherDisbursement;
	
	@Column(name = "possibilitiesofDisbursementAmount")
	private String possibilitiesofDisbursementAmount;

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getMinimumCapitalClause() {
		return minimumCapitalClause;
	}

	public void setMinimumCapitalClause(String minimumCapitalClause) {
		this.minimumCapitalClause = minimumCapitalClause;
	}

	public String getFurtherDisbursement() {
		return furtherDisbursement;
	}

	public void setFurtherDisbursement(String furtherDisbursement) {
		this.furtherDisbursement = furtherDisbursement;
	}

	public String getPossibilitiesofDisbursementAmount() {
		return possibilitiesofDisbursementAmount;
	}

	public void setPossibilitiesofDisbursementAmount(String possibilitiesofDisbursementAmount) {
		this.possibilitiesofDisbursementAmount = possibilitiesofDisbursementAmount;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
}