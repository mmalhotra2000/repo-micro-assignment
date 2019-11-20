package com.convert.currency.microservice.convertcurrencymicroservice.modelproxy;

public class CurrencyModelProxy {

	private String currencyCode;
	private String conversionFactor;
	
	private String conversionFactorServicePort;
	
	
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
	
	

	public String getConversionFactorServicePort() {
		return conversionFactorServicePort;
	}

	public void setConversionFactorServicePort(String conversionFactorServicePort) {
		this.conversionFactorServicePort = conversionFactorServicePort;
	}

	public CurrencyModelProxy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyModelProxy(String currencyCode, String conversionFactor) {
		super();
		this.currencyCode = currencyCode;
		this.conversionFactor = conversionFactor;
	}

}
