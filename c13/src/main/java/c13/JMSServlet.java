package c13;


import java.io.IOException;
import java.io.Writer;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jms.html")
public class JMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String SENDER_MESSAGE = "message";
	private final static String EMPTY_MESSAGE = "empty message";
	private final static String SPAN_TITLE_BEGIN = "<html><span style='font-weight:bold;font-style:italic;text-decoration:underline;color:red'>";
	private final static String SPAN_TITLE_END = "</span></html>";
	private final static String BR = "<br>";

	@Inject
	MessageProducerMDB producer;
	/*@Inject
	MessageConsumerMDB consumer;*/

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter(SENDER_MESSAGE);
		if (message == null || message.trim().length() == 0) {
			message = EMPTY_MESSAGE;
		}

		Writer writer = response.getWriter();
		writer.write(SPAN_TITLE_BEGIN + "Producer Message:" + SPAN_TITLE_END + BR);
		writer.write(message + showTime());
		producer.sendPrintingMessage(message);

		/*writer.write(BR + SPAN_TITLE_BEGIN + "Consumer message:" + SPAN_TITLE_END + BR);
		String receivedMessage = consumer.receiveMessage();
		writer.write(receivedMessage + showTime());*/
	}

	private String showTime() {
		return " <span style='font-style:italic;color:green;'>at " + System.currentTimeMillis() + " (Tms)</span>";
	}

}
