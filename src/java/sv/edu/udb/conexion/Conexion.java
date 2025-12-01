package sv.edu.udb.conexion;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {
    private static DataSource dataSource = null;
    
    static {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/BibliotecaDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    
    public Connection getConexion() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource no encontrado");
        }
        return dataSource.getConnection();
    }
    
    public void cerrarConexion(Connection con) {
        try {
            if (con != null && !con.isClosed()) con.close();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}