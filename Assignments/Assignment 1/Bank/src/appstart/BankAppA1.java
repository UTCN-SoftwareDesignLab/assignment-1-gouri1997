
package appstart;

import Presentation.LoginUI;
import businnessLogic.ClientsAccess;
import database.ClientDB;


public class BankAppA1 {

    public static void main(String[] args) throws ClassNotFoundException {
    /*	ClientsAccess c= new ClientsAccess();
    	ClientDB db= new ClientDB();
    	db.insertClient("Gouri", "222", "555", "India");*/
    	
    	new LoginUI();
    
    }
    
}
