package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDB {
	private static final String createclient = "INSERT INTO clients (nameClient, identitycard, cnp, address) VALUES (?,?,?,?)";
	private static final String readclient = "SELECT nameClient, identitycard, cnp, address from clients WHERE idclient=?";
	private static final String updateclient = "UPDATE clients SET nameClient=?, identitycard=?, cnp=?, address=? WHERE idclient=?";
	private static final String deleteclient = "DELETE FROM clients WHERE idclient = ?";

	public boolean insertClient(String name, String identitycard, String cnp, String adress)
			throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(createclient);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, identitycard);
			preparedStatement.setString(3, cnp);
			preparedStatement.setString(4, adress);

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

	public String getclientdetails(int idclient) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String detclient = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(readclient);
			preparedStatement.setInt(1, idclient);
			preparedStatement.execute();
			result = preparedStatement.getResultSet();

			while (result.next()) {

				String name = result.getString(1);
				String identitycard = result.getString(2);
				String cnp = result.getString(3);
				String adress = result.getString(4);
				detclient = "Name: " + name + "\r\nID Card: " + identitycard + "\r\nCNP: " + cnp + "\r\nAddress: "
						+ adress;
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

	public boolean updateClients(int idclient, String nameClient, String identitycard, String cnp, String adress)
			throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String accdet = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(updateclient);
			preparedStatement.setString(1, nameClient);
			preparedStatement.setString(2, identitycard);
			preparedStatement.setString(3, cnp);
			preparedStatement.setString(4, adress);
			preparedStatement.setInt(5, idclient);

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

	public boolean deleteClients(int idclient) throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String accdet = "";

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(deleteclient);

			preparedStatement.setInt(1, idclient);

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
