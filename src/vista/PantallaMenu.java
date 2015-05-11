/**
 * sPAIce_invaders.vista.PantallaMenu.java
 * Proyecto Final: sPAIce invaders.
 *
 * Asignatura: Programación de Aplicaciones Interactivas.
 * Universidad de La Laguna.
 * Curso: 2014-2015
 *
 * Autores: 
 *    Daniel E. Quijada Díaz
 *    Francisco J. Palacios Rodríguez.
 *    Héctor Rodríguez Pérez
 */
package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import modelo.Juego;


/**
 * Pantalla que muestra el menú con distintas opciones:
 *    * Nuevo Juego
 *    * Cargar Juego
 *    * Settings
 *    * Salir
 *    etc..
 */
@SuppressWarnings("serial")
public class PantallaMenu extends Pantalla implements Observer {

	public static final int OFFSETX = Juego.TOTAL_X / 2 - 150;  //Separacion desde el borde izquierdo
	public static final int OFFSETY = Juego.TOTAL_Y / 2 - 250; //Separacion desde el borde superior
	public static final int SEPARACION = 50; //Separacion vertical entre las opciones
	
	private static final int OFFSETX_SELECTOR = 20;
	private static final int OFFSETY_SELECTOR = 17;
	private static final int DIAMETRO = 15; //Tama�o del selector
	
	public static int selector = OFFSETY; //Posicion inicial del selector
	
   /**
    * 
    */
   public PantallaMenu () {

   }


	protected void paintComponent(Graphics g) {
		
		   g.setColor(Color.BLACK);
		   g.fillRect(0, 0, Juego.TOTAL_X, Juego.TOTAL_Y);
		   g.setColor(Color.WHITE);
		   g.setFont(new Font("Monospaced", Font.PLAIN, 30));
		   g.drawString("Nuevo Juego", OFFSETX, OFFSETY);
		   g.drawString("Cargar partida", OFFSETX, OFFSETY + SEPARACION);
		   g.drawString("Opciones", OFFSETX, OFFSETY + (SEPARACION * 2));
		   g.drawString("Salir", OFFSETX, OFFSETY + (SEPARACION * 3));
		   
		   g.fillOval(OFFSETX - OFFSETX_SELECTOR, selector - OFFSETY_SELECTOR, DIAMETRO, DIAMETRO);
		   
	}


/* (non-Javadoc)
 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
 */
@Override
public void update(Observable o, Object arg) {
	repaint();
	
}
	
}
