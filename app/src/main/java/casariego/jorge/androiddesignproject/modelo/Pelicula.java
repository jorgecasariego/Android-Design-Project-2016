package casariego.jorge.androiddesignproject.modelo;

/**
 * Created by jorgecasariego on 1/6/16.
 */
public class Pelicula {
    private String nombre;
    private String descripcion;

    public Pelicula(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
