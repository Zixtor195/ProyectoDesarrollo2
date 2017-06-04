/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Validaciones;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ivanmvr
 */
public class ValidarNumero extends InputVerifier {

    JLabel campo;
    private int limite;

    public ValidarNumero(JLabel campo, int limite) {
        this.campo = campo;
        this.limite = limite;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField campoNum = (JTextField) input;
        String texto = campoNum.getText().trim();       
        System.out.println(texto);
        texto = texto.replaceAll("\\s*","");//Eliminar espacios en blanco
        System.out.println(texto);
        try {            
            
            long telefono = Long.parseLong(texto);
            if (telefono<0){
                telefono *= -1;
            }
            campoNum.setText(Long.toString(telefono));
        } catch (NumberFormatException e) {
            System.out.println(texto);            
            campo.setText("Debe ingresar un valor numerico");
            return true;
        }
        
        if (texto.length()>limite){
            campo.setText("Verifique la cantidad de caracteres");
            return true;
        }
        campo.setText("");
        return true;
    }

}
