
package com.assessment.creditcard.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.assessment.creditcard.dto.CreditCardRequestDTO;
import com.assessment.creditcard.model.CreditCardCustomer;

/**
 * Mapper interface to map the CreditCardDetailsRequestDTO to CreditCardCustomer
 * model
 * 
 *
 * @author Jyoti
 */

@Mapper(componentModel = "spring", uses = { CreditCardDetailsMapper.class })
public interface CreditCardMapper {

	CreditCardMapper INSTANCE = Mappers.getMapper(CreditCardMapper.class);

	@Mappings({ @Mapping(source = "name", target = "name"),
			@Mapping(source = "creditCardDetails", target = "creditCardData") })
	CreditCardCustomer mapToCreditCardCustomer(CreditCardRequestDTO creditCardReq);
}
