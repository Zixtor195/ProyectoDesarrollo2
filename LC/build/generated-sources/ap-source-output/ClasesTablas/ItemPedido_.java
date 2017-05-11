package ClasesTablas;

import ClasesTablas.Item;
import ClasesTablas.ItemPedidoPK;
import ClasesTablas.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-10T23:32:46")
@StaticMetamodel(ItemPedido.class)
public class ItemPedido_ { 

    public static volatile SingularAttribute<ItemPedido, Item> item;
    public static volatile SingularAttribute<ItemPedido, Pedido> pedido;
    public static volatile SingularAttribute<ItemPedido, ItemPedidoPK> itemPedidoPK;
    public static volatile SingularAttribute<ItemPedido, Integer> cantidad;

}