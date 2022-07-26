package Service;

import java.util.List;

import Bean.Books;

public interface BooksService {
	
	Boolean addBook(Books book);

	Boolean removeBook(int bookID);

	Books searchBook(int bookID);

	List<Books> getAllBooks();

}
