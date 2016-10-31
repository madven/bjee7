package c11;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DBProducer {

	@Produces
	@PersistenceContext(unitName = "c11PU")
	private EntityManager em;
}
