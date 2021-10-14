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
@Table(name="CUTBACKDETAILS")
public class CutbackDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	
	@Column(name = "comparisonId")
	private Long comparisonId;
	
	@Column(name = "cutbackFromAmount")
	private BigDecimal cutbackFromAmount;
	
	@Column(name = "cutbackToAmount")
	private BigDecimal cutbackToAmount;
	
	@Column(name = "cutbackRatio")
	private BigDecimal cutbackRatio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getComparisonId() {
		return comparisonId;
	}

	public void setComparisonId(Long comparisonId) {
		this.comparisonId = comparisonId;
	}

	public BigDecimal getCutbackFromAmount() {
		return cutbackFromAmount;
	}

	public void setCutbackFromAmount(BigDecimal cutbackFromAmount) {
		this.cutbackFromAmount = cutbackFromAmount;
	}

	public BigDecimal getCutbackToAmount() {
		return cutbackToAmount;
	}

	public void setCutbackToAmount(BigDecimal cutbackToAmount) {
		this.cutbackToAmount = cutbackToAmount;
	}

	public BigDecimal getCutbackRatio() {
		return cutbackRatio;
	}

	public void setCutbackRatio(BigDecimal cutbackRatio) {
		this.cutbackRatio = cutbackRatio;
	}

}
