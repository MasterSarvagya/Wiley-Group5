package Presentation;

public class PresentationImpl implements Presentation {

	@Override
	public void showMenu() {
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
		

	}

	@Override
	public void performMenu(int choice) {
	
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
			
			System.out.println("Exit from the system");
			break;	
			
			
			
		default :
			
			System.out.println("Error Occurred");
			break;
		}

	}


	private void returnBook() {
		// TODO Auto-generated method stub
		
	}

	private void issueBook() {
		// TODO Auto-generated method stub
		
	}

	private void getAllBook() {
		// TODO Auto-generated method stub
		
	}

	private void searchBook() {
		// TODO Auto-generated method stub
		
	}

	private void delBook() {
		// TODO Auto-generated method stub
		
	}

	private void addBook() {
		// TODO Auto-generated method stub
		
	}


	private void getAllemployee() {
		// TODO Auto-generated method stub
		
	}

	private void searchEmployee() {
		// TODO Auto-generated method stub
		
	}

	private void addEmployee() {
		// TODO Auto-generated method stub
		
	}
	
	private void delEmployee() {
		// TODO Auto-generated method stub
		
	}

}
