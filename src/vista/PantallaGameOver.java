/**
 * sPAIce_invaders.vista.PantallaGameOver.java
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
import modelo.GameOver;
import modelo.PreJuego;

/**
 * Muestra un texto indicando que la partida ha acabado
 */
@SuppressWarnings("serial")
public class PantallaGameOver extends Pantalla implements Observer{

	private static final int OFFSETX = 100;
	private static final int OFFSETY = 30;
	
	private Font fontarcade = Fuentes.getArcadeFont().deriveFont(Font.PLAIN, 30);
	private Font fontinv = Fuentes.getInvadersFont().deriveFont(Font.PLAIN, 80);
	
	private static PantallaGameOver pantallaGameOver;
	private GameOver gameover;
	
	private PantallaGameOver() {
		setBackground(Color.BLACK);
	}
	
	public static PantallaGameOver getInstance () {
	      if (getPantallaGameOver () == null)
	         setPantallaGameOver (new PantallaGameOver ());
	      return getPantallaGameOver ();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int mitadAncho = getWidth() / 2 - OFFSETX;
		int mitadAlto = getHeight() / 2 - OFFSETY;
		
		g.setColor(Color.WHITE);
		g.setFont(fontinv);
		g.drawString("B", mitadAncho, mitadAlto - OFFSETY);
		g.setFont(fontarcade);
		g.drawString("GAME OVER", mitadAncho, mitadAlto);
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	public static PantallaGameOver getPantallaGameOver() {
		return pantallaGameOver;
	}

	public static void setPantallaGameOver(PantallaGameOver pantallaGameOver) {
		PantallaGameOver.pantallaGameOver = pantallaGameOver;
	}

	public GameOver getGameover() {
		return gameover;
	}

	public void setGameover(GameOver gameover) {
		this.gameover = gameover;
	}

}
