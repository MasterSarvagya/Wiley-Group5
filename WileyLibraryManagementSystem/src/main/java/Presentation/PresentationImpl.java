package Presentation;

public class PresentationImpl implements Presentation {

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
			delBook();
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

	private void delBook() {
		System.out.println("Option Under Construction");
	}

	private void addBook() {
		System.out.println("Option Under Construction");
	}

	private void getAllemployee() {
		System.out.println("Option Under Construction");
	}

	private void searchEmployee() {
		System.out.println("Option Under Construction");
	}

	private void addEmployee() {
		System.out.println("Option Under Construction");
	}

	private void delEmployee() {
		System.out.println("Option Under Construction");
	}
}
