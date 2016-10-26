package ex01;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InventoryEJB01 {

	// ======================================
	// = Attributes =
	// ======================================

	@PersistenceContext(unitName = "chapter09PU")
	private EntityManager em;

	// ======================================
	// = Public Methods =
	// ======================================

	public void addItem(Item01 item) {
		em.merge(item);
		item.increaseAvailableStock();
		sendShippingMessage();
	}

	private void sendShippingMessage() {
		// Send a message
	}
}
