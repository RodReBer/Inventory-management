package inventario.dominio;

import java.io.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Dron implements Serializable {

    private String identificacion;
    private String modelo;
    private int tipoCamara;

    public Dron() {
    }

    public Dron(String identificacion, String modelo, Integer tipoCamara) {
        this.identificacion = identificacion;
        this.modelo = modelo;
        this.tipoCamara = tipoCamara;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTipoCamara() {
        return tipoCamara;
    }

    public void setTipoCamara(int tipoCamara) {
        this.tipoCamara = tipoCamara;
    }

    @Override
    public String toString() {
        return "Dron{" + "identificacion=" + identificacion + ", modelo=" + modelo + ", tipoCamara=" + tipoCamara + '}';
    }

}
