package conexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;

import modelo.Persona;

//Java.sql.Date mySqlDate = Java.sql.Date.valueOf( myLocalDate );
//LocalDate myLocalDate = mySqlDate.toLocalDate();

public class DAOPersona {
	
	private static final String ALL_PERSONAS = "SELECT * FROM PERSONAS ORDER BY 1"; 

	private static final String CUENTA_PERSONAS = "SELECT COUNT(ID_PERSONA) AS CUENTA FROM PERSONAS";
	
	private static final String INSERT_PERSONA = "INSERT INTO PERSONAS (ID_PERSONA, DOCUMENTO, APELLIDO1, APELLIDO2, NOMBRE1, NOMBRE2, FECHA_NAC, MAIL, CLAVE, ID_ROL) values (SEQ_ID_PERSONA.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String BUSCAR_PERSONA = "SELECT * FROM PERSONAS WHERE APELLIDO1=? AND NOMBRE1=?";
	
	private static final String UPDATE_PERSONA = "UPDATE PERSONAS SET DOCUMENTO=?, APELLIDO1=?, APELLIDO2=?, NOMBRE1=?, NOMBRE2=?, FECHA_NAC=?, ID_ROL=? WHERE ID_PERSONA=?";
	
	private static final String DELETE_PERSONA = "DELETE FROM PERSONAS WHERE ID_PERSONA=?"; 
	

	public static boolean insert(Persona p) {
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(INSERT_PERSONA);
			
			statement.setString(1, p.getDocumento());
			statement.setString(2, p.getApellido1());
			statement.setString(3, p.getApellido2());
			statement.setString(4, p.getNombre1());
			statement.setString(5, p.getNombre2());
			
			statement.setDate(6, java.sql.Date.valueOf(p.getFechaNac()));
			
			statement.setString(7, p.getMail());
			statement.setString(8, p.getClave());
			statement.setLong(9, p.getRol().getIdRol());
			
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	public static boolean edit(Persona p) {
		try{
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(UPDATE_PERSONA);
			
			statement.setString(1, p.getDocumento());
			statement.setString(2, p.getApellido1());
			statement.setString(3, p.getApellido2());
			statement.setString(4, p.getNombre1());
			statement.setString(5, p.getNombre2());
			statement.setDate(6, java.sql.Date.valueOf(p.getFechaNac()));
			statement.setLong(7, p.getRol().getIdRol());
			statement.setLong(8, p.getIdPersona());
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
		
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	public static boolean delete(int idPersona) {
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(DELETE_PERSONA);
			statement.setInt(1, idPersona);
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static LinkedList<Persona> findAll(){
		LinkedList<Persona> personas = new LinkedList<>();
		
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(ALL_PERSONAS);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Persona persona = getPersonaFromResultSet(resultado);
				personas.add(persona);
			}
			return personas;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
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
				Persona p = getPersonaFromResultSet(resultado);
				personas.add(p);
			}
			return personas;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static int cuentaPersonas() {
		
		int cuenta = 0;
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(CUENTA_PERSONAS);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				cuenta = resultado.getInt("CUENTA");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cuenta;
	}
	
	
	

	
private static Persona getPersonaFromResultSet(ResultSet resultado) throws SQLException {
	
	int id = resultado.getInt("ID_PERSONA");		
	String documento =	resultado.getString("DOCUMENTO"); 
	String nombre1 = resultado.getString("NOMBRE1"); 
	String nombre2 = resultado.getString("NOMBRE2"); 
	String apellido1 = resultado.getString("APELLIDO1"); 
	String apellido2 = resultado.getString("APELLIDO2");
	LocalDate fec_nac = (resultado.getDate("FECHA_NAC")).toLocalDate();
	String mail = resultado.getString("MAIL");
	String clave = resultado.getString("CLAVE");
	
	Persona p = new Persona(documento, nombre1, nombre2, apellido1, apellido2, fec_nac, clave, mail);
	p.setIdPersona(id);
	
	return p;
	
	}


}

