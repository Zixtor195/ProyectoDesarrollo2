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
public interface FactoryIF 
{
     public JPanel createProduct(String discriminador);
    
}
