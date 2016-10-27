package ex07;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class InventoryService07 {

	// ======================================
	// =             Attributes             =
	// ======================================

	@PersistenceContext(unitName = "chapter09PU")
	private EntityManager em;

	// ======================================
	// =           Public Methods           =
	// ======================================

	public void addItem(Item07 item) {
		em.merge(item);
		item.increaseAvailableStock();
		sendShippingMessage();
	}

	private void sendShippingMessage() {
		// Send a message
	}
}
