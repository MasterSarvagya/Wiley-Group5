package Persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Integer addEmployee(Employee employee) {
		Integer rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO Employees VALUES(?,?,?,?,?,?)");) {

			preparedStatement.setInt(1, employee.getEmpID());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setLong(3, employee.getEmpPhoneNumber());
			preparedStatement.setBoolean(4, employee.getIsAdmin());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setInt(6, employee.getBookLimit());

			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public Integer removeEmployee(int empID) {
		Integer rows = 0;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("DELETE FROM Employees WHERE EMPLOYEE_ID=?");) {

			preparedStatement.setInt(1, empID);

			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public Employee searchEmployee(int empID) {
		Employee employee = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("SELECT * FROM Employees WHERE Employee_ID=?");) {

			preparedStatement.setInt(1, empID);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("employee_id");
				String name = resultSet.getString("employee_name");
				Long phone = resultSet.getLong("phone_Number");
				boolean admin = resultSet.getBoolean("isAdmin");
				String password = resultSet.getString("password");
				int limit = resultSet.getInt("book_limit");

				employee = new Employee(id, phone, limit, admin, name, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/LibraryManagementSystem",
				"Wiley", "wiley"); Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
			while (resultSet.next()) {
				int id = resultSet.getInt("employee_id");
				String name = resultSet.getString("employee_name");
				Long phone = resultSet.getLong("phone_Number");
				boolean admin = resultSet.getBoolean("isAdmin");
				String password = resultSet.getString("password");
				int limit = resultSet.getInt("book_limit");

				Employee employee = new Employee(id, phone, limit, admin, name, password);
				empList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

}
