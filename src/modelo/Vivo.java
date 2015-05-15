/**
 * sPAIce_invaders.modelo.Vivos.java
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
 * Clase abstracta que representa a todos los objetos que tienen vida.
 */
public abstract class Vivo extends Elemento {

   private int vidas;
   
   public void moverX(int desplazamiento){
	   setX(getX() + desplazamiento);
   }
   
   public void moverY(int desplazamiento){
	   setY(getY() + desplazamiento);
   }

   /**
    * @return the vidas
    */
   public int getVidas () {
      return vidas;
   }
   
   /**
    * @param vidas the vidas to set
    */
   public void setVidas (int vidas) {
      this.vidas = vidas;
   }

   public boolean isVivo () {
      return (getVidas () > 0);
   }
   
   public int getColision () {
      return getVidas ();
   }
   
   public void setColision (int colision) {
      setVidas (colision);
   }
}
