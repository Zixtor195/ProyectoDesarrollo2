/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author familia BS
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedido.findByHoraInicio", query = "SELECT p FROM Pedido p WHERE p.horaInicio = :horaInicio")
    , @NamedQuery(name = "Pedido.findByHoraUltimoItem", query = "SELECT p FROM Pedido p WHERE p.horaUltimoItem = :horaUltimoItem")
    , @NamedQuery(name = "Pedido.findByTipo", query = "SELECT p FROM Pedido p WHERE p.tipo = :tipo")
    , @NamedQuery(name = "Pedido.findByNumMesa", query = "SELECT p FROM Pedido p WHERE p.numMesa = :numMesa")
    , @NamedQuery(name = "Pedido.findByEstado", query = "SELECT p FROM Pedido p WHERE p.estado = :estado")
    , @NamedQuery(name = "Pedido.findByFechaPedido", query = "SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_ultimo_item")
    @Temporal(TemporalType.TIME)
    private Date horaUltimoItem;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "num_mesa")
    private Integer numMesa;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private Set<ItemPedido> itemPedidoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido", fetch = FetchType.LAZY)
    private Set<Factura> facturaSet;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, Date horaInicio, String tipo, String estado, Date fechaPedido) {
        this.idPedido = idPedido;
        this.horaInicio = horaInicio;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaPedido = fechaPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
    
    public void setIdPedidoAumentado() {
        this.idPedido++;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraUltimoItem() {
        return horaUltimoItem;
    }

    public void setHoraUltimoItem(Date horaUltimoItem) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Set<ItemPedido> getItemPedidoSet() {
        return itemPedidoSet;
    }

    public void setItemPedidoSet(Set<ItemPedido> itemPedidoSet) {
        this.itemPedidoSet = itemPedidoSet;
    }

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
