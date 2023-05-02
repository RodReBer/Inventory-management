package inventario.interfaz;

import inventario.dominio.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Menu extends javax.swing.JFrame {

    private Sistema sistema;
    private SerializarDeserializar serializarSistema;
    private Validadores validar;

    public Menu(Sistema sistema) throws IOException, ClassNotFoundException {
        initComponents();
        this.sistema = sistema;
        serializarSistema = new SerializarDeserializar(sistema);
        serializarSistema.recuperarSerializado();
        validar = new Validadores(sistema);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImageMenu = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mAltas = new javax.swing.JMenu();
        miRegistrarArticulos = new javax.swing.JMenuItem();
        miRegistrarDron = new javax.swing.JMenuItem();
        miRegistrarFuncionario = new javax.swing.JMenuItem();
        mAcciones = new javax.swing.JMenu();
        miIngresoEgreso = new javax.swing.JMenuItem();
        miRegVueloDron = new javax.swing.JMenuItem();
        miEstadisticas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(0);
        setTitle("Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblImageMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventario.recursos/logo_fondo.png"))); // NOI18N
        getContentPane().add(lblImageMenu);
        lblImageMenu.setBounds(10, 0, 700, 580);

        jMenuBar1.setPreferredSize(new java.awt.Dimension(169, 50));

        mAltas.setText("Altas");

        miRegistrarArticulos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miRegistrarArticulos.setText("Registrar Artículos");
        miRegistrarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarArticulosActionPerformed(evt);
            }
        });
        mAltas.add(miRegistrarArticulos);

        miRegistrarDron.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miRegistrarDron.setText("Registrar Dron");
        miRegistrarDron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarDronActionPerformed(evt);
            }
        });
        mAltas.add(miRegistrarDron);

        miRegistrarFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miRegistrarFuncionario.setText("Registrar Funcionario");
        miRegistrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistrarFuncionarioActionPerformed(evt);
            }
        });
        mAltas.add(miRegistrarFuncionario);

        jMenuBar1.add(mAltas);

        mAcciones.setText("Acciones");

        miIngresoEgreso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miIngresoEgreso.setText("Ingreso/Egreso Cargas");
        miIngresoEgreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miIngresoEgresoActionPerformed(evt);
            }
        });
        mAcciones.add(miIngresoEgreso);

        miRegVueloDron.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miRegVueloDron.setText("Registrar Vuelo Dron");
        miRegVueloDron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegVueloDronActionPerformed(evt);
            }
        });
        mAcciones.add(miRegVueloDron);

        miEstadisticas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miEstadisticas.setText("Emisión de Estadísticas");
        miEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEstadisticasActionPerformed(evt);
            }
        });
        mAcciones.add(miEstadisticas);

        jMenuBar1.add(mAcciones);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(747, 668));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miRegistrarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarArticulosActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarArticulo ra = new RegistrarArticulo(sistema);
            ra.setVisible(true);
        });
    }//GEN-LAST:event_miRegistrarArticulosActionPerformed

    private void miRegistrarDronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarDronActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarDron rd = new RegistrarDron(sistema);
            rd.setVisible(true);
        });
    }//GEN-LAST:event_miRegistrarDronActionPerformed

    private void miRegistrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistrarFuncionarioActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            RegistrarFuncionario rf = new RegistrarFuncionario(sistema);
            rf.setVisible(true);
        });
    }//GEN-LAST:event_miRegistrarFuncionarioActionPerformed

    private void miIngresoEgresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miIngresoEgresoActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoEgresoDeCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            IngresoEgresoDeCarga ingEg = new IngresoEgresoDeCarga(sistema);
            ingEg.setVisible(true);
        });
    }//GEN-LAST:event_miIngresoEgresoActionPerformed

    private void miRegVueloDronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegVueloDronActionPerformed
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroDeVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            RegistroDeVuelo rv = new RegistroDeVuelo(sistema);
            rv.setVisible(true);
        });
    }//GEN-LAST:event_miRegVueloDronActionPerformed

    private void miEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEstadisticasActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            EmisionDeEstadisticas ede = new EmisionDeEstadisticas(sistema);
            ede.setVisible(true);
        });
    }//GEN-LAST:event_miEstadisticasActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            JFrame jframe = new JFrame();
            int Answer = JOptionPane.showOptionDialog(jframe, "¿Está seguro que desea salir?", "Mensaje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Salir", "Cancelar"}, "Salir");
            if (Answer == JOptionPane.YES_OPTION) {
                serializarSistema.grabarSerializado();
                validar.mensaje("Se ha guardado exitosamente la información");
                System.exit(0);
            }
        } catch (IOException ex) {
            System.out.println("Error al guardar serializado");
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblImageMenu;
    private javax.swing.JMenu mAcciones;
    private javax.swing.JMenu mAltas;
    private javax.swing.JMenuItem miEstadisticas;
    private javax.swing.JMenuItem miIngresoEgreso;
    private javax.swing.JMenuItem miRegVueloDron;
    private javax.swing.JMenuItem miRegistrarArticulos;
    private javax.swing.JMenuItem miRegistrarDron;
    private javax.swing.JMenuItem miRegistrarFuncionario;
    // End of variables declaration//GEN-END:variables

    public class JPanelConFondo extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
