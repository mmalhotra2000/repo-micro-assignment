package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.model.CurrencyModel;
import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.service.ConversionFactorService;

@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class CurrencyConversionFactorMicroserviceApplication implements CommandLineRunner {

	@Autowired
	private ConversionFactorService conversionFactorService;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionFactorMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CurrencyModel currencyModel1 = new CurrencyModel("USD", "78");
		CurrencyModel currencyModel2 = new CurrencyModel("INR", "12");
		conversionFactorService.createCurrencyConverionFactor(currencyModel1);
		conversionFactorService.createCurrencyConverionFactor(currencyModel2);
	}

}
