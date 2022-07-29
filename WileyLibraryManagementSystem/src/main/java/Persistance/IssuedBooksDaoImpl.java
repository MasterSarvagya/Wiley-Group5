package Persistance;

import java.util.List;

import Bean.IssuedBooks;

public class IssuedBooksDaoImpl implements IssuedBooksDao {

	@Override
	public Boolean issueBook(int empID,Integer booksID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean returnBook(int empID, Integer booksID) {
		
		//Step I -
		// search issue boook for empid and book id
		// get IssuedBook object if return date == null
		
		
		
		
		//Step II - 
		// Issued books set return date - now(), 
		// latefees = scheduleddate - returndate;
		
		//Step III -
		// Increase user book limit (searchemployeebyid object)
		// Increase user book quantity left (searcbookbyid object)
		
		//Step IV -
		//Update employee,book and issuedBook;
		// UPDATE TABLE ISSUEDBOOK SET RETURNDATE = returndate, LATEFEES = latefees where 
		// where empid = empid and booksid = bookid;
		
		//return latefees;
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IssuedBooks searchIssuedBooks(int empID, int booksID) {
		// TODO Auto-generated method stub
		// select * from issuedbooks where empid - empid and booksid = bookid
		return null;
	}

	@Override
	public List<IssuedBooks> getAllIssuedBooks(int empID, int booksID) {
		// TODO Auto-generated method stub
		return null;
	}

}
