package sv.edu.udb.dao;

import sv.edu.udb.conexion.Conexion;
import sv.edu.udb.entities.Libro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDAO {

    public List<Libro> obtenerTodos() {
        List<Libro> lista = new ArrayList<>();
        // OJO: Asegúrate que 'Libro' empiece con mayúscula si así está en tu BD
        String sql = "SELECT * FROM materiales WHERE tipo = 'Libro'"; 
        
        Conexion conPool = new Conexion();
        
        try (Connection con = conPool.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Libro libro = new Libro();
                libro.setCodigo(rs.getString("codigo"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                
                // CORRECCIÓN 1: 'anio_publicacion' (según tu imagen)
                libro.setAnio(rs.getInt("anio_publicacion")); 
                
                libro.setCantidadTotal(rs.getInt("cantidad_total"));
                
                // CORRECCIÓN 2: 'cantidad_disponible' (EN SINGULAR, sin la 's')
                libro.setCantidadDisponibles(rs.getInt("cantidad_disponible"));
                
                libro.setEditorial(rs.getString("editorial"));
                libro.setIsbn(rs.getString("isbn"));
                
                lista.add(libro);
            }
        } catch (SQLException ex) {
            // Esto imprimirá el error real en la consola de NetBeans si vuelve a fallar
            ex.printStackTrace(); 
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    // Método insertar (Actualizado también por si acaso)
    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO materiales (codigo, tipo, titulo, autor, anio_publicacion, "
                   + "cantidad_total, cantidad_disponible, editorial, isbn) "
                   + "VALUES (?, 'Libro', ?, ?, ?, ?, ?, ?, ?)";
        
        Conexion conPool = new Conexion();
        
        try (Connection con = conPool.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, libro.getCodigo());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setInt(5, libro.getCantidadTotal());
            ps.setInt(6, libro.getCantidadDisponibles());
            ps.setString(7, libro.getEditorial());
            ps.setString(8, libro.getIsbn());
            
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}