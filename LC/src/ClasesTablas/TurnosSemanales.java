/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "turnos_semanales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnosSemanales.findAll", query = "SELECT t FROM TurnosSemanales t"),
    @NamedQuery(name = "TurnosSemanales.findByIdEmpleado", query = "SELECT t FROM TurnosSemanales t WHERE t.turnosSemanalesPK.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "TurnosSemanales.findByTurno", query = "SELECT t FROM TurnosSemanales t WHERE t.turnosSemanalesPK.turno = :turno")})
public class TurnosSemanales implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnosSemanalesPK turnosSemanalesPK;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleado empleado;

    public TurnosSemanales() {
    }

    public TurnosSemanales(TurnosSemanalesPK turnosSemanalesPK) {
        this.turnosSemanalesPK = turnosSemanalesPK;
    }

    public TurnosSemanales(int idEmpleado, String turno) {
        this.turnosSemanalesPK = new TurnosSemanalesPK(idEmpleado, turno);
    }

    public TurnosSemanalesPK getTurnosSemanalesPK() {
        return turnosSemanalesPK;
    }

    public void setTurnosSemanalesPK(TurnosSemanalesPK turnosSemanalesPK) {
        this.turnosSemanalesPK = turnosSemanalesPK;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnosSemanalesPK != null ? turnosSemanalesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosSemanales)) {
            return false;
        }
        TurnosSemanales other = (TurnosSemanales) object;
        if ((this.turnosSemanalesPK == null && other.turnosSemanalesPK != null) || (this.turnosSemanalesPK != null && !this.turnosSemanalesPK.equals(other.turnosSemanalesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.TurnosSemanales[ turnosSemanalesPK=" + turnosSemanalesPK + " ]";
    }
    
}
