package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionsDB {

	private static final String inserttrans = "INSERT INTO transactions (datetr, src_account, dest_account, amount_transf) VALUES (CURDATE(),?,?,?)";
	private static final String getreport = "SELECT datetr, dest_account, amount_transf FROM transactions where datetr >=? and datetr <=? and src_account=?";
	private static final String selecttrreport = "SELECT datetr, src_account, dest_account, amount_transf FROM transactions where datetr >=? and datetr <=?";

	public boolean insertTransaction(String src_account, String dest_account, int amount_transf)
			throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(inserttrans);
			preparedStatement.setString(1, src_account);
			preparedStatement.setString(2, dest_account);
			preparedStatement.setInt(3, amount_transf);
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

	public String getreport(String datefrom, String dateto, String iban) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String report = "IBAN: " + iban;

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(getreport);
			preparedStatement.setString(1, datefrom);
			preparedStatement.setString(2, dateto);
			preparedStatement.setString(3, iban);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				String datetr = result.getString(1);
				String destiban = result.getString(2);
				int amount = result.getInt(3);

				report += "\r\nDate: " + datetr + "\r\nYou transfered to:   " + destiban + "    Amount:  " + amount
						+ "\r\n\r\n";
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
		return report;
	}

	public String selectreportbyadmin(String datefrom, String dateto) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String report = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(selecttrreport);
			preparedStatement.setString(1, datefrom);
			preparedStatement.setString(2, dateto);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				String datetr = result.getString(1);
				String srciban = result.getString(2);
				String destiban = result.getString(3);
				int amount = result.getInt(4);

				report += "\r\nDate: " + datetr + "\r\nFrom Account:  " + srciban + "  To Account:   " + destiban
						+ "    Amount:  " + amount + "\r\n\r\n";
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
		return report;
	}

}
