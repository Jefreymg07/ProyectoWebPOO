<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Resultados de la búsqueda</title>
</head>
<body>

<h2>Resultados encontrados</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Autor</th>
        <th>Año</th>
        <th>Acción</th>
    </tr>

    <jsp:useBean id="lista" class="java.util.ArrayList" scope="request" />

    <c:forEach var="libro" items="${lista}">
        <tr>
            <td>${libro.id}</td>
            <td>${libro.nombre}</td>
            <td>${libro.autor}</td>
            <td>${libro.anio}</td>
            <td>
                <a href="detalleLibro.jsp?id=${libro.id}">Ver detalles</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
