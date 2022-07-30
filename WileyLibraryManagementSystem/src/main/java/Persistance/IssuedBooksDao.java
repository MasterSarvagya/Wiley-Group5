package Persistance;

import java.util.List;

import Bean.IssuedBooks;

public interface IssuedBooksDao {

<<<<<<< HEAD
	Boolean issueBook(int empID, int booksID);
=======
	Boolean issueBook(int empID, Integer booksID);
>>>>>>> branch 'master' of https://github.com/MasterSarvagya/Wiley-Project-Group.git

<<<<<<< HEAD
	Boolean returnBook(int empID, int booksID);
=======
	Boolean returnBook(int empID, Integer booksID);
	
	IssuedBooks searchIssuedBooks(int empID, int booksID);
	
	List<IssuedBooks> getAllIssuedBooks(int empID, int booksID);
>>>>>>> branch 'master' of https://github.com/MasterSarvagya/Wiley-Project-Group.git

}
