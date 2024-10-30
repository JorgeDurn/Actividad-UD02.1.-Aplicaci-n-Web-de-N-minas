
package com.aprendec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aprendec.conexion.Conexion;
import com.aprendec.model.DatosNoCorrectosException;
import com.aprendec.model.SueldoEmpleado;

public class SueldoDAO {
	 private Connection connection;
	 private PreparedStatement statement;
	 

	 //Obtener empleado
	 public List<SueldoEmpleado> informacionSueldo() throws SQLException, DatosNoCorrectosException {
		 ResultSet rs = null;
		 List <SueldoEmpleado>empleadoSueldo = new ArrayList<>();
		  
		 String sql = null;
		 connection = obtenerConexion();
		  
		  try {
			  sql = "SELECT * FROM empleados";
			   statement = connection.prepareStatement(sql);
			   rs = statement.executeQuery(sql);
			   
		       while(rs.next()) {
		    	   SueldoEmpleado suel= new SueldoEmpleado(rs.getString(1),rs.getString(2),rs.getInt(6));
		    	   
		    	   empleadoSueldo.add(suel);
		       }
		       
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
		return empleadoSueldo;
			 }
	 
	 public SueldoEmpleado buscarSueldoPorDNI(String dni) throws SQLException, DatosNoCorrectosException {
		    ResultSet rs = null;
		    SueldoEmpleado empleadoSueldo = null;

		    String sql = "SELECT * FROM empleados WHERE dni = ?";
		    connection = obtenerConexion();

		    try {
		        statement = connection.prepareStatement(sql);
		        statement.setString(1, dni);
		        rs = statement.executeQuery();

		        if (rs.next()) {
		            empleadoSueldo = new SueldoEmpleado(rs.getString("dni"),rs.getString("nombre"), rs.getInt("sueldo"));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (rs != null) rs.close();
		        if (statement != null) statement.close();
		        if (connection != null) connection.close();
		    }

		    return empleadoSueldo;
		}

	 
	 // obtener conexion pool
	 private Connection obtenerConexion() throws SQLException {
	  return Conexion.getConnection();
	 }
}
