package com.assessment.creditcard.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.assessment.creditcard.config.CreditCardTestConfig;
import com.assessment.creditcard.dto.CreditCardDetailsRequestDTO;
import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.mapper.CreditCardMapper;
import com.assessment.creditcard.model.CreditCardCustomer;
import com.assessment.creditcard.model.CreditCardDetails;
import com.assessment.creditcard.repository.CreditCardCustomerRepository;
import com.assessment.creditcard.repository.CreditCardDetailsRepository;
import com.assessment.creditcard.service.impl.CreditCardServiceImpl;

public class CreditCardServiceTest extends CreditCardTestConfig{

	@InjectMocks
	private CreditCardServiceImpl creditCardServiceImpl;

	@Mock
	CreditCardMapper creditCardMapper;

	@Mock
	CreditCardCustomerRepository customerRepo;

	@Mock
	CreditCardDetailsRepository creditCardRepo;
	
	@Test
	public void addCreditCardTest() {
		
		CreditCardRequestDTO request = new CreditCardRequestDTO("Tina",
				CreditCardDetailsRequestDTO.builder().cardNumber("123456").amountLimit(100).build());
		
		CreditCardCustomer creditCardCustomer = CreditCardCustomer.builder().name("Tina")
				.creditCardData(CreditCardDetails.builder().cardNumber("123456").amountLimit(100).build()).build();
		
		CreditCardCustomer creditCardCustomerAfterSaving = CreditCardCustomer.builder().id(1).name("Tina")
				.creditCardData(CreditCardDetails.builder().cardNumber("123456").amountLimit(100).build()).build();
		
		CreditCardDetails creditCardDataAfterSaving = CreditCardDetails.builder().id(1).cardNumber("123456").build();
		when(creditCardMapper.mapToCreditCardCustomer(request)).thenReturn(creditCardCustomer);
		when(customerRepo.save(creditCardCustomer)).thenReturn(creditCardCustomerAfterSaving);
		when(creditCardRepo.save(creditCardCustomerAfterSaving.getCreditCardData())).thenReturn(creditCardDataAfterSaving);
		
		creditCardServiceImpl.addCreditCard(request);
		
		verify(customerRepo, times(1)).save(creditCardCustomer);
	}
	
	@Test
	public void getAllTest() {
		
		
		List<CreditCardCustomer> creditCardCustomerList = new ArrayList<>();
		CreditCardCustomer creditCardCustomer = CreditCardCustomer.builder().id(1).name("Tina")
				.creditCardData(CreditCardDetails.builder().cardNumber("123456").amountLimit(100).build()).build();
		
		creditCardCustomerList.add(creditCardCustomer);
		
		CreditCardDetails creditCardData = CreditCardDetails.builder().id(1).cardNumber("123456").build();
		when(customerRepo.findAll()).thenReturn(creditCardCustomerList);
		when(creditCardRepo.findByCustId(creditCardCustomer.getId())).thenReturn(creditCardData);
		
		creditCardServiceImpl.getAll();
		
		verify(customerRepo, times(1)).findAll();
	}
}
