package modelo;

import java.util.LinkedList;

public class Rol {
	private int idRol;
	private String nombreRol;
	private String descripcionRol;
	
	private LinkedList <Persona> personas = new LinkedList<>();
	private LinkedList <Funcionalidad> funciones = new LinkedList<>();
	

	public Rol() {
	}
	
	public Rol(String nombreRol, String descripcionRol, LinkedList<Persona> personas, LinkedList<Funcionalidad> funciones) {
		this.nombreRol = nombreRol;
		this.descripcionRol = descripcionRol;
		this.personas = personas;
		this.funciones = funciones;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	
	public LinkedList<Funcionalidad> getFunciones() {
		return funciones;
	}

	public void setFunciones(LinkedList<Funcionalidad> funciones) {
		this.funciones = funciones;
	}

	public LinkedList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(LinkedList<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + ", descripcionRol=" + descripcionRol + ", personas="
				+ personas + ", funciones=" + funciones + "]";
	}

	

}
