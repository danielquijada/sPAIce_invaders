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

import java.util.Observable;
import java.util.Observer;
import javax.swing.JApplet;
import modelo.Master;


/**
 * TODO Descripción de la clase.
 */
public class AppletJuego extends JApplet implements Observer {

   private static final int ANCHO = 800;
   private static final int ALTO = ANCHO;

   /**
    * @param juego
    * @param lForKey
    */
   public AppletJuego () {
      add (Master.getInstance ().getPantalla ());
      setSize (ANCHO, ALTO);
      setPreferredSize (getSize ());
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update (Observable o, Object arg) {
      add (Master.getInstance ().getPantalla ());
      validate ();
   }
}
