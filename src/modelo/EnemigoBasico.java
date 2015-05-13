/**
 * sPAIce_invaders.modelo.EnemigoBasico.java
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
 * Clase que describe el enemigo más básico del juego
 * Reúne las caracterísiticas específicas o únicas de este enemigo frente a otro tipo de enemigos.
 */
public class EnemigoBasico extends Enemigo {
	private final int VIDA_ENEMIGO_BASICO = 1;
	
	public EnemigoBasico(int posX, int posY){
		super(posX, posY);
		setVidas(VIDA_ENEMIGO_BASICO);
	}
}
