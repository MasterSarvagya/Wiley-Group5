package Service;

import java.util.List;

public interface IssuedBooksService {

	Boolean issueBook(Integer empID, List<Integer> booksID);

	Boolean returnBook(Integer empID, List<Integer> booksID);

}
