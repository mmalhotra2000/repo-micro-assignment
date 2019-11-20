package com.convert.currency.microservice.convertcurrencymicroservice.service;

import com.convert.currency.microservice.convertcurrencymicroservice.dto.ConvertedCurrenecyDTO;
import com.convert.currency.microservice.convertcurrencymicroservice.exceptions.ConvertCurrencyException;

public interface ConvertCurrencyService {

	ConvertedCurrenecyDTO convertCurrency(String inputAmount, String ccode) throws ConvertCurrencyException;
	
	

}
