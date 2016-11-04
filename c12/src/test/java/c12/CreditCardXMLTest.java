package c12;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardXMLTest {

	public static final String creditCardXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
			+ "<creditCard number=\"12345678\">\n" + "    <expiry_date>10/14</expiry_date>\n"
			+ "    <control_number>566</control_number>\n" + "    <type>Visa</type>\n" + "</creditCard>";

	@Test
	public void shouldMarshallACreditCard() throws JAXBException {
		CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");
		StringWriter stringWriter = new StringWriter();

		JAXBContext jaxbContext = JAXBContext.newInstance(CreditCard.class);
		Marshaller m = jaxbContext.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(creditCard, stringWriter);

		System.out.println(stringWriter);
		Assert.assertEquals(creditCardXML, stringWriter.toString().trim());
	}

	@Test
	public void shouldUnmarshallACreditCard() throws JAXBException {
		StringReader stringReader = new StringReader(creditCardXML);

		JAXBContext jaxbContext = JAXBContext.newInstance(CreditCard.class);
		Unmarshaller u = jaxbContext.createUnmarshaller();
		CreditCard creditCard = (CreditCard) u.unmarshal(stringReader);

		Assert.assertEquals("12345678", creditCard.getNumber());
		Assert.assertEquals("10/14", creditCard.getExpiryDate());
		Assert.assertEquals((Object) 566, creditCard.getControlNumber());
		Assert.assertEquals("Visa", creditCard.getType());
	}

}
