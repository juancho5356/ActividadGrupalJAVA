package Controlador;

import java.sql.*;
import java.util.LinkedList;

import Modelo.Funcionalidad;

public class DAOFuncionalidad {

	private static String ALL_FUNCIONES = "SELECT * FROM FUNCIONALIDADES ORDER BY 1"; 

	private static final String CUENTA_FUNCIONES = "SELECT COUNT(ID_FUNCIONALIDAD) AS CUENTA FROM FUNCIONALIDADES";
	
	private static final String INSERT_FUNCIONALIDAD = "INSERT INTO FUNCIONALIDADES (ID_FUNCIONALIDAD, NOMBRE, DESCRIPCION) values (SEQ_ID_FUNCIONALIDAD.nextval, ?, ?)";
	
	private static final String BUSCAR_FUNCIONALIDAD = "SELECT * FROM FUNCIONALIDADES WHERE NOMBRE=?";
	
	private static final String UPDATE_FUNCIONALIDAD = "UPDATE FUNCIONALIDADES SET NOMBRE=?, DESCRIPCION=? WHERE ID_FUNCIONALIDAD=?";
	
	private static final String DELETE_FUNCIONALIDAD = "DELETE FROM FUNCIONALIDADES WHERE ID_FUNCIONALIDAD=?"; 
	
	
	public static boolean insert(Funcionalidad f) {
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(INSERT_FUNCIONALIDAD);
			
			statement.setString(1, f.getNombreFuncion());
			statement.setString(2, f.getDescripcionFuncion());

			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean edit(Funcionalidad f) {
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(UPDATE_FUNCIONALIDAD);
			
			statement.setString(1, f.getNombreFuncion());
			statement.setString(2, f.getDescripcionFuncion());
			statement.setLong(3, f.getIdFuncionalidad());
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public static boolean delete(int idF) {
		PreparedStatement statement;
		try {
			statement = ConexionBD.getConnection().prepareStatement(DELETE_FUNCIONALIDAD);
			
			statement.setLong(1, idF);
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static LinkedList<Funcionalidad> findAll(){
		LinkedList<Funcionalidad> personas = new LinkedList<>();
		
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(ALL_FUNCIONES);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Funcionalidad persona = getFuncionalidadFromResultSet(resultado);
				personas.add(persona);
			}
			return personas;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static LinkedList<Funcionalidad> findFuncionalidad(String nombre) {
		LinkedList<Funcionalidad> personas = new LinkedList<>();
		
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_FUNCIONALIDAD);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			while(resultado.next()) {
				Funcionalidad p = getFuncionalidadFromResultSet(resultado);
				personas.add(p);
			}
			return personas;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static int cuentaFuncionalidades() {
		
		int cuenta = 0;
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(CUENTA_FUNCIONES);
			
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
	
	
	

	
private static Funcionalidad getFuncionalidadFromResultSet(ResultSet resultado) throws SQLException {
	
	int id = resultado.getInt("ID_FUNCIONALIDAD");		
	String n = resultado.getString("NOMBRE");
	String d = resultado.getString("DESCRIPCION");
	
	Funcionalidad f = new Funcionalidad();
	f.setIdFuncionalidad(id);
	f.setNombreFuncion(n);
	f.setDescripcionFuncion(d);
	
	return f;
	
	}
}
