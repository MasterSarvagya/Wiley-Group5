package Persistance;

import java.util.List;

import Bean.Books;

public interface BooksDao {

	Integer addBook(Books book);

	Integer removeBook(int bookID);

	Books searchBook(int bookID);

	List<Books> getAllBooks();
}
