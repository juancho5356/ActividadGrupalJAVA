package Controlador;

import java.sql.*;

public class ConexionBD {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "JAVA";
	private static String CLAVE = "JAVA";
	
	static {
		
		databaseConnection = null;

	try { 
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Se encontró el Driver para Oracle DB - La librería está referenciada");
			System.out.println("------------------------------------------------------------------------------------");
			
			try {
				
				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE);
					
				System.out.println("Conexión creada con éxito, es posible acceder a la base de datos");
					
				System.out.println("------------------------------------------------------------------------------------");
					
			} catch (SQLException e) {
					
				System.out.println("No logramos instanciar una conexión");
				e.printStackTrace();
				
			}
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("No tienes el driver en tu build-path?");
			e.printStackTrace();
			
			}
	
	}
	
	public static Connection getConnection() {
		return databaseConnection;
	
}
}
