package login;

import Bean.Employee;
import Presentation.PresentationImpl;

public class LoginImpl implements Login {

	private Integer empID;
	private String password;

	@Override
	public void getInput() {
		// TODO Auto-generated method stub

		Employee employee = new Employee(empID, empID, empID, null, password, password);

		if (empID == employee.getEmpID() && password == employee.getPassword())
			loginSuccess();
		else
			loginFailed();
	}

	private void loginSuccess() {

		PresentationImpl presentationImpl = new PresentationImpl();
		while (true) {
			presentationImpl.showMenu();
			presentationImpl.performMenu(0);
		}

	}

	private void loginFailed() {

		System.out.println("Login Failed");

	}

}
