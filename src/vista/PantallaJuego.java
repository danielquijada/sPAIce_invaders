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
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import modelo.Enemigo;
import modelo.Juego;
import modelo.Nave;
import modelo.Proyectil;
import modelo.Tabla;


/**
 * Pantalla en la que se mostrará el juego. Muestra: * Fondo * Actores (nave, enemigos) * HUD
 */
@SuppressWarnings ("serial")
public class PantallaJuego extends Pantalla implements Observer {

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
      Tabla t = getJuego ().getEnemigos ();
      Iterator<Enemigo> iter = getJuego ().getEnemigos ().iterator ();
      Iterator<Proyectil> it = getJuego ().getProyectiles ().iterator ();
      
      while (iter.hasNext ()) {
         Enemigo enemy = iter.next ();
         int x = (int)((double)enemy.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
         int y = (int)((double)enemy.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
         new EnemigoBasicoDibujable ().dibujar (g, x, y, TAM, TAM);
      }
      
      for (Nave nave : getJuego ().getNaves ()) {
         int x = (int)((double)nave.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
         int y = (int)((double)nave.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
         new NaveBasicaDibujable ().dibujar (g, x , y, TAM, TAM);
      }
      
      while(it.hasNext()){
    	  Proyectil proyectil = it.next();
          int x = (int)((double)proyectil.getX () * (double) getWidth () / (double) Juego.TOTAL_X);
          int y = (int)((double)proyectil.getY () * (double) getHeight () / (double) Juego.TOTAL_Y);
          new ProyectilBasicoDibujable ().dibujar (g, x, y, TAM, TAM);                    
    	  if (proyectil.getY() < 0) {
        	  it.remove();
    	  }
      }
  
      //HUD
      new Hud (getJuego ()).dibujar(g,getWidth());
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

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update (Observable o, Object arg) {
      repaint ();
   }
}
