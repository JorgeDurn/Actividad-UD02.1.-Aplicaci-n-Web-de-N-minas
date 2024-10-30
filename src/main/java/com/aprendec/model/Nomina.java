package com.aprendec.model;

/**
 * Clase Nomina
 */
public class Nomina {
	/**
	 * Array donde se guarda los sueldos correspondientes a la categoría
	 */
	private static final int[] SUELDO_BASE = { 50000, 70000, 90000, 110000, 130000, 150000, 170000, 190000, 210000,
			230000 };

	/**
	 * Recibe un Empleado para asignarle el sueldo en funcion de su categoría
	 * 
	 * @param em Empleado
	 * @return int sueldo
	 */
	public int sueldo(Empleado em) {
		return SUELDO_BASE[em.getCategoria()-1] +5000 * em.anyosTrabajados;
	}

}
