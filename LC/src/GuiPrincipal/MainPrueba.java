/*

    NOTAS:

    1. ESTE ES UN MAIN DE PRUEBA EN EL CUAL CRISTIAN JURADO HIZO PRUEBAS DE
    INSERCION DE DATOS A LA BASE DE DATOS
    
    2. LUEGO VINO JUAN FELIPE DE SAPO A HACER MAS PRUEBAS DE CRUD,
    AHI LAS DEJE EXPRESADAS POR SI LES INTERESA PROBAR

    3. RECUERDEN CAMBIAR LOS DATOS DE LA CONEXION EN LA PERSINTENCE PARA QUE CONECTE
   

 */

package GuiPrincipal;

import ClasesTablas.Empleado;
import ControladorClasesTablas.EmpleadoJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Moni
 */
public class MainPrueba {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        
        // Crear un empleado
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");//PruebaJPAPU es el nombre de nuestra unidad de persistencia
        
        EmpleadoJpaController dao = new EmpleadoJpaController(emf);//Creamos un controlador de personal
        
        Empleado persona = new Empleado();//Creamos un objeto personal
        persona.setApellidos("Llano");
        persona.setCargo("secretaria");
        persona.setContraseña("114");
        persona.setDireccion("la pajarera");
        persona.setEmail("mmllano");
        persona.setIdEmpleado(114);
        persona.setNombres("monica");
        persona.setTelCel("no tiene");
        persona.setTelFijo("no me lo se");
        persona.setTipoDocumento("cedula");
        
        /* TipoDocumentoJpaController tpdoc = new TipoDocumentoJpaController(emf);//Debido a que Tipo documento es una Foreing Key en Personal, debemos instanciar un controlador
        //de tipo TipoDocumento
        persona.setTpDocumento(tpdoc.findTipoDocumento(1));//Buscamos el tipo documento con primary key = 1 (C.C.) y se lo pasamos al objeto personal
        */
        //dao.create(persona);//Utilizamos el método create definido en el controlador personal para ingresar el objeto personal a la BD
        //Al ejecutar el método puede que salte una excepcion por lo que es importante lanzarla desde el main con throws Exception 
        emf.close();
        
        // Eliminar un empleado (test by Juan Felipe U_U)
        //dao.destroy(114);
        //emf.close();
        
        // Editar un empleado (test by Juan Felipe U_U)
        //dao.edit(persona);
        //emf.close();
        
        // Encontrar un empleado (test by Juan Felipe U_U)
        //System.out.println(dao.findEmpleado(111).getApellidos());
        //emf.close();

        // Retornar lista de la tabla empleado (test by Juan Felipe U_U)
        //dao.findEmpleadoEntities();
        // Retornar la lista de todos los emails de los empleados de la base de datos
        /*for (int i = 0; i < dao.findEmpleadoEntities().size(); i++) {
            System.out.println(dao.findEmpleadoEntities().get(i).getEmail());
        }*/
        //emf.close();

        
    }
    
}
