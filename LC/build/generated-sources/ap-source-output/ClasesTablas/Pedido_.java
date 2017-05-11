package ClasesTablas;

import ClasesTablas.Empleado;
import ClasesTablas.Factura;
import ClasesTablas.ItemPedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-10T23:32:46")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, String> tipo;
    public static volatile SingularAttribute<Pedido, String> horaUltimoItem;
    public static volatile SingularAttribute<Pedido, Integer> numMesa;
    public static volatile SingularAttribute<Pedido, Empleado> idEmpleado;
    public static volatile SetAttribute<Pedido, Factura> facturaSet;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;
    public static volatile SetAttribute<Pedido, ItemPedido> itemPedidoSet;
    public static volatile SingularAttribute<Pedido, String> horaInicio;

}