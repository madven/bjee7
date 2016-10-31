package c11;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Model
public class BookController {

	private Book book = new Book();

	@Inject
	private BookEJB bookEJB;

	public String doCreateBook() {
		bookEJB.createBook(book);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
				"The book " + book.getTitle() + " has been created with id=" + book.getId()));
		return "newBook.xhtml";
	}

	public void doFindBookById() {
		book = bookEJB.findBookById(book.getId());
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
