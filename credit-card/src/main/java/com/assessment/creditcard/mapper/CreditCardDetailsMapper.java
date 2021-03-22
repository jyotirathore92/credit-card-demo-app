
package com.assessment.creditcard.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.assessment.creditcard.dto.CreditCardDetailsRequestDTO;
import com.assessment.creditcard.model.CreditCardDetails;

/**
 * Mapper interface to map the CreditCardDetailsRequestDTO to CreditCardCustomer
 * model which has CreditCardDetails as a parameter in it. Thus, mapping
 * CreditCardDetailsRequestDTO to CreditCardDetails.
 * 
 *
 * @author Jyoti
 */

@Mapper(componentModel = "spring")
public interface CreditCardDetailsMapper {

	CreditCardDetailsMapper INSTANCE = Mappers.getMapper(CreditCardDetailsMapper.class);

	@Mappings({ @Mapping(source = "cardNumber", target = "cardNumber"),
			@Mapping(source = "amountLimit", target = "amountLimit") })
	CreditCardDetails toCreditCardData(CreditCardDetailsRequestDTO creditCardDetails);
}
