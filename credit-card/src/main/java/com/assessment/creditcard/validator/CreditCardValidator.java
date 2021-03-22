package com.assessment.creditcard.validator;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.exception.BadRequestException;

/**
 * Class to validate all the input parameters which are present in the request
 * object
 *
 * @author Jyoti
 */

@Component
public class CreditCardValidator implements Validator {

	static final String NAME = "name";

	@Override
	public boolean supports(Class<?> clazz) {
		return CreditCardRequestDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CreditCardRequestDTO creditCardRequestDTO = (CreditCardRequestDTO) target;

		if (creditCardRequestDTO.getName().isBlank()) {
			errors.rejectValue(NAME, "Please enter name");
		}
		if (creditCardRequestDTO.getCreditCardDetails().getCardNumber().isBlank()) {
			errors.rejectValue(null, "EMPTY");
		} else if (!creditCardRequestDTO.getCreditCardDetails().getCardNumber().matches("\\d*")) {
			errors.rejectValue(null, "Invalid characters in credit card number");
		} else if (creditCardRequestDTO.getCreditCardDetails().getCardNumber().length() > 19) {
			errors.rejectValue(null, "Invalid credit card number length");
		} else if (!luhnCheck(creditCardRequestDTO.getCreditCardDetails().getCardNumber())) {
			errors.rejectValue(null, "Invalid credit card number");
		}

		if (errors.hasErrors()) {
			throw new BadRequestException(errors.getAllErrors());
		}

	}

	private boolean luhnCheck(String cardNumber) {
		PrimitiveIterator.OfInt factor = IntStream.iterate(1, i -> 3 - i).iterator();

		int sum = new StringBuilder(cardNumber).reverse().toString().chars().map(character -> character - '0')
				.map(i -> i * factor.nextInt()).reduce(0, (char1, char2) -> char1 + char2 / 10 + char2 % 10);

		return (sum % 10) == 0;
	}

}
