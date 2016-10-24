package c8;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {

	public static void main(String[] args) throws NamingException {
		Context ctx = new InitialContext();
		BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/c8-service-1.0/BookEJB!c8.BookEJBRemote");

		List<Book> books = bookEJB.findBooks();
		for (Book book : books) {
			System.out.println("--- " + book);
		}

		Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction by Douglas Adams.",
				"1-24561-799-0", 354, false);
		bookEJB.createBook(book);
		System.out.println("### Book created : " + book);

		book.setTitle("H2G2");
		book = bookEJB.updateBook(book);
		System.out.println("### Book updated : " + book);

		bookEJB.deleteBook(book);
		System.out.println("### Book deleted");
	}

}
