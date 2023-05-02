package inventario.interfaz;

import inventario.dominio.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class RegistrarDron extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private DefaultTableModel dtm = new DefaultTableModel();
    private Validadores validar;
    private SerializarDeserializar serializarSistema;

    public RegistrarDron(Sistema sistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.cargaAutomatica();
        sistema.addObserver(this);
        validar = new Validadores(sistema);
        serializarSistema = new SerializarDeserializar(sistema);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarDron = new javax.swing.JButton();
        lblIentificacionDron = new javax.swing.JLabel();
        lblModeloDron = new javax.swing.JLabel();
        tfIdentificacionDron = new javax.swing.JTextField();
        tfModeloDron = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaDatosDron = new javax.swing.JTable();
        lblTipoDeCamaraDron = new javax.swing.JLabel();
        tfTipoDeCamaraDron = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Drones");
        getContentPane().setLayout(null);

        btnAgregarDron.setText("Agregar");
        btnAgregarDron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDronActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarDron);
        btnAgregarDron.setBounds(270, 130, 80, 23);

        lblIentificacionDron.setText("Identificación");
        getContentPane().add(lblIentificacionDron);
        lblIentificacionDron.setBounds(30, 20, 100, 16);

        lblModeloDron.setText("Modelo");
        getContentPane().add(lblModeloDron);
        lblModeloDron.setBounds(30, 60, 100, 16);
        getContentPane().add(tfIdentificacionDron);
        tfIdentificacionDron.setBounds(180, 20, 170, 22);
        getContentPane().add(tfModeloDron);
        tfModeloDron.setBounds(180, 60, 170, 22);

        tTablaDatosDron.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Identificación", "Modelo", "Tipo de Camara"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tTablaDatosDron);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 20, 390, 130);

        lblTipoDeCamaraDron.setText("Tipo de Camara");
        getContentPane().add(lblTipoDeCamaraDron);
        lblTipoDeCamaraDron.setBounds(30, 100, 100, 16);
        getContentPane().add(tfTipoDeCamaraDron);
        tfTipoDeCamaraDron.setBounds(180, 100, 170, 22);

        setBounds(0, 0, 853, 215);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarDronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDronActionPerformed
        String ide = tfIdentificacionDron.getText();
        String modelo = tfModeloDron.getText();
        int tipo = 0;
        try {
            tipo = Integer.parseInt(tfTipoDeCamaraDron.getText());
        } catch (NumberFormatException e) {
            validar.mensaje("El tipo de camara, es vacío, contiene espacio o no es numérico, intente nuevamente");
        }

        if (validar.validarUnicidad(ide, 2)) {
            validar.mensaje("El dron ya existe, intente nuevamente");
        } else if (validar.validarCamposObligatorios(tfIdentificacionDron, tfModeloDron, tfTipoDeCamaraDron)) {
            validar.mensaje("Existen campos vacíos, asegurese de llenar los campos");
        } else if (validar.validarSintaxis(tfIdentificacionDron, tfModeloDron, tfTipoDeCamaraDron)) {
            validar.mensaje("Identificación, Modelo y Tipo de Cámara, no deben comenzar con espacio");
        } else if (tipo < 1 || tipo > 6) {
            validar.mensaje("El tipo de cámara debe ser un número entre 1 y 6 inclusive");
        } else {
            sistema.setDrones(new Dron(ide, modelo, tipo));
            sistema.print();
            cargaAutomatica();
            sistema.updatedJTable();
        }
    }//GEN-LAST:event_btnAgregarDronActionPerformed

    private void cargaAutomatica() {
        try {
            dtm.getDataVector().removeAllElements();
            tTablaDatosDron.updateUI();

            if (dtm.getColumnCount() == 0) {
                ArrayList<Object> nombrecolumna = new ArrayList<>();
                nombrecolumna.add("Identificación");
                nombrecolumna.add("Modelo");
                nombrecolumna.add("Tipo de Cámara");
                for (Object columna : nombrecolumna) {
                    dtm.addColumn(columna);
                }
                tTablaDatosDron.setModel(dtm);
            }

            ArrayList<Object[]> datos = new ArrayList<>();
            for (Dron dron : sistema.getDrones()) {
                Object[] informacion = new Object[]{dron.getIdentificacion(), dron.getModelo(), dron.getTipoCamara()};
                datos.add(informacion);
            }

            for (Object[] DatoPersonal : datos) {
                dtm.addRow(DatoPersonal);
            }
            tTablaDatosDron.setModel(dtm);

        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDron;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIentificacionDron;
    private javax.swing.JLabel lblModeloDron;
    private javax.swing.JLabel lblTipoDeCamaraDron;
    private javax.swing.JTable tTablaDatosDron;
    private javax.swing.JTextField tfIdentificacionDron;
    private javax.swing.JTextField tfModeloDron;
    private javax.swing.JTextField tfTipoDeCamaraDron;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o == sistema) {
            cargaAutomatica();
        }
    }

}
