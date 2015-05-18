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
 * Interfaz genérica "Estado". Describe acciones distintas a realizar al presionar distintos botones.
 */
public interface Estado {

   public abstract void izquierda ();

   public abstract void derecha ();

   public abstract void arriba ();

   public abstract void abajo ();

   public abstract void accion ();

   public abstract void salir ();

   public abstract void paraIzquierda ();

   public abstract void paraDerecha ();

   public abstract void paraArriba ();

   public abstract void paraAbajo ();

   public abstract void paraAccion ();

   public abstract void paraSalir ();
}
