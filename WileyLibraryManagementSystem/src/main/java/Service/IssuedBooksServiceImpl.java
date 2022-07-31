package Service;

import java.util.List;

import Bean.IssuedBooks;
import Persistance.IssuedBooksDao;
import Persistance.IssuedBooksDaoImpl;

public class IssuedBooksServiceImpl implements IssuedBooksService {

	IssuedBooksDao issuedBooksDao = new IssuedBooksDaoImpl();

	@Override
	public Boolean issueBook(Integer empID, Integer booksID) {
		return issuedBooksDao.issueBook(empID, booksID);
	}

	@Override
	public Double returnBook(Integer empID, Integer booksID) {
		return issuedBooksDao.returnBook(empID, booksID);
	}

	@Override
	public IssuedBooks searchIssuedBooks(Integer empID, Integer booksID) {
		return issuedBooksDao.searchIssuedBooks(empID, booksID);
	}

	@Override
	public List<IssuedBooks> getAllIssuedBooks() {
		return issuedBooksDao.getAllIssuedBooks();
	}

}
