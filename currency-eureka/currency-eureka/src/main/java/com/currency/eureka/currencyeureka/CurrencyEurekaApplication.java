package com.currency.eureka.currencyeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CurrencyEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyEurekaApplication.class, args);
	}

}
