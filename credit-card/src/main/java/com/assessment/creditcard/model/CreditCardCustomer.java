package com.assessment.creditcard.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardCustomer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy=SEQUENCE, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
	private long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "customer")
	private CreditCardDetails creditCardData;
	
}
