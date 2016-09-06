package org.agoncal.book.javaee7.chapter02;

import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator{

	@Inject
	private Logger logger;

	@Loggable
	public String generateNumber() {
		String mock = "MOCK-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN : " + mock);
		return mock;
	}

}