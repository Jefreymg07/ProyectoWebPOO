<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultado del Préstamo</title>
</head>
<body>

<h2>Resultado del Préstamo</h2>

<!-- Mensaje enviado por el Servlet -->
<p><b>${mensaje}</b></p>

<h3>Datos del Libro Prestado</h3>
<table border="1" cellpadding="5">
    <tr>
        <td><b>ID del Libro:</b></td>
        <td>${idLibro}</td>
    </tr>
</table>

<h3>Datos del Usuario</h3>
<table border="1" cellpadding="5">
    <tr>
        <td><b>Usuario:</b></td>
        <td>${usuario}</td>
    </tr>
</table>

<h3>Fecha del Préstamo</h3>
<table border="1" cellpadding="5">
    <tr>
        <td><b>Fecha:</b></td>
        <td>${fecha}</td>
    </tr>
</table>

<br>
<a href="prestarLibro.jsp">Realizar otro préstamo</a> |
<a href="consultarLibros.jsp">Volver a consulta</a>

</body>
</html>
