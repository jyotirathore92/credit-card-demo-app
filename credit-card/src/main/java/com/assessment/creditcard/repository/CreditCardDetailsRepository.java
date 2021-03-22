package com.assessment.creditcard.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assessment.creditcard.model.CreditCardDetails;

@Repository
public interface CreditCardDetailsRepository extends CrudRepository<CreditCardDetails, Long> {

	@Query(value = "SELECT * FROM CREDIT_CARD_DETAILS C WHERE C.CUST_ID =?1", nativeQuery = true)
	CreditCardDetails findByCustId(long id);
}
