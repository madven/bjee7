package c14;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

@WebServlet(urlPatterns = "/servletConsumer")
public class ServletConsumer extends HttpServlet {

	@WebServiceRef
	private CardValidatorService cardValidatorService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.print("<h1>Servlet Consumer</h1><br/>");

		CreditCard creditCard = new CreditCard();
		creditCard.setNumber("12341234");
		creditCard.setExpiryDate("10/12");
		creditCard.setType("VISA");
		creditCard.setControlNumber(1234);

		Validator cardValidator = cardValidatorService.getCardValidatorPort();
		out.print(cardValidator.validate(creditCard) + "<br/>");

		creditCard.setNumber("12341233");
		out.print(cardValidator.validate(creditCard) + "<br/>");
	}
}
