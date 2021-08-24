package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "JAVA";
	private static String CLAVE = "JAVA";
	
	static {
		
		databaseConnection = null;
		
		try { 
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			try {
				
				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE); 
			
			}catch(SQLException e){
				
				System.out.println("No logramos instanciar una conexión");
				e.printStackTrace();
			
			}
				
	
			
		}catch(ClassNotFoundException e) {
			System.out.println("No tienes el driver en tu build-patch?");
			e.printStackTrace();
			
		}
	}
	
	public static Connection getConnection() {
		return databaseConnection;
	}
	

}
