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
import controlador.ListenForKey;
import modelo.Juego;


/**
 * TODO Descripción de la clase.
 */
public class AppletJuego extends JApplet {

   private static final int ANCHO = 800;
   private static final int ALTO = ANCHO;
   
   private PantallaJuego pantallaJuego;

   /**
    * @param juego
    * @param lForKey
    */
   public AppletJuego (Juego juego) {
      setPantallaJuego (new PantallaJuego (juego));
      add (getPantallaJuego ());
      setSize (ANCHO, ALTO);
      setPreferredSize (getSize ());
   }

   
   /**
    * @return the pantallaJuego
    */
   public PantallaJuego getPantallaJuego () {
      return pantallaJuego;
   }

   
   /**
    * @param pantallaJuego the pantallaJuego to set
    */
   public void setPantallaJuego (PantallaJuego pantallaJuego) {
      this.pantallaJuego = pantallaJuego;
   }
}
