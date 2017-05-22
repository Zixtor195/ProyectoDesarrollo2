/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author familia BS
 */
@Entity
@Table(name = "turnos_semanales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurnosSemanales.findAll", query = "SELECT t FROM TurnosSemanales t")
    , @NamedQuery(name = "TurnosSemanales.findByIdEmpleado", query = "SELECT t FROM TurnosSemanales t WHERE t.turnosSemanalesPK.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "TurnosSemanales.findByDia", query = "SELECT t FROM TurnosSemanales t WHERE t.turnosSemanalesPK.dia = :dia")
    , @NamedQuery(name = "TurnosSemanales.findByHoraInicio", query = "SELECT t FROM TurnosSemanales t WHERE t.horaInicio = :horaInicio")
    , @NamedQuery(name = "TurnosSemanales.findByHoraFin", query = "SELECT t FROM TurnosSemanales t WHERE t.horaFin = :horaFin")})
public class TurnosSemanales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnosSemanalesPK turnosSemanalesPK;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_fin")
    private String horaFin;

    public TurnosSemanales() {
    }

    public TurnosSemanales(TurnosSemanalesPK turnosSemanalesPK) {
        this.turnosSemanalesPK = turnosSemanalesPK;
    }

    public TurnosSemanales(int idEmpleado, String dia) {
        this.turnosSemanalesPK = new TurnosSemanalesPK(idEmpleado, dia);
    }

    public TurnosSemanalesPK getTurnosSemanalesPK() {
        return turnosSemanalesPK;
    }

    public void setTurnosSemanalesPK(TurnosSemanalesPK turnosSemanalesPK) {
        this.turnosSemanalesPK = turnosSemanalesPK;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
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
