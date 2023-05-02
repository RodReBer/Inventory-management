package inventario.dominio;

import java.io.*;
import java.util.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class SerializarDeserializar {

    private final Sistema sistema;

    public SerializarDeserializar(Sistema sistema) {
        this.sistema = sistema;
    }

    public void grabarSerializado() throws IOException {
        FileOutputStream archivo = new FileOutputStream("Sistema");
        ObjectOutputStream datos = new ObjectOutputStream(archivo);
        datos.writeObject(sistema.getArticulos());
        datos.writeObject(sistema.getFuncionarios());
        datos.writeObject(sistema.getDrones());
        datos.writeObject(sistema.getCargas());
        datos.writeObject(sistema.getMapaAreas());
        datos.writeObject(sistema.getMapaRegistroVuelos());
    }

    public void recuperarSerializado() throws IOException, ClassNotFoundException {
        try {
            FileInputStream archivo = new FileInputStream("Sistema");
            ObjectInputStream datos = new ObjectInputStream(archivo);

            ArrayList<Articulo> articulos = (ArrayList<Articulo>) datos.readObject();
            ArrayList<Funcionario> funcionarios = (ArrayList<Funcionario>) datos.readObject();
            ArrayList<Dron> drones = (ArrayList<Dron>) datos.readObject();
            ArrayList<Carga> cargas = (ArrayList<Carga>) datos.readObject();
            HashMap<String, Carga[][]> matrices = (HashMap<String, Carga[][]>) datos.readObject();
            HashMap<String, ArrayList<RegistrosVuelosDron>> registrosVuelos = (HashMap<String, ArrayList<RegistrosVuelosDron>>) datos.readObject();

            for (Articulo articulo : articulos) {
                sistema.setArticulos(articulo);
            }
            for (Funcionario funcionario : funcionarios) {
                sistema.setFuncionarios(funcionario);
            }
            for (Dron drone : drones) {
                sistema.setDrones(drone);
            }
            for (Carga carga : cargas) {
                sistema.setCargas(carga);
            }
            sistema.setMapaAreas(matrices);
            sistema.setMapaRegistroVuelosRecuperarSerializado(registrosVuelos);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al crear serializado");
        }
    }

}
