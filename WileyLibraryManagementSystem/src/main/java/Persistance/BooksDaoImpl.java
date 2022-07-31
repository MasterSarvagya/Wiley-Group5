package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Books;

public class BooksDaoImpl implements BooksDao {

	@Override
	public Integer addBook(Books book) {
		Integer rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO Books VALUES(?,?,?,?,?,?)");) {

			preparedStatement.setInt(1, book.getBookID());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getBookType());
			preparedStatement.setString(4, book.getBookAuthor());
			preparedStatement.setInt(5, book.getOriginalQty());
			preparedStatement.setInt(6, book.getLeftQty());

			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}

		return rows;
	}

	@Override
	public Integer removeBook(int bookID) {
		Integer rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM Books WHERE BOOK_ID=?");) {

			preparedStatement.setInt(1, bookID);

			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}

		return rows;
	}

	@Override
	public Books searchBook(int bookID) {
		Books book = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM BOOKS WHERE BOOK_ID=?");) {

			preparedStatement.setInt(1, bookID);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("book_id");
				int originalQty = resultSet.getInt("original_qty");
				int leftQty = resultSet.getInt("qty_left");
				String bookName = resultSet.getString("book_name");
				String bookType = resultSet.getString("book_type");
				String bookAuthor = resultSet.getString("author_name");

				book = new Books(id, originalQty, leftQty, bookName, bookAuthor, bookType);
			}
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}

		return book;
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> booksList = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley"); Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("SELECT * FROM BOOKS");
			while (resultSet.next()) {
				int id = resultSet.getInt("book_id");
				int originalQty = resultSet.getInt("original_qty");
				int leftQty = resultSet.getInt("qty_left");
				String bookName = resultSet.getString("book_name");
				String bookType = resultSet.getString("book_type");
				String bookAuthor = resultSet.getString("author_name");

				Books book = new Books(id, originalQty, leftQty, bookName, bookAuthor, bookType);
				booksList.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return booksList;
	}

}
