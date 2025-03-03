package com.convert.currency.microservice.convertcurrencymicroservice.dto;

public class ConvertedCurrenecyDTO {

	private String currencyCode;
	private String inputAmount;
	private String convertedAmount;
	
	private String conversionFactorServicePort;

	public ConvertedCurrenecyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public ConvertedCurrenecyDTO(String currencyCode, String inputAmount) {
		super();
		this.currencyCode = currencyCode;
		this.inputAmount = inputAmount;
	}



	public ConvertedCurrenecyDTO(String currencyCode, String inputAmount, String convertedAmount) {
		super();
		this.currencyCode = currencyCode;
		this.inputAmount = inputAmount;
		this.convertedAmount = convertedAmount;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getInputAmount() {
		return inputAmount;
	}

	public void setInputAmount(String inputAmount) {
		this.inputAmount = inputAmount;
	}

	public String getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(String convertedAmount) {
		this.convertedAmount = convertedAmount;
	}



	public String getConversionFactorServicePort() {
		return conversionFactorServicePort;
	}



	public void setConversionFactorServicePort(String conversionFactorServicePort) {
		this.conversionFactorServicePort = conversionFactorServicePort;
	}
	
	

}
