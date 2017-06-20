/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronesD;

import VistasUsuario.GuiCajero;
import VistasUsuario.GuiGerente;
import VistasUsuario.GuiMesero;
import javax.swing.JPanel;

/**
 *
 * @author Sala
 */
public class FabricaPanelesUsuario implements FactoryIF
{

    public JPanel createProduct(String discriminador, int id) {
        //System.out.print(id);
        
        if(discriminador.equalsIgnoreCase("Gerente"))
        {
            return new GuiGerente();
        
        }    
        if(discriminador.equalsIgnoreCase("Cajero"))
        {
             return new GuiCajero(id);
        
        }  
        
        if(discriminador.equalsIgnoreCase("Mesero"))
        {
             return new GuiMesero(id,discriminador);
            
           
        } 
        return null;
        
    }    

    @Override
    public JPanel createProduct(int id, String discriminador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}   
   
    
    
    
    
    

