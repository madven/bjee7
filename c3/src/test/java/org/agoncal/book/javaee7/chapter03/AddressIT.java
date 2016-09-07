package org.agoncal.book.javaee7.chapter03;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.Test;

public class AddressIT {

	@Test
	public void shouldRaiseConstraintViolationCauseInvalidZipCode() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();

		Address address = new Address("233 Spring Street", "New York", "NY", "DummyZip", "USA");
		Set<ConstraintViolation<Address>> violations = validator.validate(address);
		Assert.assertEquals(1, violations.size());

		vf.close();
	}
}
