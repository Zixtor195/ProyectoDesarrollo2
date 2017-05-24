/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorClasesTablas;

import ClasesTablas.Factura;
import ClasesTablas.Pagos;
import ClasesTablas.PagosPK;
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
public class PagosJpaControllerTest {
    
    public PagosJpaControllerTest() {
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
    public void testGenerarPagoEfectivo() throws Exception {
        System.out.println("Generar Pago Efectivo");
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
       PagosJpaController dao = new PagosJpaController(emf);
       FacturaJpaController daof = new FacturaJpaController (emf);
       
       Factura factura = daof.findFactura(1);       
       Pagos pago = new Pagos();
       PagosPK pagoPk = new PagosPK();
       //dao.
       factura.setEstado("Pagado");
       pagoPk.setIdPago(1);
       pagoPk.setIdFactura(1);
       
       pago.setPagosPK(pagoPk);       
       pago.setCedulaCliente(134567);
       pago.setTipo("Efectivo");
       pago.setValor(factura.getValorTotal());
       
        String expResult = dao.create(pago);
        String result = "creado exitosamente";
        assertEquals(expResult, result);
        dao.destroy(pagoPk);
        factura.setEstado("Sin pagar");
           
    }

    
    @Test
    public void testGenerarPagoMixto() throws Exception {
        System.out.println("Generar Pago Mixto");
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
       PagosJpaController dao = new PagosJpaController(emf);
       FacturaJpaController daof = new FacturaJpaController (emf);
       
      
           
    }

    
    
    
    
    
    
    
}
