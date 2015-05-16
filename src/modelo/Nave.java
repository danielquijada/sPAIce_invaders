/**
 * sPAIce_invaders.modelo.Nave.java
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
 * Clase que describe el elemento vivo "Nave". Es la unidad controlada por el usuario.
 * La nave tiene una vida determinada, es capaz de moverse en horizontal y disparar hacia arriba.
 */
public abstract class Nave extends Vivo {

	private int puntuacion;
	
	public Nave(int posX, int posY){
		setX(posX);
		setY(posY);
	}
 
	public int getPuntuacion() {
		return puntuacion;
	}
	
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
}
