package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DatabaseConnector {

	Connection connection;
	PreparedStatement preparedStatement;

	public DatabaseConnector(String URL, String user, String password) throws SQLException {

		connection = DriverManager.getConnection(URL, user, password);

	}

	public PreparedStatement getPreparedStatement(String query) throws SQLException {

		preparedStatement = connection.prepareStatement(query);

		return preparedStatement;

	}

}

/*
 * Use as - try ( DatabaseConnector databaseConnector = new
 * DatabaseConnector(URL,user,password);) {
 * 
 * PreparedStatement preparedStatement =
 * databaseConnector.getPreparedStatement(QUERY); preparedStatement.setInt(1.
 * 100);
 *
 * ResultSet resultSet = preparedStatement.executeQuery(); OR
 * preparedStatement.executeUpdate();
 *
 * } catch (SQLException e) { 
 * 		e.printStackTrace(); 
 * }
 * 
 */
