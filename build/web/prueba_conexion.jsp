<%@page import="sv.edu.udb.entities.Usuario"%>
<%@page import="sv.edu.udb.dao.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Test DAO Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-primary text-white">
                <h3>🛠️ Prueba Unitaria: UsuarioDAO</h3>
            </div>
            <div class="card-body">
                <p>Intentando conectar con las credenciales que encontramos en tu BD:</p>
                <ul>
                    <li>Usuario: <b>admin</b></li>
                    <li>Contraseña: <b>12345</b></li>
                </ul>
                <hr>
                <%
                    // 1. Instanciamos el DAO
                    UsuarioDAO dao = new UsuarioDAO();
                    
                    // 2. Probamos con la contraseña CORRECTA ("12345")
                    Usuario u = dao.validarUsuario("admin", "12345");
                    
                    if(u != null) {
                %>
                    <div class="alert alert-success border-success">
                        <h4 class="alert-heading">✅ ¡LOGIN EXITOSO!</h4>
                        <p>El sistema reconoció al usuario correctamente.</p>
                        <hr>
                        <strong>Datos recuperados de la BD:</strong>
                        <ul>
                            <li>ID: <%= u.getId() %></li>
                            <li>Rol: <%= u.getRol() %></li>
                            <li>Estado: <%= u.getEstado() %></li>
                        </ul>
                    </div>
                <%
                    } else {
                %>
                    <div class="alert alert-danger border-danger">
                        <h4 class="alert-heading">❌ LOGIN FALLIDO</h4>
                        <p>El DAO devolvió null. Posibles causas:</p>
                        <ul>
                            <li>La contraseña no es "12345" (revisa espacios en blanco).</li>
                            <li>El usuario no tiene estado 'Activo'.</li>
                            <li>La consulta SQL en UsuarioDAO tiene algún error de nombres de columna.</li>
                        </ul>
                    </div>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>