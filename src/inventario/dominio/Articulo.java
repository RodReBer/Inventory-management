package inventario.dominio;

import java.io.Serializable;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Articulo implements Serializable {

    private String nombre;
    private String descripcion;

    public Articulo() {
    }

    public Articulo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + ", descripcion: " + descripcion;
    }

}
