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
public class ValidarCantidadCaracteres extends InputVerifier {

    JLabel campo;
    int limite;

    public ValidarCantidadCaracteres(JLabel campo, int limite) {
        this.campo = campo;
        this.limite=limite;
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField campoTexto = (JTextField) input;
        
        if( campoTexto.getText().length() <= limite){
            campo.setText("");
            return true;
        }
        campo.setText("Verifique la cantidad de caracteres");
        return true;
    }

}
