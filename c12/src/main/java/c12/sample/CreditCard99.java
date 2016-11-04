package c12.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard99 {

	@XmlAttribute
	private String number;
	@XmlAttribute(name = "expiry_date")
	private String expiryDate;
	@XmlAttribute(name = "control_number")
	private Integer controlNumber;
	@XmlAttribute
	private String type;

	public CreditCard99() {
	}

	public CreditCard99(String number, String expiryDate, Integer controlNumber, String type) {
		this.number = number;
		this.expiryDate = expiryDate;
		this.controlNumber = controlNumber;
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(Integer controlNumber) {
		this.controlNumber = controlNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
