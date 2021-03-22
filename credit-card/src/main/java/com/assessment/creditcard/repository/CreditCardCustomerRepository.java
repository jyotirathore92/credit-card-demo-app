package com.assessment.creditcard.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.creditcard.model.CreditCardCustomer;

@Repository
public interface CreditCardCustomerRepository extends CrudRepository<CreditCardCustomer, Long>{

}
