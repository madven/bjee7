package ex07;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ItemServiceGateway {
	@Inject
	ItemService07 service;

	public List<Book07> findBooks() {
		return service.findBooks();
	}

	public List<CD07> findCDs() {
		return service.findCDs();
	}

	public Book07 findBookById(Long id) {
		return service.findBookById(id);
	}

	public CD07 findCDById(Long id) {
		return service.findCDById(id);
	}

	public Book07 createBook(Book07 book) {
		return service.createBook(book);
	}

	public CD07 createCD(CD07 cd) {
		return service.createCD(cd);
	}

	public void deleteBook(Book07 book) {
		service.deleteBook(book);
	}

	public void deleteCD(CD07 cd) {
		service.deleteCD(cd);
	}

	public Book07 updateBook(Book07 book) {
		return service.updateBook(book);
	}

	public CD07 updateCD(CD07 cd) {
		return service.updateCD(cd);
	}
}
