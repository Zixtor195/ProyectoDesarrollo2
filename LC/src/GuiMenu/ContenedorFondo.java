/*
    Universidad del Valle
    Asignatura: Desarrollo de Software II 750092M
    Tema: Proyecto final - Entrega final
    Archivo: MenuPane.java
    Version: 1.0
    Fecha de creacion: 10 junio 2017
    Autores:   
                Monica Marcela Llano
                Sebastian Balante Salazar
                Cristian Camilo Jurado Arboleda
                Juan Felipe Orozco Escobar
    Responsabilidad: Cumple la funcion de Container principal en la interfaz Menu
                     el cual permite tener un fondo predeterminado en todo el Container
    Colaboracion: Ninguna clase
*/

package GuiMenu;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class ContenedorFondo extends Container{
	
	public ImageIcon icono;
        
	public ContenedorFondo(String rutaIMG){            
		icono = new ImageIcon (rutaIMG);
	}

        @Override
	public void paint (Graphics g){
            
		Rectangle r = g.getClipBounds();
		g.setColor(this.getBackground());
		g.fillRect (r.x, r.y, r.width, r.height); // Para rellenar todo el fondo asi el usuario agrande la pantalla
		
		g.drawImage (icono.getImage(), 0, 0, this.getWidth(),
				this.getHeight(), this.getBackground(), this);
		
		super.paint(g);
        }
} // Cierra Clase ContenedorFondo
