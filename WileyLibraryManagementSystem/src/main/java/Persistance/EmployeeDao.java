package Persistance;

import java.util.List;

import Bean.Employee;

public interface EmployeeDao {

	Integer addEmployee(Employee employee);

	Integer removeEmployee(int empID);

	Employee searchEmployee(int empID);

	List<Employee> getAllEmployees();

}
