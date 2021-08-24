package conexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


import modelo.Rol;

public class DAORol {
	
	private static String ALL_ROLES = "SELECT * FROM ROLES ORDER BY 1"; 

	private static final String CUENTA_ROLES = "SELECT COUNT(ID_ROL) AS CUENTA FROM ROLES";
	
	private static final String INSERT_ROL = "INSERT INTO ROLES (ID_ROL, NOMBRE, DESCRIPCION) values (SEQ_ID_ROL.nextval, ?, ?)";
	
	private static final String BUSCAR_ROL = "SELECT * FROM ROLES WHERE NOMBRE=?";
	
	private static final String BUSCAR_ROL_ID = "SELECT * FROM ROLES WHERE ID_ROL=?";
	
	private static final String UPDATE_ROL = "UPDATE ROLES SET NOMBRE=?, DESCRIPCION=? WHERE ID_ROL=?";
	
	private static final String DELETE_ROL = "DELETE FROM ROLES WHERE ID_ROL=?"; 
	
	
	public static boolean insert(Rol r) {
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(INSERT_ROL);
			
			statement.setString(1, r.getNombreRol());
			statement.setString(2, r.getDescripcionRol());

			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean edit(Rol r) {
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(UPDATE_ROL);
			
			statement.setString(1, r.getNombreRol());
			statement.setString(2, r.getDescripcionRol());
			statement.setLong(3, r.getIdRol());
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	public static boolean delete(int idRol) {
		PreparedStatement statement;
		try {
			statement = ConexionBD.getConnection().prepareStatement(DELETE_ROL);
			
			statement.setLong(1, idRol);
			
			int Retorno = statement.executeUpdate();
			
			return Retorno > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static LinkedList<Rol> findAll(){
		LinkedList<Rol> roles = new LinkedList<>();
		
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(ALL_ROLES);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Rol rol = getRolFromResultSet(resultado);
				roles.add(rol);
			}
			return roles;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Rol findRol(String nombre) {
		
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_ROL);
			
			statement.setString(1, nombre);
			
			ResultSet resultado = statement.executeQuery();
			
			Rol rol = null;
			
			while(resultado.next()) {
				rol = getRolFromResultSet(resultado);
			}
			return rol;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static Rol findRolID(int id ) {
		
		try {
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(BUSCAR_ROL_ID);
			
			statement.setLong(1, id);
			
			ResultSet resultado = statement.executeQuery();
			
			Rol rol = null;
			
			while(resultado.next()) {
				rol = getRolFromResultSet(resultado);
			}
			return rol;
			
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static int cuentaRoles() {
		
		int cuenta = 0;
		
		try {
			
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(CUENTA_ROLES);
			
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
	
	
private static Rol getRolFromResultSet(ResultSet resultado) throws SQLException {
	
	int id = resultado.getInt("ID_ROL");		
	String n = resultado.getString("NOMBRE");
	String d = resultado.getString("DESCRIPCION");
	
	Rol r = new Rol();
	r.setIdRol(id);
	r.setNombreRol(n);
	r.setDescripcionRol(d);
	
	
	return r;
	
	}
}

