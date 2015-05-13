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
import java.util.ArrayList;

import modelo.Juego;
import modelo.Proyectil;

/**
 * TODO Descripci�n de la clase.
 */
public class ListenForKey implements KeyListener{

   private Juego juego;
  
   
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			//getJuego ().moverNave (0, Juego.IZQUIERDA);
			getJuego ().smoothmoveTimer.start();
			getJuego ().dir = Juego.IZQUIERDA;
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
         //getJuego ().moverNave (0, Juego.DERECHA);
			getJuego ().smoothmoveTimer.start();
			getJuego ().dir = Juego.DERECHA;
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			if(getJuego ().getProyectiles().isEmpty()) {
				getJuego ().disparar (0);				
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			getJuego ().smoothmoveTimer.stop();
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			getJuego ().smoothmoveTimer.stop();
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			ArrayList<Proyectil> aux = getJuego().getProyectiles();
			
		}	
	}

   
   /**
    * @return the juego
    */
   public Juego getJuego () {
      return juego;
   }

   
   /**
    * @param juego the juego to set
    */
   public void setJuego (Juego juego) {
      this.juego = juego;
   }

}
