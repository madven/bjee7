package c11;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
@DataSourceDefinition(name = "java:global/jdbc/lab11DS", className = "org.apache.derby.jdbc.EmbeddedDriver", url = "jdbc:derby:memory:lab11DB;create=true;user=app;password=app")
public class DBPopulator {

	@Inject
	private BookEJB bookEJB;

	private Logger logger = Logger.getLogger("c11");

	@PostConstruct
	private void createDummyData() {
		bookEJB.createBook(new Book("The Hitchhiker's Guide to the Galaxy", 23.99f, "Science fiction comedy book", 354,
				Boolean.TRUE));
		bookEJB.createBook(
				new Book("Harry Potter and the Goblet of Fire", 19.79f, "Science fiction (Book 4)", 734, Boolean.TRUE));
		bookEJB.createBook(new Book("Java EE 6 with GlassFish 3", 31.49f, "Just fantastic", 354, Boolean.TRUE));
		logger.info("&&&&&&&&&&&&&& Inserted " + bookEJB.findAllBooks().size() + " Books");
	}
}
