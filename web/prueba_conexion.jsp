<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="sv.edu.udb.entities.Prestamo"%>
<%@page import="sv.edu.udb.dao.PrestamoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Test PrestamoDAO</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="container mt-5">
        <div class="card shadow">
            <div class="card-header bg-warning text-dark">
                <h3>📖 Prueba de Transacción: Préstamos</h3>
            </div>
            <div class="card-body">
                
                <h4>1. Intentando registrar un préstamo...</h4>
                <%
                    PrestamoDAO dao = new PrestamoDAO();
                    
                    // --- PREPARAR DATOS ---
                    // Asumimos que existe el Usuario con ID 1 (admin)
                    // Asumimos que existe el Material con ID 1 (El primer libro que insertaste)
                    int idUsuario = 1; 
                    int idMaterial = 1;
                    
                    // Calcular fecha de devolución (Hoy + 7 días)
                    Calendar cal = Calendar.getInstance();
                    Date fechaHoy = cal.getTime();
                    cal.add(Calendar.DAY_OF_YEAR, 7); // Sumamos 7 días
                    Date fechaDevolucion = cal.getTime();
                    
                    // Crear el objeto Prestamo
                    Prestamo nuevoP = new Prestamo(idUsuario, idMaterial, fechaHoy, fechaDevolucion);
                    
                    // --- INSERTAR ---
                    // Solo insertamos si no es una recarga (para no llenar de basura la BD)
                    // Pero para esta prueba, lo haremos directo.
                    boolean registrado = dao.insertar(nuevoP);
                    
                    if(registrado) {
                        out.println("<div class='alert alert-success'>✅ Préstamo registrado correctamente en la BD.</div>");
                    } else {
                        out.println("<div class='alert alert-danger'>❌ Error al registrar. Revisa IDs o consola.</div>");
                    }
                %>
                
                <hr>
                
                <h4>2. Consultando préstamos activos...</h4>
                <table class="table table-bordered">
                    <thead class="table-dark">
                        <tr>
                            <th>ID Préstamo</th>
                            <th>ID Usuario</th>
                            <th>ID Material</th>
                            <th>Fecha Préstamo</th>
                            <th>Devolución Prevista</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Prestamo> lista = dao.obtenerPrestamosActivos();
                            
                            if(lista.isEmpty()) {
                                out.println("<tr><td colspan='6' class='text-center'>No hay préstamos activos.</td></tr>");
                            } else {
                                for(Prestamo p : lista) {
                        %>
                            <tr>
                                <td><%= p.getIdPrestamo() %></td>
                                <td><%= p.getIdUsuario() %></td>
                                <td><%= p.getIdMaterial() %></td>
                                <td><%= p.getFechaPrestamo() %></td>
                                <td style="color:red; font-weight:bold"><%= p.getFechaDevolucionPrevista() %></td>
                                <td><span class="badge bg-primary"><%= p.getEstado() %></span></td>
                            </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
                
            </div>
        </div>
    </body>
</html>