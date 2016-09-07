package org.agoncal.book.javaee7.chapter03;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
@Constraint(validatedBy = ZipCodeValidator.class)
public @interface ZipCode {
	String message() default "{org.agoncal.book.javaee7.chapter03.ZipCode.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Retention(RUNTIME)
	@Target({ FIELD, METHOD, PARAMETER, CONSTRUCTOR, ANNOTATION_TYPE })
	@Constraint(validatedBy = ZipCodeValidator.class)
	@interface List{
		ZipCode[] value();
	}
}
