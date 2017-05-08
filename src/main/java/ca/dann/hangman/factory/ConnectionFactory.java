package ca.dann.hangman.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String USER = "root";
	private static final String PASS = "insert password here";
	private static final String URL = "jdbc:mysql://localhost:3306/hangman";

	public static Connection openConnection() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());	

		Connection con =  DriverManager.getConnection(URL, USER, PASS);
		return con;

	}	
}
