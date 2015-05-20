/**
 * sPAIce_invaders.vista.PantallaHiScores.java
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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import modelo.Fuentes;
import modelo.HiScores;


/**
 * Clase que muestra la tabla de puntuaciones.
 */
public class PantallaHiScores extends Pantalla {

   private HiScores                hiScores;
   private static PantallaHiScores pantallaHiScores;

   private PantallaHiScores () {
      setHiScores (HiScores.getInstance ());
      setBackground (Color.BLACK);
   }
   /*
    * (non-Javadoc)
    * 
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   @Override
   protected void paintComponent (Graphics g) {
      super.paintComponent (g);
      Font fontarcade = Fuentes.getArcadeFont ().deriveFont (Font.PLAIN, 50);
      g.setColor (Color.WHITE);
      g.setFont (fontarcade);
      g.drawString ("Puntuaciones", getWidth () / 2 - getWidth () / 6, getHeight () / 20);

      for (int i = 0; i < getHiScores ().getJugadores ().size (); i++) {
         int altura = getHeight () * (i + 1) / (getHiScores ().getJugadores ().size () + 1);
         g.drawString ((i + 1) + "", getWidth () * 2 / 10, altura);
         g.drawString (getHiScores ().getJugadores ().get (i), getWidth () * 4 / 10, altura);
         g.drawString ("" + getHiScores ().getPuntuaciones ().get (i), getWidth () * 7 / 10, altura);
      }
   }


   /**
    * @return the pantallaHiScores
    */
   public static PantallaHiScores getPantallaHiScores () {
      return pantallaHiScores;
   }


   /**
    * @param pantallaHiScores
    *           the pantallaHiScores to set
    */
   public static void setPantallaHiScores (PantallaHiScores pantallaHiScores) {
      PantallaHiScores.pantallaHiScores = pantallaHiScores;
   }



   /**
    * @return the hiScores
    */
   public HiScores getHiScores () {
      return hiScores;
   }



   /**
    * @param hiScores
    *           the hiScores to set
    */
   public void setHiScores (HiScores hiScores) {
      this.hiScores = hiScores;
   }


   /**
    * @return
    */
   public static Pantalla getInstance () {
      if (getPantallaHiScores () == null)
         setPantallaHiScores (new PantallaHiScores ());
      return getPantallaHiScores ();
   }
}
