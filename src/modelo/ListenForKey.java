/**
 * sPAIce_invaders.modelo.ListenForKey.java
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
package modelo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * TODO Descripción de la clase.
 */
public class ListenForKey implements KeyListener{

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("Left pressed");
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("Right pressed");
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("Space pressed");
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("Left released");
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			System.out.println("Right released");
		}
		else if (e.getKeyCode() == KeyEvent.VK_SPACE){
			System.out.println("Space released");
		}	}

}
