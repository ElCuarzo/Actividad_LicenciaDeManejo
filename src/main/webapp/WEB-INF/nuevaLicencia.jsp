<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear nueva licencia</title>
</head>
<body>
	<h1>Nueva Licencia</h1>
	<form action="/crear/licencia" method="POST">
        <label for="nombre">Nombre: </label>
        <select name="nombre" id="nombre">
        	<c:forEach items="${nombres}" var="persona">
        		<option value="${persona.id}">${persona.nombre}</option>
        	</c:forEach>
        </select>
        <br>
        <label for="fechaExpiracion">FechaExpiracion </label>
        <input type="date" id="fechaExpiracion" name="fechaExpiracion" required>
        <br>
        <select name="estado" id="estado">
        	<option value="Chile">CH</option>
        	<option value="Argentina">ARG</option>
        	<option value="EstadosUnidos">USA</option>
        	<option value="Peru">PE</option>
        </select>
        <input type="submit" value="Crear">
    </form>
</body>
</html>