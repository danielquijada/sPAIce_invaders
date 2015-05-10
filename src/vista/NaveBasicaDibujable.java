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

import java.awt.Graphics;


/**
 * TODO Descripción de la clase.
 */
public class NaveBasicaDibujable extends NaveDibujable {

   /* (non-Javadoc)
    * @see vista.ElementoDibujable#dibujar(java.awt.Graphics, int, int, int, int)
    */
   @Override
   public void dibujar (Graphics g, int x, int y, int tamX, int tamY) {
      g.fillRect (x, y, tamX, tamY);
   }

}
