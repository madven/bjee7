package ex07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderEJBIT {

	private static EJBContainer ec;
	private static Context ctx;
	private static OrderEJB orderEJB;

	// ======================================
	// =          Lifecycle Methods         =
	// ======================================

	@BeforeClass
	public static void initContainer() throws Exception {
		Map<String, Object> properties = new HashMap<>();
		properties.put(EJBContainer.MODULES, new File("target/classes"));
		ec = EJBContainer.createEJBContainer(properties);
		ctx = ec.getContext();

		// Check JNDI dependencies
		assertNotNull(ctx.lookup("java:global/classes/OrderEJB!ex07.OrderEJB"));
		assertNotNull(ctx.lookup("java:global/classes/OrderEJB"));

		// Looks up the EJB
		orderEJB = (OrderEJB) ctx.lookup("java:global/classes/OrderEJB");

	}

	@AfterClass
	public static void closeContainer() throws Exception {
		if (ctx != null) {
			ctx.close();
		}
		if (ec != null) {
			ec.close();
		}
	}

	// ======================================
	// =              Unit tests            =
	// ======================================

	/**
	 * Without the @Asynchronous annotation on the EJB, this tes would timeout and fail
	 */
	@Test(timeout = 500)
	public void shouldSendEmailOrderCompleteAsynchronously() throws Exception {
		orderEJB.sendEmailOrderComplete(new Order());
	}

	/**
	 * Without the @Asynchronous annotation on the EJB, this tes would timeout and fail
	 */
	@Test(timeout = 500)
	public void shouldPrintOrderAsynchronously() throws Exception {
		orderEJB.printOrder(new Order());
	}

	@Test
	public void shouldSendOrderToWorkflow() throws ExecutionException, InterruptedException {
		// when
		Future<Integer> status = orderEJB.sendOrderToWorkflow(new Order());

		// then
		assertEquals((Object) 1, status.get());
	}
}
