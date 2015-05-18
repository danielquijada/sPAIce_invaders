/**
 * sPAIce_invaders.vista.EnemigoBasicoDibujable.java
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

import modelo.Fuentes;

/**
 * Representa la forma de dibujar un enemigo básico concreto.
 */
public class EnemigoOvniDibujable extends EnemigoDibujable {

	private Font font = Fuentes.getInvadersFont();

	public static boolean animacion = false;
	/**
	 * Animaciones
	 * tipo 0: d e
	 * tipo 1: b c
	 * tipo 2: f g
	 * boss : v
	 */
	@Override
	public void dibujar(Graphics g, int x, int y, int tamX, int tipo) {
		g.setColor(Color.RED);
		g.setFont(font.deriveFont(Font.PLAIN, tamX));

		g.drawString("v", x, y);


	}
}
