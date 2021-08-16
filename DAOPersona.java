package Controlador;

import java.sql.*;
import java.util.*;

public class DAOPersona {

	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CANT_PERSONAS FROM PERSONAS";
	
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONAS";
	
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
	
	public static LinkedList<String> findAll(){
		
		LinkedList<String> personas = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(ALL_PERSONAS);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				String persona = resultado.getString("APELLIDO1");
				personas.add(persona);
			}
			
			return personas;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
