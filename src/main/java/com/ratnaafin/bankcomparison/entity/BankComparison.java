package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BANKCOMPARISON")
public class BankComparison implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "customerId")
	private Long customerId;
	
	@Column(name = "bankId")
	private Long bankId;
	
	@Transient
	private String bankName;

	@Column(name = "loanAmount")
	private Double loanAmount;

	@Column(name = "processingFees")
	private Double processingFees;
	
	@Column(name = "processingFeesPer")
	private Double processingFeesPer;
	
	@Column(name = "processingFeesGst")
	private Double processingFeesGst;
	
	@Column(name = "consultancyFees")
	private Double consultancyFees;
	
	@Column(name = "consultancyFeesGst")
	private Double consultancyFeesGst;
	
	
	@Column(name = "interestRate")
	private Double interestRate;
	
	@Column(name = "interestExpense")
	private Double interestExpense;

	@Column(name = "renewalFees")
	private Double renewalFees;
	
	@Column(name = "renewalExpenses")
	private Double renewalExpenses;
	
	@Column(name = "hypothecation")
	private Double hypothecation;
	
	@Column(name = "mortgageCharges")
	private Double mortgageCharges;

	@Column(name = "progressReport")
	private Double progressReport;
	
	@Column(name = "collateral")
	private String collateral;
	
	@Column(name = "collateralPer")
	private Double collateralPer;
	
	@Column(name = "valuationReport")
	private Double valuationReport;
	
	@Column(name = "totalExpenses")
	private Double totalExpenses;
	
	@Column(name = "minimumCapitalClause")
	private String minimumCapitalClause;
	
	@Column(name = "furtherDisbursement")
	private String furtherDisbursement;
	
	@Column(name = "possibilitiesofDisbursementAmount")
	private String possibilitiesofDisbursementAmount;
	
	@Column(name = "collectionAmnt")
	private Double collectionAmnt;
	
	@Column(name = "loanTenure")
	private Double loanTenure;
	
	@Column(name = "loanStartDate")
	private String loanStartDate;
	
	@Column(name = "moratoriumPeriodStartDate")
	private String moratoriumPeriodStartDate;

	@Column(name = "moratoriumPeriodEndDate")
	private String moratoriumPeriodEndDate;
	
	@Column(name = "repaymentPeriodStartDate")
	private String repaymentPeriodStartDate;
	
	@Column(name = "repaymentPeriodEndDate")
	private String repaymentPeriodEndDate;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(Double processingFees) {
		this.processingFees = processingFees;
	}

	public Double getProcessingFeesPer() {
		return processingFeesPer;
	}

	public void setProcessingFeesPer(Double processingFeesPer) {
		this.processingFeesPer = processingFeesPer;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getInterestExpense() {
		return interestExpense;
	}

	public void setInterestExpense(Double interestExpense) {
		this.interestExpense = interestExpense;
	}

	public Double getRenewalFees() {
		return renewalFees;
	}

	public void setRenewalFees(Double renewalFees) {
		this.renewalFees = renewalFees;
	}

	public Double getRenewalExpenses() {
		return renewalExpenses;
	}

	public void setRenewalExpenses(Double renewalExpenses) {
		this.renewalExpenses = renewalExpenses;
	}

	public Double getHypothecation() {
		return hypothecation;
	}

	public void setHypothecation(Double hypothecation) {
		this.hypothecation = hypothecation;
	}

	public Double getMortgageCharges() {
		return mortgageCharges;
	}

	public void setMortgageCharges(Double mortgageCharges) {
		this.mortgageCharges = mortgageCharges;
	}

	public Double getProgressReport() {
		return progressReport;
	}

	public void setProgressReport(Double progressReport) {
		this.progressReport = progressReport;
	}

	public String getCollateral() {
		return collateral;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}

	public Double getCollateralPer() {
		return collateralPer;
	}

	public void setCollateralPer(Double collateralPer) {
		this.collateralPer = collateralPer;
	}

	public Double getValuationReport() {
		return valuationReport;
	}

	public void setValuationReport(Double valuationReport) {
		this.valuationReport = valuationReport;
	}

	public Double getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(Double totalExpenses) {
		this.totalExpenses = totalExpenses;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getCollectionAmnt() {
		return collectionAmnt;
	}

	public void setCollectionAmnt(Double collectionAmnt) {
		this.collectionAmnt = collectionAmnt;
	}

	
	
	public Double getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(Double loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(String loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	
	public Double getProcessingFeesGst() {
		return processingFeesGst;
	}

	public void setProcessingFeesGst(Double processingFeesGst) {
		this.processingFeesGst = processingFeesGst;
	}

	public Double getConsultancyFees() {
		return consultancyFees;
	}

	public void setConsultancyFees(Double consultancyFees) {
		this.consultancyFees = consultancyFees;
	}

	public Double getConsultancyFeesGst() {
		return consultancyFeesGst;
	}

	public void setConsultancyFeesGst(Double consultancyFeesGst) {
		this.consultancyFeesGst = consultancyFeesGst;
	}

	public String getMoratoriumPeriodStartDate() {
		return moratoriumPeriodStartDate;
	}

	public void setMoratoriumPeriodStartDate(String moratoriumPeriodStartDate) {
		this.moratoriumPeriodStartDate = moratoriumPeriodStartDate;
	}

	public String getMoratoriumPeriodEndDate() {
		return moratoriumPeriodEndDate;
	}

	public void setMoratoriumPeriodEndDate(String moratoriumPeriodEndDate) {
		this.moratoriumPeriodEndDate = moratoriumPeriodEndDate;
	}

	public String getRepaymentPeriodStartDate() {
		return repaymentPeriodStartDate;
	}

	public void setRepaymentPeriodStartDate(String repaymentPeriodStartDate) {
		this.repaymentPeriodStartDate = repaymentPeriodStartDate;
	}

	public String getRepaymentPeriodEndDate() {
		return repaymentPeriodEndDate;
	}

	public void setRepaymentPeriodEndDate(String repaymentPeriodEndDate) {
		this.repaymentPeriodEndDate = repaymentPeriodEndDate;
	}

}