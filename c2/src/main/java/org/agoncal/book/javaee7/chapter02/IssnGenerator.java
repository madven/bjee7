package org.agoncal.book.javaee7.chapter02;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

@EightDigits
public class IssnGenerator implements NumberGenerator{

	@Inject
	Logger logger;

	@Loggable
	public String generateNumber() {
		String issn =  "8-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISSN : " + issn);
		return issn;
	}

}
