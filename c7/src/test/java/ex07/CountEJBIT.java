package ex07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Test;

public class CountEJBIT {

	@Test
	public void shoulCountItems() throws NamingException {
		Map<String, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));

		try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
			Context ctx = ec.getContext();

			assertNotNull(ctx.lookup("java:global/classes/CounterEJB!ex07.CounterEJB"));

			CounterEJB counterEJB1 = (CounterEJB) ctx
					.lookup("java:global/classes/CounterEJB!ex07.CounterEJB");
			CounterEJB counterEJB2 = (CounterEJB) ctx
					.lookup("java:global/classes/CounterEJB!ex07.CounterEJB");

			counterEJB1.increment();
			assertEquals(0, counterEJB2.count());
			counterEJB1.increment();
			assertEquals(2, counterEJB1.count());
			counterEJB2.increment();
			assertEquals(1, counterEJB2.count());

		}
	}

}
