package c12.sample;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine99 {

	@XmlAttribute
	private String item;
	@XmlElement(name = "unit_price")
	private Double unitPrice;
	@XmlAttribute
	private Integer quantity;

	public OrderLine99() {
	}

	public OrderLine99(String item, Double unitPrice, Integer quantity) {
		this.item = item;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
