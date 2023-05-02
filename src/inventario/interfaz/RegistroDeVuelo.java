package inventario.interfaz;

import inventario.dominio.*;
import java.awt.Color;
import java.awt.Component;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class RegistroDeVuelo extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private ArchivoLectura archivoLectura;
    private Validadores validar;
    private DefaultTableModel dtm = new DefaultTableModel();
    int coincidencias = 0;
    int cantidadLineasArchivo = 0;

    public RegistroDeVuelo(Sistema sistema) {
        traductor();
        initComponents();
        this.sistema = sistema;
        sistema.addObserver(this);
        validar = new Validadores(sistema);
    }

    private void traductor() {
        UIManager.put("FileChooser.lookInLabelText", "Mirar en");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtComparador = new javax.swing.JTable();
        lblAreaRegistroVuelo = new javax.swing.JLabel();
        lblFilaRegistroVuelo = new javax.swing.JLabel();
        lblTotalC = new javax.swing.JLabel();
        lblTotalD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Vuelos");
        getContentPane().setLayout(null);

        jFileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooserActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser);
        jFileChooser.setBounds(23, 6, 611, 316);

        jtComparador.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jtComparador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Archivo", null, null, null, null, null, null, null, null, null, null},
                {"Manual", null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "De", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtComparador.setToolTipText("");
        jtComparador.setColumnSelectionAllowed(true);
        jtComparador.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(jtComparador);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(23, 398, 877, 107);

        lblAreaRegistroVuelo.setText("Área: -");
        getContentPane().add(lblAreaRegistroVuelo);
        lblAreaRegistroVuelo.setBounds(49, 353, 60, 16);

        lblFilaRegistroVuelo.setText("Fila: -");
        getContentPane().add(lblFilaRegistroVuelo);
        lblFilaRegistroVuelo.setBounds(113, 353, 60, 16);

        lblTotalC.setText("Total coincidencias 0");
        getContentPane().add(lblTotalC);
        lblTotalC.setBounds(40, 523, 180, 16);

        lblTotalD.setText("Total diferencias 0");
        getContentPane().add(lblTotalD);
        lblTotalD.setBounds(40, 545, 180, 16);

        setSize(new java.awt.Dimension(948, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooserActionPerformed

        if (evt.getActionCommand().equals(javax.swing.JFileChooser.APPROVE_SELECTION)) {
            try {
                archivoLectura = new ArchivoLectura(jFileChooser.getSelectedFile().getAbsolutePath());
                Integer[][] comparar = new Integer[2][10];
                ArrayList<String> lectura = new ArrayList<>();
                cantidadLineasArchivo = 0;
                while (archivoLectura.hayMasLineas()) {
                    cantidadLineasArchivo++;
                    if (!archivoLectura.linea().contains(",")){
                        lectura.add(archivoLectura.linea());
                    } else {
                        String[] valores = archivoLectura.linea().split(",");
                        
                        for (String valore : valores) {
                            lectura.add(valore);
                        }
                        
                    }
                }

                String codigo = lectura.get(0);
                String zona = lectura.get(1).split("#")[0];
                String fila = lectura.get(1).split("#")[1];

                if (esLecturaCorrecta(lectura)) {
                    comparacionArchivoYManual(comparar, lectura, codigo, zona, fila, cantidadLineasArchivo);
                    boolean estadoDeRegistro = registrarVueloExitoso(codigo, zona, fila);

                    if (estadoDeRegistro) {
                        validar.mensaje("Error al guardar el registro de vuelo");
                    } else {
                        validar.mensaje("Registro Exitoso");
                    }

                } else {
                    registrarVueloNoExitoso(codigo, zona, fila);
                    validar.mensaje("Vuelo no exitoso, lectura incompleta! Cantidad de líneas: " + (lectura.size() - 2));
                    sistema.updatedJTable();
                }

            } catch (NumberFormatException e) {
                System.out.println("Error al cargar el archivo");
            }
        } else if (evt.getActionCommand().equals(javax.swing.JFileChooser.CANCEL_SELECTION)) {
            dtm.getDataVector().removeAllElements();
            jtComparador.updateUI();
        }
        sistema.updatedJTable();
    }//GEN-LAST:event_jFileChooserActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtComparador;
    private javax.swing.JLabel lblAreaRegistroVuelo;
    private javax.swing.JLabel lblFilaRegistroVuelo;
    private javax.swing.JLabel lblTotalC;
    private javax.swing.JLabel lblTotalD;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        /**/
    }

    private boolean esLecturaCorrecta(ArrayList<String> lectura) {
        return lectura.size() == 12;
    }

    private TableCellRenderer formatCell(Color color) {
        TableCellRenderer renderGreen = new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel lbl = new JLabel(value == null ? "" : value.toString());
                lbl.setOpaque(true);
                lbl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
                lbl.setBackground(color);
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                return lbl;
            }
        };
        return renderGreen;
    }

    private boolean registrarVueloExitoso(String codigo, String zona, String fila) {
        boolean registroNoExitoso = false;
        try {

            RegistrosVuelosDron registro = new RegistrosVuelosDron(nombreArchivo(), true, zona, fila, coincidencias, 10 - coincidencias, 0, codigo, (String) datosDron(codigo).get(0), Integer.valueOf((String) datosDron(codigo).get(1)));

            ArrayList<RegistrosVuelosDron> registroVueloDron = sistema.getMapaRegistroVuelos().get(codigo) == null ? new ArrayList<>() : sistema.getMapaRegistroVuelos().get(codigo);
            registroVueloDron.add(registro);
            sistema.setMapaRegistroVuelos(codigo, registroVueloDron);

        } catch (Exception e) {
            System.out.println("E: La lísta de drones está vacía");
            registroNoExitoso = true;
        }
        return registroNoExitoso;
    }

    private void registrarVueloNoExitoso(String codigo, String zona, String fila) {
        try {
            RegistrosVuelosDron registro = new RegistrosVuelosDron(nombreArchivo(), false, zona, fila, coincidencias, coincidencias, cantidadLineasArchivo - 2, codigo, (String) datosDron(codigo).get(0), Integer.valueOf((String) datosDron(codigo).get(1)));

            ArrayList<RegistrosVuelosDron> registroVueloDron = sistema.getMapaRegistroVuelos().get(codigo) == null ? new ArrayList<>() : sistema.getMapaRegistroVuelos().get(codigo);
            registroVueloDron.add(registro);
            sistema.setMapaRegistroVuelos(codigo, registroVueloDron);
        } catch (Exception e) {
            System.out.println("NE: La lísta de drones está vacía");
        }
    }

    private String nombreArchivo() {
        String rutaArchivo = jFileChooser.getSelectedFile().getAbsolutePath().replace("\\", "-");
        String[] dividirPath = rutaArchivo.split("-");
        return dividirPath[dividirPath.length - 1];
    }

    private ArrayList datosDron(String codigo) {
        ArrayList<String> infoDron = new ArrayList<>();
        String modeloDron = "";
        int tipoCamara = 0;

        for (Dron dron : sistema.getDrones()) {
            if (dron.getIdentificacion().equals(codigo)) {
                infoDron.add(dron.getModelo());
                infoDron.add(String.valueOf(dron.getTipoCamara()));
            }
        }
        return infoDron;
    }

    private void comparacionArchivoYManual(Integer[][] comparar, ArrayList<String> lectura, String codigo, String zona, String fila, int cantidadLineasArchivo) {
        dtm.getDataVector().removeAllElements();
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        jtComparador.updateUI();

        if (dtm.getColumnCount() == 0) {
            ArrayList<Object> nombrecolumna = new ArrayList<>();
            nombrecolumna.add("De");
            nombrecolumna.add("1");
            nombrecolumna.add("2");
            nombrecolumna.add("3");
            nombrecolumna.add("4");
            nombrecolumna.add("5");
            nombrecolumna.add("6");
            nombrecolumna.add("7");
            nombrecolumna.add("8");
            nombrecolumna.add("9");
            nombrecolumna.add("10");

            for (Object columna : nombrecolumna) {
                dtm.addColumn(columna);
            }

            for (int i = 2; i < 12; i++) {
                if (cantidadLineasArchivo - 2 < 11) {
                    comparar[0][i - 2] = Integer.valueOf(lectura.get(i));
                }
            }

            Carga[][] registroManual = sistema.getMapaAreas().get(zona);

            for (int j = 0; j < 10; j++) {
                boolean esNull = registroManual[(Integer.parseInt(fila) - 1)][j] == null;
                comparar[1][j] = esNull ? 0 : registroManual[Integer.parseInt(fila) - 1][j].getCodigo();
            }

            ArrayList<Object[]> datosArchivo = new ArrayList<>();
            ArrayList<Object[]> datosManual = new ArrayList<>();

            Object[] informacionArchivo = new Object[]{"Archivo", comparar[0][0], comparar[0][1], comparar[0][2], comparar[0][3], comparar[0][4], comparar[0][5], comparar[0][6], comparar[0][7], comparar[0][8], comparar[0][9]};
            datosArchivo.add(informacionArchivo);

            Object[] informacionManual = new Object[]{"Manual", comparar[1][0], comparar[1][1], comparar[1][2], comparar[1][3], comparar[1][4], comparar[1][5], comparar[1][6], comparar[1][7], comparar[1][8], comparar[1][9]};
            datosManual.add(informacionManual);

            for (Object[] dArchivo : datosArchivo) {
                dtm.addRow(dArchivo);
            }

            for (Object[] dManual : datosManual) {
                dtm.addRow(dManual);
            }
            jtComparador.setModel(dtm);

            /* chequeo coincidencias */
            jtComparador.getColumnModel().getColumn(0).setCellRenderer(formatCell(new Color(171, 178, 185)));
            coincidencias = 0;
            for (int i = 0; i < 10; i++) {
                if (Objects.equals(comparar[0][i], comparar[1][i])) {
                    jtComparador.getColumnModel().getColumn(i + 1).setCellRenderer(formatCell(Color.GREEN));
                    coincidencias++;
                } else {
                    jtComparador.getColumnModel().getColumn(i + 1).setCellRenderer(formatCell(Color.red));
                }
            }
            lblTotalC.setText("Total coincidencias " + String.valueOf(coincidencias));
            lblTotalD.setText("Total diferencias " + String.valueOf(10 - coincidencias));
            lblAreaRegistroVuelo.setText("Área: " + zona);
            lblFilaRegistroVuelo.setText("Fila: " + fila);
        }
    }

}
