package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Bean.Books;
import Bean.Employee;
import Bean.IssuedBooks;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;


import Bean.IssuedBooks;

public class IssuedBooksDaoImpl implements IssuedBooksDao {
	
	private static Scanner scanner = new Scanner(System.in);

	@Override

	public Boolean issueBook(int empID, int booksID) {
		
		Boolean step1,step2,step3;
		step1=step2=step3=false;
		
		BooksDaoImpl bookDaoImpl = new BooksDaoImpl();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		Employee employee = employeeDaoImpl.searchEmployee(empID);
		Books book = bookDaoImpl.searchBook(booksID);

		if(employee.getBookLimit()>0 && book.getLeftQty()>0 ) {
			step1 = true;
		}
		
		
		
		//step II - // if()?
		
		//insert query(which table) issued books table empid,booksid,date
		//lateFees = 0 return date = null
		//scheduledTReturn date  = date+7 days
		
			
			int rows = 0;
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO IssuedBooks VALUES(?,?,?,?,?)");) {
			
			preparedStatement.setInt(1, employee.getEmpID());
			preparedStatement.setInt(2, book.getBookID());
			//preparedStatement.setTimestamp(3, new Timestamp(LocalDate.getTime());
			preparedStatement.setTimestamp(4, null);
			preparedStatement.setDouble(5, 0);
			
			
			rows = preparedStatement.executeUpdate();//returns integer
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if(rows != 0) {
				step2 = true;
			}
		
		
		//Step III -
		
		//reduce book limit & quantity left -1;
		//	update query
		//         OR
		// 	employee remove, object limit change insert again
			
			employeeDaoImpl.removeEmployee(empID);
			bookDaoImpl.removeBook(booksID);
			
			employee.setBookLimit(employee.getBookLimit()-1);
			book.setLeftQty(book.getLeftQty()-1);
		
			step3 = (employeeDaoImpl.addEmployee(employee) > 0) && (bookDaoImpl.addBook(book) > 0);
			
		return (step1 && step2 && step3);
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
		return null;
	}
	@Override
	public void issueBook(int empID, int booksID) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public java.lang.Boolean issueBook(int empID, Integer booksID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void returnBook(int empID, int booksID) {
		// TODO Auto-generated method stub
		
	}

}
