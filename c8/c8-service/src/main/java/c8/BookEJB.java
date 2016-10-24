package c8;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

	@Inject
	private EntityManager em;

	public List<Book> findBooks() {
		return em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
	}

	public @NotNull Book createBook(@NotNull Book book) {
		em.persist(book);
		return book;
	}

	public void deleteBook(@NotNull Book book) {
		em.remove(em.merge(book));
	}

	public @NotNull Book updateBook(@NotNull Book book) {
		return em.merge(book);
	}

}
