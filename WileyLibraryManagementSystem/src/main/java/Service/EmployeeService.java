package Service;

import java.util.List;

import Bean.Employee;

public interface EmployeeService {

	Boolean addEmployee(Employee employee);

	Boolean removeEmployee(Integer empID);

	Employee searchEmployee(Integer empID);

	List<Employee> getAllEmployees();
	
	Boolean employeeLogin(Integer empId, String password);

}
