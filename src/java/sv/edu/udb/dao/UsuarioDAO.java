package sv.edu.udb.dao;

import sv.edu.udb.conexion.Conexion;
import sv.edu.udb.entities.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    /**
     * Método para validar si un usuario existe (LOGIN)
     * @param user Nombre de usuario
     * @param pass Contraseña (en texto plano por ahora)
     * @return Objeto Usuario si los datos son correctos, null si no.
     */
    public Usuario validarUsuario(String user, String pass) {
        Usuario usuarioEncontrado = null;
        // La consulta verifica usuario, contraseña y que esté Activo
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ? AND estado = 'Activo'";
        
        // 1. Obtenemos la conexión del Pool
        Conexion conPool = new Conexion();
        
        // Usamos try-with-resources para cerrar todo automáticamente
        try (Connection con = conPool.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si entra aquí, es que el usuario EXISTE
                    usuarioEncontrado = new Usuario();
                    usuarioEncontrado.setId(rs.getInt("id"));
                    usuarioEncontrado.setUsuario(rs.getString("usuario"));
                    usuarioEncontrado.setRol(rs.getString("rol"));
                    usuarioEncontrado.setEstado(rs.getString("estado"));
                    // No es recomendable guardar la password en el objeto por seguridad
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return usuarioEncontrado;
    }
}