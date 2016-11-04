package c12;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {

	@XmlAttribute
	private String number;
	@XmlElement(name = "expiry_date")
	private String expiryDate;
	@XmlElement(name = "control_number")
	private Integer controlNumber;
	private String type;

	public CreditCard() {
	}

	public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controlNumber == null) ? 0 : controlNumber.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CreditCard other = (CreditCard) obj;
		if (controlNumber == null) {
			if (other.controlNumber != null) {
				return false;
			}
		} else if (!controlNumber.equals(other.controlNumber)) {
			return false;
		}
		if (expiryDate == null) {
			if (other.expiryDate != null) {
				return false;
			}
		} else if (!expiryDate.equals(other.expiryDate)) {
			return false;
		}
		if (number == null) {
			if (other.number != null) {
				return false;
			}
		} else if (!number.equals(other.number)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}
}
