/**
 * sPAIce_invaders.modelo.Enemigos.java
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
 * Clase que describe la l�gica de los enemigos, que son entidades vivas capaces
 * de disparar. No son controlables por el usuario.
 */
public abstract class Enemigo extends Vivo {

	public Enemigo(int posX, int posY) {
		setX(posX);
		setY(posY);
	}
}
