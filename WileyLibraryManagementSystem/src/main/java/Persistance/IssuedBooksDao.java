package Persistance;

import java.util.List;

public interface IssuedBooksDao {

	Boolean issueBook(int empID, List<Integer> booksID);

	Boolean returnBook(int empID, List<Integer> booksID);

}
