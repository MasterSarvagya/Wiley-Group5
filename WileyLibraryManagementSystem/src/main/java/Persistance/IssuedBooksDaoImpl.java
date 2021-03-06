package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import Bean.Books;
import Bean.Employee;
import Bean.IssuedBooks;

public class IssuedBooksDaoImpl implements IssuedBooksDao {

	@Override
	public Boolean issueBook(Integer empID, Integer booksID) {

		BooksDaoImpl bookDaoImpl = new BooksDaoImpl();
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		Employee employee = employeeDaoImpl.searchEmployee(empID);
		Books book = bookDaoImpl.searchBook(booksID);

		if (employee.getBookLimit() > 0 && book.getLeftQty() > 0) {
			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem", "Wiley", "wiley");
					PreparedStatement preparedStatement = connection
							.prepareStatement("INSERT INTO IssuedBooks VALUES(?,?,?,?,?,?)");) {

				preparedStatement.setInt(1, employee.getEmpID());
				preparedStatement.setInt(2, book.getBookID());
				preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
				preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now().plusDays(7)));
				preparedStatement.setTimestamp(5, new Timestamp(0));
				preparedStatement.setDouble(6, 0);

				if (preparedStatement.executeUpdate() != 0) {
					employeeDaoImpl.removeEmployee(empID);
					bookDaoImpl.removeBook(booksID);

					employee.setBookLimit(employee.getBookLimit() - 1);
					book.setLeftQty(book.getLeftQty() - 1);

					return (employeeDaoImpl.addEmployee(employee) > 0) && (bookDaoImpl.addBook(book) > 0);
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		return false;
	}

	@Override
	public Double returnBook(Integer empID, Integer booksID) {

		IssuedBooks issuedBooks = searchIssuedBooks(empID, booksID);
		if (issuedBooks.getReturnDateTime().compareTo(new Timestamp(0).toLocalDateTime()) == 0) {

			BooksDaoImpl bookDaoImpl = new BooksDaoImpl();
			EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

			Employee employee = employeeDaoImpl.searchEmployee(empID);
			Books book = bookDaoImpl.searchBook(booksID);

			employeeDaoImpl.removeEmployee(empID);
			bookDaoImpl.removeBook(booksID);

			employee.setBookLimit(employee.getBookLimit() + 1);
			book.setLeftQty(book.getLeftQty() + 1);

			issuedBooks.setReturnDateTime(LocalDateTime.now());

			double latefees = ChronoUnit.DAYS.between(issuedBooks.getIssueDateTime(), issuedBooks.getReturnDateTime());
			int constant = 0;
			if (book.getBookType().compareTo("Management") == 0)
				constant = 7;
			else if (book.getBookType().compareTo("Technology") == 0)
				constant = 6;
			else
				constant = 5;
			issuedBooks.setLateFees(latefees * constant);

			employeeDaoImpl.addEmployee(employee);
			bookDaoImpl.addBook(book);

			try (Connection connection = DriverManager
					.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem", "Wiley", "wiley");
					PreparedStatement preparedStatement = connection.prepareStatement(
							"UPDATE ISSUEDBOOKS SET RETURN_DATETIME=?,LATE_FEES=? WHERE EMPLOYEE_ID=? AND BOOK_ID=? LIMIT 1");) {

				preparedStatement.setTimestamp(1, Timestamp.valueOf(issuedBooks.getReturnDateTime()));
				preparedStatement.setDouble(2, issuedBooks.getLateFees());
				preparedStatement.setInt(3, empID);
				preparedStatement.setInt(4, booksID);
				System.out.println(preparedStatement);
				if (preparedStatement.executeUpdate() != 0) {
					return issuedBooks.getLateFees();
				}

			} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
			}
		}
		return -1.0;
	}

	@Override
	public IssuedBooks searchIssuedBooks(Integer empID, Integer booksID) {
		IssuedBooks issuedBook = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM ISSUEDBOOKS WHERE EMPLOYEE_ID=? AND BOOK_ID=?");) {
			preparedStatement.setInt(1, empID);
			preparedStatement.setInt(2, booksID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				LocalDateTime issueDateTime = resultSet.getTimestamp(3).toLocalDateTime();
				LocalDateTime scheduledReturnDateTime = resultSet.getTimestamp(4).toLocalDateTime();
				LocalDateTime returnDateTime = resultSet.getTimestamp(5).toLocalDateTime();
				double lateFees = resultSet.getDouble(6);
				issuedBook = new IssuedBooks(empID, booksID, issueDateTime, scheduledReturnDateTime, returnDateTime,
						lateFees);
			}
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return issuedBook;
	}

	@Override
	public List<IssuedBooks> getAllIssuedBooks() {
		List<IssuedBooks> issuedBooks = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ISSUEDBOOKS");) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Integer empID = resultSet.getInt(1);
				Integer booksID = resultSet.getInt(2);
				LocalDateTime issueDateTime = resultSet.getTimestamp(3).toLocalDateTime();
				LocalDateTime scheduledReturnDateTime = resultSet.getTimestamp(4).toLocalDateTime();
				LocalDateTime returnDateTime = resultSet.getTimestamp(5).toLocalDateTime();
				double lateFees = resultSet.getDouble(6);
				issuedBooks.add(new IssuedBooks(empID, booksID, issueDateTime, scheduledReturnDateTime, returnDateTime,
						lateFees));
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return issuedBooks;
	}

}
