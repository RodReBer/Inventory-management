package inventario.interfaz;

import inventario.dominio.*;
import java.util.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class EmisionDeEstadisticas extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private DefaultListModel dlm = new DefaultListModel();
    private DefaultListModel dlmd = new DefaultListModel();
    private DefaultListModel dlmdsv = new DefaultListModel();

    public EmisionDeEstadisticas(Sistema sistema) {
        initComponents();
        this.sistema = sistema;
        cargarListaVuelosDrones();
        cargarListaDronesSinVolar();
        sistema.addObserver(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlVuelosDronSeleccionado = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlDronesConVuelo = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jlDronesSinVuelo = new javax.swing.JList<>();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        lblVueloExitosoEstadistica = new javax.swing.JLabel();
        lblVueloNoExitosoEstadistica = new javax.swing.JLabel();
        lblDetallesEstadisticasExitosas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadisticas");

        jScrollPane1.setViewportView(jlVuelosDronSeleccionado);

        jlDronesConVuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlDronesConVueloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jlDronesConVuelo);

        jScrollPane4.setViewportView(jlDronesSinVuelo);

        lblVueloExitosoEstadistica.setText("Drones Con Vuelo");

        lblVueloNoExitosoEstadistica.setText("Drones Sin Vuelo");

        lblDetallesEstadisticasExitosas.setText("Detalle dron con vuelo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblVueloExitosoEstadistica))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVueloNoExitosoEstadistica)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblDetallesEstadisticasExitosas)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVueloExitosoEstadistica)
                            .addComponent(lblVueloNoExitosoEstadistica))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(lblDetallesEstadisticasExitosas)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(730, 469));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlDronesConVueloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlDronesConVueloMouseClicked
        String seleccion = jlDronesConVuelo.getSelectedValue();
        dlmd.removeAllElements();
        jlVuelosDronSeleccionado.updateUI();
        ArrayList<RegistrosVuelosDron> registrosVuelosDronSeleccionado = sistema.getMapaRegistroVuelos().get(seleccion);
        ArrayList<Object[]> datos = new ArrayList<>();

        for (RegistrosVuelosDron registrosVuelosDron : registrosVuelosDronSeleccionado) {
            Object[] informacion;
            String nombreAchivo = registrosVuelosDron.getNombreArchivo();
            String zona = registrosVuelosDron.getArea();
            String fila = registrosVuelosDron.getFila();
            int coincidencias = registrosVuelosDron.getCoincidencias();
            int diferencias = registrosVuelosDron.getDiferencias();
            int cantidadLineasArchivosNoExitoso = registrosVuelosDron.getCantidadLineasArchivoNoExitoso();

            if (registrosVuelosDron.isExitoso()) {
                informacion = new Object[]{"Nombre archivo: " + nombreAchivo + " - " + "Área: " + zona + " - " + "Fila: " + fila + " - " + "Coincidencias: " + coincidencias + " - " + "Diferencias: " + diferencias};
            } else {
                informacion = new Object[]{"Nombre archivo: " + nombreAchivo + " - " + "Área: " + zona + " - " + "Fila: " + fila + " - " + "Cantidad líneas de carga: " + cantidadLineasArchivosNoExitoso};
            }
            datos.add(informacion);
        }

        for (Object[] DatoPersonal : datos) {
            dlmd.addElement(Arrays.toString(DatoPersonal).replace("[", "").replace("]", ""));         

        }
        jlVuelosDronSeleccionado.setModel(dlmd);

    }//GEN-LAST:event_jlDronesConVueloMouseClicked

    @Override
    public void update(Observable o, Object arg) {
        if (o == sistema) {
            cargarListaVuelosDrones();
            cargarListaDronesSinVolar();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> jlDronesConVuelo;
    private javax.swing.JList<String> jlDronesSinVuelo;
    private javax.swing.JList<String> jlVuelosDronSeleccionado;
    private javax.swing.JLabel lblDetallesEstadisticasExitosas;
    private javax.swing.JLabel lblVueloExitosoEstadistica;
    private javax.swing.JLabel lblVueloNoExitosoEstadistica;
    // End of variables declaration//GEN-END:variables

    private void cargarListaVuelosDrones() {
        try {
            dlm.removeAllElements();
            jlDronesConVuelo.updateUI();

            ArrayList<Object[]> datos = new ArrayList<>();
            Set<String> dronesConVuelos = sistema.getMapaRegistroVuelos().keySet();

            String[] drones = Arrays.toString(dronesConVuelos.toArray()).replace("[", "").replace("]", "").split(",");

            for (String codigosDrones : drones) {
                Object[] informacion = new Object[]{codigosDrones};
                datos.add(informacion);
            }

            for (Object[] vuelo : datos) {
                dlm.addElement(Arrays.toString(vuelo).replace("[", "").replace("]", "").replace(" ", ""));
            }

            jlDronesConVuelo.setModel(dlm);

        } catch (Exception e) {
            System.out.println("Error al cargar lista vuelos drones");
        }
    }

    private void cargarListaDronesSinVolar() {
        try {
            dlmdsv.removeAllElements();
            jlDronesSinVuelo.updateUI();

            ArrayList<Object[]> datos = new ArrayList<>();
            ArrayList<String> listaDronesConVuelo = new ArrayList<>();
            Set<String> dronesConVuelos = sistema.getMapaRegistroVuelos().keySet();
            ArrayList<Dron> listaDrones = sistema.getDrones();

            String[] listaDronesConVuelos = Arrays.toString(dronesConVuelos.toArray()).replace("[", "").replace("]", "").split(",");

            for (String dron : listaDronesConVuelos) {
                listaDronesConVuelo.add(dron.replace(" ", ""));
            }

            for (Dron codigosDrones : listaDrones) {
                if (!listaDronesConVuelo.contains(codigosDrones.getIdentificacion())) {
                    Object[] informacion = new Object[]{codigosDrones.getIdentificacion()};
                    datos.add(informacion);
                }
            }

            for (Object[] dronSinVuelo : datos) {
                dlmdsv.addElement(Arrays.toString(dronSinVuelo).replace("[", "").replace("]", "").replace(" ", ""));
            }

            jlDronesSinVuelo.setModel(dlmdsv);

        } catch (Exception e) {
            System.out.println("Error al cargar lista de dornes");
        }
    }

    
}
