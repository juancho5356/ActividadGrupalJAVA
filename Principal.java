package Modelo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		
		Persona p1 = new Persona();
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
		
		r1.setFunciones(funciones);
	}

}
