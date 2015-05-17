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
public class EnemigoBasicoDibujable extends EnemigoDibujable {

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
		g.setColor(Color.WHITE);
		g.setFont(font.deriveFont(Font.PLAIN, tamX));

		if (!animacion) {
			if (tipo == 0) {
				g.drawString("d", x, y);
			} else if (tipo == 1) {
				g.drawString("c", x, y);
			} else if (tipo == 2) {
				g.drawString("g", x, y);
			}			
		}
		else {
			if (tipo == 0) {
				g.drawString("e", x, y);
			} else if (tipo == 1) {
				g.drawString("b", x, y);
			} else if (tipo == 2) {
				g.drawString("f", x, y);
			}
		}


	}
}
