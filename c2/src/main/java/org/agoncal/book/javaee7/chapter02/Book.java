package org.agoncal.book.javaee7.chapter02;

public class Book {
	String title;
	Float price;
	String description;
	String number;


	public Book() {}

	public Book(String title, float price, String description) {
		super();
		this.title = title;
		this.price = price;
		this.description = description;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [title=");
		builder.append(title);
		builder.append(", price=");
		builder.append(price);
		builder.append(", description=");
		builder.append(description);
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}
}
