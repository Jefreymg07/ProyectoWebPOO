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
        <h1 class="mb-4">Prueba Unitaria: UsuarioDAO</h1>
        
        <div class="card">
            <div class="card-header">Intentando loguear con: <b>admin</b> / <b>12345</b></div>
            <div class="card-body">
                <%
                    // 1. Instanciamos tu DAO (Tu código)
                    UsuarioDAO dao = new UsuarioDAO();
                    
                    // 2. Ejecutamos el método con los datos REALES que vimos en la imagen
                    Usuario u = dao.validarUsuario("admin", "12345");
                    
                    if(u != null) {
                %>
                    <div class="alert alert-success">
                        <h3>✅ ¡LOGIN EXITOSO!</h3>
                        <p>El DAO fue a la base de datos, encontró al usuario y trajo estos datos:</p>
                        <ul>
                            <li><b>ID:</b> <%= u.getId() %></li>
                            <li><b>Usuario:</b> <%= u.getUsuario() %></li>
                            <li><b>Rol:</b> <%= u.getRol() %></li>
                        </ul>
                        <hr>
                        <p><i>Jefrey: Ya puedes entregarle UsuarioDAO.java a Neftaly.</i></p>
                    </div>
                <%
                    } else {
                %>
                    <div class="alert alert-danger">
                        <h3>❌ LOGIN FALLIDO</h3>
                        <p>El DAO devolvió null. Revisa la consulta SQL en UsuarioDAO.java.</p>
                    </div>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>