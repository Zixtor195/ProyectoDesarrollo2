package ClasesTablas;

import ClasesTablas.Pedido;
import ClasesTablas.TurnosSemanales;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-10T23:32:46")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> apellidos;
    public static volatile SingularAttribute<Empleado, String> tipoDocumento;
    public static volatile SetAttribute<Empleado, Pedido> pedidoSet;
    public static volatile SingularAttribute<Empleado, Integer> idEmpleado;
    public static volatile SetAttribute<Empleado, TurnosSemanales> turnosSemanalesSet;
    public static volatile SingularAttribute<Empleado, String> direccion;
    public static volatile SingularAttribute<Empleado, String> cargo;
    public static volatile SingularAttribute<Empleado, String> telFijo;
    public static volatile SingularAttribute<Empleado, String> telCel;
    public static volatile SingularAttribute<Empleado, String> email;
    public static volatile SingularAttribute<Empleado, String> nombres;
    public static volatile SingularAttribute<Empleado, String> contraseña;

}