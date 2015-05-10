/**
 * sPAIce_invaders.modelo.Elemento.java
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
 * Clase para describir todo elemento del juego, desde enemigos y naves hasta proyectiles y escudos
 */
public abstract class Elemento {
	
   /**
    * 
    */
	
	private Point coordenadas;
	
   public Elemento () {
	   
   }

   public int getX() {
		return (int) coordenadas.getX();
   }
	
	public void setX(int x) {
		this.coordenadas.x = x;
	}
	
	public int getY() {
		return (int) coordenadas.getY();
	}
	
	public void setY(int y) {
		this.coordenadas.y = y;
	}

	public Point getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Point coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	
   
   

}
