package sv.edu.udb.entities;

/**
 * Clase Libro
 * Hereda de MaterialEscrito (que ya tiene autor, género, título, etc.)
 */
public class Libro extends MaterialEscrito {
    
    // Atributos propios de un Libro
    private String isbn;
    private String editorial;
    private int cantidadTotal;
    private int cantidadDisponibles;

    // 1. CONSTRUCTOR VACÍO 
    // (Obligatorio para que funcionen las herramientas de Java y BD)
    public Libro() {
        super(); // Inicializa la clase padre
    }

    // 2. CONSTRUCTOR COMPLETO
    // Recibe TODOS los datos: los del Libro + los del MaterialEscrito + los del Material
    public Libro(String codigo, String titulo, int anio, String autor, String genero, 
                 String isbn, String editorial, int cantidadTotal, int cantidadDisponibles) {
        
        // Enviamos los datos comunes a la clase padre (MaterialEscrito)
        // Nota: "Libro" se pasa fijo porque esta clase siempre es un libro
        super(codigo, titulo, anio, "Libro", autor, genero); 
        
        // Guardamos los datos exclusivos de Libro
        this.isbn = isbn;
        this.editorial = editorial;
        this.cantidadTotal = cantidadTotal;
        this.cantidadDisponibles = cantidadDisponibles;
    }

    // 3. GETTERS Y SETTERS (Para leer y modificar los datos privados)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public int getCantidadDisponibles() {
        return cantidadDisponibles;
    }

    public void setCantidadDisponibles(int cantidadDisponibles) {
        this.cantidadDisponibles = cantidadDisponibles;
    }

    // 4. IMPLEMENTACIÓN DE MÉTODO ABSTRACTO
    // Esto es obligatorio porque MaterialEscrito/Material lo exigen
    @Override
    public String getInformacion() {
        return "LIBRO: " + getTitulo() + " - " + getAutor() + " (" + editorial + ")";
    }
    
    // Método para imprimir en consola (útil para pruebas)
    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + getTitulo() + '}';
    }
}