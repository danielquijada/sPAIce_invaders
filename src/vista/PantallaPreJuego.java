/**
 * sPAIce_invaders.vista.PantallaPreJuego.java
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

import modelo.Fuentes;
import modelo.Juego;
import modelo.PreJuego;

/**
 * Muestra un texto previo a la partida
 */
@SuppressWarnings("serial")
public class PantallaPreJuego extends Pantalla implements Observer{

	private static final int OFFSETX = 100;
	private static final int OFFSETY = 30;
		
	private Font fontarcade = Fuentes.getArcadeFont().deriveFont(Font.PLAIN, 30);
	private Font fontinv = Fuentes.getInvadersFont().deriveFont(Font.PLAIN, 80);
	
	private static PantallaPreJuego pantallaPreJuego;
	private PreJuego prejuego;
	
	private PantallaPreJuego() {
		setBackground(Color.BLACK);
	}
	
	public static PantallaPreJuego getInstance () {
	      if (getPantallaPreJuego () == null)
	         setPantallaPreJuego (new PantallaPreJuego ());
	      return getPantallaPreJuego ();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int mitadAncho = getWidth() / 2 - OFFSETX;
		int mitadAlto = getHeight() / 2 - OFFSETY;
		
		g.setColor(Color.WHITE);
		g.setFont(fontinv);
		g.drawString("BDF", mitadAncho, mitadAlto - OFFSETY);
		g.setFont(fontarcade);
		g.drawString("BEWARE", mitadAncho, mitadAlto);
		g.drawString("THE", mitadAncho, mitadAlto);
		g.drawString("INVASION", mitadAncho, mitadAlto);
		
	}
	
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public static PantallaPreJuego getPantallaPreJuego() {
		return pantallaPreJuego;
	}

	public static void setPantallaPreJuego(PantallaPreJuego pantallaPreJuego) {
		PantallaPreJuego.pantallaPreJuego = pantallaPreJuego;
	}

	public PreJuego getPreJuego() {
		return prejuego;
	}

	public void setPreJuego(PreJuego prejuego) {
		this.prejuego = prejuego;
	}

}
