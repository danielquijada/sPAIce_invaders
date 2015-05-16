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

import modelo.EnemigoBasico;
import modelo.Fuentes;
import modelo.Juego;


/**
 * Representa la forma de dibujar un enemigo básico concreto.
 */
public class EnemigoBasicoDibujable extends EnemigoDibujable {

   /* (non-Javadoc)
    * @see vista.ElementoDibujable#dibujar(java.awt.Graphics, int, int, int, int)
    */
   @Override
   public void dibujar (Graphics g, int x, int y, Juego juego) {
	   g.setColor(Color.WHITE);
	   g.fillOval (x, y, EnemigoBasico.ALTO, EnemigoBasico.ANCHO);
   }
}
