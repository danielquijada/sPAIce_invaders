/**
 * sPAIce_invaders.modelo.Enemigos.java
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
 * Clase que describe la l�gica de los enemigos, que son entidades vivas capaces de disparar. No son controlables por el
 * usuario.
 */
public abstract class Enemigo extends Vivo {

   public static final int TRIANGULAR = 0; // Tipo de enemigo. Sólo son visualmente diferentes en principio.
   public static final int ANTENAS = 1;
   public static final int REDONDO = 2;
   public static final int NODRIZA = 3;
   
   public Enemigo (int posX, int posY, int tipo) {
      setX (posX);
      setY (posY);
      setTipo (tipo);
   }
}
