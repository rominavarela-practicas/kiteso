package mx.kiteso.KIteso.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public static void main(String[] argv) {
		System.out.println("-----This is a test n.n-----");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("MySQL JDBC driver not found!! u.u");
			return;
		}
		
		System.out.println("MySQL JDBC driver registered!! :D");
		
		Connection connection = null;
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost/Diseno_Software", "root", "toor");
			System.out.println("SQL connection to database established!! :'D");
		}catch(SQLException e){
			System.out.println("Connection failed!! D:");
			return;
		}finally{
			try{
				if(connection != null){
					connection.close();
				}
				System.out.println("Connection closed u.u");
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
