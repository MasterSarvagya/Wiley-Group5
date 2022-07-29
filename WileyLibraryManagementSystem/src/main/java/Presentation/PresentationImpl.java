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

	private EmployeeService employeeService = new EmployeeServiceImpl();
	private static Scanner scanner = new Scanner(System.in);

	private BooksService bookService = new BooksServiceImpl();

	@Override
	public void showMenu() {
		System.out.println("======================================================");
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
		System.out.println(" 0.   Exit");
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
		List<Books> bookList = bookService.getAllBooks();
		if (bookService.getAllBooks() == null)
			System.out.println("No Books Present");
		else {
			for (Books book : bookList) {
				System.out.println(book);

			}
		}
	}

	private void searchBook() {
		System.out.println("Enter Book ID: ");
		int id = scanner.nextInt();
		Books book = bookService.searchBook(id);
		if (book != null)
			System.out.println(book);
		else
			System.out.println("Book With ID " + id + " Does Not Exist");
	}

	private void removeBook() {
		System.out.print(" Enter Book ID: ");
		int bookID = scanner.nextInt();
		if (bookService.removeBook(bookID))
			System.out.println("Book is Removed");
		else
			System.out.println("Operation Failed");
	}

	private void addBook() {
		System.out.print("Enter Book ID: ");
		int bookID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Book Name: ");
		String bookName = scanner.nextLine();
		System.out.print("Enter Book Author: ");
		String bookAuthor = scanner.nextLine();
		System.out.print("Enter Book Type: ");
		String bookType = scanner.nextLine();
		System.out.print("Enter Book Quantity: ");
		int originalQty = scanner.nextInt();
		int leftQty = originalQty;

		Books book = new Books(bookID, originalQty, leftQty, bookName, bookAuthor, bookType);
		if (bookService.addBook(book))
			System.out.println("Book is Added");
		else
			System.out.println("Operation Failed");
	}

	private void getAllemployee() {
		List<Employee> empList = employeeService.getAllEmployees();
		if (empList == null)
			System.out.println("No Employee Found");
		for (Employee employee : empList)
			System.out.println(employee);
	}

	private void searchEmployee() {
		System.out.print("Enter Employee ID: ");
		int id = scanner.nextInt();
		Employee empl = employeeService.searchEmployee(id);
		if (empl != null) {
			System.out.println(empl);
		} else
			System.out.println("Employee With ID " + id + " Does Not Exist");
	}

	private void addEmployee() {
		System.out.print("Enter Employee ID: ");
		int empID = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter Employee Name: ");
		String empName = scanner.nextLine();
		System.out.print("Enter Password: ");
		String password = scanner.nextLine();
		System.out.print("Enter Employee Phone Number: ");
		Long empPhoneNumber = scanner.nextLong();

		int bookLimit = 5;
		boolean isAdmin = false;

		Employee employee = new Employee(empID, empPhoneNumber, bookLimit, isAdmin, empName, password);
		if (employeeService.addEmployee(employee))
			System.out.println("Employee Added Sccessfully");
		else
			System.out.println("Operation Failed");
	}

	private void delEmployee() {
		System.out.print("Enter Employee ID: ");
		int empID = scanner.nextInt();
		if (employeeService.removeEmployee(empID))
			System.out.println("Employee Deleted Successfully");
		else
			System.out.println("Operation Failed");
	}
}
