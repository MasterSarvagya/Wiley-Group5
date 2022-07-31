package Persistance;

import java.util.List;

import Bean.IssuedBooks;

public interface IssuedBooksDao {

	Boolean issueBook(Integer empID, Integer booksID);

	Boolean returnBook(Integer empID, Integer booksID);

	IssuedBooks searchIssuedBooks(Integer empID, Integer booksID);

	List<IssuedBooks> getAllIssuedBooks();
}
