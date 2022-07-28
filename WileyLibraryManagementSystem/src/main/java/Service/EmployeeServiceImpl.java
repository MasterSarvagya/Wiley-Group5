package Service;

import java.util.List;

import Bean.Employee;
import Persistance.EmployeeDao;
import Persistance.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public Boolean addEmployee(Employee employee) {
		if(employeeDao.addEmployee(employee) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean removeEmployee(Integer empID) {
		if(employeeDao.removeEmployee(empID)>0)
			return true;
		return false;
	}

	@Override
	public Employee searchEmployee(Integer empID) {
		return employeeDao.searchEmployee(empID);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Boolean employeeLogin(Integer empId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
