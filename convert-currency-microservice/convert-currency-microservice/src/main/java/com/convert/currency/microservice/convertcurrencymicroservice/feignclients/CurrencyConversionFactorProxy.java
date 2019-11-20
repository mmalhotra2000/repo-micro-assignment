package com.convert.currency.microservice.convertcurrencymicroservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.convert.currency.microservice.convertcurrencymicroservice.modelproxy.CurrencyModelProxy;


@FeignClient(name = "CurrencyConversionFactorMicroserviceApplication")
public interface CurrencyConversionFactorProxy {

	@GetMapping("/conversion/getconversion/{ccode}")
	public CurrencyModelProxy getConversionFactor(@PathVariable("ccode") String ccode);
}
