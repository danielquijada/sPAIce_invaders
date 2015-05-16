/**
 * sPAIce_invaders.vista.ElementoDibujable.java
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

import modelo.Juego;


/**
 * Clase abstracta que representa a todos los objetos dibujables.
 */
public abstract class ElementoDibujable {

   /**
    * @param g Graphics en la que se dibujará.
    * @param x Coordenada X.
    * @param y Coordenada Y.
    * @param tamX Tamaño en el eje X.
    * @param tamY Tamaño en el eje Y.
    */
   public abstract void dibujar (Graphics g, int x, int y, Juego juego);
}
