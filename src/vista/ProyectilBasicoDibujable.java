/**
 * sPAIce_invaders.vista.ProyectilDibujable.java
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
import java.awt.Graphics;


/**
 * Representa los proyectiles dibujables.
 */
public  class ProyectilBasicoDibujable extends InerteDibujable {

	   @Override
	   public void dibujar (Graphics g, int x, int y, int tamX, int tamY) {
		   g.setColor(Color.WHITE);
         g.fillRect (x, y, tamX, tamY);
	   }
}
