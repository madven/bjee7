package ex07;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BusinessLogic2 {

	@EJB
	ShoppingCartEJB07 shoppingCartEJB;

	public void addCD() {
		Item07 cd = new Item07();
		cd.setTitle("Zoot Allure");
		cd.setPrice(23f);
		cd.setDescription("Another Zappa's master piece");

		// Adds the book to the shopping cart
		shoppingCartEJB.addItem(cd);
	}

}
