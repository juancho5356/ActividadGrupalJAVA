package Controlador;

import java.sql.*;

public class ConexionBD {

	public static void main(String[] args) {
		
try { 
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Se encontr� el Driver para Oracle DB - La librer�a est� referenciada");
			System.out.println("------------------------------------------------------------------------------------");
			
			
			} catch (ClassNotFoundException e) {
			
			System.out.println("No tienes el driver en tu build-patch?");
			e.printStackTrace();
			return;
			}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Connection connection = null;
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		try {
				
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"JAVA",					
					"JAVA");
				
			System.out.println("Conexi�n creada con �xito, es posible acceder a la base de datos");
				
			System.out.println("------------------------------------------------------------------------------------");
				
		} catch (SQLException e) {
				
			System.out.println("No logramos instanciar una conexi�n");
			e.printStackTrace();
			return;
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		String consulta = "SELECT * FROM ROLES";
		
		try {
			Statement sentencia = connection.createStatement(); 
			ResultSet rolesRS = sentencia.executeQuery(consulta);
			
			while (rolesRS.next()) {
				
				System.out.println(
						"  NOMBRE " 	+ 	rolesRS.getString("NOMBRE")); 	
				
			}
			
		}catch(SQLException e) {
					
			System.out.println("....................................................................................");				
			System.out.println("Error al ejecutar la consulta -> " + consulta);
			System.out.println("....................................................................................");				
			e.printStackTrace();
			return;
		}
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("------------------------------------------------------------------------------------");

		try {
			connection.close();
			System.out.println("Conexi�n cerrada con �xito");
					
		}catch (SQLException e) {
			System.out.println("Error al cerrar conexi�n");
			e.printStackTrace();
			return;
		} 
}
}
