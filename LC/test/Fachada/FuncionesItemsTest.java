/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClasesTablas.Item;
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
public class FuncionesItemsTest {
    
    public FuncionesItemsTest() {
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
     * Test of ModificarItem method, of class FuncionesItems.
     */
    @Test
    public void testModificarItem() {
        System.out.println("ModificarItem");
        int idItem = 0;
        String nombre = "";
        int precio = 0;
        String categoria = "";
        String descripcion = "";
        String Estado = "";
        String rut = "";
        FuncionesItems instance = new FuncionesItems();
        String expResult = "";
        String result = instance.ModificarItem(idItem, nombre, precio, categoria, descripcion, Estado, rut);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of CrearItem method, of class FuncionesItems.
     */
    @Test
    public void testCrearItem() {
        System.out.println("CrearItem");
        int idItem = 0;
        String nombre = "";
        int precio = 0;
        String categoria = "";
        String descripcion = "";
        String Estado = "";
        String rut = "";
        FuncionesItems instance = new FuncionesItems();
        String expResult = "";
        String result = instance.CrearItem(idItem, nombre, precio, categoria, descripcion, Estado, rut);
        assertEquals(expResult, result);        
        
    }

    /**
     * Test of ConsultarItem method, of class FuncionesItems.
     */
    @Test
    public void testConsultarItem() {
        System.out.println("ConsultarItem");
        int idItem = 0;
        FuncionesItems instance = new FuncionesItems();
        Item expResult = null;
        Item result = instance.ConsultarItem(idItem);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of EliminarItem method, of class FuncionesItems.
     */
    @Test
    public void testEliminarItem() {
        System.out.println("EliminarItem");
        Item item = null;
        EntityManagerFactory emf = null;
        FuncionesItems instance = new FuncionesItems();
        String expResult = "";
        String result = instance.EliminarItem(item, emf);
        assertEquals(expResult, result);
        
    }
    
}
