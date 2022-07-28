package Presentation;

public class PresentationImpl implements Presentation {

	@Override
	public void showMenu() {
		System.out.println(" 0.   Exit");
		System.out.println(" 1.   Add An Employee");
		System.out.println(" 2.   Delete An Employee");
		System.out.println(" 3.   Search An Employee");
		System.out.println(" 4.   Get All Employee");
		System.out.println(" 5.   For Employee Login");
		System.out.println(" 6.   Add A Book");
		System.out.println(" 7.   Delete A Book");
		System.out.println(" 8.   Search A Book");
		System.out.println(" 9.   Get All Book");
		System.out.println(" 10.  Issue A Book");
		System.out.println(" 11.  Return A Book");
		

	}

	@Override
	public void performMenu(int choice) {
		// TODO Auto-generated method stub

	}

}
