/**
 * sPAIce_invaders.vista.NaveBasicaDibujable.java
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
 * TODO Descripción de la clase.
 */
public class NaveBasicaDibujable extends NaveDibujable {

	private Font font = Fuentes.getInvadersFont();
	
   /* (non-Javadoc)
    * @see vista.ElementoDibujable#dibujar(java.awt.Graphics, int, int, int, int)
    */
   @Override
   public void dibujar (Graphics g, int x, int y, int tamX, int tamY) {
	   g.setFont(font.deriveFont(Font.PLAIN, tamX));
	   g.setColor(Color.GREEN);
	   g.drawString("w", x, y);
   }

}
