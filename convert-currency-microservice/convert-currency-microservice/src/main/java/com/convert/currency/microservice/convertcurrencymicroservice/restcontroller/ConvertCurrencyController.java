package com.convert.currency.microservice.convertcurrencymicroservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.convert.currency.microservice.convertcurrencymicroservice.dto.ConvertedCurrenecyDTO;
import com.convert.currency.microservice.convertcurrencymicroservice.exceptions.ConvertCurrencyException;
import com.convert.currency.microservice.convertcurrencymicroservice.service.ConvertCurrencyService;

@RestController
@RequestMapping("/currency")
public class ConvertCurrencyController {
	
	@Autowired
	private ConvertCurrencyService convertCurrencyService;
	
	
	@GetMapping("/convert/{amt}/{ccode}")
	public ConvertedCurrenecyDTO convertCurrency(@PathVariable("amt") String inputAmount,
			@PathVariable("ccode") String ccode) throws ConvertCurrencyException {
		return convertCurrencyService.convertCurrency(inputAmount,ccode);
	}
	
	
	

}
