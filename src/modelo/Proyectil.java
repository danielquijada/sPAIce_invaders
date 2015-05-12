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

   /**
    * 
    */
	public static final double ZERO = 0.0;
	public static final int DESPLAZAMIENTO_BASICO = 15;
	private double tiempo;
	private double velocidad;
	private Point posInicial;
	
   public Proyectil (int posX, int posY) {
      setTiempo(ZERO);
      setX(posX);
      setY(posY);
      posInicial = new Point(posX, posY);
   }
   
   public void calcularNuevaPosicion(){
	   setY(getY() - DESPLAZAMIENTO_BASICO);
   }

	public double getTiempo() {
		return tiempo;
	}
	
	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	
	
   
   

}
