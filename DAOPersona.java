package Controlador;

import java.sql.*;

public class DAOPersona {

	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CANT_PERSONAS FROM PERSONAS";
	
	public static int cuentaPersonas() {
		
		int contador = 0;
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(CUENTA_PERSONAS);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				contador = resultado.getInt("CANT_PERSONAS");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return contador;
	}
}
