package org.agoncal.book.javaee7.chapter03;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerIT {

	private static ValidatorFactory vf;
	private static Validator validator;

	@BeforeClass
	public static void init() {
		vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	@AfterClass
	public static void close() {
		vf.close();
	}

	@Test
	public void shouldRaiseNoConstraintViolation() {
		Customer customer = new Customer("John", "Smith", "jsmith@gmail.com");
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		assertEquals(0, violations.size());
	}

	@Test
	public void shouldRaiseConstraintViolationCauseInvalidEmail() {
		Customer customer = new Customer("John", "Smith", "DummyEmail");
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
		assertEquals(1, violations.size());
		assertEquals("invalid email address", violations.iterator().next().getMessage());
		assertEquals("DummyEmail", violations.iterator().next().getInvalidValue());
		assertEquals("{org.agoncal.book.javaee7.chapter03.Email.message}",
				violations.iterator().next().getMessageTemplate());
	}
}
