package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions.ConversionExeption;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions.CurrencyNotFoundException;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.model.CurrencyModel;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.repository.CurrencyModelRepository;

@Service
public class ConversionFactorServiceImpl implements ConversionFactorService {

	
	@Autowired
	private Environment env;

	
	@Autowired
	private CurrencyModelRepository currencyModelRepository;

	@Override
	public CurrencyModel createCurrencyConverionFactor(CurrencyModel currencyModel) throws ConversionExeption {
		CurrencyModel currencyModel2 = currencyModelRepository.findByCurrencyCode(currencyModel.getCurrencyCode());
		if (null != currencyModel2) {
			throw new ConversionExeption("Requested currency already exists in the system.");
		}
		return currencyModelRepository.save(currencyModel);
	}

	@Override
	public CurrencyModel getConversionFactorByCurrencyCode(String ccode) throws CurrencyNotFoundException {
		CurrencyModel currencyModel = currencyModelRepository.findByCurrencyCode(ccode);
		if (null == currencyModel) {
			throw new CurrencyNotFoundException("Requested currency does not exist in the system.");
		}
		currencyModel.setConversionFactorServicePort(env.getProperty("server.port"));
		return currencyModelRepository.findByCurrencyCode(ccode);
	}

	@Override
	public CurrencyModel updateCurrencyConverionFactor(CurrencyModel currencyModel) throws ConversionExeption {
		CurrencyModel currencyModel2 = getConversionFactorByCurrencyCode(currencyModel.getCurrencyCode());
		if (null != currencyModel2) {
			currencyModel2.setConversionFactor(currencyModel.getConversionFactor());
		} else {
			throw new CurrencyNotFoundException("Requested currency does not exist in the system.");
		}
		currencyModelRepository.save(currencyModel2);
		return currencyModel2;
	}

	@Override
	public CurrencyModel handleNoConversionFactor() {

		return new CurrencyModel("error", "error");
	}

}
