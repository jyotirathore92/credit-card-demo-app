package com.assessment.creditcard.responsedto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.ObjectError;

@Data
@AllArgsConstructor
public class ExceptionResponseDTO {

	private int status;
	private String message;
	private List<ObjectError> errors;

}
