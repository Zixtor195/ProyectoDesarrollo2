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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    , @NamedQuery(name = "TurnosSemanales.findById", query = "SELECT t FROM TurnosSemanales t WHERE t.id = :id")
    , @NamedQuery(name = "TurnosSemanales.findByDia", query = "SELECT t FROM TurnosSemanales t WHERE t.dia = :dia")
    , @NamedQuery(name = "TurnosSemanales.findByHoraInicio", query = "SELECT t FROM TurnosSemanales t WHERE t.horaInicio = :horaInicio")
    , @NamedQuery(name = "TurnosSemanales.findByHoraFin", query = "SELECT t FROM TurnosSemanales t WHERE t.horaFin = :horaFin")})
public class TurnosSemanales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    private String horaFin;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado idEmpleado;

    public TurnosSemanales() {
    }

    public TurnosSemanales(Integer id) {
        this.id = id;
    }

    public TurnosSemanales(Integer id, String dia, String horaInicio, String horaFin) {
        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosSemanales)) {
            return false;
        }
        TurnosSemanales other = (TurnosSemanales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.TurnosSemanales[ id=" + id + " ]";
    }
    
}
