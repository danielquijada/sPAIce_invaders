/**
 * sPAIce_invaders.modelo.EnemigoBasico.java
 * Proyecto Final: sPAIce invaders.
 *
 * Asignatura: ProgramaciÃ³n de Aplicaciones Interactivas.
 * Universidad de La Laguna.
 * Curso: 2014-2015
 *
 * Autores: 
 *    Daniel E. Quijada DÃ­az
 *    Francisco J. Palacios RodrÃ­guez.
 *    HÃ©ctor RodrÃ­guez PÃ©rez
 */

package modelo;

/**
 * Clase que describe el enemigo más básico del juego Reúne las caracterísiticas específicas o únicas de este enemigo
 * frente a otro tipo de enemigos.
 */
public class EnemigoBasico extends Enemigo {

   public static final int ANCHO = 40;
   public static final int ALTO  = 40;
   private final int        VIDAS = 1;

   public EnemigoBasico (int posX, int posY, int tipo) {
      super (posX, posY,tipo);
      setSize (ANCHO, ALTO);
      setVidas (VIDAS);
   }

}
