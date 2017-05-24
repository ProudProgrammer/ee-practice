package hu.gaborbalazs.practice.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
	
	public static void main(String[] args) throws SQLException {
		
		System.out.println("Hello World");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gb_practice?useSSL=false", "root", "root");
//		Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
		Statement stmt = conn.createStatement();
		
		System.out.println("OK");

	}

}
