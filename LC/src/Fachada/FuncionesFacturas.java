/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClasesTablas.Factura;
import ClasesTablas.ItemPedido;
import ClasesTablas.ItemsDeFactura;
import ClasesTablas.ItemsDeFacturaPK;
import ClasesTablas.Pedido;
import ControladorClasesTablas.FacturaJpaController;
import ControladorClasesTablas.ItemPedidoJpaController;
import ControladorClasesTablas.ItemsDeFacturaJpaController;
import ControladorClasesTablas.PedidoJpaController;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import GuiFacturasPagos.FacturasEliminar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;

import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Jurado
 */
public class FuncionesFacturas {
    
    public FuncionesFacturas(){};
    
    public String CrearFactura (int idPedido, String estadoPedido, String estadoFactura,
                                String HoraPago, int idFactura, Pedido pedido, int total,
                                EntityManagerFactory emf){  
        String resultado= "";
       
        
        FacturaJpaController dao = new FacturaJpaController(emf);   
        PedidoJpaController daop = new PedidoJpaController(emf);          
        ItemPedidoJpaController daoi = new ItemPedidoJpaController(emf);  
        ItemsDeFacturaJpaController daocho = new ItemsDeFacturaJpaController(emf);
        Factura factura = new Factura();
        
        pedido.setEstado(estadoPedido);        
        factura.setEstado(estadoFactura);
        factura.setHoraPago(HoraPago);
        factura.setIdFactura(idFactura);
        factura.setIdPedido(pedido);
        factura.setValorTotal(total);
        
        try {
            daop.edit(pedido);
            dao.create(factura);
            List<ItemPedido> Ip = daoi.findItemPedidoEntities();                
            
        
            for (int i = 0; i < Ip.size(); i++) {
            if (Ip.get(i).getPedido().getIdPedido() == idPedido){               
                                            
                ItemsDeFactura itemfac = new ItemsDeFactura();
                ItemsDeFacturaPK itemsPK = new ItemsDeFacturaPK();
                itemsPK.setNombre(Ip.get(i).getItem().getNombre());
                itemsPK.setIdFactura(dao.findFactura(factura.getIdFactura()).getIdFactura());
                
                itemfac.setItemsDeFacturaPK(itemsPK);
                itemfac.setCantidad(Ip.get(i).getCantidad());
                itemfac.setFactura(dao.findFactura(factura.getIdFactura()));
                itemfac.setPrecio(Ip.get(i).getItem().getPrecio());
                daocho.create(itemfac);                       
                    }
            }                                   
            JOptionPane.showMessageDialog(null, "Factura creado exitosamente."); 
            resultado= "1";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ya existe Esta Factura");
            resultado= "Error";
        }finally{
            emf.close();
        }
        
        return resultado;
    }
    
    public String ModificarFactura (int idPedido, String estadoPedido, String estadoFactura,
                                String HoraPago, int idFactura, Pedido pedido, int total,
                                EntityManagerFactory emf){
        String resultado= "";
        FacturaJpaController dao = new FacturaJpaController(emf);
                
        Factura factura = dao.findFactura(idFactura);
        factura.setEstado(estadoFactura);
        factura.setHoraPago(HoraPago);
        factura.setIdFactura(idFactura);
        factura.setIdPedido(pedido);
        factura.setValorTotal(total);

        try {            
            dao.edit(factura);            
            JOptionPane.showMessageDialog(null, "Factura Modificada exitosamente.");
            resultado= "1";

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Al Modificar");
            resultado= "Error";
        }finally{
            emf.close();
        }
        
        return resultado;            
    }
    
    public String EliminarFactura (Factura factura, EntityManagerFactory emf){
        FacturaJpaController daof = new FacturaJpaController(emf);
        try {
            daof.edit(factura);
            JOptionPane.showMessageDialog(null, "Factura Eliminada exitosamente.");
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacturasEliminar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FacturasEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;       
    }
    
}
