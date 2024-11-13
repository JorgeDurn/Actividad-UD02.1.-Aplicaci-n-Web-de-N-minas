<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        div {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            background-color: #007BFF;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
        .voler-btn {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h2>Editar Información del Empleado</h2>
    <form action="empresa" method="post">
        <input type="hidden" name="opcion" value="Editar">
        <div>
            <label for="dni">DNI del Empleado:</label>
            <input type="text" id="dni" name="dni" value="${empleado.dni}">
        </div>
        <div>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${empleado.nombre}">
        </div>
        <div>
            <label for="sexo">Sexo:</label>
            <select id="sexo" name="sexo" required>
                <option value="">Seleccione</option>
                <option value="H">Hombre</option>
                <option value="M">Mujer</option>
            </select>
        </div>
        <div>
            <label for="categoria">Categoría:</label>
            <input type="number" id="categoria" name="categoria" value="${empleado.categoria}" min="1" max="10" required>
        </div>
        <div>
            <label for="anyosTrabajados">Años Trabajados:</label>
            <input type="number" id="anyosTrabajados" name="anyosTrabajados" value="${empleado.anyosTrabajados}" min="0" required>
        </div>
        <div>
            <button type="submit">Guardar Cambios</button>
            <a class="voler-btn" href="/empresa/Index.jsp"><input type="button" value="Volver"></a>
        </div>
    </form>
</body>
</html>
