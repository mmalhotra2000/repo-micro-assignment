package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.restcontroller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions.ConversionExeption;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions.CurrencyNotFoundException;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.model.CurrencyModel;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.service.ConversionFactorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/conversion")
public class ConversionFactorController {

	@Autowired
	private ConversionFactorService conversionFactorService;

	/**
	 * To add new currency conversion factor
	 * 
	 * @param currencyModel
	 * @return
	 * @throws ConversionExeption
	 */
	@PostMapping("/addcurrency")
	public ResponseEntity<Object> createCurrencyConverionFactor(@RequestBody CurrencyModel currencyModel)
			throws ConversionExeption {

		CurrencyModel currencyModelSaved = conversionFactorService.createCurrencyConverionFactor(currencyModel);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/conversion/getconversion/{ccode}")
				.buildAndExpand(currencyModelSaved.getCurrencyCode()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@HystrixCommand(fallbackMethod = "noConversionFactorHandler")
	@GetMapping("/getconversion/{ccode}")
	public CurrencyModel getConversionFactor(@PathVariable("ccode") String ccode) throws CurrencyNotFoundException {

		return conversionFactorService.getConversionFactorByCurrencyCode(ccode);
	}

	public CurrencyModel noConversionFactorHandler(String ccode) {

		return conversionFactorService.handleNoConversionFactor();
	}

	/**
	 * To add new currency conversion factor
	 * 
	 * @param currencyModel
	 * @return
	 * @throws ConversionExeption
	 */
	@PutMapping("/updatecurrency")
	public ResponseEntity<Object> updateCurrencyConverionFactor(@RequestBody CurrencyModel currencyModel)
			throws ConversionExeption {

		CurrencyModel currencyModelUpdated = conversionFactorService.updateCurrencyConverionFactor(currencyModel);

		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/conversion/getconverion/{ccode}")
				.buildAndExpand(currencyModelUpdated.getCurrencyCode()).toUri();

		return ResponseEntity.status(HttpStatus.NO_CONTENT).location(uri).build();
	}

}
