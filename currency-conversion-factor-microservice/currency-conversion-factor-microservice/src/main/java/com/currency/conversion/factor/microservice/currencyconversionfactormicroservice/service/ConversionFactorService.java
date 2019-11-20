package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.service;

import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions.ConversionExeption;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions.CurrencyNotFoundException;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.model.CurrencyModel;

public interface ConversionFactorService {

	CurrencyModel createCurrencyConverionFactor(CurrencyModel currencyModel) throws ConversionExeption;

	CurrencyModel getConversionFactorByCurrencyCode(String ccode) throws CurrencyNotFoundException;

	CurrencyModel updateCurrencyConverionFactor(CurrencyModel currencyModel) throws ConversionExeption;

	CurrencyModel handleNoConversionFactor();

}
