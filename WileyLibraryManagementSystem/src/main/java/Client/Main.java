package Client;

import login.Login;
import login.LoginImpl;

public class Main {

	public static void main(String[] args) {

		Login login = new LoginImpl();

		login.loginInput();
	}

}