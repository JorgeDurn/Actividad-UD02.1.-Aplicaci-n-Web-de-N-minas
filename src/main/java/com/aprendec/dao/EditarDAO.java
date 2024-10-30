package com.aprendec.dao;

// Importaciones necesarias para la gestión de la base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aprendec.conexion.Conexion;
import com.aprendec.model.Empleado;

/**
 * Clase DAO para realizar operaciones de edición en la tabla de empleados
 */
public class EditarDAO {
	
	private Connection connection; // Conexión a la base de datos
	private PreparedStatement statement; // Preparación de la consulta SQL
	private boolean estadoOperacion; // Estado de la operación (éxito o fracaso)
	
	/**
	 * Método para editar los datos de un empleado utilizando su DNI
	 * @param dni DNI del empleado a editar
	 * @return true si la operación fue exitosa, false en caso contrario
	 * @throws SQLException en caso de error de base de datos
	 */
	public boolean editar(String dni) throws SQLException {
		String sql = null;
		connection = obtenerConexion(); // Obtiene la conexión a la base de datos
		List<Empleado> lista = new ArrayList<>(); // Lista para almacenar empleados
		try {
			connection.setAutoCommit(false); // Desactiva el autocommit
			sql = "UPDATE empleados SET dni=?, nombre=?, sexo=?, categoria=?, anyosTrabajados=? WHERE id=" + dni; // Consulta SQL para actualizar
			statement = connection.prepareStatement(sql);
		 
			// Itera sobre la lista de empleados (aunque está vacía aquí, debería llenarse antes)
			for (Empleado emp : lista) {
				if (emp.getDni().equals(dni)) {
					// Asigna los valores a la consulta
					statement.setString(1, emp.getDni());
					statement.setString(2, emp.getNombre());
					statement.setAsciiStream(emp.getSexo(), null, 0);
					statement.setInt(3, emp.getCategoria());
					statement.setInt(4, emp.getAnyosTrabajados());
				}
			}
		 
			estadoOperacion = statement.executeUpdate() > 0; // Ejecuta la actualización y verifica si fue exitosa
			connection.commit(); // Confirma los cambios
			statement.close();
			connection.close();
		 
		} catch (SQLException e) {
			connection.rollback(); // Revierte cambios en caso de error
			e.printStackTrace();
		}
		 
		return estadoOperacion; // Devuelve el estado de la operación
	}
	 
	/**
	 * Método para editar los datos de un empleado
	 * @param empleado Objeto Empleado con los nuevos datos
	 * @return true si la operación fue exitosa, false en caso contrario
	 * @throws SQLException en caso de error de base de datos
	 */
	public boolean editarA(Empleado empleado) throws SQLException {
	    String sql = "UPDATE empleados SET nombre=?, sexo=?, categoria=?, anyosTrabajados=? WHERE dni=?"; // Consulta SQL para actualizar
	    connection = obtenerConexion(); // Obtiene la conexión a la base de datos
	    estadoOperacion = false; // Inicializa el estado de la operación
	    try {
	        connection.setAutoCommit(false); // Desactiva el autocommit
	        statement = connection.prepareStatement(sql); // Prepara la consulta
	        
	        // Asigna los valores del objeto empleado a la consulta
	        statement.setString(1, empleado.getNombre());
	        statement.setString(2, String.valueOf(empleado.getSexo()));  // Asumiendo que sexo es `char`
	        statement.setInt(3, empleado.getCategoria());
	        statement.setInt(4, empleado.getAnyosTrabajados());
	        statement.setString(5, empleado.getDni());
	        
	        estadoOperacion = statement.executeUpdate() > 0; // Ejecuta la actualización y verifica si fue exitosa
	        connection.commit(); // Confirma los cambios
	    } catch (SQLException e) {
	        connection.rollback(); // Revierte cambios en caso de error
	        e.printStackTrace();
	    } finally {
	        // Cierra la declaración y la conexión
	        if (statement != null) statement.close();
	        if (connection != null) connection.close();
	    }
	    
	    return estadoOperacion; // Devuelve el estado de la operación
	}

	// Método privado para obtener una conexión a la base de datos
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection(); // Obtiene la conexión desde el pool de conexiones
	}
}
