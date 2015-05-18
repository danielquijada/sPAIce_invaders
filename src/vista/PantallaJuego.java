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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import modelo.Enemigo;
import modelo.Juego;
import modelo.Nave;
import modelo.Proyectil;


/**
 * Pantalla en la que se mostrará el juego. 
 *  Muestra: * Fondo * Actores (nave, enemigos) * Proyectiles * HUD
 */
@SuppressWarnings ("serial")
public class PantallaJuego extends Pantalla implements Observer {

   private static final int     TAMX = 5; //tama�o del proyectil
   private static final int		TAMY = 10;
   private Juego                juego;
   private static PantallaJuego pantallaJuego;
   private Image img = Toolkit.getDefaultToolkit().getImage("./res/img/ingame_background.png");
   
   /**
    * @param juego
    */
   private PantallaJuego (Juego juego) {
      setJuego (juego);
      setBackground(Color.BLACK);
      
   }

   public static PantallaJuego getInstance () {
      if (getPantallaJuego () == null)
         setPantallaJuego (new PantallaJuego (Juego.getInstance ()));
      return getPantallaJuego ();
   }

   /*
    * (non-Javadoc)
    * 
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   @Override
   protected void paintComponent (Graphics g) {
      super.paintComponent (g);
      g.drawImage(img, 0, 0,getWidth(),getHeight(), null);
      Iterator<Enemigo> iter = getJuego ().getEnemigos ().iterator ();

      while (iter.hasNext ()) {
         Enemigo enemy = iter.next ();
         if (enemy.isVivo ()) {
            int x = (int) ((double) enemy.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
            int y = (int) ((double) enemy.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
            int tamX = (int) ((enemy.getSize ().getX () * getHeight ()) / (double) Juego.TOTAL_X);
            int tamY = (int) ((enemy.getSize ().getY () * getHeight ()) / (double) Juego.TOTAL_Y);
            new EnemigoBasicoDibujable ().dibujar (g, x, y, tamX, enemy.getTipo());
         }
      }

      for (Enemigo ovni : getJuego ().getEnemigosEspeciales() ) {
    	  if(ovni.isVivo()){
	          int x = (int) ((double) ovni.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
	          int y = (int) ((double) ovni.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
	          int tamX = (int) ((ovni.getSize ().getX () * getHeight ()) / (double) Juego.TOTAL_X);
	          int tamY = (int) ((ovni.getSize ().getY () * getHeight ()) / (double) Juego.TOTAL_Y);
	          new EnemigoOvniDibujable ().dibujar (g, x, y, tamX, tamY);
    	  }
       }
    	  

      Iterator<Proyectil> it = getJuego ().getProyectiles ().iterator ();

      while (it.hasNext ()) {
         Proyectil proyectil = it.next ();
         int x = (int) ((double) proyectil.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
         int y = (int) ((double) proyectil.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
         new ProyectilBasicoDibujable ().dibujar (g, x, y, proyectil.getSize ().x,proyectil.getSize ().y);
         if (proyectil.getY () < 0) {
            it.remove ();
         }
      }

      // HUD
      new Hud (getJuego ()).dibujar (g, getWidth (), getHeight());

      for (Nave nave : getJuego ().getNaves ()) {
         int x = (int) ((double) nave.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
         int y = (int) ((double) nave.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
         int tamX = (int) ((nave.getSize ().getX () * getHeight ()) / (double) Juego.TOTAL_X);
         int tamY = (int) ((nave.getSize ().getY () * getHeight ()) / (double) Juego.TOTAL_Y);
         new NaveBasicaDibujable ().dibujar (g, x, y, tamX, tamY);
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

   /*
    * (non-Javadoc)
    * 
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update (Observable o, Object arg) {
      repaint ();
   }


   /**
    * @return the pantallaJuego
    */
   public static PantallaJuego getPantallaJuego () {
      return pantallaJuego;
   }


   /**
    * @param pantallaJuego
    *           the pantallaJuego to set
    */
   public static void setPantallaJuego (PantallaJuego pantallaJuego) {
      PantallaJuego.pantallaJuego = pantallaJuego;
   }
}
