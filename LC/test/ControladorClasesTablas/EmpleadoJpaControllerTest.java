/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author familia BS
 */
public class EmpleadoJpaControllerTest {
    
    public EmpleadoJpaControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        Empleado empleado = null;
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        empleado = new Empleado(132456, "Juanito", "Casas", "Gerete", "6594875", "3164857948", "juanito4@corral.com", "Carrera 58 #26-59", "Cedula", "Juanito123", "123", "Activo", null);
        ejc.create(empleado);
        String expResult = ejc.create(empleado);
        String result = "creado exitosamente";
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testFindEmpleado() {
        System.out.println("Consult");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        Integer id = 132456;
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);;
        Empleado empleado = ejc.findEmpleado(id);
        String expResult = "";
        String result = "encontrado exitosamente";
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testEdit() throws Exception {
        System.out.println("Edit");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        Empleado empleado = null;
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        empleado = ejc.findEmpleado(132456);
        empleado.setNombres("Pepito");
        empleado.setApellidos("Pepas");
        empleado.setCargo("Caja");
        empleado.setTelCel("3195862456");
        ejc.edit(empleado);
        System.out.println("Empleado editado");
        String expResult = "";
        String result = "editador exitosamente";
        assertEquals(expResult, result);
    }

    
    @Test
    public void testDestroy() throws Exception {
        System.out.println("Destroy");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        EmpleadoJpaController ejc = new EmpleadoJpaController(emf);
        ejc.destroy(132456);
        System.out.println("Empleado eliminador");
        String expResult = "";
        String result = "eliminado exitosamente";
        assertEquals(expResult, result);
    }
}
