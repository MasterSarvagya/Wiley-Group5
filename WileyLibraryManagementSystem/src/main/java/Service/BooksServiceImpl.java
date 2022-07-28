package Service;

import java.util.List;
import Persistance.BooksDaoImpl;
import Persistance.BooksDao;

import Bean.Books;

public class BooksServiceImpl implements BooksService {
	private BooksDao booksDao = new BooksDaoImpl();

	@Override
	public Boolean addBook(Books book) {
		if(booksDao.addBook(book)>0)
			return true;
		return false;
	}

	@Override
	public Boolean removeBook(Integer bookID) {
		if(booksDao.removeBook(bookID)>0)
			return true;
		return false;
	}

	@Override
	public Books searchBook(Integer bookID) {
		return booksDao.searchBook(bookID);
	}

	@Override
	public List<Books> getAllBooks() {
		return booksDao.getAllBooks();
	}

}
