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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIdEmpleado", query = "SELECT e FROM Empleado e WHERE e.idEmpleado = :idEmpleado"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "Empleado.findByTelFijo", query = "SELECT e FROM Empleado e WHERE e.telFijo = :telFijo"),
    @NamedQuery(name = "Empleado.findByTelCel", query = "SELECT e FROM Empleado e WHERE e.telCel = :telCel"),
    @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByTipoDocumento", query = "SELECT e FROM Empleado e WHERE e.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "Empleado.findByContrase", query = "SELECT e FROM Empleado e WHERE e.contrase = :contrase"),
    @NamedQuery(name = "Empleado.findByEstado", query = "SELECT e FROM Empleado e WHERE e.estado = :estado"),
    @NamedQuery(name = "Empleado.findByArchivo", query = "SELECT e FROM Empleado e WHERE e.archivo = :archivo")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_empleado", nullable = false)
    private Integer idEmpleado;
    @Basic(optional = false)
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    @Basic(optional = false)
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "cargo", nullable = false, length = 100)
    private String cargo;
    @Basic(optional = false)
    @Column(name = "tel_fijo", nullable = false, length = 100)
    private String telFijo;
    @Basic(optional = false)
    @Column(name = "tel_cel", nullable = false, length = 100)
    private String telCel;
    @Basic(optional = false)
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "tipo_documento", nullable = false, length = 100)
    private String tipoDocumento;
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 100)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrase", nullable = false, length = 100)
    private String contrase;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 100)
    private String estado;
    @Column(name = "archivo", length = 2147483647)
    private String archivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Set<Pedido> pedidoSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpleado")
    private Set<TurnosSemanales> turnosSemanalesSet;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(Integer idEmpleado, String nombres, String apellidos, String cargo, String telFijo, String telCel, String email, String direccion, String tipoDocumento,String usuario, String contrase, String estado) {
        this.idEmpleado = idEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
        this.telFijo = telFijo;
        this.telCel = telCel;
        this.email = email;
        this.direccion = direccion;
        this.tipoDocumento = tipoDocumento;
        this.usuario = usuario;
        this.contrase = contrase;
        this.estado = estado;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrase() {
        return contrase;
    }

    public void setContrase(String contrase) {
        this.contrase = contrase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    @XmlTransient
    public Set<Pedido> getPedidoSet() {
        return pedidoSet;
    }

    public void setPedidoSet(Set<Pedido> pedidoSet) {
        this.pedidoSet = pedidoSet;
    }

    @XmlTransient
    public Set<TurnosSemanales> getTurnosSemanalesSet() {
        return turnosSemanalesSet;
    }

    public void setTurnosSemanalesSet(Set<TurnosSemanales> turnosSemanalesSet) {
        this.turnosSemanalesSet = turnosSemanalesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.Empleado[ idEmpleado=" + idEmpleado;
    }
    
}
