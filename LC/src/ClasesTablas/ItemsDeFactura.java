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
@Table(name = "items_de_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsDeFactura.findAll", query = "SELECT i FROM ItemsDeFactura i"),
    @NamedQuery(name = "ItemsDeFactura.findByNombre", query = "SELECT i FROM ItemsDeFactura i WHERE i.itemsDeFacturaPK.nombre = :nombre"),
    @NamedQuery(name = "ItemsDeFactura.findByCantidad", query = "SELECT i FROM ItemsDeFactura i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "ItemsDeFactura.findByPrecio", query = "SELECT i FROM ItemsDeFactura i WHERE i.precio = :precio"),
    @NamedQuery(name = "ItemsDeFactura.findByIdFactura", query = "SELECT i FROM ItemsDeFactura i WHERE i.itemsDeFacturaPK.idFactura = :idFactura")})
public class ItemsDeFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemsDeFacturaPK itemsDeFacturaPK;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio", nullable = false)
    private int precio;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public ItemsDeFactura() {
    }

    public ItemsDeFactura(ItemsDeFacturaPK itemsDeFacturaPK) {
        this.itemsDeFacturaPK = itemsDeFacturaPK;
    }

    public ItemsDeFactura(ItemsDeFacturaPK itemsDeFacturaPK, int cantidad, int precio) {
        this.itemsDeFacturaPK = itemsDeFacturaPK;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ItemsDeFactura(String nombre, int idFactura) {
        this.itemsDeFacturaPK = new ItemsDeFacturaPK(nombre, idFactura);
    }

    public ItemsDeFacturaPK getItemsDeFacturaPK() {
        return itemsDeFacturaPK;
    }

    public void setItemsDeFacturaPK(ItemsDeFacturaPK itemsDeFacturaPK) {
        this.itemsDeFacturaPK = itemsDeFacturaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
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
        hash += (itemsDeFacturaPK != null ? itemsDeFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsDeFactura)) {
            return false;
        }
        ItemsDeFactura other = (ItemsDeFactura) object;
        if ((this.itemsDeFacturaPK == null && other.itemsDeFacturaPK != null) || (this.itemsDeFacturaPK != null && !this.itemsDeFacturaPK.equals(other.itemsDeFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.ItemsDeFactura[ itemsDeFacturaPK=" + itemsDeFacturaPK + " ]";
    }
    
}
