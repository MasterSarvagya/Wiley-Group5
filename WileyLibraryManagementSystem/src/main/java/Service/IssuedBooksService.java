package Service;

import java.util.List;

public interface IssuedBooksService {

	Boolean issueBook(int empID, List<Integer> booksID);

	Boolean returnBook(int empID, List<Integer> booksID);

}
