package com.assessment.creditcard.responsedto;

import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardResponseDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String name;
	private String cardNumber;
	private double amountLimit;
	private double balance;
}
