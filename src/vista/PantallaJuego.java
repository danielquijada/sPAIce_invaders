/**
 * sPAIce_invaders.vista.PantallaJuego.java
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

import java.awt.Graphics;
import modelo.Enemigo;
import modelo.Juego;
import modelo.Nave;
import modelo.NaveBasica;


/**
 * Pantalla en la que se mostrará el juego. Muestra: * Fondo * Actores (nave, enemigos) * HUD
 */
public class PantallaJuego extends Pantalla {

   private static final int TAM = 30;
   private Juego juego;

   /**
    * @param juego
    */
   public PantallaJuego (Juego juego) {
      setJuego (juego);
   }

   /* (non-Javadoc)
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   @Override
   protected void paintComponent (Graphics g) {
      super.paintComponent (g);
      for (Enemigo enemy : getJuego ().getEnemigos ()) {
         new EnemigoBasicoDibujable ().dibujar (g, enemy.getX (), enemy.getY (), TAM, TAM);
      }
      for (Nave nave : getJuego ().getNaves ()) {
         new NaveBasicaDibujable ().dibujar (g, nave.getX(), nave.getY (), TAM, TAM);
      }
   }
   
   /**
    * @return the juego
    */
   public Juego getJuego () {
      return juego;
   }

   /**
    * @param juego
    *           the juego to set
    */
   public void setJuego (Juego juego) {
      this.juego = juego;
   }
}
