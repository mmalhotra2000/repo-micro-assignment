package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CurrencyConversionFactorResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(CurrencyNotFoundException.class)
	public final ResponseEntity<Object> handleCurrencyNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(ConversionExeption.class)
	public final ResponseEntity<Object> handleConversionExeption(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

	}
}