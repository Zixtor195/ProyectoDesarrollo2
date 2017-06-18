/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClasesTablas.Factura;
import ClasesTablas.Pedido;
import java.text.ParseException;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian Jurado
 */
public class FuncionesFacturasTest {
    
    public FuncionesFacturasTest() {
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

    /**
     * Test of CrearFactura method, of class FuncionesFacturas.
     */
    @Test
    public void testCrearFactura() throws ParseException {
        System.out.println("CrearFactura");
        int idPedido = 0;
        String estadoPedido = "";
        String estadoFactura = "";    
        int idFactura = 0;
        Pedido pedido = null;
        int total = 0;
        EntityManagerFactory emf = null;
        FuncionesFacturas instance = new FuncionesFacturas();
        String expResult = "";
        String result = instance.CrearFactura(idPedido, estadoPedido, estadoFactura,idFactura, pedido, total, emf);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarFactura method, of class FuncionesFacturas.
     */
   

    /**
     * Test of EliminarFactura method, of class FuncionesFacturas.
     */
    
    /**
     * Test of ConsultarFactura method, of class FuncionesFacturas.
     */
    @Test
    public void testConsultarFactura() {
        System.out.println("ConsultarFactura");
        int idFactura = 0;
        FuncionesFacturas instance = new FuncionesFacturas();
        Factura expResult = null;
        Factura result = instance.ConsultarFactura(idFactura);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
