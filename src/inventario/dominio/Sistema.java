package inventario.dominio;

import java.io.*;
import java.util.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Sistema extends Observable implements Serializable {

    private ArrayList<Carga> cargas;
    private ArrayList<Dron> drones;
    private ArrayList<Articulo> articulos;
    private ArrayList<Funcionario> funcionarios;
    private HashMap<String, Carga[][]> mapaAreas;
    private HashMap<String, ArrayList<RegistrosVuelosDron>> mapaRegistroVuelos;

    public Sistema() {
        cargas = new ArrayList<>();
        drones = new ArrayList<>();
        articulos = new ArrayList<>();
        funcionarios = new ArrayList<>();
        mapaAreas = new HashMap<>();
        mapaRegistroVuelos = new HashMap<>();
        mapearAreas();
    }

    public void updatedJTable() {
        setChanged();
        notifyObservers();
    }

    public ArrayList<Carga> getCargas() {
        return cargas;
    }

    public void setCargas(Carga cargas) {
        this.cargas.add(cargas);
    }

    public ArrayList<Dron> getDrones() {
        return drones;
    }

    public void setDrones(Dron drones) {
        this.drones.add(drones);
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(Articulo articulos) {
        this.articulos.add(articulos);
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario funcionarios) {
        this.funcionarios.add(funcionarios);
    }

    public HashMap<String, Carga[][]> getMapaAreas() {
        return mapaAreas;
    }

    public void setMapaAreas(HashMap<String, Carga[][]> mapaAreas) {
        this.mapaAreas = mapaAreas;
    }

    public void print() {
        System.out.println(articulos.toString() + " " + drones.toString() + " " + funcionarios.toString());
    }

    public HashMap<String, ArrayList<RegistrosVuelosDron>> getMapaRegistroVuelos() {
        return mapaRegistroVuelos;
    }

    public void setMapaRegistroVuelos(String key, ArrayList mapaRegistroVuelos) {
        this.mapaRegistroVuelos.put(key, mapaRegistroVuelos);
    }

    public void setMapaRegistroVuelosRecuperarSerializado(HashMap<String, ArrayList<RegistrosVuelosDron>> mapaRegistroVuelos) {
        this.mapaRegistroVuelos = mapaRegistroVuelos;
    }

    private void mapearAreas() {
        String letras = "A,B,C,D,E";
        String[] claves = letras.split(",");

        for (String clave : claves) {
            Carga[][] area = new Carga[12][10];
            mapaAreas.put(clave, area);
        }
    }

}
