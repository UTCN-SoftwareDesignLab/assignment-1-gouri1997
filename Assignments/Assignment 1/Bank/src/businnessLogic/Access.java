package businnessLogic;

import database.*;
import java.util.ArrayList;
import java.util.Vector;

public class Access {

	AccountDB accountdb = new AccountDB();
	AccountCRUD accrud = new AccountCRUD();
	TransactionsDB transactionsdb = new TransactionsDB();

	public ArrayList<Account> getMyAccounts(int idclient) throws ClassNotFoundException {
		return accountdb.viewmyaccounts(idclient);
	}

	public ArrayList<String> getMyIBANs(int idclient) throws ClassNotFoundException {
		return accountdb.getMyIbans(idclient);
	}

	public String getAccDetails(String iban) throws ClassNotFoundException {
		return accountdb.getaccountdetails(iban);
	}

	public String transferMoney(String ibansrc, String ibandst, int amount) throws ClassNotFoundException {
		int initialamountsrc = 0;
		int initialamountdst = 0;
		int dif = 0;
		int sum = 0;

		String message = "";

		initialamountsrc = accountdb.selectamount(ibansrc);
		initialamountdst = accountdb.selectamount(ibandst);
		if (accountdb.selectcurrency(ibandst).equals(accountdb.selectcurrency(ibansrc))) {
			if (initialamountsrc >= amount) {
				sum = initialamountdst + amount;
				dif = initialamountsrc - amount;
				accountdb.transferMoney(ibansrc, dif);
				accountdb.transferMoney(ibandst, sum);

				transactionsdb.insertTransaction(ibansrc, ibandst, amount);

				message = "Success!";
			} else
				message = "Insufficient founds!";
		} else
			message = "The Currency dosn't match!";

		return message;
	}

	public String payBills(String ibansrc, String ibandst, int amount) throws ClassNotFoundException {
		int initialamountsrc = 0;
		int dif = 0;
		String message = "";

		initialamountsrc = accountdb.selectamount(ibansrc);
		if (initialamountsrc >= amount) {
			dif = initialamountsrc - amount;
			accountdb.transferMoney(ibansrc, dif);
			transactionsdb.insertTransaction(ibansrc, ibandst, amount);
			message = "Success!";
		} else
			message = "Insufficient founds!";
		return message;
	}

	public String insertAcc(String iban, int amount, String currency, String accounttype, int idclient)
			throws ClassNotFoundException {
		accrud.insertAcc(iban, amount, currency, accounttype, idclient);
		String mess = "Success!";
		return mess;
	}

	public String getAccDet(String iban) throws ClassNotFoundException {
		return accrud.getaccdetails(iban);

	}

	public String updateAcc(int amount, String currency, String accounttye, String iban) throws ClassNotFoundException {
		accrud.updateAcc(amount, currency, accounttye, iban);

		String mess = "Account updated!";
		return mess;
	}

	public String deleteAcc(String iban) throws ClassNotFoundException {
		accrud.deleteAcc(iban);
		String mess = "Account deleted!";
		return mess;
	}

}
