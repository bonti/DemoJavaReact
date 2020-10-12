package com.sb.musicmanager.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.sb.musicmanager.validation.validator.ValidNumberOrEmptyValidator;

//Example of a custom constraint validation 
@Documented
@Constraint(validatedBy = ValidNumberOrEmptyValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNumberOrEmpty {
	String message() default "invalid number";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	String min();
	String max();
}