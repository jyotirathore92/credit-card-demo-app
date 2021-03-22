package com.assessment.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the triggering point of the Credit Card Application service
 * which provides API's for adding credit card data and viewing all the credit card 
 * data present in the application.
 *
 * @author Jyoti
 */

@SpringBootApplication
public class CreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);

	}
}
