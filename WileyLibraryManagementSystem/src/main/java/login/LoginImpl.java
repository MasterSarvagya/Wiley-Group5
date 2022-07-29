package login;

import java.util.Scanner;

import Bean.Employee;
import Persistance.EmployeeDaoImpl;
import Presentation.PresentationImpl;

public class LoginImpl implements Login {

	Scanner scanner = new Scanner(System.in);

	public void loginInput() {

		System.out.println("======================================================");

		System.out.print("Enter Employee ID: ");
		int employeeID = scanner.nextInt();

		System.out.print("Enter Employee Password: ");
		String employeePassword = scanner.next();

		System.out.println("======================================================");

		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		Employee employee = employeeDaoImpl.searchEmployee(employeeID);

		//employee = new Employee(1, 11111, 5, false, "Master", "1");
		
		if(employee == null)
			loginFailed();

		if (employeePassword.compareTo(employee.getPassword()) == 0)
			loginSuccess();
		else
			loginFailed();

		scanner.close();
	}

	private void loginSuccess() {

		PresentationImpl presentationImpl = new PresentationImpl();
		boolean flag = true;
		while (flag) {
			presentationImpl.showMenu();
			System.out.print("Enter Choice: ");
			Integer ch = scanner.nextInt();
			flag = presentationImpl.performMenu(ch);
		}

	}

	private void loginFailed() {
		System.out.println("Login Failed");
		System.out.print("Try Again (Y/N): ");
		Character character = scanner.next().charAt(0);
		if (character == 'Y' || character == 'y')
			loginInput();
		else
			System.out.print("Thanks For Using The System");
	}
}
