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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "item_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemPedido.findAll", query = "SELECT i FROM ItemPedido i"),
    @NamedQuery(name = "ItemPedido.findByIdPedido", query = "SELECT i FROM ItemPedido i WHERE i.itemPedidoPK.idPedido = :idPedido"),
    @NamedQuery(name = "ItemPedido.findByIdItem", query = "SELECT i FROM ItemPedido i WHERE i.itemPedidoPK.idItem = :idItem"),
    @NamedQuery(name = "ItemPedido.findByCantidad", query = "SELECT i FROM ItemPedido i WHERE i.cantidad = :cantidad")})
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemPedidoPK itemPedidoPK;
    @Basic(optional = false)
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @JoinColumn(name = "id_item", referencedColumnName = "id_item", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;

    public ItemPedido() {
    }

    public ItemPedido(ItemPedidoPK itemPedidoPK) {
        this.itemPedidoPK = itemPedidoPK;
    }

    public ItemPedido(ItemPedidoPK itemPedidoPK, int cantidad) {
        this.itemPedidoPK = itemPedidoPK;
        this.cantidad = cantidad;
    }

    public ItemPedido(int idPedido, int idItem) {
        this.itemPedidoPK = new ItemPedidoPK(idPedido, idItem);
    }

    public ItemPedidoPK getItemPedidoPK() {
        return itemPedidoPK;
    }

    public void setItemPedidoPK(ItemPedidoPK itemPedidoPK) {
        this.itemPedidoPK = itemPedidoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemPedidoPK != null ? itemPedidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        if ((this.itemPedidoPK == null && other.itemPedidoPK != null) || (this.itemPedidoPK != null && !this.itemPedidoPK.equals(other.itemPedidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.ItemPedido[ itemPedidoPK=" + itemPedidoPK + " ]";
    }
    
}
