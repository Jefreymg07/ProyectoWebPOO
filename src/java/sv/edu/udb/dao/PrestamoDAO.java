package sv.edu.udb.dao;

import sv.edu.udb.conexion.Conexion;
import sv.edu.udb.entities.Prestamo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestamoDAO {

    /**
     * Registra un nuevo préstamo.
     * IMPORTANTE: Neftaly debe validar el stock antes de llamar a este método.
     */
    public boolean insertar(Prestamo prestamo) {
        // La fecha_prestamo se pone automática en MySQL (CURRENT_TIMESTAMP)
        // El estado por defecto es 'Activo' y mora 0.00
        String sql = "INSERT INTO prestamos (usuario_id, material_id, fecha_devolucion_prevista, estado, mora_acumulada) "
                   + "VALUES (?, ?, ?, 'Activo', 0.00)";
        
        Conexion conPool = new Conexion();
        
        try (Connection con = conPool.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, prestamo.getIdUsuario());
            ps.setInt(2, prestamo.getIdMaterial());
            
            // Conversión de fecha Java -> fecha SQL
            java.sql.Date fechaSql = new java.sql.Date(prestamo.getFechaDevolucionPrevista().getTime());
            ps.setDate(3, fechaSql);
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Lista los préstamos activos (para que el profesor vea quién debe libros).
     */
    public List<Prestamo> obtenerPrestamosActivos() {
        List<Prestamo> lista = new ArrayList<>();
        // Hacemos un JOIN simple o traemos los IDs. Por ahora traemos IDs para mantenerlo simple.
        String sql = "SELECT * FROM prestamos WHERE estado = 'Activo'";
        
        Conexion conPool = new Conexion();
        
        try (Connection con = conPool.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Prestamo p = new Prestamo();
                p.setIdPrestamo(rs.getInt("id"));
                p.setIdUsuario(rs.getInt("usuario_id"));
                p.setIdMaterial(rs.getInt("material_id"));
                
                // Recuperar fechas (Timestamp incluye hora, Date solo fecha)
                p.setFechaPrestamo(rs.getTimestamp("fecha_prestamo"));
                p.setFechaDevolucionPrevista(rs.getDate("fecha_devolucion_prevista"));
                p.setEstado(rs.getString("estado"));
                
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    /**
     * Método para devolver un libro (Actualiza estado y fecha real).
     */
    public boolean finalizarPrestamo(int idPrestamo) {
        String sql = "UPDATE prestamos SET estado = 'Devuelto', fecha_devolucion_real = NOW() WHERE id = ?";
        
        Conexion conPool = new Conexion();
        try (Connection con = conPool.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, idPrestamo);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}