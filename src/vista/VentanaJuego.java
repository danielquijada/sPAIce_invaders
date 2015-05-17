/**
 * sPAIce_invaders.vista.VentanaJuego.java
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

import javax.swing.JFrame;

import controlador.ListenForKey;



/**
 * TODO Descripción de la clase.
 */
@SuppressWarnings("serial")
public class VentanaJuego extends JFrame {

   private AppletJuego applet;
   /**
    * @param juego
    * @param lForKey
    */
   public VentanaJuego (ListenForKey lForKey) {
      setTitle ("sPAIce invaders");
      setDefaultCloseOperation (EXIT_ON_CLOSE);
      addKeyListener (lForKey);
      setApplet (new AppletJuego ());
      add (getApplet ());
      pack ();
      setLocationRelativeTo (null);
   }
   
   /**
    * @return the applet
    */
   public AppletJuego getApplet () {
      return applet;
   }
   
   /**
    * @param applet the applet to set
    */
   public void setApplet (AppletJuego applet) {
      this.applet = applet;
   }
}
