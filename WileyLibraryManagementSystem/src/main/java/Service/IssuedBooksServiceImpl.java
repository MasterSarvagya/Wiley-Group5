package Service;

import java.util.List;

import Bean.IssuedBooks;

public class IssuedBooksServiceImpl implements IssuedBooksService {

	private Integer calcLateFees() {
		return 0;
	}

	@Override
	public Boolean issueBook(Integer empID, Integer booksID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double returnBook(Integer empID, Integer booksID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuedBooks searchIssuedBooks(Integer empID, Integer booksID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<IssuedBooks> getAllIssuedBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
