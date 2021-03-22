package com.assessment.creditcard.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String name;
	
	private CreditCardDetailsRequestDTO creditCardDetails;

}
