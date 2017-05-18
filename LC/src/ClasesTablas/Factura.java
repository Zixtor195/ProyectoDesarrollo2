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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado"),
    @NamedQuery(name = "Factura.findByHoraPago", query = "SELECT f FROM Factura f WHERE f.horaPago = :horaPago"),
    @NamedQuery(name = "Factura.findByValorTotal", query = "SELECT f FROM Factura f WHERE f.valorTotal = :valorTotal")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_factura", nullable = false)
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 2147483647)
    private String estado;
    @Basic(optional = false)
    @Column(name = "hora_pago", nullable = false, length = 100)
    private String horaPago;
    @Basic(optional = false)
    @Column(name = "valor_total", nullable = false)
    private int valorTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Set<ItemsDeFactura> itemsDeFacturaSet;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false)
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private Set<Pagos> pagosSet;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, String estado, String horaPago, int valorTotal) {
        this.idFactura = idFactura;
        this.estado = estado;
        this.horaPago = horaPago;
        this.valorTotal = valorTotal;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(String horaPago) {
        this.horaPago = horaPago;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    @XmlTransient
    public Set<ItemsDeFactura> getItemsDeFacturaSet() {
        return itemsDeFacturaSet;
    }

    public void setItemsDeFacturaSet(Set<ItemsDeFactura> itemsDeFacturaSet) {
        this.itemsDeFacturaSet = itemsDeFacturaSet;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    @XmlTransient
    public Set<Pagos> getPagosSet() {
        return pagosSet;
    }

    public void setPagosSet(Set<Pagos> pagosSet) {
        this.pagosSet = pagosSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
