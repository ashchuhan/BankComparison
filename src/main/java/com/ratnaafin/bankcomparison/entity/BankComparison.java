package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
	private BigDecimal loanAmount;

	@Column(name = "processingFees")
	private BigDecimal processingFees;
	
	@Column(name = "processingFeesPer")
	private BigDecimal processingFeesPer;
	
	@Column(name = "processingFeesGst")
	private BigDecimal processingFeesGst;
	
	@Column(name = "consultancyFees")
	private BigDecimal consultancyFees;
	
	@Column(name = "consultancyFeesGst")
	private BigDecimal consultancyFeesGst;
	
	
	@Column(name = "interestRate")
	private BigDecimal interestRate;
	
	@Column(name = "interestExpense")
	private BigDecimal interestExpense;

	@Column(name = "renewalFees")
	private BigDecimal renewalFees;
	
	@Column(name = "renewalExpenses")
	private BigDecimal renewalExpenses;
	
	@Column(name = "hypothecation")
	private BigDecimal hypothecation;
	
	@Column(name = "mortgageCharges")
	private BigDecimal mortgageCharges;

	@Column(name = "progressReport")
	private BigDecimal progressReport;
	
	@Column(name = "collateral")
	private String collateral;
	
	@Column(name = "collateralPer")
	private BigDecimal collateralPer;
	
	@Column(name = "valuationReport")
	private BigDecimal valuationReport;
	
	@Column(name = "totalExpenses")
	private BigDecimal totalExpenses;
	
	@Column(name = "minimumCapitalClause")
	private String minimumCapitalClause;
	
	@Column(name = "furtherDisbursement")
	private String furtherDisbursement;
	
	@Column(name = "possibilitiesofDisbursementAmount")
	private String possibilitiesofDisbursementAmount;
	
	@Column(name = "collectionAmnt")
	private BigDecimal collectionAmnt;
	
	@Column(name = "loanTenure")
	private BigDecimal loanTenure;
	
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

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(BigDecimal processingFees) {
		this.processingFees = processingFees;
	}

	public BigDecimal getProcessingFeesPer() {
		return processingFeesPer;
	}

	public void setProcessingFeesPer(BigDecimal processingFeesPer) {
		this.processingFeesPer = processingFeesPer;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public BigDecimal getInterestExpense() {
		return interestExpense;
	}

	public void setInterestExpense(BigDecimal interestExpense) {
		this.interestExpense = interestExpense;
	}

	public BigDecimal getRenewalFees() {
		return renewalFees;
	}

	public void setRenewalFees(BigDecimal renewalFees) {
		this.renewalFees = renewalFees;
	}

	public BigDecimal getRenewalExpenses() {
		return renewalExpenses;
	}

	public void setRenewalExpenses(BigDecimal renewalExpenses) {
		this.renewalExpenses = renewalExpenses;
	}

	public BigDecimal getHypothecation() {
		return hypothecation;
	}

	public void setHypothecation(BigDecimal hypothecation) {
		this.hypothecation = hypothecation;
	}

	public BigDecimal getMortgageCharges() {
		return mortgageCharges;
	}

	public void setMortgageCharges(BigDecimal mortgageCharges) {
		this.mortgageCharges = mortgageCharges;
	}

	public BigDecimal getProgressReport() {
		return progressReport;
	}

	public void setProgressReport(BigDecimal progressReport) {
		this.progressReport = progressReport;
	}

	public String getCollateral() {
		return collateral;
	}

	public void setCollateral(String collateral) {
		this.collateral = collateral;
	}

	public BigDecimal getCollateralPer() {
		return collateralPer;
	}

	public void setCollateralPer(BigDecimal collateralPer) {
		this.collateralPer = collateralPer;
	}

	public BigDecimal getValuationReport() {
		return valuationReport;
	}

	public void setValuationReport(BigDecimal valuationReport) {
		this.valuationReport = valuationReport;
	}

	public BigDecimal getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(BigDecimal totalExpenses) {
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

	public BigDecimal getCollectionAmnt() {
		return collectionAmnt;
	}

	public void setCollectionAmnt(BigDecimal collectionAmnt) {
		this.collectionAmnt = collectionAmnt;
	}

	
	
	public BigDecimal getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(BigDecimal loanTenure) {
		this.loanTenure = loanTenure;
	}

	public String getLoanStartDate() {
		return loanStartDate;
	}

	public void setLoanStartDate(String loanStartDate) {
		this.loanStartDate = loanStartDate;
	}

	
	public BigDecimal getProcessingFeesGst() {
		return processingFeesGst;
	}

	public void setProcessingFeesGst(BigDecimal processingFeesGst) {
		this.processingFeesGst = processingFeesGst;
	}

	public BigDecimal getConsultancyFees() {
		return consultancyFees;
	}

	public void setConsultancyFees(BigDecimal consultancyFees) {
		this.consultancyFees = consultancyFees;
	}

	public BigDecimal getConsultancyFeesGst() {
		return consultancyFeesGst;
	}

	public void setConsultancyFeesGst(BigDecimal consultancyFeesGst) {
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