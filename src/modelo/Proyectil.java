/**
 * sPAIce_invaders.modelo.Proyectiles.java
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
package modelo;

import java.awt.Point;


/**
 * Elemento abstracto que representa un proyectil.
 */
public abstract class Proyectil extends Inerte {

   public static final int VELOCIDAD = 0;
   public Proyectil (int posX, int posY) {
      setX(posX);
      setY(posY);
   }
   /**
    * @return
    */
   public abstract int getVelocidad ();
}
