/**
 * sPAIce_invaders.controlador.OyenteTimers.java
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

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Juego;


/**
 * Oyente simple para el timer del bucle de juego.
 */
public class OyenteTimers implements ActionListener {

   /*
    * (non-Javadoc)
    * 
    * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
    */
   @Override
   public void actionPerformed (ActionEvent e) {
      Juego.getInstance ().step ();
   }
}
