package com.aprendec.model;

/**
 * Clase Persona
 */
public class Persona {
	/**
	 * Variables de Persona String nombre
	 */
	public String nombre;
	/**
	 * 
	 * String dni
	 */
	public String dni;
	/**
	 * 
	 * char sexo
	 */
	public char sexo;

	/**
	 * Devuelve el String nombre
	 * 
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Constructor
	 * 
	 * @param nombre String
	 * @param dni    String
	 * @param sexo   char
	 */
	public Persona(String nombre, String dni, char sexo) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
	}

	/**
	 * Constructor
	 * 
	 * @param nombre String
	 * @param sexo   char
	 */
	public Persona(String nombre, char sexo) {
		this.nombre = nombre;
		this.sexo = sexo;
	}

	/**
	 * Metodo que asigna el dni
	 * 
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setSexo(char sexo) {
		this.sexo=sexo;
	}

	/**
	 * metodo que devuelve un String con los campos nombre y dni
	 * 
	 * @return String
	 */
	public String imprime() {
		return this.nombre + " " + this.dni;
	}

}
