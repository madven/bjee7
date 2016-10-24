package c8;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Test;

public class BookEJBIT {

	@Test
	public void shouldCreateABook() throws NamingException {
		Map<String, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));

		try(EJBContainer ec = EJBContainer.createEJBContainer(properties)){
			Context ctx = ec.getContext();

			assertNotNull(ctx.lookup("java:global/jdbc/c8DS"));
			assertNotNull(ctx.lookup("java:global/classes/BookEJB!c8.BookEJBRemote"));
			assertNotNull(ctx.lookup("java:global/classes/BookEJB!c8.BookEJB"));

			BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB!c8.BookEJB");
			assertEquals(2, bookEJB.findBooks().size());

			Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction by Douglas Adams.",
					"1-24561-799-0", 354, false);

			bookEJB.createBook(book);
			assertNotNull("ID should not be null", book.getId());
			assertEquals(3, bookEJB.findBooks().size());

			bookEJB.deleteBook(book);
			assertEquals(2, bookEJB.findBooks().size());
		}
	}

}
