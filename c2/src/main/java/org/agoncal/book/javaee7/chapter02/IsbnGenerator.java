package org.agoncal.book.javaee7.chapter02;

import java.util.Random;
import java.util.logging.Logger;

import javax.inject.Inject;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator{

	@Inject
	Logger logger;

	@Loggable
	public String generateNumber() {
		String isbn = "13-84356-" + Math.abs(new Random().nextInt());
		logger.info("Generated ISBN : " + isbn);
		return isbn;
	}

}
