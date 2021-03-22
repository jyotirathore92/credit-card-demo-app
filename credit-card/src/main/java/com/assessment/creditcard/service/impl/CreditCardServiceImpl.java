package com.assessment.creditcard.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.mapper.CreditCardMapper;
import com.assessment.creditcard.model.CreditCardCustomer;
import com.assessment.creditcard.model.CreditCardDetails;
import com.assessment.creditcard.repository.CreditCardCustomerRepository;
import com.assessment.creditcard.repository.CreditCardDetailsRepository;
import com.assessment.creditcard.responsedto.CreditCardResponseDTO;
import com.assessment.creditcard.service.CreditCardService;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class containing the business logic to add and retrieve credit card
 * details
 * 
 *
 * @author Jyoti
 */

@Service
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	CreditCardMapper creditCardMapper;

	@Autowired
	CreditCardCustomerRepository customerRepo;

	@Autowired
	CreditCardDetailsRepository creditCardRepo;

	/**
	 * Method to add the credit card details that comes from the client into the
	 * database. It maintains the transaction and rollsback in case of any issue.
	 *
	 * @param creditCardReqDto object which contains the request attributes for
	 *                         adding credit card details in the application
	 * @return CreditCardResponseDTO response after pushing the data into the
	 *         database
	 */

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CreditCardResponseDTO addCreditCard(CreditCardRequestDTO creditCardReq) {

		CreditCardResponseDTO creditCardResponse = new CreditCardResponseDTO();
		CreditCardCustomer customer = creditCardMapper.mapToCreditCardCustomer(creditCardReq);
		customer.setCreationDate(new Date());
		customer = customerRepo.save(customer);
		customer.getCreditCardData().setCustomer(customer);
		CreditCardDetails creditCard = creditCardRepo.save(customer.getCreditCardData());
		creditCardResponse = CreditCardResponseDTO.builder().cardNumber(creditCard.getCardNumber())
				.name(customer.getName()).amountLimit(creditCard.getAmountLimit()).balance(0).build();
		return creditCardResponse;
	}

	/**
	 * Method to get all the credit card details
	 *
	 * @return List<CreditCardResponseDTO> contains all the credit card data and is
	 *         returned as a list
	 */

	@Override
	public List<CreditCardResponseDTO> getAll() {

		List<CreditCardCustomer> customerList = (List<CreditCardCustomer>) customerRepo.findAll();
		List<CreditCardResponseDTO> creditCardResponse = new ArrayList<>();

		customerList.stream().forEach(customer -> {
			CreditCardDetails creditCard = creditCardRepo.findByCustId(customer.getId());
			if (null == creditCard) {
				log.info("No credit card details for customer " + customer.getName());
			} else {
				CreditCardResponseDTO response = new CreditCardResponseDTO();
				response = CreditCardResponseDTO.builder().cardNumber(creditCard.getCardNumber())
						.name(customer.getName()).amountLimit(creditCard.getAmountLimit()).build();
				creditCardResponse.add(response);
			}
		});
		return creditCardResponse;
	}

}
