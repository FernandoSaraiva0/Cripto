package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cripto2";
	
	public static Connection createConnectionToMySQL() throws SQLException, ClassNotFoundException {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager
					.getConnection(DB_URL, USERNAME, PASSWORD);
		
			return connection;
		
			
	}
	// Singleton - Garante que exista apenas uma instância 
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection con = createConnectionToMySQL();
		
		if(con!=null) {
			con.close();
		}
	}
	
}
