/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebas
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado"),
    @NamedQuery(name = "Factura.findByFormaPago", query = "SELECT f FROM Factura f WHERE f.formaPago = :formaPago"),
    @NamedQuery(name = "Factura.findByHoraPago", query = "SELECT f FROM Factura f WHERE f.horaPago = :horaPago"),
    @NamedQuery(name = "Factura.findByValorTotal", query = "SELECT f FROM Factura f WHERE f.valorTotal = :valorTotal"),
    @NamedQuery(name = "Factura.findByCedulaCliente", query = "SELECT f FROM Factura f WHERE f.cedulaCliente = :cedulaCliente")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_factura", nullable = false)
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private String estado;
    @Basic(optional = false)
    @Column(name = "forma_pago", nullable = false)
    private String formaPago;
    @Basic(optional = false)
    @Column(name = "hora_pago", nullable = false)
    private String horaPago;
    @Basic(optional = false)
    @Column(name = "valor_total", nullable = false)
    private int valorTotal;
    @Basic(optional = false)
    @Column(name = "cedula_cliente", nullable = false)
    private int cedulaCliente;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido idPedido;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Factura(Integer idFactura, String estado, String formaPago, String horaPago, int valorTotal, int cedulaCliente) {
        this.idFactura = idFactura;
        this.estado = estado;
        this.formaPago = formaPago;
        this.horaPago = horaPago;
        this.valorTotal = valorTotal;
        this.cedulaCliente = cedulaCliente;
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

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
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
