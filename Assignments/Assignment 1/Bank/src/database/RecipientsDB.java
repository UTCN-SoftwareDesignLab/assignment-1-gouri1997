package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class RecipientsDB {
	private static final String reciplist = "SELECT ibanrecip FROM recipients";

	public ArrayList<String> getRecipIbans() throws ClassNotFoundException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		ArrayList<String> ibansList = new ArrayList<String>();

		try {
			conn = DbConnection.createConnection();
			preparedStatement = conn.prepareStatement(reciplist);
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
}