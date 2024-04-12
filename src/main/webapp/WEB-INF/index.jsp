<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Mostrar Persona</title>
</head>
<body>
    <a href="/persona/nueva">Crear nueva persona</a>
    <c:forEach items="${persona}" var="persona">
        <h1><c:out value="${persona.nombre}"></c:out></h1>
        <p>El número de licencia es: <c:out value="${persona.licencia.numero}"></c:out></p>
        <p>Estado: <c:out value="${persona.licencia.estado}"></c:out></p>
        <p>Fecha de expiración: <c:out value="${persona.licencia.fechaExpiracion}"></c:out></p>
    </c:forEach>
</body>
</html>

