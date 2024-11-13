<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Sueldos</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ccc;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
    </style>
</head>
<body>
    <h1>Listar Sueldo de Empleados</h1>
    <form action="empresa" method="post">
        <input type="hidden" name="opcion" value="buscarSueldo">
        <label for="dni">DNI del Empleado:</label>
        <input type="text" name="dni" id="dni">
        <input type="submit" value="Buscar Sueldo">
    </form>

    <!-- Tabla de resultados -->
    <table>
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Sueldo</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty sueldoEmpleado}">
                <tr>
                    <td><c:out value="${sueldoEmpleado.nombre}"/></td>
                    <td><c:out value="${sueldoEmpleado.sueldo}"/></td>
                </tr>
            </c:if>
            <c:if test="${empty sueldoEmpleado}">
                <tr>
                    <td colspan="2">No se encontró el sueldo para el DNI ingresado.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

    <a href="/empresa/Index.jsp">
        <input type="button" value="Volver">
    </a>
</body>
</html>
