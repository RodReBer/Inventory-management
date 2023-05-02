package inventario.interfaz;

import inventario.dominio.*;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class RegistrarArticulo extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private DefaultTableModel dtm = new DefaultTableModel();
    private Validadores validar;
    private SerializarDeserializar serializarSistema;

    public RegistrarArticulo(Sistema sistema) {
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

        btnAgregarArticulo = new javax.swing.JButton();
        lblNombreArticulo = new javax.swing.JLabel();
        lblDescripcionArticulo = new javax.swing.JLabel();
        tfNombreArticulo = new javax.swing.JTextField();
        tfDescripcionArticulo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaDatosArticulo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Artículos");
        getContentPane().setLayout(null);

        btnAgregarArticulo.setText("Agregar");
        btnAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArticuloActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarArticulo);
        btnAgregarArticulo.setBounds(270, 130, 80, 23);

        lblNombreArticulo.setText("Nombre");
        getContentPane().add(lblNombreArticulo);
        lblNombreArticulo.setBounds(30, 20, 100, 16);

        lblDescripcionArticulo.setText("Descripcion");
        getContentPane().add(lblDescripcionArticulo);
        lblDescripcionArticulo.setBounds(30, 60, 100, 16);
        getContentPane().add(tfNombreArticulo);
        tfNombreArticulo.setBounds(180, 20, 170, 22);
        getContentPane().add(tfDescripcionArticulo);
        tfDescripcionArticulo.setBounds(180, 60, 170, 22);

        tTablaDatosArticulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tTablaDatosArticulo);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 20, 390, 130);

        setBounds(0, 0, 834, 215);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArticuloActionPerformed
        String nombre = tfNombreArticulo.getText();
        String desc = tfDescripcionArticulo.getText();

        if (validar.validarUnicidad(nombre, 1)) {
            validar.mensaje("El artículo ya existe, intente nuevamente");
        } else if (validar.validarCamposObligatorios(tfNombreArticulo, tfDescripcionArticulo)) {
            validar.mensaje("Existen campos vacíos, asegurese de llenar los campos");
        } else if (validar.validarSintaxis(tfNombreArticulo, tfDescripcionArticulo)) {
            validar.mensaje("Nombre o Descripción no deben comenzar con espacio");
        } else {
            sistema.setArticulos(new Articulo(nombre, desc));
            sistema.print();
            cargaAutomatica();
            sistema.updatedJTable();
        }
    }//GEN-LAST:event_btnAgregarArticuloActionPerformed

    public void cargaAutomatica() {
        try {
            dtm.getDataVector().removeAllElements();
            tTablaDatosArticulo.updateUI();

            if (dtm.getColumnCount() == 0) {
                ArrayList<Object> nombrecolumna = new ArrayList<>();
                nombrecolumna.add("Nombre");
                nombrecolumna.add("Descripción");
                for (Object columna : nombrecolumna) {
                    dtm.addColumn(columna);
                }
                tTablaDatosArticulo.setModel(dtm);
            }

            ArrayList<Object[]> datos = new ArrayList<>();
            for (Articulo articulo : sistema.getArticulos()) {
                Object[] informacion = new Object[]{articulo.getNombre(), articulo.getDescripcion()};
                datos.add(informacion);
            }

            for (Object[] DatoPersonal : datos) {
                dtm.addRow(DatoPersonal);
            }
            tTablaDatosArticulo.setModel(dtm);

        } catch (Exception e) {
            System.out.println("Error al cargar");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArticulo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDescripcionArticulo;
    private javax.swing.JLabel lblNombreArticulo;
    private javax.swing.JTable tTablaDatosArticulo;
    private javax.swing.JTextField tfDescripcionArticulo;
    private javax.swing.JTextField tfNombreArticulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o == sistema) {
            cargaAutomatica();
        }
    }

}
