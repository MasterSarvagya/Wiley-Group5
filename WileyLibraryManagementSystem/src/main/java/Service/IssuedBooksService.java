package Service;

import java.util.List;

import Bean.IssuedBooks;

public interface IssuedBooksService {

	Boolean issueBook(Integer empID, Integer booksID);
	
	Double returnBook(Integer empID, Integer booksID);
	
	IssuedBooks searchIssuedBooks(Integer empID, Integer booksID) ;
	
	List<IssuedBooks> getAllIssuedBooks();

}
