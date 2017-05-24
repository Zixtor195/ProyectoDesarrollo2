/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Item;
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
 * @author Sala
 */
public class ItemJpaControllerTest {
    
    public ItemJpaControllerTest() {
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
     * Test of getEntityManager method, of class ItemJpaController.
     */
    @Test
    public void testCrearItem() throws Exception {
        System.out.println("CrearItem");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        ItemJpaController dao = new ItemJpaController(emf);

        Item item = new Item();
        item.setIdItem(12345);
        item.setNombre("Patica");
        item.setPrecio(5000);
        item.setCategoria("Pollo");
        item.setDescripcion("pata maluca");
        item.setEstado("Activo");
        //item.setFoto(ruta);      
        
        String expResult = dao.create(item);
        String result = "creado exitosamente";
        assertEquals(expResult, result);
        dao.destroy(item.getIdItem());
        
    }


   
    @Test
    public void testEditarItem() throws Exception {
        System.out.println("Editar Item");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        ItemJpaController dao = new ItemJpaController(emf);

        Item item = dao.findItem(100);        
        item.setNombre("Patica-fea");
        item.setPrecio(8000);
        item.setCategoria("Categoria 7");
        item.setDescripcion("pata maluca");
        item.setEstado("Activo");
        
        String expResult = dao.edit(item);
        String result = "modificado exitosamente";
        assertEquals(expResult, result);
    
       
    }

    @Test
    public void consultar() {
        System.out.println("consultar Item");
       
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        ItemJpaController dao = new ItemJpaController(emf);
        
        Item item = new Item();
        item.setIdItem(100);              
        item.setNombre("Patica-fea");
        item.setPrecio(8000);
        item.setCategoria("Categoria 7");
        item.setDescripcion("pata maluca");
        item.setEstado("Activo");
        
        Item expResult = item;
        Item result = dao.findItem(100);
        assertEquals(expResult, result);
      
    }
    
    
    
}
