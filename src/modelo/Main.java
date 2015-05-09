/**
 * sPAIce_invaders.modelo.Main.java
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

import vista.VentanaJuego;


/**
 * TODO Descripción de la clase.
 */
public class Main {

	
	public static void main(String args[]) {

		ListenForKey lForKey = new ListenForKey();
		Juego juego = new Juego();
		VentanaJuego ventanajuego = new VentanaJuego(juego, lForKey);
		
	}
		
	
}
