package com.aprendec.controller;

// Importaciones necesarias para el funcionamiento del servlet
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Importaciones de clases del modelo y DAO
import com.aprendec.dao.EditarDAO;
import com.aprendec.dao.SueldoDAO;
import com.aprendec.dao.informaciónDAO;
import com.aprendec.model.DatosNoCorrectosException;
import com.aprendec.model.Empleado;
import com.aprendec.model.SueldoEmpleado;

/**
 * Servlet que administra las peticiones relacionadas con la nómina
 */
@WebServlet(description = "administra peticiones para la tabla productos", urlPatterns = { "/empresa" })
public class CalculaNomina extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Constructor del servlet
    public CalculaNomina() {
        super();
    }

    /**
     * Maneja las peticiones GET
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recupera la opción solicitada desde la petición
        String opcion = request.getParameter("opcion");

        // Opción para listar empleados
        if (opcion.equals("listar")) {
            informaciónDAO informacionDAO = new informaciónDAO();
            List<Empleado> lista = new ArrayList<>();
            try {
                lista = informacionDAO.informacion();
                for (Empleado empleado : lista) {
                    System.out.println(empleado);
                }

                // Añade la lista de empleados a la petición
                request.setAttribute("lista", lista);
                // Redirige a la vista de listado de empleados
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DatosNoCorrectosException e) {
                e.printStackTrace();
            }

            System.out.println("Usted ha presionado la opción listar");
        } 
        // Opción para listar sueldos
        else if (opcion.equals("sueldo")) {
            SueldoDAO sueldoDAO = new SueldoDAO();
            List<SueldoEmpleado> sueldo = new ArrayList<SueldoEmpleado>();
            try {
                sueldo = sueldoDAO.informacionSueldo();

                // Añade la lista de sueldos a la petición
                request.setAttribute("lista", sueldo);
                // Redirige a la vista de sueldos
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/sueldo.jsp");
                requestDispatcher.forward(request, response);

            } catch (IOException | SQLException | DatosNoCorrectosException e) {
                e.printStackTrace();
            }

        } 
        // Opción para editar un empleado
        else if (opcion.equals("Editar")) {
            String dni = request.getParameter("dni");
            System.out.println("Editar empleado: " + dni);
            EditarDAO empleadoDAO = new EditarDAO();
            try {
                empleadoDAO.editar(dni);
                // Añade el DNI del empleado a la petición para la vista
                request.setAttribute("empleado", dni);
                // Redirige a la vista de edición
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/Editar.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Maneja las peticiones POST
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recupera la opción solicitada desde la petición
        String opcion = request.getParameter("opcion");

        // Opción para buscar sueldo
        if (opcion.equals("buscarSueldo")) {
            String dni = request.getParameter("dni");

            if (dni != null && !dni.isEmpty()) {
                SueldoDAO sueldoDAO = new SueldoDAO();
                SueldoEmpleado sueldoEmpleado = null;

                try {
                    // Busca el sueldo del empleado por DNI
                    sueldoEmpleado = sueldoDAO.buscarSueldoPorDNI(dni);

                    if (sueldoEmpleado != null) {
                        // Añade el sueldo del empleado a la petición
                        request.setAttribute("sueldoEmpleado", sueldoEmpleado);
                    }

                    // Redirige a la vista de sueldo
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/sueldo.jsp");
                    requestDispatcher.forward(request, response);

                } catch (SQLException | DatosNoCorrectosException e) {
                    e.printStackTrace();
                }
            }
        } 
        // Opción para editar empleado
        else if (opcion.equals("Editar")) {
            // Crear el objeto Empleado con los datos del formulario
            Empleado emp = null;
            String dni = request.getParameter("dni");
            String nombre = request.getParameter("nombre");
            char sexo = request.getParameter("sexo").charAt(0);
            int categoria = Integer.parseInt(request.getParameter("categoria"));
            int anyosTrabajados = Integer.parseInt(request.getParameter("anyosTrabajados"));

            try {
                emp = new Empleado(nombre, dni, sexo, categoria, anyosTrabajados);
            } catch (DatosNoCorrectosException e) {
                e.printStackTrace();
            }

            EditarDAO empleadoDAO = new EditarDAO();
            try {
                // Intenta editar el empleado
                boolean editado = empleadoDAO.editarA(emp);
                if (editado) {
                    System.out.println("Registro editado satisfactoriamente...");
                    // Redirige a la lista actualizada
                    response.sendRedirect("nomina?opcion=listar");
                } else {
                    System.out.println("Error al editar el registro...");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
