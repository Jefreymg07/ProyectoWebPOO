package sv.edu.udb.entities;

/**
 * Clase Ejemplar
 * Representa una copia física específica de un libro.
 * Se usa para controlar qué copia exacta se lleva el alumno.
 */
public class Ejemplar {
    
    // Atributos
    private int id;                 // ID único de la copia (Autoincrementable)
    private String codigoLibro;     // Conecta con el Libro (FK)
    private String numeroEjemplar;  // Ej: "Copia 1", "Copia 2"
    private String estado;          // "Disponible", "Prestado", "Reparación", "Perdido"
    private String ubicacion;       // Ej: "Estante A, Fila 3"

    // 1. CONSTRUCTOR VACÍO (Obligatorio)
    public Ejemplar() {
    }

    // 2. CONSTRUCTOR COMPLETO
    public Ejemplar(int id, String codigoLibro, String numeroEjemplar, String estado, String ubicacion) {
        this.id = id;
        this.codigoLibro = codigoLibro;
        this.numeroEjemplar = numeroEjemplar;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    // 3. GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNumeroEjemplar() {
        return numeroEjemplar;
    }

    public void setNumeroEjemplar(String numeroEjemplar) {
        this.numeroEjemplar = numeroEjemplar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // Método para imprimir (útil para depurar errores)
    @Override
    public String toString() {
        return "Ejemplar{" + "id=" + id + ", libro=" + codigoLibro + ", estado=" + estado + '}';
    }
}