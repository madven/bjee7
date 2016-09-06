package org.agoncal.book.javaee7.chapter02;

import javax.inject.Inject;

@Loggable
public class BookService {

	@Inject
	@ThirteenDigits
	NumberGenerator numberGenerator;

	public Book createBook(String title, Float price, String description){
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		return book;
	}
}
