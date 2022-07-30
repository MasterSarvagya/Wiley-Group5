package Persistance;

import java.util.List;

public interface IssuedBooksDao {

	Boolean issueBook(int empID, int booksID);

	Boolean returnBook(int empID, int booksID);

}
