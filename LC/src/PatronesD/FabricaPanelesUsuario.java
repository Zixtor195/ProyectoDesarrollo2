/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatronesD;

import javax.swing.JPanel;

/**
 *
 * @author Sala
 */
public class FabricaPanelesUsuario implements FactoryIF
{

    @Override
    public JPanel createProduct(String discriminador) {
        
        if(discriminador.equalsIgnoreCase("Gerente"))
        {
        
        
        }    
        if(discriminador.equalsIgnoreCase("Cajero"))
        {
        
        
        }  
        
        if(discriminador.equalsIgnoreCase("Mesero"))
        {
        
        
        } 
        return null;
        
    }    
        
}   
   
    
    
    
    
    

