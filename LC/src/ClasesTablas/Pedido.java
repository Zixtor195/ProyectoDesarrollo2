/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Sebas
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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido = 0;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_ultimo_item")
    private String horaUltimoItem;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "num_mesa")
    private Integer numMesa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<ItemPedido> itemPedidoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido", fetch = FetchType.LAZY)
    private List<Factura> facturaSet;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idEmpleado;

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
    
    public void setIdPedido(int idpedido) {
        this.idPedido = idpedido ;
    }
    
    public void setIdPedidoAumentado() {
        this.idPedido++ ;
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
    public List<ItemPedido> getItemPedidoSet() {
        return itemPedidoSet;
    }

    public void setItemPedidoSet(List<ItemPedido> itemPedidoSet) {
        this.itemPedidoSet = itemPedidoSet;
    }

    @XmlTransient
    public List<Factura> getFacturaSet() {
        return facturaSet;
    }

    public void setFacturaSet(List<Factura> facturaSet) {
        this.facturaSet = facturaSet;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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
    
}
