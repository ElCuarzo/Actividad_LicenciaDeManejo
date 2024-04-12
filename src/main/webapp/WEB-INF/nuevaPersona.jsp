<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear nuevo usuario</title>
</head>
<body>
	<a href="/">Ir al INDEX</a>
	<h1>Nueva Persona</h1>
	<form action="/crear/persona" method="POST">
        <label for="nombre">Nombre: </label>
        <input type="text" id="nombre" name="nombre" required>
        <br>
        <label for="apellido">Apellido: </label>
        <input type="text" id="apellido" name="apellido" required>
        <br>
        <input type="submit" value="Crear">
    </form>
</body>
</html>