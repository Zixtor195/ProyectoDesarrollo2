package Datos.Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Validator that ensures that given string is an e-mail address.
 *
 * @author Jiri Vagner, Jan Stola
 */
public class ValidarEmail extends InputVerifier {

    JLabel campo;
    private Pattern pattern;
    private Matcher matcher;
    private int limite;
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+"//1 o mas letras ,numeros o simbolos
            + "(\\.[_A-Za-z0-9-]+)*@"//0 o mas letras o numeros o simbolos seguidos de @
            + "[A-Za-z0-9-]+"//1 o mas letras o numeros o simbolos 
            + "(\\.[A-Za-z0-9]+)*"//0 o mas letras o numeros o simbolos 
            + "(\\.[A-Za-z]{2,})$";//un punto seguido de 2 o mas letras 

    public ValidarEmail(JLabel campo, int limite) {
        this.campo = campo;
        this.limite = limite;
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean verify(JComponent input) {
        JTextField tf = (JTextField) input;
        String texto = tf.getText();

        matcher = pattern.matcher(texto);
        boolean resultado = matcher.matches();
        System.out.println(texto + " resultado " + resultado);
        if (resultado && texto.length()<limite) {
            campo.setText("");
        } else {

            campo.setText("Verifique el email");
            return true;
        }

        return true;
    }
}
