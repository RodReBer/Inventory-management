package inventario;

import inventario.dominio.Sistema;
import inventario.interfaz.Menu;
import java.io.IOException;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Sistema sistema = new Sistema();        
        Menu menu = new Menu(sistema);
        menu.setVisible(true);
    }
}
