<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Menú de Opciones</title>
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
        }
        td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
            background-color: #fff;
        }
        a {
            text-decoration: none;
            color: #007BFF;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Menu de Opciones</h1>
    <table>
        <tr>
            <td><a href="empresa?opcion=sueldo"> Listar Salarios</a></td>
        </tr>
        <tr>
            <td><a href="empresa?opcion=listar"> Listar Empleados</a></td>
        </tr>
        <tr>
            <td><a href="empresa?opcion=Editar"> Editar Empleados</a></td>
        </tr>
    </table>
</body>
</html>
