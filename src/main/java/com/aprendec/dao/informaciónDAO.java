package com.aprendec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aprendec.conexion.Conexion;
import com.aprendec.model.DatosNoCorrectosException;
import com.aprendec.model.Empleado;

public class informaciónDAO {
	 private Connection connection;
	 private PreparedStatement statement;
	 
	 //Obtener empleado
	 public List<Empleado> informacion() throws SQLException, DatosNoCorrectosException {
		 ResultSet rs = null;
		 List<Empleado> listEmpleado = new ArrayList<>();
		  
		  String sql = null;
		  connection = obtenerConexion();
		  
		  
		  try {
			  sql = "SELECT * FROM empleados";
			   statement = connection.prepareStatement(sql);
			   rs = statement.executeQuery(sql);
			   
		       while(rs.next()) {
		           Empleado e =new Empleado(rs.getString(1),rs.getString(2),rs.getString(3).charAt(0),rs.getInt(4),rs.getInt(5));
		           listEmpleado.add(e);
		       }			   
			 
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
		return listEmpleado;
			 
			 }
	 
	 // obtener conexion pool
	 private Connection obtenerConexion() throws SQLException {
	  return Conexion.getConnection();
	 }
}
