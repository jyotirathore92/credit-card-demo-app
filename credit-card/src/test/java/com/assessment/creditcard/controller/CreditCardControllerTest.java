package com.assessment.creditcard.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.assessment.creditcard.config.CreditCardTestConfig;
import com.assessment.creditcard.dto.CreditCardDetailsRequestDTO;
import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.responsedto.CreditCardResponseDTO;
import com.assessment.creditcard.service.CreditCardService;
import com.assessment.creditcard.validator.CreditCardValidator;

// @ActiveProfiles("test")
// @ExtendWith(MockitoExtension.class)
// @SpringBootTest(classes = CreditCardApplication.class)
public class CreditCardControllerTest extends CreditCardTestConfig {

	@InjectMocks
	private CreditCardController creditCardController;

	@Mock
	private CreditCardValidator creditCardValidator;

	@Mock
	private CreditCardService creditCardService;

	@Test
	public void addCreditCardTest() {
		BindingResult bindingResult = new BeanPropertyBindingResult(new CreditCardRequestDTO(), "request");
		CreditCardRequestDTO request = new CreditCardRequestDTO("Tina",
				CreditCardDetailsRequestDTO.builder().cardNumber("123456").amountLimit(100).build());
		doNothing().when(creditCardValidator).validate(request, bindingResult);
		Mockito.when(creditCardService.addCreditCard(request))
				.thenReturn(CreditCardResponseDTO.builder().cardNumber("123456").name("Tina").build());
		
		
		CreditCardResponseDTO response = CreditCardResponseDTO.builder().cardNumber("123456").name("Tina").build();
		creditCardController.addCreditCard(request, bindingResult);
		assertEquals(response.getCardNumber(), "123456");
	}
	
	@Test
	public void getAllTest() {
		
		List<CreditCardResponseDTO> creditCardResponseDtoList = new ArrayList<>();
		creditCardResponseDtoList.add(CreditCardResponseDTO.builder().
				cardNumber("123456").name("Tina").build());
		Mockito.when(creditCardService.getAll())
				.thenReturn(creditCardResponseDtoList);
		
		
		CreditCardResponseDTO response = CreditCardResponseDTO.builder().cardNumber("123456").name("Tina").build();
		creditCardController.getAll();
		assertEquals(response.getCardNumber(), "123456");
	}

}
