package ex07;

import java.util.concurrent.Future;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class OrderEJB {

	@Resource
	private SessionContext ctx;

	@Asynchronous
	public void sendEmailOrderComplete(Order order) {
		// Very Long task
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Asynchronous
	public void printOrder(Order order) {
		// Very Long task
		try {
			Thread.sleep(1000);
		} catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Asynchronous
	public Future<Integer> sendOrderToWorkflow(Order order) {
		Integer status = 0;
		// processing
		status = 1;
		if (ctx.wasCancelCalled()) {
			return new AsyncResult<>(2);
		}
		// processing
		return new AsyncResult<>(status);
	}

}
