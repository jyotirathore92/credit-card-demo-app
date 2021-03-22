package com.assessment.creditcard.service;

import java.util.List;

import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.responsedto.CreditCardResponseDTO;

public interface CreditCardService {

	CreditCardResponseDTO addCreditCard(CreditCardRequestDTO creditCardReq);
	
	List<CreditCardResponseDTO> getAll();
}
