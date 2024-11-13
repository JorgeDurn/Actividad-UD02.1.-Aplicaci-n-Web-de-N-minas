<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Empleados</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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
        a {
            margin-top: 20px;
            display: inline-block;
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Listar Empleados</h1>
    <table>
        <tr>
            <th>DNI</th>
            <th>Nombre</th>
            <th>Sexo</th>
            <th>Categoría</th>
            <th>Años trabajados</th>
        </tr>
        <c:forEach var="empleado" items="${lista}">
        <tr>
            <td><c:out value="${ empleado.dni}"></c:out></td>
            <td><c:out value="${ empleado.nombre}"></c:out></td>
            <td><c:out value="${ empleado.sexo}"></c:out></td>
            <td><c:out value="${ empleado.categoria}"></c:out></td>
            <td><c:out value="${ empleado.anyosTrabajados}"></c:out></td>
        </tr>
        </c:forEach>
    </table>
    <a href="/empresa/Index.jsp">Volver</a>
</body>
</html>
