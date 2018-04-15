package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountCRUD {
	private static final String createacc = "INSERT INTO accounts (iban, amount, currency, accounttype, idclient, datecreate) VALUES (?,?,?,?,?,CURDATE())";
	private static final String readacc = "SELECT iban, amount, currency, accounttype, idclient, datecreate from accounts WHERE iban=?";
	private static final String updateacc = "UPDATE accounts SET amount=?, currency=?, accounttype=? WHERE iban=?";
	private static final String deleteacc = "DELETE FROM accounts WHERE iban = ?";

	public boolean insertAcc(String iban, int amount, String currency, String accounttype, int idclient)
			throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(createacc);
			preparedStatement.setString(1, iban);
			preparedStatement.setInt(2, amount);
			preparedStatement.setString(3, currency);
			preparedStatement.setString(4, accounttype);
			preparedStatement.setInt(5, idclient);
			preparedStatement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
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

	public String getaccdetails(String iban1) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String detclient = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(readacc);
			preparedStatement.setString(1, iban1);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				String iban = result.getString(1);
				int amount = result.getInt(2);
				String currency = result.getString(3);
				String acctype = result.getString(4);
				int idclient = result.getInt(5);
				String datecreate = result.getString(6);
				detclient = " IBAN: " + iban + "\r\nAmount: " + amount + " " + currency + "\r\nAccount Type:" + acctype
						+ "\r\nCreated on: " + datecreate;

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
		return detclient;
	}

	public boolean updateAcc(int amount, String currency, String accounttype, String iban)
			throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String accdet = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(updateacc);
			preparedStatement.setInt(1, amount);
			preparedStatement.setString(2, currency);
			preparedStatement.setString(3, accounttype);
			preparedStatement.setString(4, iban);

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

	public boolean deleteAcc(String iban) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(deleteacc);

			preparedStatement.setString(1, iban);

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

}
