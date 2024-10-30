package com.aprendec.model;

/**
 * Clase DatosNoCorrectosException
 */
public class DatosNoCorrectosException extends Exception {

	/**
	 * número de versión por defecto
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Muestra el mensaje de la excepción
	 * 
	 * @param message String
	 */
	public DatosNoCorrectosException(String message) {
		super(message);
	}

}
