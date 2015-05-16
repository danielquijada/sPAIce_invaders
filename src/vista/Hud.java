/**
 * sPAIce_invaders.vista.Hud.java
 * Proyecto Final: sPAIce invaders.
 *
 * Asignatura: Programaci�n de Aplicaciones Interactivas.
 * Universidad de La Laguna.
 * Curso: 2014-2015
 *
 * Autores: 
 *    Daniel E. Quijada D�az
 *    Francisco J. Palacios Rodr�guez.
 *    H�ctor Rodr�guez P�rez
 */
package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import modelo.Juego;

/**
 * TODO Descripci�n de la clase.
 */
@SuppressWarnings("serial")
public class Hud extends Pantalla{
	
	private Juego juego;
	
	private static final int OFFSET_X_STRING = 200;
	private static final int OFFSET_Y_STRING = 20;

	private static final int OFFSET_Y_VIDAS = 10;
	private static final int OFFSET_X_VIDAS = 50;
	
	private static final int SEPARACION = 20;
	
	private Font font1 = new Font("Monospaced", Font.BOLD, 20);
	
	public Hud(Juego juego) {
		setJuego(juego);
		
	}

	
	public void dibujar(Graphics g, int width, int height) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(8, height - 70, width - 10, height - 70);
		
		g.setColor(Color.WHITE);
		g.setFont(font1);
		g.drawString("Puntuacion: " + getJuego ().getNaves().get(0).getPuntiacion(), 10, OFFSET_Y_STRING);
		g.drawString("Vidas: ", width - OFFSET_X_STRING, OFFSET_Y_STRING);
	
		g.setColor(Color.red);	
		if (getJuego().getNaves().get(0).getVidas() == 1) {
			g.fillOval(width - OFFSET_X_VIDAS - SEPARACION , OFFSET_Y_VIDAS, 10, 10);			
		}
		else if (getJuego().getNaves().get(0).getVidas() == 2) {
			g.fillOval(width - OFFSET_X_VIDAS - SEPARACION, OFFSET_Y_VIDAS, 10, 10);						
			g.fillOval(width - OFFSET_X_VIDAS - (SEPARACION * 2), OFFSET_Y_VIDAS, 10, 10);						
		}
		else if(getJuego().getNaves().get(0).getVidas() == 3) {
			g.fillOval(width - OFFSET_X_VIDAS - SEPARACION, OFFSET_Y_VIDAS, 10, 10);						
			g.fillOval(width - OFFSET_X_VIDAS - (SEPARACION * 2), OFFSET_Y_VIDAS, 10, 10);					
			g.fillOval(width - OFFSET_X_VIDAS - (SEPARACION * 3), OFFSET_Y_VIDAS, 10, 10);									
		}
		
	}
	
	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
}
