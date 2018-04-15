package database;

import businnessLogic.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountDB {
	private static final String viewacc = "SELECT idaccount, iban, amount, currency, accounttype, idclient, datecreate FROM accounts where idclient = ?";
	private static final String myibanlist = "SELECT iban FROM accounts WHERE idclient = ?";
	private static final String accdetails = "SELECT amount, currency, accounttype, datecreate FROM accounts WHERE iban = ?";
	private static final String updatetransf = "UPDATE accounts SET amount=? WHERE iban = ?";
	private static final String selamount = "SELECT amount FROM accounts WHERE iban = ?";
	private static final String selcurrency = "SELECT currency FROM accounts WHERE iban = ?";

	public ArrayList<Account> viewmyaccounts(int myidclient) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ArrayList<Account> accList = new ArrayList<Account>();

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(viewacc);
			preparedStatement.setInt(1, myidclient);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {
				int idaccount = result.getInt(1);
				String iban = result.getString(2);
				int amount = result.getInt(3);
				String currency = result.getString(4);
				String acctype = result.getString(5);
				int idclient = result.getInt(6);
				String datecreate = result.getString(7);
				Account acc = new Account(idaccount, iban, amount, currency, acctype, idclient, datecreate);
				accList.add(acc);
			}
		} catch (SQLException e) {
		}

		finally {
			try {
				result.close();
			} catch (Exception rse) {
			}
			try {
			} catch (Exception sse) {
			}
			try {
				conn.close();
			} catch (Exception cse) {
			}
		}
		return accList;
	}

	public ArrayList<String> getMyIbans(int myidclient1) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ArrayList<String> ibansList = new ArrayList<String>();
		int i = 0;
		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(myibanlist);
			preparedStatement.setInt(1, myidclient1);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {
				ibansList.add(result.getString(1));
			}
		} catch (SQLException e) {
		}

		finally {
			try {
				result.close();
			} catch (Exception rse) {
			}
			try {
			} catch (Exception sse) {
			}
			try {
				conn.close();
			} catch (Exception cse) {
			}
		}
		return ibansList;
	}

	public String getaccountdetails(String iban) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String accdet = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(accdetails);
			preparedStatement.setString(1, iban);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				int amount = result.getInt(1);
				String currency = result.getString(2);
				String acctype = result.getString(3);
				String datecreate = result.getString(4);
				accdet = "Amount: " + amount + "  " + currency + "\nAccount type: " + acctype + "\nDate of creation: "
						+ datecreate;
			}
		} catch (SQLException e) {
		}

		finally {
			try {
				result.close();
			} catch (Exception rse) {
			}
			try {
			} catch (Exception sse) {
			}
			try {
				conn.close();
			} catch (Exception cse) {
			}
		}
		return accdet;
	}

	public boolean transferMoney(String iban, int money) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String accdet = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(updatetransf);
			preparedStatement.setString(2, iban);
			preparedStatement.setInt(1, money);
			preparedStatement.execute();
			return true;

		} catch (SQLException e) {
		}

		finally {
			try {
				result.close();
			} catch (Exception rse) {
			}
			try {
			} catch (Exception sse) {
			}
			try {
				conn.close();
			} catch (Exception cse) {
			}
		}
		return false;
	}

	public int selectamount(String iban) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		int amount = 0;
		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(selamount);
			preparedStatement.setString(1, iban);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				amount = result.getInt(1);
			}
		} catch (SQLException e) {
		}

		finally {
			try {
				result.close();
			} catch (Exception rse) {
			}
			try {
			} catch (Exception sse) {
			}
			try {
				conn.close();
			} catch (Exception cse) {
			}
		}
		return amount;
	}

	public String selectcurrency(String iban) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String currency = "";
		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(selcurrency);
			preparedStatement.setString(1, iban);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				currency = result.getString(1);
			}
		} catch (SQLException e) {
		}

		finally {
			try {
				result.close();
			} catch (Exception rse) {
			}
			try {
			} catch (Exception sse) {
			}
			try {
				conn.close();
			} catch (Exception cse) {
			}
		}
		return currency;
	}

}
