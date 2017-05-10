package ClasesTablas;

import ClasesTablas.ItemPedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-09T19:36:23")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> descripcion;
    public static volatile SingularAttribute<Item, Integer> precio;
    public static volatile SingularAttribute<Item, String> categoria;
    public static volatile SetAttribute<Item, ItemPedido> itemPedidoSet;
    public static volatile SingularAttribute<Item, String> nombre;
    public static volatile SingularAttribute<Item, Integer> idItem;

}