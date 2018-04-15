package businnessLogic;

import database.*;

public class LoginAccess {
	LoginDB logindb;

	public LoginAccess() {
	}

	public String login(String myuser, String mypass) throws ClassNotFoundException {
		logindb = new LoginDB();
		/*
		 * try { return logindb.verifyLoginUserType(myuser, mypass); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); }
		 */
		return logindb.verifyLoginUserType(myuser, mypass);
	}

	public int getLoginClientId(String myuser, String mypass) throws ClassNotFoundException {
		logindb = new LoginDB();
		return logindb.getIdClientLogin(myuser, mypass);
	}
}
