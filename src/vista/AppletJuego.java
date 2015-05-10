/**
 * sPAIce_invaders.vista.AppletJuego.java
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

package vista;

import javax.swing.JApplet;
import modelo.Juego;
import modelo.ListenForKey;


/**
 * TODO Descripción de la clase.
 */
public class AppletJuego extends JApplet {

   private static final int ANCHO = 800;
   private static final int ALTO = ANCHO;
   
   private PantallaJuego juego;

   /**
    * @param juego
    * @param lForKey
    */
   public AppletJuego (Juego juego) {
      setJuego (new PantallaJuego (juego));
      add (getJuego ());
      setSize (ANCHO, ALTO);
      setPreferredSize (getSize ());
   }

   /**
    * @return the juego
    */
   public PantallaJuego getJuego () {
      return juego;
   }

   /**
    * @param juego
    *           the juego to set
    */
   public void setJuego (PantallaJuego juego) {
      this.juego = juego;
   }
}
