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

package controlador;

import modelo.Fuentes;
import modelo.Juego;
import modelo.Master;
import modelo.Menu;
import vista.PantallaJuego;
import vista.PantallaMenu;
import vista.VentanaJuego;


/**
 * Simple Main que inicializa lo necesario.
 */
public class Main {


   public static void main (String args[]) {

	  new Fuentes();
      Juego juego = Juego.getInstance ();
      VentanaJuego ventanaJuego = new VentanaJuego (new ListenForKey ()); // Añade a la ventana el KeyListener.
      Master.getInstance ().addObserver (ventanaJuego.getApplet ()); // Añade observers.
      juego.addObserver (PantallaJuego.getInstance ());
      Menu.getInstance ().addObserver (PantallaMenu.getInstance ());
      ventanaJuego.setVisible (true);
   }


}
