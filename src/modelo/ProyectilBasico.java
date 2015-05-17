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
 * Clase que representa un proyectil espec�fico. Con ciertas caracter�sticas
 * �nicas tales como su velocidad.
 */
public class ProyectilBasico extends Proyectil {

	public static final int DAMAGE = 1;
	public static final int VELOCIDAD = -12;

	public ProyectilBasico(int posX, int posY, double velocidad) {
		super(posX, posY);
		setDamage(DAMAGE);
	}

	@Override
	public int getVelocidad() {
		return VELOCIDAD;
	}
}
