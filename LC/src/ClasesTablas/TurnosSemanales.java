/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesTablas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    , @NamedQuery(name = "TurnosSemanales.findByIdEmpleado", query = "SELECT t FROM TurnosSemanales t WHERE t.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "TurnosSemanales.findByDia", query = "SELECT t FROM TurnosSemanales t WHERE t.dia = :dia")
    , @NamedQuery(name = "TurnosSemanales.findByHoraInicio", query = "SELECT t FROM TurnosSemanales t WHERE t.horaInicio = :horaInicio")
    , @NamedQuery(name = "TurnosSemanales.findByHoraFin", query = "SELECT t FROM TurnosSemanales t WHERE t.horaFin = :horaFin")})
public class TurnosSemanales implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    @Basic(optional = false)
    private int id;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", nullable = false, insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Empleado idEmpleado;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_fin")
    private String horaFin;

    public TurnosSemanales() {
    }

    public TurnosSemanales(Empleado idEmpleado, String dia, String horaInicio, String horaFin) {
        this.idEmpleado = idEmpleado;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TurnosSemanales other = (TurnosSemanales) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TurnosSemanales " + "id=" + id + ", idEmpleado=" + idEmpleado + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }

}
