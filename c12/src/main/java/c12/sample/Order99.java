package c12.sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "creationDate", "customer", "orderLines", "creditCard" })
public class Order99 {

	@XmlAttribute
	Long id;
	@XmlAttribute(name = "date")
	@XmlJavaTypeAdapter(DateAdapter99.class)
	Date creationDate;
	@XmlTransient
	Double totalAmount;
	@XmlElementWrapper(name = "content")
	@XmlElement(name = "order_line", required = true)
	List<OrderLine99> orderLines;
	@XmlElement(required = true)
	Customer99 customer;
	@XmlElement(name = "credit_card")
	CreditCard99 creditCard;

	public Order99() {
	}

	public Order99(Long id, Double totalAmount, Date creationDate) {
		this.id = id;
		this.totalAmount = totalAmount;
		this.creationDate = creationDate;
	}

	public void addOrderLine(OrderLine99 orderLine) {
		if (orderLines == null) {
			orderLines = new ArrayList<>();
		}
		orderLines.add(orderLine);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderLine99> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine99> orderLines) {
		this.orderLines = orderLines;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer99 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer99 customer) {
		this.customer = customer;
	}

	public CreditCard99 getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard99 creditCard) {
		this.creditCard = creditCard;
	}
}
