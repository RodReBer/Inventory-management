package inventario.interfaz;

import inventario.dominio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class IngresoEgresoDeCarga extends javax.swing.JFrame implements Observer {

    private Sistema sistema;
    private DefaultListModel modeloFuncionario;
    private DefaultListModel modeloArticulos;
    private JButton ultimobutton = new JButton();
    private String zona;
    private Validadores validar;
    private SerializarDeserializar serializarSistema;

    public IngresoEgresoDeCarga(Sistema sistema) {
        initComponents();
        llenarBotones();
        resetearElementos();
        this.sistema = sistema;
        sistema.addObserver(this);
        zona = "A";
        modeloFuncionario = new DefaultListModel();
        modeloArticulos = new DefaultListModel();
        validar = new Validadores(sistema);
        serializarSistema = new SerializarDeserializar(sistema);
    }

    private void llenarBotones() {
        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 10; j++) {
                JButton boton = new JButton(" ");
                boton.setMargin(new Insets(-5, -5, -5, -5));
                boton.setBackground(Color.GRAY);
                boton.setForeground(Color.WHITE);
                boton.setText(i + ": " + j);
                boton.addActionListener(new EspacioListener());
                jPanel2.add(boton);
            }
        }
    }

    private void resetearElementos() {
        jpIngresar.setVisible(false);
        jpEgresar.setVisible(false);
        ultimobutton.setBackground(Color.GRAY);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == sistema) {
            cargaAutomatica();
        }
    }

    private void cargaAutomatica() {
        modeloArticulos.removeAllElements();
        modeloFuncionario.removeAllElements();

        if (!sistema.getArticulos().isEmpty()) {
            for (Articulo articulo : sistema.getArticulos()) {
                modeloArticulos.addElement(articulo.getNombre());
            }
            jlArticulosIngresoEgreso.setModel(modeloArticulos);
        }

        if (!sistema.getFuncionarios().isEmpty()) {
            for (Funcionario funcionario : sistema.getFuncionarios()) {
                modeloFuncionario.addElement(funcionario.getNombre());
            }
            jlFuncionarioIngresoEgreso.setModel(modeloFuncionario);
        }
    }

    private boolean chequearSiTieneCarga(JButton btn) {
        int fila = Integer.parseInt(btn.getText().split(": ")[0]);
        int columna = Integer.parseInt(btn.getText().split(": ")[1]);
        boolean tiene = true;

        if (sistema.getMapaAreas().get(zona)[fila - 1][columna - 1] == null) {
            tiene = false;
        }
        return tiene;
    }

    private String back(String zona) {
        String newZona = "";
        if (zona.equals("A")) {
            newZona = "E";
        }
        if (zona.equals("B")) {
            newZona = "A";
        }
        if (zona.equals("C")) {
            newZona = "B";
        }
        if (zona.equals("D")) {
            newZona = "C";
        }
        if (zona.equals("E")) {
            newZona = "D";
        }
        return newZona;
    }

    private String next(String zona) {
        String newZona = "";
        if (zona.equals("A")) {
            newZona = "B";
        }
        if (zona.equals("B")) {
            newZona = "C";
        }
        if (zona.equals("C")) {
            newZona = "D";
        }
        if (zona.equals("D")) {
            newZona = "E";
        }
        if (zona.equals("E")) {
            newZona = "A";
        }
        return newZona;
    }

    private void limpiarCamposYActualizar() {
        tfCantidadd.setText("");
        tfCodigo.setText("");
        jpIngresar.setVisible(false);
        cargarInformacionDeCarga(ultimobutton);
        jpEgresar.setVisible(true);
        jpEgresar.setBounds(810, 230, 580, 280);
    }

    private class EspacioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton cual = ((JButton) e.getSource());

            if (!cual.equals(ultimobutton)) {
                ultimobutton.setBackground(Color.GRAY);
            }

            if (btnActionSelected(cual)) {
                ultimobutton = cual;
                if (chequearSiTieneCarga(cual)) {
                    jpIngresar.setVisible(false);
                    cargarInformacionDeCarga(cual);
                    jpEgresar.setVisible(true);
                    jpEgresar.setBounds(810, 230, 580, 280);
                } else {
                    jpIngresar.setVisible(true);
                    jpIngresar.setBounds(810, 230, 580, 280);
                    jpEgresar.setVisible(false);
                }
            }
        }
    }

    private void cargarInformacionDeCarga(JButton cual) {
        try {
            int fila = Integer.parseInt(cual.getText().split(": ")[0]);
            int columna = Integer.parseInt(cual.getText().split(": ")[1]);
            Carga contenidoCarga = sistema.getMapaAreas().get(zona)[fila - 1][columna - 1];
            lblCodigoEgresoValor.setText(contenidoCarga.getCodigo().toString());
            lblArticuloEgresoValor.setText(contenidoCarga.getArticulo().getNombre());
            lblCantidadEgresoValor.setText(contenidoCarga.getCantidad().toString());
            lblFuncionarioEgresoValor.setText(contenidoCarga.getFuncionario().getNombre());
        } catch (NumberFormatException e) {
            System.out.println("Array vacío, no se ingresa");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblArea = new javax.swing.JLabel();
        jpEgresar = new javax.swing.JPanel();
        btnEgresar = new javax.swing.JButton();
        lblEgreso = new javax.swing.JLabel();
        lblCodigoEgreso = new javax.swing.JLabel();
        lblArticuloEgreso = new javax.swing.JLabel();
        lblCantidadEgreso = new javax.swing.JLabel();
        lblFuncionarioEgreso = new javax.swing.JLabel();
        lblCodigoEgresoValor = new javax.swing.JLabel();
        lblArticuloEgresoValor = new javax.swing.JLabel();
        lblCantidadEgresoValor = new javax.swing.JLabel();
        lblFuncionarioEgresoValor = new javax.swing.JLabel();
        jpIngresar = new javax.swing.JPanel();
        lblIngreso = new javax.swing.JLabel();
        lblFuncionarios = new javax.swing.JLabel();
        lblArticulos = new javax.swing.JLabel();
        lblCodigoIngreso = new javax.swing.JLabel();
        lblCantidadIngreso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlArticulosIngresoEgreso = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlFuncionarioIngresoEgreso = new javax.swing.JList<>();
        tfCantidadd = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso/Egreso de Carga");
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setLayout(new java.awt.GridLayout(12, 10));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(80, 90, 690, 420);

        jLabel2.setText("1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 60, 20, 16);

        jLabel3.setText("2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 60, 20, 16);

        jLabel4.setText("3");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 60, 20, 16);

        jLabel5.setText("4");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(310, 60, 20, 16);

        jLabel6.setText("5");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(380, 60, 20, 16);

        jLabel7.setText("6");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(450, 60, 20, 16);

        jLabel8.setText("7");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(510, 60, 20, 16);

        jLabel9.setText("8");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(580, 60, 20, 16);

        jLabel10.setText("9");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(650, 60, 20, 16);

        jLabel11.setText("10");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(720, 60, 20, 16);

        jLabel12.setText("1");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(40, 110, 20, 16);

        jLabel13.setText("2");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(40, 140, 20, 16);

        jLabel14.setText("3");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(40, 170, 20, 16);

        jLabel16.setText("4");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(40, 200, 20, 16);

        jLabel17.setText("12");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(40, 480, 20, 16);

        jLabel18.setText("5");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(40, 230, 20, 16);

        jLabel19.setText("6");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(40, 270, 20, 16);

        jLabel20.setText("7");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(40, 310, 20, 16);

        jLabel21.setText("8");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(40, 340, 20, 16);

        jLabel22.setText("9");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(40, 380, 20, 16);

        jLabel23.setText("10");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(40, 420, 20, 16);

        jLabel24.setText("11");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(40, 450, 20, 16);

        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(650, 540, 120, 23);

        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(80, 540, 120, 23);

        lblArea.setText("Área: A ");
        getContentPane().add(lblArea);
        lblArea.setBounds(110, 10, 60, 16);

        jpEgresar.setBackground(new java.awt.Color(90, 149, 253));
        jpEgresar.setLayout(null);

        btnEgresar.setText("Egresar");
        btnEgresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresarActionPerformed(evt);
            }
        });
        jpEgresar.add(btnEgresar);
        btnEgresar.setBounds(391, 219, 150, 23);

        lblEgreso.setText("Egreso");
        jpEgresar.add(lblEgreso);
        lblEgreso.setBounds(19, 15, 60, 16);

        lblCodigoEgreso.setText("Código");
        jpEgresar.add(lblCodigoEgreso);
        lblCodigoEgreso.setBounds(34, 43, 50, 16);

        lblArticuloEgreso.setText("Artículo");
        jpEgresar.add(lblArticuloEgreso);
        lblArticuloEgreso.setBounds(34, 71, 60, 16);

        lblCantidadEgreso.setText("Cantidad");
        jpEgresar.add(lblCantidadEgreso);
        lblCantidadEgreso.setBounds(34, 99, 60, 16);

        lblFuncionarioEgreso.setText("Funcionario");
        jpEgresar.add(lblFuncionarioEgreso);
        lblFuncionarioEgreso.setBounds(34, 127, 70, 16);

        lblCodigoEgresoValor.setText("********");
        jpEgresar.add(lblCodigoEgresoValor);
        lblCodigoEgresoValor.setBounds(130, 43, 140, 16);

        lblArticuloEgresoValor.setText("********");
        jpEgresar.add(lblArticuloEgresoValor);
        lblArticuloEgresoValor.setBounds(130, 71, 140, 16);

        lblCantidadEgresoValor.setText("********");
        jpEgresar.add(lblCantidadEgresoValor);
        lblCantidadEgresoValor.setBounds(130, 99, 150, 16);

        lblFuncionarioEgresoValor.setText("********");
        jpEgresar.add(lblFuncionarioEgresoValor);
        lblFuncionarioEgresoValor.setBounds(130, 127, 140, 16);

        getContentPane().add(jpEgresar);
        jpEgresar.setBounds(810, 370, 580, 280);

        jpIngresar.setBackground(new java.awt.Color(124, 253, 64));
        jpIngresar.setLayout(null);

        lblIngreso.setText("Ingreso");
        jpIngresar.add(lblIngreso);
        lblIngreso.setBounds(18, 15, 70, 16);

        lblFuncionarios.setText("Funcionarios");
        jpIngresar.add(lblFuncionarios);
        lblFuncionarios.setBounds(24, 37, 100, 16);

        lblArticulos.setText("Artículos");
        jpIngresar.add(lblArticulos);
        lblArticulos.setBounds(196, 37, 80, 16);

        lblCodigoIngreso.setText("Código");
        jpIngresar.add(lblCodigoIngreso);
        lblCodigoIngreso.setBounds(410, 122, 60, 16);

        lblCantidadIngreso.setText("Cantidad");
        jpIngresar.add(lblCantidadIngreso);
        lblCantidadIngreso.setBounds(410, 54, 70, 16);

        jScrollPane1.setViewportView(jlArticulosIngresoEgreso);

        jpIngresar.add(jScrollPane1);
        jScrollPane1.setBounds(190, 81, 160, 130);

        jScrollPane2.setViewportView(jlFuncionarioIngresoEgreso);

        jpIngresar.add(jScrollPane2);
        jScrollPane2.setBounds(24, 81, 160, 130);
        jpIngresar.add(tfCantidadd);
        tfCantidadd.setBounds(410, 76, 72, 22);
        jpIngresar.add(tfCodigo);
        tfCodigo.setBounds(410, 144, 72, 22);

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jpIngresar.add(btnIngresar);
        btnIngresar.setBounds(389, 204, 150, 23);

        getContentPane().add(jpIngresar);
        jpIngresar.setBounds(810, 60, 580, 280);

        setSize(new java.awt.Dimension(1472, 681));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed

        String funcionario = jlFuncionarioIngresoEgreso.getSelectedValue();
        String articulo = jlArticulosIngresoEgreso.getSelectedValue();
        Articulo articuloARegistrar = new Articulo();
        Funcionario funcionarioARegistrar = new Funcionario();

        for (Articulo art : sistema.getArticulos()) {
            if (art.getNombre().equalsIgnoreCase(articulo)) {
                articuloARegistrar = art;
                break;
            }
        }

        for (Funcionario fun : sistema.getFuncionarios()) {
            if (fun.getNombre().equalsIgnoreCase(funcionario)) {
                funcionarioARegistrar = fun;
                break;
            }
        }
        try {
            Carga newCarga;
            newCarga = new Carga(articuloARegistrar, funcionarioARegistrar, Integer.valueOf(tfCantidadd.getText()), Integer.valueOf(tfCodigo.getText()));

            if (validar.validarUnicidad(tfCodigo.getText(), 4)) {
                validar.mensaje("El código ya existe, intente nuevamente");
            } else if (validar.validarCamposObligatoriosIngresoEgreso(jlFuncionarioIngresoEgreso, jlArticulosIngresoEgreso, tfCantidadd, tfCodigo)) {
                validar.mensaje("Existen campos vacíos, elementos de listas sin seleccionar o la cantidad ingresada no es distinta de 0, validar campos!");
            } else {
                sistema.setCargas(newCarga);
                int fila = Integer.parseInt(ultimobutton.getText().split(": ")[0]);
                int columna = Integer.parseInt(ultimobutton.getText().split(": ")[1]);
                sistema.getMapaAreas().get(zona)[fila - 1][columna - 1] = newCarga;
                limpiarCamposYActualizar();
            }

        } catch (NumberFormatException e) {
            validar.mensaje("Existen campos vacíos, sin seleccionar o código y cantidad no son datos numéricos");
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnEgresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresarActionPerformed
        int fila = Integer.parseInt(ultimobutton.getText().split(": ")[0]);
        int columna = Integer.parseInt(ultimobutton.getText().split(": ")[1]);
        Carga contenidoCarga = sistema.getMapaAreas().get(zona)[fila - 1][columna - 1];
        if (contenidoCarga != null) {
            sistema.getMapaAreas().get(zona)[fila - 1][columna - 1] = null;
            jpIngresar.setVisible(true);
            jpIngresar.setBounds(810, 230, 580, 280);
            jpEgresar.setVisible(false);
        }
    }//GEN-LAST:event_btnEgresarActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        String newZona = back(zona);
        zona = newZona;
        lblArea.setText("Área: " + newZona);
        resetearElementos();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        String newZona = next(zona);
        zona = newZona;
        lblArea.setText("Área: " + newZona);
        resetearElementos();
    }//GEN-LAST:event_btnNextActionPerformed

    private boolean btnActionSelected(JButton btn) {
        cargaAutomatica();
        boolean state = true;
        if (btn.getBackground() == Color.red) {
            btn.setBackground(Color.GRAY);
            state = false;
            jpIngresar.setVisible(false);
            jpEgresar.setVisible(false);
        } else {
            btn.setBackground(Color.red);
        }
        return state;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEgresar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlArticulosIngresoEgreso;
    private javax.swing.JList<String> jlFuncionarioIngresoEgreso;
    private javax.swing.JPanel jpEgresar;
    private javax.swing.JPanel jpIngresar;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblArticuloEgreso;
    private javax.swing.JLabel lblArticuloEgresoValor;
    private javax.swing.JLabel lblArticulos;
    private javax.swing.JLabel lblCantidadEgreso;
    private javax.swing.JLabel lblCantidadEgresoValor;
    private javax.swing.JLabel lblCantidadIngreso;
    private javax.swing.JLabel lblCodigoEgreso;
    private javax.swing.JLabel lblCodigoEgresoValor;
    private javax.swing.JLabel lblCodigoIngreso;
    private javax.swing.JLabel lblEgreso;
    private javax.swing.JLabel lblFuncionarioEgreso;
    private javax.swing.JLabel lblFuncionarioEgresoValor;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblIngreso;
    private javax.swing.JTextField tfCantidadd;
    private javax.swing.JTextField tfCodigo;
    // End of variables declaration//GEN-END:variables
}
