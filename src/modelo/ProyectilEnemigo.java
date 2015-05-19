/**
 * sPAIce_invaders.modelo.ProyectilEnemigo.java
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
public class ProyectilEnemigo extends ProyectilBasico {

   private static final int VELOCIDAD = 6;
   /**
    * @param posX
    * @param posY
    * @param velocidad
    */
   public ProyectilEnemigo (int posX, int posY, double velocidad) {
      super (posX, posY, velocidad);
   }
   
   /* (non-Javadoc)
    * @see modelo.ProyectilBasico#getVelocidad()
    */
   @Override
   public int getVelocidad () {
      return VELOCIDAD;
   }
}
