package com.assessment.creditcard.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = { "customer" })
public class CreditCardDetails implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "CREDITCARD_SEQ", allocationSize = 1)
	private long id;
	
	@OneToOne
	@JoinColumn(name="CUST_ID", nullable = false)
	private CreditCardCustomer customer;
	
	@Column(name = "CARD_NUMBER", nullable = false)
	private String cardNumber;
	
	@Column(name = "AMOUNT_LIMIT", nullable = false)
	private double amountLimit;
	
	@Column(name = "BALANCE", nullable = false)
	private double balance;
	
}
