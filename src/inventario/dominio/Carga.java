package inventario.dominio;

import java.io.Serializable;

/**
 *
 * @author Cristhian Barboza (297304) - Rodrigo Rey (275635)
 */
public class Carga implements Serializable {

    private Articulo articulo;
    private Funcionario funcionario;
    private Integer cantidad;
    private Integer codigo;

    public Carga() {
    }

    public Carga(Articulo articulo, Funcionario funcionario, Integer cantidad, Integer codigo) {
        this.articulo = articulo;
        this.funcionario = funcionario;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Carga{" + "articulo=" + articulo + ", funcionario=" + funcionario + ", cantidad=" + cantidad + ", codigo=" + codigo + '}';
    }
}
