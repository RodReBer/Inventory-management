package inventario.dominio;

import java.io.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class RegistrosVuelosDron extends Dron implements Serializable {

    private String nombreArchivo;
    private boolean exitoso;
    private String area;
    private String fila;
    private int coincidencias;
    private int diferencias;
    private int cantidadLineasArchivoNoExitoso;

    public RegistrosVuelosDron() {
    }

    public RegistrosVuelosDron(String nombreArchivo, boolean exitoso, String area, String fila, int coincidencias, int diferencias, int cantidadLineasArchivoNoExitoso, String identificacion, String modelo, Integer tipoCamara) {
        super(identificacion, modelo, tipoCamara);
        this.nombreArchivo = nombreArchivo;
        this.exitoso = exitoso;
        this.area = area;
        this.fila = fila;
        this.coincidencias = coincidencias;
        this.diferencias = diferencias;
        this.cantidadLineasArchivoNoExitoso = cantidadLineasArchivoNoExitoso;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getCoincidencias() {
        return coincidencias;
    }

    public void setCoincidencias(int coincidencias) {
        this.coincidencias = coincidencias;
    }

    public int getDiferencias() {
        return diferencias;
    }

    public void setDiferencias(int diferencias) {
        this.diferencias = diferencias;
    }

    public int getCantidadLineasArchivoNoExitoso() {
        return cantidadLineasArchivoNoExitoso;
    }

    public void setCantidadLineasArchivoNoExitoso(int cantidadLineasArchivoNoExitoso) {
        this.cantidadLineasArchivoNoExitoso = cantidadLineasArchivoNoExitoso;
    }

    @Override
    public String toString() {
        return "RegistrosVuelosDron{" + super.toString() + "nombreArchivo=" + nombreArchivo + ", exitoso=" + exitoso + ", area=" + area + ", fila=" + fila + ", coincidencias=" + coincidencias + ", diferencias=" + diferencias + '}';
    }

}
