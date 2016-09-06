package org.agoncal.book.javaee7.chapter02;

import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class BookServiceIT {

	@Test
	public void shouldCheckNumberIsMock(){
		Weld weld = new Weld();
		System.setProperty(Weld.ARCHIVE_ISOLATION_SYSTEM_PROPERTY, "false");
		WeldContainer container = weld.initialize();
		BookService bookService = container.instance().select(BookService.class).get();
		Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
		assertTrue(book.getNumber().startsWith("MOCK"));
		weld.shutdown();
	}
}
