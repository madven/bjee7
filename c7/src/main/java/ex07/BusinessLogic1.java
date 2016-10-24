package ex07;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BusinessLogic1 {

	@EJB
	ShoppingCartEJB07 shoppingCartEJB;

	public void addBook() {
		Item07 book = new Item07();
		book.setTitle("The Hitchhiker's Guide to the Galaxy");
		book.setPrice(12.5F);
		book.setDescription("Science fiction comedy book");

		// Adds the book to the shopping cart
		shoppingCartEJB.addItem(book);
	}

}
