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
import javax.persistence.Persistence;

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
        if (!(emf==null||idPedido==0 || estadoPedido==""||estadoFactura==""||
                HoraPago==""||idFactura==0||pedido==null||total==0)){
        
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
            resultado= "2";
        }finally{
            emf.close();
        }
        emf.close(); 
        }
        return resultado;
    }
    
    public String ModificarFactura (int idPedido, String estadoPedido, String estadoFactura,
                                String HoraPago, int idFactura, Pedido pedido, int total,
                                EntityManagerFactory emf){
        
        String resultado= "";
        if (!(emf==null||idPedido==0 || estadoPedido==""||estadoFactura==""||
                HoraPago==""||idFactura==0||pedido==null||total==0)){
        
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
            resultado= "2";
        }finally{
            emf.close();
        }
        emf.close();
        }
        return resultado;            
    }
    
    public String EliminarFactura (Factura factura, EntityManagerFactory emf){
        String resultado = "";
        
        if (!(emf == null||factura==null)){
            FacturaJpaController daof = new FacturaJpaController(emf);
            try {
                daof.edit(factura);
                JOptionPane.showMessageDialog(null, "Factura Eliminada exitosamente.");
                resultado = "1";
            } catch (NonexistentEntityException ex) {
                 JOptionPane.showMessageDialog(null, "la Factura no existe");
                 resultado = "2";
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                resultado = "3";
            }
            emf.close(); 
        }
        return resultado;       
    }
    
    public Factura ConsultarFactura (int idFactura){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        FacturaJpaController daof = new FacturaJpaController(emf);
        Factura factura = daof.findFactura(idFactura);
        emf.close(); 
        return factura;
        
    }
}
