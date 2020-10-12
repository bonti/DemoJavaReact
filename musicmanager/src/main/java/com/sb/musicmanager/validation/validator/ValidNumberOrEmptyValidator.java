package com.sb.musicmanager.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.sb.musicmanager.validation.annotation.ValidNumberOrEmpty;

public class ValidNumberOrEmptyValidator implements ConstraintValidator<ValidNumberOrEmpty, String> {

	private String min;
	private String max;

	@Override
	public void initialize(ValidNumberOrEmpty constraintAnnotation) {
		this.min = constraintAnnotation.min();
		this.max = constraintAnnotation.max();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) { // blank string is valid
			return true;
		}
		if (StringUtils.isNumeric(value)) { // check if the value is numeric
			int intValue = Integer.parseInt(value);
			if (intValue >= Integer.parseInt(min) && intValue <= Integer.parseInt(max)) {
				return true;
			}
		}
		return false;
	}

}