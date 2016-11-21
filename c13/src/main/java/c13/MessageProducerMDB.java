package c13;

import java.util.Date;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Destination;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;

public class MessageProducerMDB {

	@Inject
	@JMSConnectionFactory("jms/__defaultConnectionFactory")
	private JMSContext context;

	@Resource(lookup = "jms/javaee7/Queue")
	private Destination printingQueue;

	public void sendPrintingMessage(String message) {
		context.createProducer().send(printingQueue, message + new Date());
	}
}
