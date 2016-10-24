package c8;

import java.util.List;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;

@Remote
public interface BookEJBRemote {

	List<Book> findBooks();
	@NotNull Book createBook(@NotNull Book book);
	void deleteBook(@NotNull Book book);
	@NotNull Book updateBook(@NotNull Book book);
}
