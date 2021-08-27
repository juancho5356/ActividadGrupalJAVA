package Controlador;

import java.sql.*;
import java.util.*;

import Modelo.Persona;

public class DAOPersona {

	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CANT_PERSONAS FROM PERSONAS";
	
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONAS ORDER BY ID_PERSONA";
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONAS (ID_PERSONA, DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2) VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String BUSCAR_PERSONA = "SELECT * FROM PERSONAS WHERE APELLIDO1=? AND NOMBRE1=?";
	
	private static final String UPDATE_PERSONA = "UPDATE PERSONAS SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=? WHERE ID_PERSONA=?";
	
	private static final String DELETE_PERSONA = "DELETE FROM PERSONAS WHERE ID_PERSONA=?";
	
	private static final String BUSCAR_ADMIN = "SELECT * FROM PERSONAS WHERE ID_ROL = 1";
	
	private static final String BUSCAR_JEFE = "SELECT * FROM PERSONAS WHERE ID_ROL = 2";
	
	private static final String BUSCAR_OPERADOR = "SELECT * FROM PERSONAS WHERE ID_ROL = 3";
	
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
	
	public static LinkedList<Persona> findAll(){
		
		LinkedList<Persona> personas = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(ALL_PERSONAS);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				int idPersona = resultado.getInt("ID_PERSONA");
				String documento = resultado.getString("DOCUMENTO");
				String apellido1 = resultado.getString("APELLIDO1");
				String apellido2 = resultado.getString("APELLIDO2");
				String nombre1 = resultado.getString("NOMBRE1");
				String nombre2 = resultado.getString("NOMBRE2");
				String mail = resultado.getString("EMAIL");
				
				
				Persona p = new Persona();
				p.setIdPersona(idPersona);
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				p.setMail(mail);
				
				personas.add(p);
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
			
			statement.setLong(1, 16);
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
	
	public static LinkedList<Persona> findPersona(String apellido1, String nombre1) {
		
		LinkedList<Persona> personas = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_PERSONA);
			
			statement.setString(1, apellido1);
			statement.setString(2, nombre1);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				//int idPersona = resultado.getInt("ID_PERSONA");
				String documento = resultado.getString("DOCUMENTO");
				String apellido = resultado.getString("APELLIDO1");
				String apellido2 = resultado.getString("APELLIDO2");
				String nombre = resultado.getString("NOMBRE1");
				String nombre2 = resultado.getString("NOMBRE2");
				
				Persona p = new Persona();
				p.setDocumento(documento);
				p.setApellido1(apellido);
				p.setApellido2(apellido2);
				p.setNombre1(nombre);
				p.setNombre2(nombre2);
				
				personas.add(p);

			}
			
			return personas;
		
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean edit(Persona persona, String idPersonaST) {
		
		int idPersona = Integer.parseInt(idPersonaST);
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(UPDATE_PERSONA);
			
			statement.setString(1, persona.getDocumento());
			statement.setString(2, persona.getApellido1());
			statement.setString(3, persona.getApellido2());
			statement.setString(4, persona.getNombre1());
			statement.setString(5, persona.getNombre2());
			statement.setInt(6, idPersona);
			
			int retorno = statement.executeUpdate();
			
			return retorno > 0;
		
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(int idPersona) {
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(DELETE_PERSONA);
			
			statement.setInt(1, idPersona);
			
			int retorno = statement.executeUpdate();
			
			return retorno > 0;
		
		}catch(SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static LinkedList<Persona> findAdmin(){
		
		LinkedList<Persona> administradores = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_ADMIN);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				String documento = resultado.getString("DOCUMENTO");
				String apellido1 = resultado.getString("APELLIDO1");
				String apellido2 = resultado.getString("APELLIDO2");
				String nombre1 = resultado.getString("NOMBRE1");
				String nombre2 = resultado.getString("NOMBRE2");
				String correo = resultado.getString("EMAIL");
				String contraseña = resultado.getString("CONTRASEÑA");
				
				Persona p = new Persona();
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				p.setMail(correo);
				p.setClave(contraseña);
				
				administradores.add(p);
			}
			return administradores;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static LinkedList<Persona> findJefe(){
		
		LinkedList<Persona> jefes = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_JEFE);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				String documento = resultado.getString("DOCUMENTO");
				String apellido1 = resultado.getString("APELLIDO1");
				String apellido2 = resultado.getString("APELLIDO2");
				String nombre1 = resultado.getString("NOMBRE1");
				String nombre2 = resultado.getString("NOMBRE2");
				String correo = resultado.getString("EMAIL");
				String contraseña = resultado.getString("CONTRASEÑA");
				
				Persona p = new Persona();
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				p.setMail(correo);
				p.setClave(contraseña);
				
				jefes.add(p);
			}
			return jefes;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static LinkedList<Persona> findOperador(){
		
		LinkedList<Persona> operadores = new LinkedList<>();
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_OPERADOR);
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				
				String documento = resultado.getString("DOCUMENTO");
				String apellido1 = resultado.getString("APELLIDO1");
				String apellido2 = resultado.getString("APELLIDO2");
				String nombre1 = resultado.getString("NOMBRE1");
				String nombre2 = resultado.getString("NOMBRE2");
				String correo = resultado.getString("EMAIL");
				String contraseña = resultado.getString("CONTRASEÑA");
				
				Persona p = new Persona();
				p.setDocumento(documento);
				p.setApellido1(apellido1);
				p.setApellido2(apellido2);
				p.setNombre1(nombre1);
				p.setNombre2(nombre2);
				p.setMail(correo);
				p.setClave(contraseña);
				
				operadores.add(p);
			}
			return operadores;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
