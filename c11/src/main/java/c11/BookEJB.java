package c11;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named
@Stateless
public class BookEJB {

	@Inject
	private EntityManager em;

	public List<Book> findAllBooks(){
		return em.createNamedQuery("findAllBooks", Book.class).getResultList();
	}

	public Book createBook(Book book){
		em.persist(book);
		return book;
	}

	public Book findBookById(Long id){
		return em.find(Book.class, id);
	}
}
