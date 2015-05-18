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
 * Clase que representa un tipo de nave espec�fica. Re�ne aquellas
 * caracter�sticas espec�ficas o �nicas y capacidades de una nave b�sica frente
 * a los dem�s.
 */
public class NaveBasica extends Nave {

	public static final int ALTO = 70;
	public static final int ANCHO = 70;
	private final int VIDA_NAVE_BASICA = 3;
	private int puntuacion_inicial = 0;

	public NaveBasica(int posX, int posY) {
		super(posX, posY);
		setVidas(VIDA_NAVE_BASICA);
		setSize(ANCHO, ALTO);
		setPuntuacion(puntuacion_inicial);
	}
}
