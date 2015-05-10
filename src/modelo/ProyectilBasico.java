/**
 * sPAIce_invaders.modelo.ProyectilBasico.java
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
 * Clase que representa un proyectil específico. Con ciertas características únicas tales como su velocidad.
 */
public class ProyectilBasico extends Proyectil {
	private final int VELOCIDAD_PROYECTI_BASICO = 1;
	
	public ProyectilBasico(int posX, int posY, double velocidad){
		super(posX, posY);
		setVelocidad(VELOCIDAD_PROYECTI_BASICO);
	}

}
