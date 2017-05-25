/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fachada;

import ClasesTablas.Item;
import ControladorClasesTablas.ItemJpaController;
import ControladorClasesTablas.exceptions.NonexistentEntityException;
import GuiFacturasPagos.FacturasEliminar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



/**
 *
 * @author Cristian Jurado
 */
public class FuncionesItems {
    
    public FuncionesItems(){};
    
    public String ModificarItem (int idItem, String nombre, int precio,
                                String categoria,String descripcion,
                                String Estado, String rut){
        String resultado = "";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");//PruebaJPAPU es el nombre de nuestra unidad de persistencia
        ItemJpaController dao = new ItemJpaController(emf);
        
        Item item = dao.findItem(idItem);             
        item.setNombre(nombre);
        item.setPrecio(precio);
        item.setCategoria(categoria);
        item.setDescripcion(descripcion);
        item.setEstado(Estado);
        item.setFoto(rut);
       
        try {
            dao.edit(item);
            JOptionPane.showMessageDialog(null, "Item Modificado exitosamente.");
            resultado = "1";
            
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "El Item no Existe en la Bd");
            resultado = "2";
        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "Error al modificar el item");
             resultado = "3";
        }finally{
            emf.close();
        }
        
        return resultado;
    }
    
    public String CrearItem (int idItem, String nombre, int precio,
                                String categoria,String descripcion,
                                String Estado, String rut){
        String resultado = "";        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        ItemJpaController dao = new ItemJpaController(emf);
        
        Item item = new Item();

        item.setIdItem(idItem);
        item.setNombre(nombre);
        item.setPrecio(precio);
        item.setCategoria(categoria);
        item.setDescripcion(descripcion);
        item.setEstado(Estado);
        item.setFoto(rut);

        try {

            dao.create(item);
            JOptionPane.showMessageDialog(null, "Item creado exitosamente.");  
            resultado = "1";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ya existe este Item."); 
            resultado = "2";
        }finally{
            emf.close();
        }
        
        return resultado;
    }
    
    public Item ConsultarItem (int idItem){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LCPU");
        ItemJpaController dao = new ItemJpaController(emf);                        
        Item item = dao.findItem(idItem);
        emf.close();
        return item;
    }    
    
    public String EliminarItem (Item item,EntityManagerFactory emf){
        String resultado = "";
        ItemJpaController dao = new ItemJpaController(emf);
                
        try {
            dao.edit(item);
            JOptionPane.showMessageDialog(null, "Item Eliminado exitosamente.");
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "El Item no existe");
            resultado = "2";
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
            resultado = "3";
        }
            
        emf.close();
        
        return resultado;        
    }
    
}
