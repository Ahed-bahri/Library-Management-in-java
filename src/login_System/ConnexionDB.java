package login_System;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
	
	String url="jdbc:mysql://localhost/bibo";
	String login="root";
	String pass="";
	public static Connection cn;

	private ConnexionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection(url,login,pass);			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static Connection getConnexion() {
		if (cn==null) {
			new ConnexionDB();
		}
		return cn;
	}
	
}
