package Persistance;

import java.util.List;

import Bean.IssuedBooks;

public interface IssuedBooksDao {

	Boolean issueBook(int empID, Integer booksID);

	Boolean returnBook(int empID, Integer booksID);
	
	IssuedBooks searchIssuedBooks(int empID, int booksID);
	
	List<IssuedBooks> getAllIssuedBooks(int empID, int booksID);

}
