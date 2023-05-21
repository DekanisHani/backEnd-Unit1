package jdbc.lezione.epicode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	String url = "jdbc:postgresql://localhost:5432/";
	String dbName = "esercizioGiorno1";
	String user = "postgres";
	String pass = "root";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
		conn = DriverManager.getConnection(url + dbName, user, pass);
		st = conn.createStatement();
	}
	
	
	
}
