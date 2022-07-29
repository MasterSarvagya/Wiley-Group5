package Presentation;

import java.util.List;
import java.util.Scanner;

import Bean.Books;
import Bean.Employee;
import Service.BooksService;
import Service.BooksServiceImpl;
import Service.EmployeeService;
import Service.EmployeeServiceImpl;

public class PresentationImpl implements Presentation {
	
	private EmployeeService employeeService=new EmployeeServiceImpl();
	private static Scanner scanner = new Scanner(System.in);
	
	private BooksService bookService=new BooksServiceImpl();

	@Override
	public void showMenu() {
		System.out.println("======================================================");
		System.out.println(" 0.   Exit");
		System.out.println(" 1.   Add An Employee");
		System.out.println(" 2.   Delete An Employee");
		System.out.println(" 3.   Search An Employee");
		System.out.println(" 4.   Get All Employee");
		System.out.println(" 5.   Add A Book");
		System.out.println(" 6.   Delete A Book");
		System.out.println(" 7.   Search A Book");
		System.out.println(" 8.   Get All Book");
		System.out.println(" 9.   Issue A Book");
		System.out.println(" 10.  Return A Book");
		System.out.println("======================================================");
	}

	@Override
	public Boolean performMenu(int choice) {

		switch (choice) {
		case 1:
			addEmployee();
			break;
		case 2:
			delEmployee();
			break;
		case 3:
			searchEmployee();
			break;
		case 4:
			getAllemployee();
			break;
		case 5:
			addBook();
			break;
		case 6:
			removeBook();
			break;
		case 7:
			searchBook();
			break;
		case 8:
			getAllBook();
			break;
		case 9:
			issueBook();
			break;
		case 10:
			returnBook();
			break;
		case 0:
			System.out.print("Thanks For Using The System");
			return false;
		default:
			System.out.println("Wrong Choice");
			break;
		}

		return true;

	}

	private void returnBook() {
		System.out.println("Option Under Construction");
	}

	private void issueBook() {
		System.out.println("Option Under Construction");
	}

	private void getAllBook() {
		System.out.println("Option Under Construction");
	}

	private void searchBook() {
		System.out.println("Option Under Construction");
	}

	private void removeBook() {
		
		System.out.println(" Enter Book ID : ");
		int bookID =scanner.nextInt();
		
		boolean delete=bookService.removeBook(bookID);
		if(delete) {
			System.out.println("Element deleted");
		}
		else {
			System.out.println("Cannot delete");
		}	
	}

	private void addBook() {
		
		System.out.println("Enter book id");
		int bookID = scanner.nextInt();
		System.out.println("Enter Book Author");
		String bookAuthor = scanner.nextLine();
		System.out.println("Enter Book name");
		String bookName = scanner.nextLine();
		System.out.println("Enter Book Type");
		String bookType = scanner.nextLine();
		System.out.println("Enter Original Qty");
		int originalQty = scanner.nextInt();
		System.out.println("Enter Left Qty");
		int leftQty = originalQty;
		
		Books book = new Books(bookID,originalQty,leftQty, bookName,bookAuthor,bookType);
		if(bookService.addBook(book)) {
			System.out.println("Book is added");
		}
		else {
			System.out.println("Book's deatils invalid");
		}
		
		
		System.out.println("Option Under Construction");
	}

	private void getAllemployee() {
		List<Employee> empList = employeeService.getAllEmployees();
		for(Employee employee : empList)
			System.out.println(employee);
	}

	private void searchEmployee() {
		System.out.println("Enter Employee ID : ");
		int id=scanner.nextInt();
		Employee empl=employeeService.searchEmployee(id);
		if(empl!=null) {
			System.out.println(empl.getEmpID()+"  "+empl.getEmpName());
		}
		else
			System.out.println("Employee with id "+id+" does not exist");
	}

	private void addEmployee() {
		System.out.println("Enter employee id");
		int empID = scanner.nextInt();
		System.out.println("Enter employee phone number");
		int empPhoneNumber = scanner.nextInt();
		System.out.println("Enter book limit");
		int bookLimit = scanner.nextInt();
		System.out.println("Enter if employee is admin or not(true/false)");
		boolean isAdmin = scanner.nextBoolean();
		System.out.println("Enter employee name");
		String empName = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		
		Employee employee = new Employee(empID,empPhoneNumber,bookLimit,isAdmin,empName,password);
		if(employeeService.addEmployee(employee)) {
			System.out.println("Employee added");
		}
		else {
			System.out.println("Employee deatils invalid");
		}
	}

	private void delEmployee() {
		System.out.print("Enter Employee ID : ");
		int empID = scanner.nextInt();
		if(employeeService.removeEmployee(empID))
			System.out.println("Employee Deleted Successfully");
		else
			System.out.println("Employee deatils invalid");
	}
}
