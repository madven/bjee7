package org.agoncal.book.javaee7.chapter03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

	@Inject @USA
	ZipCodeChecker checker;

	Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

	public void initialize(ZipCode arg0) {
	}

	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if (value == null || value.length() == 0) {
			return true;
		}

		Matcher m = zipPattern.matcher(value);
		if (!m.matches()) {
			return false;
		}

		return checker.isZipCodeValid(value);
	}

}
