package c4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(book);
		tx.commit();

		book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
		System.out.println("######### " + book.getDescription());

		em.close();
		emf.close();
	}

}
