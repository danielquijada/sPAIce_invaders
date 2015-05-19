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

/**
 * Elemento abstracto que representa un proyectil.
 */
public abstract class Proyectil extends Inerte {

   public static final int VELOCIDAD = 0;
   public static final int PROYECTIL = -100;

	private int damage;

	public Proyectil(int posX, int posY) {
		setX(posX);
		setY(posY);
		setTipo (PROYECTIL);
	}

	public abstract int getVelocidad();

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getColision() {
		return getDamage();
	}

	public void setColision(int colision) {
		setDamage(colision);
	}
}
