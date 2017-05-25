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

    @Override
    public JPanel createProduct(String discriminador, int id) {
        System.out.print(id);
        
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
             return new GuiMesero(id);
            
           
        } 
        return null;
        
    }    
        
}   
   
    
    
    
    
    

