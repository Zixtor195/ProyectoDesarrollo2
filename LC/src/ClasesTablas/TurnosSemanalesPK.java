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
public class TurnosSemanalesPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_empleado", nullable = false)
    private int idEmpleado;
    @Basic(optional = false)
    @Column(name = "turno", nullable = false, length = 100)
    private String turno;

    public TurnosSemanalesPK() {
    }

    public TurnosSemanalesPK(int idEmpleado, String turno) {
        this.idEmpleado = idEmpleado;
        this.turno = turno;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmpleado;
        hash += (turno != null ? turno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosSemanalesPK)) {
            return false;
        }
        TurnosSemanalesPK other = (TurnosSemanalesPK) object;
        if (this.idEmpleado != other.idEmpleado) {
            return false;
        }
        if ((this.turno == null && other.turno != null) || (this.turno != null && !this.turno.equals(other.turno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.TurnosSemanalesPK[ idEmpleado=" + idEmpleado + ", turno=" + turno + " ]";
    }
    
}
