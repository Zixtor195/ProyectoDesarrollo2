/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Moni
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdPago", query = "SELECT p FROM Pagos p WHERE p.pagosPK.idPago = :idPago"),
    @NamedQuery(name = "Pagos.findByValor", query = "SELECT p FROM Pagos p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagos.findByCedulaCliente", query = "SELECT p FROM Pagos p WHERE p.cedulaCliente = :cedulaCliente"),
    @NamedQuery(name = "Pagos.findByIdFactura", query = "SELECT p FROM Pagos p WHERE p.pagosPK.idFactura = :idFactura")})
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PagosPK pagosPK;
    @Basic(optional = false)
    @Lob
    @Column(name = "tipo", nullable = false)
    private Object tipo;
    @Basic(optional = false)
    @Column(name = "valor", nullable = false)
    private int valor;
    @Basic(optional = false)
    @Column(name = "cedula_cliente", nullable = false)
    private int cedulaCliente;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public Pagos() {
    }

    public Pagos(PagosPK pagosPK) {
        this.pagosPK = pagosPK;
    }

    public Pagos(PagosPK pagosPK, Object tipo, int valor, int cedulaCliente) {
        this.pagosPK = pagosPK;
        this.tipo = tipo;
        this.valor = valor;
        this.cedulaCliente = cedulaCliente;
    }

    public Pagos(int idPago, int idFactura) {
        this.pagosPK = new PagosPK(idPago, idFactura);
    }

    public PagosPK getPagosPK() {
        return pagosPK;
    }

    public void setPagosPK(PagosPK pagosPK) {
        this.pagosPK = pagosPK;
    }

    public Object getTipo() {
        return tipo;
    }

    public void setTipo(Object tipo) {
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagosPK != null ? pagosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.pagosPK == null && other.pagosPK != null) || (this.pagosPK != null && !this.pagosPK.equals(other.pagosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.Pagos[ pagosPK=" + pagosPK + " ]";
    }
    
}
