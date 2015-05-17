/**
 * sPAIce_invaders.modelo.NaveBasica.java
 * Proyecto Final: sPAIce invaders.
 *
 * Asignatura: ProgramaciÃ³n de Aplicaciones Interactivas.
 * Universidad de La Laguna.
 * Curso: 2014-2015
 *
 * Autores: 
 *    Daniel E. Quijada DÃ­az
 *    Francisco J. Palacios RodrÃ­guez.
 *    HÃ©ctor RodrÃ­guez PÃ©rez
 */
package modelo;

/**
 * Clase que representa un tipo de nave específica. Reúne aquellas
 * características específicas o únicas y capacidades de una nave básica frente
 * a los demás.
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
