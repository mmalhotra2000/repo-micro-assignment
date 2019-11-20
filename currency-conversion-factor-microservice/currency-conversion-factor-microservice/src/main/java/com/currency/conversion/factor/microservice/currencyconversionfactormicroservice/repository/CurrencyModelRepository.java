package com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.currency.conversion.factor.microservice.currencyconversionfactormicroservice.model.CurrencyModel;

@Repository
public interface CurrencyModelRepository extends JpaRepository<CurrencyModel, Long> {

	CurrencyModel findByCurrencyCode(String ccode);

}
