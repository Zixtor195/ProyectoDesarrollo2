/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClasesTablas.Factura;
import ClasesTablas.Item;
import ClasesTablas.Pedido;
import java.text.ParseException;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Cristian Jurado
 */
public class Fachada {
    
    FuncionesFacturas funcionesFacturas;
    FuncionesItems funcionesItems;
    
    public Fachada(){        
        funcionesFacturas = new FuncionesFacturas();
        funcionesItems = new FuncionesItems();
    }
    
   //Este Metodo Nos Direccionara a la Clase Funciones Facturas en la funcion Crear Factura
    public String CrearFactura(int idPedido, String estadoPedido, String estadoFactura,
                                int idFactura, Pedido pedido, int total) throws ParseException{ 
        
        String resultado = funcionesFacturas.CrearFactura(idPedido, estadoPedido, estadoFactura,
                                   idFactura, pedido, total);
        return resultado;
    }
  
    
    public Factura ConsultarFactura (int idFactura) {        
        Factura factura = funcionesFacturas.ConsultarFactura(idFactura);         
        return factura;
    }
    
    public String ModificarItem (int idItem, String nombre, int precio,
                                String categoria,String descripcion,
                                String Estado, String rut) {
        String resultado = funcionesItems.ModificarItem(idItem, nombre, precio, categoria, descripcion, Estado, rut);
        return resultado;
    }
    
    public String CrearItem (int idItem, String nombre, int precio,
                                String categoria,String descripcion,
                                String Estado, String rut) {
        String resultado = funcionesItems.CrearItem(idItem, nombre, precio, categoria, descripcion, Estado, rut);
        return resultado;
    }
    
    public Item ConsultarItem (int idFactura) {
        Item item = funcionesItems.ConsultarItem(idFactura);         
        return item;
    }
    
    public String EliminarItem (Item item, EntityManagerFactory emf) {
        String resultado = funcionesItems.EliminarItem(item, emf);
        return resultado;
    }

    
}
