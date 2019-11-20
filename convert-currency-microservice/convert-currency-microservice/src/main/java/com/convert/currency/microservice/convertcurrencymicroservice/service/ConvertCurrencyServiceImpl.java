package com.convert.currency.microservice.convertcurrencymicroservice.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.convert.currency.microservice.convertcurrencymicroservice.dto.ConvertedCurrenecyDTO;
import com.convert.currency.microservice.convertcurrencymicroservice.exceptions.ConvertCurrencyException;
import com.convert.currency.microservice.convertcurrencymicroservice.feignclients.CurrencyConversionFactorProxy;
import com.convert.currency.microservice.convertcurrencymicroservice.modelproxy.CurrencyModelProxy;

@Service
public class ConvertCurrencyServiceImpl implements ConvertCurrencyService {

	@Autowired
	private CurrencyConversionFactorProxy currencyConversionFactorProxy;

	@Override
	public ConvertedCurrenecyDTO convertCurrency(String inputAmount, String ccode) throws ConvertCurrencyException {

		CurrencyModelProxy currencyModelProxy = currencyConversionFactorProxy.getConversionFactor(ccode);
		ConvertedCurrenecyDTO convertedCurrenecyDTO = new ConvertedCurrenecyDTO(ccode, inputAmount);
		if (null != currencyModelProxy) {
			if(currencyModelProxy.getConversionFactor().equals("error")) {
				throw new ConvertCurrencyException("No Currency available . Please check");
			}
			BigDecimal inputAmt = new BigDecimal(inputAmount);
			BigDecimal cf = new BigDecimal(currencyModelProxy.getConversionFactor());
			convertedCurrenecyDTO.setConvertedAmount(inputAmt.multiply(cf).toString());
			convertedCurrenecyDTO.setConversionFactorServicePort(currencyModelProxy.getConversionFactorServicePort());
		} else {
			throw new ConvertCurrencyException("No Currency available . Please check");
		}

		return convertedCurrenecyDTO;
	}

}
