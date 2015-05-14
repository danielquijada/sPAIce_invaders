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
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import modelo.Fuentes;


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

	private static final int OFFSETX = 100;
	private static final int OFFSETY  = 30;
	private static final int SEPARACION = 50; //Separacion vertical entre las opciones
	
	private static final int OFFSETX_SELECTOR = 20;
	private static final int OFFSETY_SELECTOR = 17;
	private static final int DIAMETRO = 15; //Tama�o del selector
	
	private Fuentes fuentes;
	
   /**
    * 
    */
   public PantallaMenu (Fuentes fuentes) {
	   setBackground(Color.BLACK);
	   setFuentes(fuentes);
   }


	protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int mitad_ancho = getWidth() / 2 - OFFSETX;
			int mitad_alto = getHeight() / 2 - OFFSETY;
			
			g.setColor(Color.WHITE);
			g.setFont(getFuentes().getInvadersFont().deriveFont(Font.PLAIN, 80));
			g.drawString("BDFL", mitad_ancho - 80, 100);
			g.setFont(getFuentes().getChessFont().deriveFont(Font.PLAIN, 80));
			g.drawString("SPAICE", mitad_ancho - 60, 170);
			g.setFont(getFuentes().getSafetyFont().deriveFont(Font.PLAIN,70));
			g.drawString("INVADERS", mitad_ancho - 80, 250);		
			g.setFont(getFuentes().getArcadeFont().deriveFont(Font.PLAIN, 30));
			g.drawString("Nuevo Juego", mitad_ancho, mitad_alto);
			g.drawString("Cargar partida", mitad_ancho, mitad_alto + SEPARACION);
			g.drawString("Opciones", mitad_ancho, mitad_alto + (SEPARACION * 2));
			g.drawString("Salir", mitad_ancho, mitad_alto + (SEPARACION * 3));
		   
			g.setColor(Color.RED);
			g.fillOval(mitad_ancho - OFFSETX_SELECTOR, mitad_alto - OFFSETY_SELECTOR, DIAMETRO, DIAMETRO);
		   
	}


	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
		
	
	public void setFuentes(Fuentes fuentes) {
		this.fuentes = fuentes;
	}
	
	public Fuentes getFuentes() {
		return fuentes;
	}
	

}
