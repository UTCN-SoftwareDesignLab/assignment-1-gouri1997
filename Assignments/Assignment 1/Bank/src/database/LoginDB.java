package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {
	private static final String loginq = "SELECT username, password, typeuser FROM login WHERE username = ?";
	private static final String loginclientid = "SELECT username, password, idclient FROM login WHERE username = ?";

	public String verifyLoginUserType(String myuser, String mypass) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		String type = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(loginq);
			preparedStatement.setString(1, myuser);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			if (result.next() && result != null) {
				if (result.getString(1).equals(myuser) && result.getString(2).equals(mypass)) {
					type = result.getString(3);
				}
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
		return type;
	}

	public int getIdClientLogin(String myuser, String mypass) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		int id = 0;

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(loginclientid);
			preparedStatement.setString(1, myuser);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();
			if (result.next() && result != null) {
				if (result.getString(1).equals(myuser) && result.getString(2).equals(mypass)) {
					id = result.getInt(3);
				}
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
		return id;
	}

}
