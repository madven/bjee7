package c4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookIT {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04TestPU");
	private EntityManager em;
	private EntityTransaction tx;

	@Before
	public void initEntityManager() {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@After
	public void closeEntityManager() {
		if (em != null) {
			em.close();
		}
	}

	@Test
	public void shouldFindJavaEE7Book() {
		Book book = em.find(Book.class, 1001L);
		Assert.assertEquals("Beginning Java EE 7", book.getTitle());
	}

	@Test
	public void shouldCreateH2G2Book() {
		Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

		tx.begin();
		em.persist(book);
		tx.commit();
		Assert.assertNotNull("ID should not be null", book.getId());

		List<Book> books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
		Assert.assertEquals(1, books.size());
		book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
		Assert.assertEquals("The Hitchhiker's Guide to the Galaxy", book.getDescription());
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldRaiseConstraintViolationCauseNullTitle() {
		Book book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);
		em.persist(book);
	}

}
