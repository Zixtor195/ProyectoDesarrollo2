/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido"),
    @NamedQuery(name = "Pedido.findByHoraInicio", query = "SELECT p FROM Pedido p WHERE p.horaInicio = :horaInicio"),
    @NamedQuery(name = "Pedido.findByHoraUltimoItem", query = "SELECT p FROM Pedido p WHERE p.horaUltimoItem = :horaUltimoItem"),
    @NamedQuery(name = "Pedido.findByTipo", query = "SELECT p FROM Pedido p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Pedido.findByNumMesa", query = "SELECT p FROM Pedido p WHERE p.numMesa = :numMesa")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pedido", nullable = false)
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "hora_inicio", nullable = false, length = 100)
    private String horaInicio;
    @Column(name = "hora_ultimo_item", length = 100)
    private String horaUltimoItem;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 2147483647)
    private String tipo;
    @Column(name = "num_mesa")
    private Integer numMesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Set<Factura> facturaSet;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false)
    @ManyToOne(optional = false)
    private Empleado idEmpleado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Set<ItemPedido> itemPedidoSet;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, String horaInicio, String tipo) {
        this.idPedido = idPedido;
        this.horaInicio = horaInicio;
        this.tipo = tipo;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraUltimoItem() {
        return horaUltimoItem;
    }

    public void setHoraUltimoItem(String horaUltimoItem) {
        this.horaUltimoItem = horaUltimoItem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }

    @XmlTransient
    public Set<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(Set<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @XmlTransient
    public Set<ItemPedido> getItemPedidoSet() {
        return itemPedidoSet;
    }

    public void setItemPedidoSet(Set<ItemPedido> itemPedidoSet) {
        this.itemPedidoSet = itemPedidoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.Pedido[ idPedido=" + idPedido + " ]";
    }

    public void setIdPedidoAumentado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
