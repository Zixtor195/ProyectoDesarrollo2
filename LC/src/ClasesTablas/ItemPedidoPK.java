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
public class ItemPedidoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_pedido", nullable = false)
    private int idPedido;
    @Basic(optional = false)
    @Column(name = "id_item", nullable = false)
    private int idItem;

    public ItemPedidoPK() {
    }

    public ItemPedidoPK(int idPedido, int idItem) {
        this.idPedido = idPedido;
        this.idItem = idItem;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPedido;
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedidoPK)) {
            return false;
        }
        ItemPedidoPK other = (ItemPedidoPK) object;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClasesTablas.ItemPedidoPK[ idPedido=" + idPedido + ", idItem=" + idItem + " ]";
    }
    
}
