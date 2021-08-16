package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import Controlador.ConexionBD;
import Controlador.DAOPersona;

public class Principal {

	public static void main(String[] args) {
		
		Connection connection = ConexionBD.getConnection();
		
		int contador = DAOPersona.cuentaPersonas();
		
		if(contador > 0) {
			System.out.println("En la tabla PERSONAS hay " + contador + " registros");
		
		}else {
			System.out.println("La tabla PERSONAS  no contiene registros");
			
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////
		
		/*String consulta = "SELECT * FROM PERSONAS";
		
		try {
			
			Statement sentencia = connection.createStatement();
			ResultSet personasRS = sentencia.executeQuery(consulta);
			
			while(personasRS.next()) {
				System.out.println("Documento:");
				System.out.println(personasRS.getString("DOCUMENTO"));
				System.out.println("Primer apellido:");
				System.out.println(personasRS.getString("APELLIDO1"));
				System.out.println("Segundo apellido:");
				System.out.println(personasRS.getString("APELLIDO2"));
				System.out.println("Primer nombre:");
				System.out.println(personasRS.getString("NOMBRE1"));
				System.out.println("Segundo apellido:");
				System.out.println(personasRS.getString("NOMBRE2"));
				System.out.println("*****************************");
			}
		}catch (SQLException e) {
			
			System.out.println("Error al ejecutar la consulta " + consulta);
			e.printStackTrace();
			return;
		}*/
		
///////////////////////////////////////////////////////////////////////////////////////////////
		
		/*Persona p1 = new Persona();
		p1.setDocumento("59638521");
		p1.setApellido1("Arrillaga");
		p1.setApellido2("Etchenique");
		p1.setNombre1("Raul");
		p1.setNombre2("Abraham");
		p1.setFechaNac(LocalDate.of(1944, 9, 16));
		p1.setEmail("admin@correo.com");
		p1.setClave("admin");
		
		LinkedList<Persona> administradores = new LinkedList<Persona>();
		administradores.add(p1);
///////////////////////////////////////////////////////////////////////////////////////////////		
		
		Rol r1 = new Rol();
		r1.setNombreRol("Administrador");
		r1.setDescripciónRol("Administrador de la plataforma");
		r1.setPersonas(administradores);
		
		p1.setRol(r1);
		
		LinkedList<Rol> roles = new LinkedList<Rol>();
		roles.add(r1);
///////////////////////////////////////////////////////////////////////////////////////////////	
		
		Funcionalidad f1 = new Funcionalidad();
		f1.setNombreFuncion("Control de inventario");
		f1.setDescripciónFuncion("Controlar el inventario actual");
		f1.setRoles(roles);
		
		LinkedList<Funcionalidad> funciones = new LinkedList<Funcionalidad>();
		funciones.add(f1);
		
		r1.setFunciones(funciones);*/

}
}
