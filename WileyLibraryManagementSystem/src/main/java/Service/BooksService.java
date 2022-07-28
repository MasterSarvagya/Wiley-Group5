package Service;

import java.util.List;

import Bean.Books;

public interface BooksService {
	
	Boolean addBook(Books book);

	Boolean removeBook(Integer bookID);

	Books searchBook(Integer bookID);

	List<Books> getAllBooks();

}
