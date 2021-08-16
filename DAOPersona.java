package Controlador;

import java.sql.*;
import java.util.*;

import Modelo.Persona;

public class DAOPersona {

	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CANT_PERSONAS FROM PERSONAS";
	
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONAS";
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONAS (ID_PERSONA, DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2) VALUES (?, ?, ?, ?, ?, ?)";
	
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
	
	public static boolean insert(Persona p) {
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(INSERT_PERSONA);
			
			statement.setLong(1, 15);
			statement.setString(2, p.getDocumento());
			statement.setString(3, p.getApellido1());
			statement.setString(4, p.getApellido2());
			statement.setString(5, p.getNombre1());
			statement.setString(6, p.getNombre2());
			
			int retorno = statement.executeUpdate();
			
			return retorno > 0;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
