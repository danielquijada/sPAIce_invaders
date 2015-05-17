/**
 * sPAIce_invaders.vista.Hud.java
 * Proyecto Final: sPAIce invaders.
 *
 * Asignatura: Programaciï¿½n de Aplicaciones Interactivas.
 * Universidad de La Laguna.
 * Curso: 2014-2015
 *
 * Autores: 
 *    Daniel E. Quijada Dï¿½az
 *    Francisco J. Palacios Rodrï¿½guez.
 *    Hï¿½ctor Rodrï¿½guez Pï¿½rez
 */
package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import modelo.Fuentes;
import modelo.Juego;

/**
 * Heads Up Display
 * Representa la información que está siempre visible en pantalla
 * Puntuaciones,vidas y margen inferior.
 */
@SuppressWarnings("serial")
public class Hud extends Pantalla{
	
	private Juego juego;
	
	private static final int OFFSET_X_STRING = 200;
	private static final int OFFSET_Y_STRING = 20;

	private static final int OFFSET_Y_VIDAS = 20;
	private static final int OFFSET_X_VIDAS = 60;

	private static final int OFFSET_LINEAINFERIOR = 70;
	private static final int SEPARACION = 20;
	
	private Font fontArcade = Fuentes.getArcadeFont().deriveFont(Font.PLAIN, 20);
	private Font fontInvader = Fuentes.getInvadersFont().deriveFont(Font.PLAIN, 25);
	private Font normal = new Font("Monospace",Font.PLAIN,20);
	public Hud(Juego juego) {
		setJuego(juego);
		
	}

	
	public void dibujar(Graphics g, int width, int height) {
		//Linea inferior
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.GREEN);
		g2d.setStroke(new BasicStroke(3));
		g2d.drawLine(8, height - OFFSET_LINEAINFERIOR, width - 10, height - OFFSET_LINEAINFERIOR);
		
		g.setColor(Color.WHITE);
		//Caracter especial
		g.setFont(normal);
		g.drawString(":", 75, OFFSET_Y_STRING);
		g.drawString(":", width - 145, OFFSET_Y_STRING);
		//Puntuacion y vidas
		g.setFont(fontArcade);
		g.drawString("PUNTOS   " + getJuego ().getNaves().get(0).getPuntuacion(), 10, OFFSET_Y_STRING);
		g.drawString("VIDAS ", width - OFFSET_X_STRING, OFFSET_Y_STRING);
	
		g.setColor(Color.GREEN);	
		g.setFont(fontInvader);
		if (getJuego().getNaves().get(0).getVidas() == 1) {			
			g.drawString("w",width - OFFSET_X_VIDAS - SEPARACION , OFFSET_Y_VIDAS);
		}
		else if (getJuego().getNaves().get(0).getVidas() == 2) {
			g.drawString("w",width - OFFSET_X_VIDAS - SEPARACION , OFFSET_Y_VIDAS);
			g.drawString("w",width - OFFSET_X_VIDAS - (SEPARACION * 2) , OFFSET_Y_VIDAS);						
		}
		else if(getJuego().getNaves().get(0).getVidas() == 3) {
			g.drawString("w",width - OFFSET_X_VIDAS - SEPARACION , OFFSET_Y_VIDAS);
			g.drawString("w",width - OFFSET_X_VIDAS - (SEPARACION * 2), OFFSET_Y_VIDAS);
			g.drawString("w",width - OFFSET_X_VIDAS - (SEPARACION * 3) , OFFSET_Y_VIDAS);
		}
		
	}
	
	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}
}
