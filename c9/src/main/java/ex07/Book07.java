package ex07;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Book07.FIND_ALL, query = "SELECT b FROM Book07 b")
public class Book07 extends Item07 {

	// ======================================
	// = Constants =
	// ======================================

	public static final String FIND_ALL = "Book07.findAllBooks";

	// ======================================
	// = Attributes =
	// ======================================

	private String isbn;
	private Integer nbOfPage;
	private Boolean illustrations;

	// ======================================
	// = Constructors =
	// ======================================

	public Book07() {
	}

	public Book07(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.isbn = isbn;
		this.nbOfPage = nbOfPage;
		this.illustrations = illustrations;
	}

	// ======================================
	// = Getters & Setters =
	// ======================================

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}
}
