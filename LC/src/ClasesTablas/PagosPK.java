/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Usuario
 */
@Embeddable
public class PagosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_pago", nullable = false)
    private int idPago;
    @Basic(optional = false)
    @Column(name = "id_factura", nullable = false)
    private int idFactura;

    public PagosPK() {
    }

    public PagosPK(int idPago, int idFactura) {
        this.idPago = idPago;
        this.idFactura = idFactura;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPago;
        hash += (int) idFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagosPK)) {
            return false;
        }
        PagosPK other = (PagosPK) object;
        if (this.idPago != other.idPago) {
            return false;
        }
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.PagosPK[ idPago=" + idPago + ", idFactura=" + idFactura + " ]";
    }
    
}
