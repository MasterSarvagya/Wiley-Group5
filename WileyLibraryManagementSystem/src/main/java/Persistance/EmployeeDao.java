package Persistance;

import java.util.List;

import Bean.Employee;

public interface EmployeeDao {

	Boolean addEmployee(Employee employee);

	Boolean removeEmployee(int empID);

	Employee searchEmployee(int empID);

	List<Employee> getAllEmployees();

}