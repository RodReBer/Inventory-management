package inventario.dominio;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Validadores {

    private Sistema sistema;

    public Validadores(Sistema sistema) {
        this.sistema = sistema;
    }

    public boolean validarUnicidad(String nombre, int opcion) {
        boolean yaExiste = false;
        int o = opcion;

        switch (o) {
            case 1 -> {
                if (!sistema.getArticulos().isEmpty()) {
                    for (Articulo art : sistema.getArticulos()) {
                        if (art.getNombre().toLowerCase().equalsIgnoreCase(nombre)) {
                            yaExiste = true;
                            break;
                        }
                    }
                }
            }
            case 2 -> {
                if (!sistema.getDrones().isEmpty()) {
                    for (Dron dron : sistema.getDrones()) {
                        if (dron.getIdentificacion().toLowerCase().equalsIgnoreCase(nombre)) {
                            yaExiste = true;
                            break;
                        }
                    }
                }
            }
            case 3 -> {
                if (!sistema.getFuncionarios().isEmpty()) {
                    for (Funcionario fun : sistema.getFuncionarios()) {
                        if (Objects.equals(Integer.valueOf(nombre), fun.getNumeroFuncionario())) {
                            yaExiste = true;
                            break;
                        }
                    }
                }
            }
            case 4 -> {
                if (!sistema.getCargas().isEmpty()) {
                    for (Carga carga : sistema.getCargas()) {
                        if (Objects.equals(Integer.valueOf(nombre), carga.getCodigo())) {
                            yaExiste = true;
                            break;
                        }
                    }
                }
            }

        }
        return yaExiste;
    }

    public boolean validarCamposObligatorios(JTextField nombre, JTextField descripcion) {
        boolean tieneCamposVacios = false;
        if (nombre.getText().split(" ").equals("") || nombre.getText().equals("") || descripcion.getText().split(" ").equals("") || descripcion.getText().equals("")) {
            tieneCamposVacios = true;
        }
        return tieneCamposVacios;
    }

    public boolean validarCamposObligatorios(JTextField id, JTextField modelo, JTextField tipo) {
        boolean tieneCamposVacios = false;
        if (validarCamposObligatorios(id, modelo) || tipo.getText().split(" ").equals("") || tipo.getText().equals("")) {
            tieneCamposVacios = true;
        }
        return tieneCamposVacios;
    }

    public boolean validarCamposObligatoriosIngresoEgreso(JList func, JList art, JTextField cant, JTextField cod) {
        boolean tieneCamposVacios = false;
        try {
            if (func.getSelectedValue().toString().split(" ").equals("") || func.getSelectedValue().toString().equals("")
                    || art.getSelectedValue().toString().split(" ").equals("") || art.getSelectedValue().toString().equals("")
                    || cant.getText().split(" ").equals("") || cant.getText().equals("")
                    || cod.getText().split(" ").equals("") || cod.getText().equals("") || Integer.parseInt(cant.getText()) == 0) {
                tieneCamposVacios = true;
            }
        } catch (Exception e) {
            tieneCamposVacios = true;
        }
        return tieneCamposVacios;

    }

    public boolean validarSintaxis(JTextField nombre, JTextField descripcion) {
        boolean inconsistencia = false;
        String primerCaracterNombre = nombre.getText().substring(0, 1);
        String primerCaracterDescripcion = descripcion.getText().substring(0, 1);
        if (" ".equals(primerCaracterNombre) || " ".equals(primerCaracterDescripcion)) {
            inconsistencia = true;
        }
        return inconsistencia;
    }

    public boolean validarSintaxis(JTextField id, JTextField modelo, JTextField tipo) {
        boolean inconsistencia = false;
        if (validarSintaxis(id, modelo) || tipo.getText().equals(" ") || tipo.getText().equals(" ")) {
            inconsistencia = true;
        }
        return inconsistencia;
    }

    public void mensaje(String mensaje) {
        JOptionPane op = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = op.createDialog("Mensaje");
        dialog.setAlwaysOnTop(true);
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }
}
