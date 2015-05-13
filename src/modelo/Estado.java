/**
 * sPAIce_invaders.modelo.Estado.java
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


/**
 * TODO Descripción de la clase.
 */
interface Estado {

   public abstract void izquierda ();
   public abstract void derecha ();
   public abstract void arriba ();
   public abstract void abajo ();
   public abstract void accion ();
   public abstract void salir ();
}
