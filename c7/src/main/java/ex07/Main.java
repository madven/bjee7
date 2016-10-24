package ex07;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class Main {

	@EJB
	static ShoppingCartEJB07 shoppingCartEJB;

	@EJB
	static BusinessLogic1 bl1;

	@EJB
	static BusinessLogic2 bl2;

	public static void main(String[] args)  {
		bl1.addBook();
		bl2.addCD();
		System.out.println(shoppingCartEJB.getNumberOfItems());
	}

}
