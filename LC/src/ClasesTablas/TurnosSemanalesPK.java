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
 * @author familia BS
 */
@Embeddable
public class TurnosSemanalesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_empleado")
    private int idEmpleado;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;

    public TurnosSemanalesPK() {
    }

    public TurnosSemanalesPK(int idEmpleado, String dia) {
        this.idEmpleado = idEmpleado;
        this.dia = dia;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEmpleado;
        hash += (dia != null ? dia.hashCode() : 0);
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
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.TurnosSemanalesPK[ idEmpleado=" + idEmpleado + ", dia=" + dia + " ]";
    }
    
}
