package Modelo;

import java.util.LinkedList;

public class Funcionalidad {

	private String nombreFuncion;
	private String descripcionFuncion;
	private LinkedList <Rol> roles = new LinkedList<>();

	public Funcionalidad(String nombreFuncion, String descripcionFuncion, LinkedList<Rol> roles) {
		super();
		this.nombreFuncion = nombreFuncion;
		this.descripcionFuncion = descripcionFuncion;
	}

	public String getNombreFuncion() {
		return nombreFuncion;
	}

	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}

	public String getDescripcionFuncion() {
		return descripcionFuncion;
	}

	public void setDescripciónFuncion(String descripcionFuncion) {
		this.descripcionFuncion = descripcionFuncion;
	}

	
	public LinkedList<Rol> getRoles() {
		return roles;
	}

	
	public void setRoles(LinkedList<Rol> roles) {
		this.roles = roles;
	}
	
	public boolean acceso (Persona p){
		//falta completar metodo
		boolean a = false;
		
		return a;
	}
}
