package com.convert.currency.microservice.convertcurrencymicroservice.doc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Contact DEFAULT_CONTACT = new Contact("Mohit Malhotra", "https://www.gyansetu.in",
			"mmalhotra2000@gmail.com");

	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Convert Currency microservice API",
			"Give a amount and currency code to the final amount ", "v1.0", "https://www.gyansetu.in", DEFAULT_CONTACT,
			"license", "https://www.gyansetu.in");

	private static final Set<String> PRODUCES_CONSUMES = new HashSet<>(
			Arrays.asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(PRODUCES_CONSUMES)
				.consumes(PRODUCES_CONSUMES);

	}

}