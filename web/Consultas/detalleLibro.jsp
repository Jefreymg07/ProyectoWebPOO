<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle del Libro</title>
</head>
<body>

<h2>Información del Libro</h2>

<jsp:useBean id="libro" class="java.lang.Object" scope="request" />


<table border="1" cellpadding="5">
    <tr>
        <td><b>ID:</b></td>
        <td>${libro.id}</td>
    </tr>
    <tr>
        <td><b>Nombre:</b></td>
        <td>${libro.nombre}</td>
    </tr>
    <tr>
        <td><b>Autor:</b></td>
        <td>${libro.autor}</td>
    </tr>
    <tr>
        <td><b>Año:</b></td>
        <td>${libro.anio}</td>
    </tr>
    <tr>
        <td><b>Categoría:</b></td>
        <td>${libro.categoria}</td>
    </tr>
</table>

<br>

<a href="consultarLibros.jsp">Volver a búsqueda</a>

</body>
</html>
