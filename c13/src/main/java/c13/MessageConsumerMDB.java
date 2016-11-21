package c13;


import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Queue")
public class MessageConsumerMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("Message received: " + message.getBody(String.class));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
