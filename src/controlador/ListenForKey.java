/**
 * sPAIce_invaders.modelo.ListenForKey.java
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

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import modelo.Estado;
import modelo.Juego;
import modelo.Master;

/**
 * TODO Descripci�n de la clase.
 */
public class ListenForKey implements KeyListener, Observer {

   private Estado estado;

   /**
    * 
    */
   public ListenForKey () {
      setEstado (Master.getInstance ().getEstado ()); //TODO Modificar estado inicial.
      Master.getInstance ().addObserver (this);
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
    */
   @Override
   public void keyTyped (KeyEvent e) {
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
    */
   @Override
   public void keyPressed (KeyEvent e) {
      if (e.getKeyCode () == KeyEvent.VK_LEFT) {
         getEstado ().izquierda ();
      } else if (e.getKeyCode () == KeyEvent.VK_RIGHT) {
         getEstado ().derecha ();
      } else if (e.getKeyCode () == KeyEvent.VK_UP) {
         getEstado ().arriba ();
      } else if (e.getKeyCode () == KeyEvent.VK_DOWN) {
         getEstado ().abajo ();
      } else if (e.getKeyCode () == KeyEvent.VK_SPACE) {
         getEstado ().accion ();
      } else if (e.getKeyCode () == KeyEvent.VK_ESCAPE) {
         getEstado ().salir ();
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
    */
   @Override
   public void keyReleased (KeyEvent e) {
      if (e.getKeyCode () == KeyEvent.VK_LEFT) {
         getEstado ().paraIzquierda ();
      } else if (e.getKeyCode () == KeyEvent.VK_RIGHT) {
         getEstado ().paraDerecha ();
      } else if (e.getKeyCode () == KeyEvent.VK_UP) {
         getEstado ().paraArriba ();
      } else if (e.getKeyCode () == KeyEvent.VK_DOWN) {
         getEstado ().paraAbajo ();
      } else if (e.getKeyCode () == KeyEvent.VK_SPACE) {
         getEstado ().paraAccion ();
      } else if (e.getKeyCode () == KeyEvent.VK_ESCAPE) {
         getEstado ().paraSalir ();
      }
   }
   
   /**
    * @return the estado
    */
   public Estado getEstado () {
      return estado;
   }

   
   /**
    * @param estado the estado to set
    */
   public void setEstado (Estado estado) {
      this.estado = estado;
   }

   /* (non-Javadoc)
    * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
    */
   @Override
   public void update (Observable o, Object arg) {
      setEstado (Master.getInstance ().getEstado ());
   }
}