package com.assessment.creditcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.responsedto.CreditCardResponseDTO;
import com.assessment.creditcard.service.CreditCardService;
import com.assessment.creditcard.validator.CreditCardValidator;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Class is marked with the RestController annotation.It contains all the credit
 * card applications apis with different request URIs
 *
 * @author Jyoti
 */

@RestController
@Slf4j
public class CreditCardController {

	@Autowired
	private CreditCardValidator creditCardValidator;

	@Autowired
	private CreditCardService creditCardService;

	/**
	 * Method to add the credit card details that comes from the client into the
	 * database
	 *
	 * @param creditCardReqDto object which contains the request attributes for
	 *                         adding credit card details in the application
	 * @param result           instance of BindingRsult. Used for validation
	 *                         purpose.
	 * @return CreditCardResponseDTO as a response entity
	 */
	@PostMapping(value = "/addCreditCard")
	@ApiOperation(value = "Add credit card details for a user", produces = "application/json")
	public ResponseEntity<CreditCardResponseDTO> addCreditCard(
			@Valid @RequestBody CreditCardRequestDTO creditCardReqDto, BindingResult result) {
		log.info("Credit card processing starts {}", creditCardReqDto);
		creditCardValidator.validate(creditCardReqDto, result);
		CreditCardResponseDTO creditCardResponse = creditCardService.addCreditCard(creditCardReqDto);
		return new ResponseEntity<CreditCardResponseDTO>(creditCardResponse, HttpStatus.OK);
	}

	/**
	 * Method to get all the credit card details present in the application from the
	 * database
	 *
	 * @return List<CreditCardResponseDTO> as a response entity
	 */

	@GetMapping(value = "/getAll")
	@ApiOperation(value = "Get all credit card details", produces = "application/json")
	public ResponseEntity<List<CreditCardResponseDTO>> getAll() {
		log.info("Getting all credit cards");
		List<CreditCardResponseDTO> creditCardList = creditCardService.getAll();
		return new ResponseEntity<List<CreditCardResponseDTO>>(creditCardList, HttpStatus.OK);

	}
}
