package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CurrencyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long seq;
	@Column(unique = true)
	private String currencyCode;
	private String conversionFactor;
	
	private String conversionFactorServicePort;

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public CurrencyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyModel(String currencyCode, String conversionFactor) {
		super();
		this.currencyCode = currencyCode;
		this.conversionFactor = conversionFactor;
	}

	public CurrencyModel(long seq, String currencyCode, String conversionFactor) {
		super();
		this.seq = seq;
		this.currencyCode = currencyCode;
		this.conversionFactor = conversionFactor;
	}

	public String getConversionFactorServicePort() {
		return conversionFactorServicePort;
	}

	public void setConversionFactorServicePort(String conversionFactorServicePort) {
		this.conversionFactorServicePort = conversionFactorServicePort;
	}
	
	

}
