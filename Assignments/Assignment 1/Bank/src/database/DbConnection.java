package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static final String USER = "root";
	public static final String PASS = "root";
	public static final String DBURL = "jdbc:mysql://localhost:3306/bank?useSSL=false";
	public static final String DRIVER = "com.mysql.jdbc.Driver";

	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}