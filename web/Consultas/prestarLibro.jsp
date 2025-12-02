<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Prestar Libro</title>
</head>
<body>

<h2>Formulario de Préstamo</h2>

<form action="../PrestarLibroServlet" method="post">

    <label>ID del libro:</label>
    <input type="text" name="idLibro" required>
    <br><br>

    <label>Carné o usuario:</label>
    <input type="text" name="usuario" required>
    <br><br>

    <label>Fecha de préstamo:</label>
    <input type="date" name="fecha" required>
    <br><br>

    <button type="submit">Procesar Préstamo</button>

</form>

</body>
</html>
