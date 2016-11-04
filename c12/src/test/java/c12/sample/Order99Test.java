package c12.sample;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Order99Test {

	public static final String orderXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
			+ "<order id=\"1234\" date=\"04/11/2016\">"
			+ "<customer first_name=\"James\" last_name=\"Rorrison\">"
			+ "<email>j.rorri@me.com</email>"
			+ "<phoneNumber>+44 1234 1234</phoneNumber>"
			+ "</customer>"
			+ "<content>"
			+ "<order_line item=\"H2G2\" quantity=\"1\">"
			+ "<unit_price>23.5</unit_price>"
			+ "</order_line>"
			+ "<order_line item=\"Harry Potter\" quantity=\"2\">"
			+ "<unit_price>34.99</unit_price>"
			+ "</order_line>"
			+ "</content>"
			+ "<credit_card number=\"123412341234\" expiry_date=\"10/13\" control_number=\"234\" type=\"Visa\"/>"
			+ "</order>";

	private static Date creationDate;

	@BeforeClass
	public static void init() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.NOVEMBER, 4);
		creationDate = calendar.getTime();
	}

	@Test
	public void shouldMarshallAnOrder() throws JAXBException {

		Order99 order = new Order99(1234L, 93.48, creationDate);
		order.addOrderLine(new OrderLine99("H2G2", 23.5, 1));
		order.addOrderLine(new OrderLine99("Harry Potter", 34.99, 2));
		order.setCreditCard(new CreditCard99("123412341234", "10/13", 234, "Visa"));
		order.setCustomer(new Customer99("James", "Rorrison", "j.rorri@me.com", "+44 1234 1234"));

		StringWriter writer = new StringWriter();
		JAXBContext jaxbContext = JAXBContext.newInstance(Order99.class);
		Marshaller m = jaxbContext.createMarshaller();
		m.marshal(order, writer);

		System.out.println(writer);
		Assert.assertEquals(orderXML, writer.toString());
	}

	@Test
	public void shouldUnmarshallAnOrder() throws JAXBException{

		StringReader reader = new StringReader(orderXML);
		JAXBContext jaxbContext = JAXBContext.newInstance(Order99.class);
		Unmarshaller u = jaxbContext.createUnmarshaller();
		Order99 order = (Order99) u.unmarshal(reader);

		Assert.assertEquals((Object) 1234L, order.getId());
		Assert.assertEquals(2, order.getOrderLines().size());
		Assert.assertEquals("Rorrison", order.getCustomer().getLastName());
		Assert.assertEquals("123412341234", order.getCreditCard().getNumber());
	}

}
