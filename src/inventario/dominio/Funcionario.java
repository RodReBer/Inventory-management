package inventario.dominio;

import java.io.Serializable;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Funcionario implements Serializable {

    private String nombre;
    private Integer edad;
    private Integer numeroFuncionario;

    public Funcionario() {
    }

    public Funcionario(String nombre, Integer edad, Integer numeroFuncionario) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroFuncionario = numeroFuncionario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(Integer numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nombre=" + nombre + ", edad=" + edad + ", numeroFuncionario=" + numeroFuncionario + '}';
    }

}
