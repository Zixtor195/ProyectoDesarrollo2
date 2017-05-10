package ClasesTablas;

import ClasesTablas.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-09T19:36:23")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> estado;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, Integer> valorTotal;
    public static volatile SingularAttribute<Factura, String> formaPago;
    public static volatile SingularAttribute<Factura, String> horaPago;
    public static volatile SingularAttribute<Factura, Pedido> idPedido;
    public static volatile SingularAttribute<Factura, Integer> cedulaCliente;

}