/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Factura;
import ClasesTablas.Pedido;
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
 * @author Moni
 */
public class FacturaJpaControllerTest {
    
    public FacturaJpaControllerTest() {
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
     * Test of create method, of class FacturaJpaController.
     */
    @Test
    public void testCrearFactura() throws Exception {
        System.out.println("Crear Factura");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        PedidoJpaController daop = new PedidoJpaController(emf);
        Pedido pedido = daop.findPedido(1);
        
        Factura factura = new Factura();
        
        pedido.setEstado("Facturado");        
        factura.setEstado("Sin Pagar");
        factura.setHoraPago("16:30");
        factura.setIdFactura(345);
        factura.setIdPedido(pedido);
        factura.setValorTotal(35000);
        
        
        String expResult = dao.create(factura);
        String result = "creado exitosamente";
        assertEquals(expResult, result);
        dao.destroy(factura.getIdFactura());
        pedido.setEstado("Activo");
        
    
    }

    
   
    
    @Test
    public void testEditarFactura() throws Exception {
        System.out.println("Editar Factura");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        
        
        Factura factura = dao.findFactura(1);
        
        factura.setHoraPago("16:30");
        factura.setValorTotal(85000);
        
        
        String expResult = dao.edit(factura);
        String result = "modificado exitosamente";
        assertEquals(expResult, result);
        
        
    }

   
    @Test
    public void testConsultarFactura() {
     System.out.println("Consultar Factura");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController dao = new FacturaJpaController(emf);
        PedidoJpaController daop = new PedidoJpaController(emf);
        Pedido pedido = daop.findPedido(1);
        
        Factura factura = new Factura();
        
        pedido.setEstado("Facturado");        
        factura.setEstado("Sin Pagar");
        factura.setHoraPago("16:30");
        factura.setIdFactura(1);
        factura.setIdPedido(pedido);
        factura.setValorTotal(85000);
        
        
        Factura expResult = factura;
        Factura result = dao.findFactura(1);
        assertEquals(expResult, result);  
        
    }

    
    
    
    
}
