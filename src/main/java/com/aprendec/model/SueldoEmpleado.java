package com.aprendec.model;

public class SueldoEmpleado {

	private String dni,nombre;
	private int sueldo;
	public SueldoEmpleado(String dni, String nombre, int sueldo) {
		this.dni = dni;
		this.sueldo = sueldo;
		this.nombre =  nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getDni() {
		return dni;
	}
	public int getSueldo() {
		return sueldo;
	}

}
