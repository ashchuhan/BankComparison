package com.ratnaafin.bankcomparison.entity;

import java.io.Serializable;

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
	private Double cutbackFromAmount;
	
	@Column(name = "cutbackToAmount")
	private Double cutbackToAmount;
	
	@Column(name = "cutbackRatio")
	private Double cutbackRatio;

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

	public Double getCutbackFromAmount() {
		return cutbackFromAmount;
	}

	public void setCutbackFromAmount(Double cutbackFromAmount) {
		this.cutbackFromAmount = cutbackFromAmount;
	}

	public Double getCutbackToAmount() {
		return cutbackToAmount;
	}

	public void setCutbackToAmount(Double cutbackToAmount) {
		this.cutbackToAmount = cutbackToAmount;
	}

	public Double getCutbackRatio() {
		return cutbackRatio;
	}

	public void setCutbackRatio(Double cutbackRatio) {
		this.cutbackRatio = cutbackRatio;
	}

}
