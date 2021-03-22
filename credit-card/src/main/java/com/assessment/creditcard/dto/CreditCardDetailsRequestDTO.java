package com.assessment.creditcard.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardDetailsRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String cardNumber;
	
	@NotNull
	private double amountLimit;
	
}
