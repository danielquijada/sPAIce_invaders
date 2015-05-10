/**
 * sPAIce_invaders.modelo.Main.java
 * Proyecto Final: sPAIce invaders.
 *
 * Asignatura: Programaci�n de Aplicaciones Interactivas.
 * Universidad de La Laguna.
 * Curso: 2014-2015
 *
 * Autores: 
 *    Daniel E. Quijada D�az
 *    Francisco J. Palacios Rodr�guez.
 *    H�ctor Rodr�guez P�rez
 */

package modelo;

import vista.VentanaJuego;


/**
 * TODO Descripci�n de la clase.
 */
public class Main {


   public static void main (String args[]) {

      ListenForKey lForKey = new ListenForKey ();
      Juego juego = new Juego ();
      lForKey.setJuego (juego);
      VentanaJuego ventanaJuego = new VentanaJuego (juego, lForKey);
      ventanaJuego.setVisible (true);
   }


}
