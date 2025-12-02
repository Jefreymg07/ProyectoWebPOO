<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Consultar Libros</title>
</head>
<body>
<h2>Buscar Libros</h2>

<form action="../ConsultarLibroServlet" method="post">
    <label>Nombre del libro:</label>
    <input type="text" name="nombre" required>
    <br><br>

    <button type="submit">Buscar</button>
</form>

</body>
</html>
