/**
 * sPAIce_invaders.modelo.NaveBasica.java
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
 * Clase que representa un tipo de nave específica.
 * Reúne aquellas características específicas o únicas y capacidades de una nave básica frente a los demás.
 */
public class NaveBasica extends Nave {

	private final int VIDA_NAVE_BASICA = 3;
	
	public NaveBasica(int posX, int posY){
		super(posX, posY);
		setVida(VIDA_NAVE_BASICA);
	}

}
