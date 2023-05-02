package inventario.interfaz;

import inventario.dominio.*;
import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class RegistrarFuncionario extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private DefaultTableModel dtm = new DefaultTableModel();
    private Validadores validar;
    private SerializarDeserializar serializarSistema;

    public RegistrarFuncionario(Sistema sistema) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.cargaAutomatica();
        sistema.addObserver(this);
        validar = new Validadores(sistema);
        serializarSistema = new SerializarDeserializar(sistema);
        chequearCantidadFuncionarios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarFuncionario = new javax.swing.JButton();
        lblNombreFuncionario = new javax.swing.JLabel();
        lblEdadFuncionario = new javax.swing.JLabel();
        tfNombreFuncionario = new javax.swing.JTextField();
        tfEdadFuncionario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTablaDatosFuncionario = new javax.swing.JTable();
        lblNumeroFuncionario = new javax.swing.JLabel();
        tfNumeroFuncionario = new javax.swing.JTextField();
        btnAgregarFuncionario1 = new javax.swing.JButton();
        btnCantidadFun = new javax.swing.JButton();
        lblCantFunc = new javax.swing.JLabel();
        btnBorrarfunc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionarios");
        getContentPane().setLayout(null);

        btnAgregarFuncionario.setText("Agregar");
        btnAgregarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFuncionarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarFuncionario);
        btnAgregarFuncionario.setBounds(270, 130, 80, 23);

        lblNombreFuncionario.setText("Nombre");
        getContentPane().add(lblNombreFuncionario);
        lblNombreFuncionario.setBounds(30, 20, 100, 16);

        lblEdadFuncionario.setText("Edad");
        getContentPane().add(lblEdadFuncionario);
        lblEdadFuncionario.setBounds(30, 60, 100, 16);
        getContentPane().add(tfNombreFuncionario);
        tfNombreFuncionario.setBounds(180, 20, 170, 22);
        getContentPane().add(tfEdadFuncionario);
        tfEdadFuncionario.setBounds(180, 60, 170, 22);

        tTablaDatosFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Edad", "N° Funcionario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(tTablaDatosFuncionario);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 20, 390, 130);

        lblNumeroFuncionario.setText("N° Funcionario");
        getContentPane().add(lblNumeroFuncionario);
        lblNumeroFuncionario.setBounds(30, 100, 100, 16);
        getContentPane().add(tfNumeroFuncionario);
        tfNumeroFuncionario.setBounds(180, 100, 170, 22);

        btnAgregarFuncionario1.setText("Agregar");
        btnAgregarFuncionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFuncionario1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarFuncionario1);
        btnAgregarFuncionario1.setBounds(270, 130, 80, 23);

        btnCantidadFun.setText("Semaforo Funcionarios");
        btnCantidadFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadFunActionPerformed(evt);
            }
        });
        getContentPane().add(btnCantidadFun);
        btnCantidadFun.setBounds(110, 270, 170, 23);
        getContentPane().add(lblCantFunc);
        lblCantFunc.setBounds(330, 270, 100, 30);

        btnBorrarfunc.setText("Borrar Funcionario");
        btnBorrarfunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarfuncActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrarfunc);
        btnBorrarfunc.setBounds(450, 270, 240, 23);

        setBounds(0, 0, 853, 458);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFuncionarioActionPerformed

        String nomFun = tfNombreFuncionario.getText();
        int edFun = 0;
        int nFun = 0;
        try {
            edFun = Integer.parseInt(tfEdadFuncionario.getText());
            nFun = Integer.parseInt(tfNumeroFuncionario.getText());
        } catch (NumberFormatException e) {
            validar.mensaje("N° Funcionario o Edad, es vacío, contiene espacio o no es numérico, intente nuevamente");
        }

        if (validar.validarUnicidad(String.valueOf(nFun), 3)) {
            validar.mensaje("El funcionario ya existe, intente nuevamente");
        } else if (validar.validarCamposObligatorios(tfNombreFuncionario, tfEdadFuncionario, tfNumeroFuncionario)) {
            validar.mensaje("Existen campos vacíos, asegurese de llenar los campos");
        } else if (validar.validarSintaxis(tfNombreFuncionario, tfEdadFuncionario, tfNumeroFuncionario)) {
            validar.mensaje("Nombre, Edad o N° Funcionario, no deben comenzar con espacio");
        } else {
            if (edFun > 0 && nFun > 0 && cuantosMenoresAVeinteHay(edFun)) {
                sistema.setFuncionarios(new Funcionario(nomFun, edFun, nFun));
                sistema.print();
                cargaAutomatica();
                sistema.updatedJTable();
            }
        }
        chequearCantidadFuncionarios();

    }//GEN-LAST:event_btnAgregarFuncionarioActionPerformed

    private void btnAgregarFuncionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFuncionario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarFuncionario1ActionPerformed

    private void btnCantidadFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadFunActionPerformed


    }//GEN-LAST:event_btnCantidadFunActionPerformed

    private void btnBorrarfuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarfuncActionPerformed
        int valor = (int) tTablaDatosFuncionario.getModel().getValueAt(tTablaDatosFuncionario.getSelectedRow(), 2);

        for (Funcionario funcionario : sistema.getFuncionarios()) {
            if (funcionario.getNumeroFuncionario() == valor) {
                sistema.getFuncionarios().remove(funcionario);
                break;
            }
        }
        cargaAutomatica();
    }//GEN-LAST:event_btnBorrarfuncActionPerformed

    private void cargaAutomatica() {
        dtm.getDataVector().removeAllElements();
        tTablaDatosFuncionario.updateUI();

        if (dtm.getColumnCount() == 0) {
            ArrayList<Object> nombrecolumna = new ArrayList<>();
            nombrecolumna.add("Nombre");
            nombrecolumna.add("Edad");
            nombrecolumna.add("N° Funcionario");
            for (Object columna : nombrecolumna) {
                dtm.addColumn(columna);
            }
            tTablaDatosFuncionario.setModel(dtm);
        }

        ArrayList<Object[]> datos = new ArrayList<>();
        for (Funcionario func : sistema.getFuncionarios()) {
            Object[] informacion = new Object[]{func.getNombre(), func.getEdad(), func.getNumeroFuncionario()};
            datos.add(informacion);
        }

        for (Object[] DatoPersonal : datos) {
            dtm.addRow(DatoPersonal);
        }
        tTablaDatosFuncionario.setModel(dtm);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFuncionario;
    private javax.swing.JButton btnAgregarFuncionario1;
    private javax.swing.JButton btnBorrarfunc;
    private javax.swing.JButton btnCantidadFun;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantFunc;
    private javax.swing.JLabel lblEdadFuncionario;
    private javax.swing.JLabel lblNombreFuncionario;
    private javax.swing.JLabel lblNumeroFuncionario;
    private javax.swing.JTable tTablaDatosFuncionario;
    private javax.swing.JTextField tfEdadFuncionario;
    private javax.swing.JTextField tfNombreFuncionario;
    private javax.swing.JTextField tfNumeroFuncionario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (o == sistema) {
            cargaAutomatica();
        }
    }

    private void chequearCantidadFuncionarios() {
        if (sistema.getFuncionarios().size() <= 3) {
            btnCantidadFun.setBackground(Color.GREEN);
        } else {
            btnCantidadFun.setBackground(Color.RED);
        }

        lblCantFunc.setText(String.valueOf(sistema.getFuncionarios().size()));

    }

    private boolean cuantosMenoresAVeinteHay(int edadFuncionario) {
        boolean hay = false;
        int cont = 0;
        if (edadFuncionario < 20) {
            for (Funcionario funcionario : sistema.getFuncionarios()) {
                if (funcionario.getEdad() < 20) {
                    cont++;
                }
            }
            if (cont < 3) {
                hay = true;
            }
        } else {
            hay = true;
        }
        return hay;
    }
}
