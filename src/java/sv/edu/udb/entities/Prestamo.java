package sv.edu.udb.entities;

import java.util.Date; // IMPORTANTE: Necesario para manejar fechas

/**
 * Clase Prestamo
 * Registra quién se llevó qué libro y cuándo debe devolverlo.
 * Mapea la tabla 'prestamos' de la base de datos.
 */
public class Prestamo {
    
    // Atributos privados
    private int idPrestamo;
    private int idUsuario;        // ID del alumno/profesor (FK)
    private int idMaterial;       // ID del libro/material prestado (FK)
    private Date fechaPrestamo;
    private Date fechaDevolucionPrevista; // Cuándo DEBE devolverlo
    private Date fechaDevolucionReal;     // Cuándo REALMENTE lo devolvió
    private double moraAcumulada;         // Dinero a pagar si se tardó
    private String estado;        // 'Activo', 'Devuelto', 'Moroso'
    private String observaciones;

    // 1. CONSTRUCTOR VACÍO (Obligatorio)
    public Prestamo() {
    }

    // 2. CONSTRUCTOR PARA NUEVO PRÉSTAMO (Lo usará Neftaly al prestar)
    public Prestamo(int idUsuario, int idMaterial, Date fechaPrestamo, Date fechaDevolucionPrevista) {
        this.idUsuario = idUsuario;
        this.idMaterial = idMaterial;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.moraAcumulada = 0.00;
        this.estado = "Activo";
    }

    // 3. CONSTRUCTOR COMPLETO (Lo usarás tú al leer de la BD)
    public Prestamo(int idPrestamo, int idUsuario, int idMaterial, Date fechaPrestamo, 
                    Date fechaDevolucionPrevista, Date fechaDevolucionReal, 
                    double moraAcumulada, String estado, String observaciones) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idMaterial = idMaterial;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucionPrevista = fechaDevolucionPrevista;
        this.fechaDevolucionReal = fechaDevolucionReal;
        this.moraAcumulada = moraAcumulada;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    // 4. GETTERS Y SETTERS
    public int getIdPrestamo() { return idPrestamo; }
    public void setIdPrestamo(int idPrestamo) { this.idPrestamo = idPrestamo; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdMaterial() { return idMaterial; }
    public void setIdMaterial(int idMaterial) { this.idMaterial = idMaterial; }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Date getFechaDevolucionPrevista() { return fechaDevolucionPrevista; }
    public void setFechaDevolucionPrevista(Date fechaDevolucionPrevista) { this.fechaDevolucionPrevista = fechaDevolucionPrevista; }

    public Date getFechaDevolucionReal() { return fechaDevolucionReal; }
    public void setFechaDevolucionReal(Date fechaDevolucionReal) { this.fechaDevolucionReal = fechaDevolucionReal; }

    public double getMoraAcumulada() { return moraAcumulada; }
    public void setMoraAcumulada(double moraAcumulada) { this.moraAcumulada = moraAcumulada; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    
    @Override
    public String toString() {
        return "Prestamo{" + "id=" + idPrestamo + ", usuario=" + idUsuario + ", estado=" + estado + '}';
    }
}