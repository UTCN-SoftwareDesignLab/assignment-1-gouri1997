package businnessLogic;

import database.*;

import java.util.ArrayList;

public class RecipientsAccess {

	public ArrayList<String> getallRecip() throws ClassNotFoundException {
		RecipientsDB recip = new RecipientsDB();
		return recip.getRecipIbans();
	}

}
