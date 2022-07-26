package Persistance;

import java.util.List;

import Bean.Books;

public interface BooksDao {

	Boolean addBook(Books book);

	Boolean removeBook(int bookID);

	Books searchBook(int bookID);

	List<Books> getAllBooks();
}
