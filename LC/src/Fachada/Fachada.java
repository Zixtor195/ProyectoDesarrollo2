/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClasesTablas.Factura;
import ClasesTablas.Pedido;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Cristian Jurado
 */
public class Fachada {
    
    FuncionesFacturas funcionesFacturas;
    
    public Fachada(){        
    funcionesFacturas = new FuncionesFacturas();               
    }
    
   //Este Metodo Nos Direccionara a la Clase Funciones Facturas en la funcion Crear Factura
    public void CrearFactura(int idPedido, String estadoPedido, String estadoFactura,
                                String HoraPago, int idFactura, Pedido pedido, int total,
                                EntityManagerFactory emf){ 
        
    funcionesFacturas.CrearFactura(idPedido, estadoPedido, estadoFactura,
                                   HoraPago, idFactura, pedido, total, emf);              
    }
    
    //Este Metodo Nos Direccionara a la Clase Funciones Facturas en la funcion ModificarFactura
    public void ModificarFactura (int idPedido, String estadoPedido, String estadoFactura,
                                String HoraPago, int idFactura, Pedido pedido, int total,
                                EntityManagerFactory emf){
    funcionesFacturas.ModificarFactura(idPedido, estadoPedido, estadoFactura,
                                       HoraPago, idFactura, pedido, total, emf);
    }
    
    //Este Metodo Nos Direccionara a la Clase Funciones Facturas en la funcion EliminarFactura
    public void EliminarFactura (Factura factura, EntityManagerFactory emf){
        funcionesFacturas.EliminarFactura(factura, emf);
    }
    
    //Este Metodo Nos Direccionara a la Clase Funciones Facturas en la funcion ConsultarFactura
    public Factura ConsultarFactura (int idFactura){
        Factura factura = funcionesFacturas.ConsultarFactura(idFactura);
        return factura;
    }
}
