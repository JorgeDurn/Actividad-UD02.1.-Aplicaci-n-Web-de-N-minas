package com.aprendec.model;

/**
 * Clase Empleado que extiende de persona
 */
public class Empleado extends Persona {
	/**
	 * Variables de Empleado int categoria
	 */
	private int categoria;
	/**
	 * int anyosTrabajados
	 */
	public int anyosTrabajados;

	/**
	 * Super constructor que recibe los parametros nombre, dni y sexo Asigna valores
	 * por defecto a las variables categoria (1) y anyosTrabajados (0)
	 * 
	 * @param nombre String - super
	 * @param dni    String - super
	 * @param sexo   char - super
	 */
	public Empleado(String nombre, String dni, char sexo) {
		super(nombre, dni, sexo);
		this.categoria = 1;
		this.anyosTrabajados = 0;
	}

	/**
	 * Super constructor con todos los campos, maneja la excepcion en la categoría
	 * (1-10)y en los años trabajados (>0)
	 * 
	 * @param nombre          String - super
	 * @param dni             String - super
	 * @param sexo            char - super
	 * @param categoria       int
	 * @param anyosTrabajados int
	 * @throws DatosNoCorrectosException categoría entre 1 y 10 años número positivo
	 */
	public Empleado(String nombre, String dni, char sexo, int categoria, int anyosTrabajados)
			throws DatosNoCorrectosException {
		super(nombre, dni, sexo);
		if (categoria < 1 || categoria > 10) {
			throw new DatosNoCorrectosException(
					"La categoria que has introducido '" + categoria + "' esta fuera de rango (1-10)");
		}
		if (anyosTrabajados < 0) {
			throw new DatosNoCorrectosException("Los años trabajados no pueden ser negativos");
		}
		this.categoria = categoria;
		this.anyosTrabajados = anyosTrabajados;

	}

	/**
	 * Metodo que recibe un empleado y debuelve su categoria
	 * 
	 * @return the categoria
	 */
	public int getCategoria() {
		return this.categoria;
	}

	/**
	 * Metodo para cambiar la categoría de un Empleado manejando la excepxión en la
	 * categoría para que no pueda ser nemor a 1 o mayor a 10
	 * 
	 * @param categoria the categoria to set
	 * @throws DatosNoCorrectosException categoría entre 1 y 10 años número positivo
	 */
	public void setCategoria(int categoria) throws DatosNoCorrectosException {
		if (categoria < 1 || categoria > 10) {
			throw new DatosNoCorrectosException("Datos incorrectos en la categoría");
		}
		this.categoria = categoria;
	}

	/**
	 * Metodo que incrementa en 1 los años trabajados de un Empleado
	 */
	public void incrAnyo() {
		anyosTrabajados++;
	}

	/**
	 * Devuelve un String formado por nombre, dni, sexo, categoria y años trabajados
	 * 
	 * @return String
	 */
	public String imprime() {
		return nombre + " " + dni + " " + sexo + " " + categoria + " " + anyosTrabajados;
	}

	public String getDni() {
		return this.dni;
	}

	public int getAnyosTrabajados() {
		return anyosTrabajados;
	}
	
	public char getSexo() {
		return super.sexo;
	}

	public void setAnyosTrabajados(int anyosTrabajados) {
		this.anyosTrabajados = anyosTrabajados;
	}
	
	
}
