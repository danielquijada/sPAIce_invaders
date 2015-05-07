/**
 * sPAIce_invaders.vista.PantallaMenu.java
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Pantalla que muestra el menú con distintas opciones:
 *    * Nuevo Juego
 *    * Cargar Juego
 *    * Settings
 *    * Salir
 *    etc..
 */
@SuppressWarnings("serial")
public class PantallaMenu extends Pantalla {

	private static final int ALTO = 700;
	private static final int ANCHO = 600;
	
	private static final int VERTICAL_GAP = 50; //Separacion vertical entre las opciones
	private static final int OFFSETX = 250; //Separacion desde el borde izquierdo
	private static final int OFFSETY = 250; //Separacion desde el borde superior
	
	private static final int DIAMETRO = 15; //Tama�o del selector
	private static int selector = OFFSETY; //Posicion inicial del selector
	
	private ListenForKey lForKey = new ListenForKey();

	public static void main(String args[]) {
		
		JFrame frame = new JFrame("SPAICE INVADERS");
		frame.setSize(ANCHO,ALTO);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(new PantallaMenu()); 
		
		frame.setVisible(true);	
	}
	
   /**
    * 
    */
   public PantallaMenu () {
		setBackground(Color.BLACK);
		addKeyListener(lForKey);
		setFocusable(true);
   }
   
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Monospaced", Font.PLAIN, 30));
		g.drawString("Play", OFFSETX, OFFSETY);
		g.drawString("Settings", OFFSETX, OFFSETY + VERTICAL_GAP);
		g.drawString("Exit", OFFSETX, OFFSETY + (VERTICAL_GAP * 2));

		g.fillOval(OFFSETX - 20, selector - 17, DIAMETRO, DIAMETRO);
	}
	
	private class ListenForKey implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {		
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				if (selector == OFFSETY) { //Si estas en la posicion inicial y le das arriba cambias al ultimo
					selector = OFFSETY + (VERTICAL_GAP * 2);					
					repaint();		
				}
				else {
					selector = selector - VERTICAL_GAP;
					repaint();
				}
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (selector == OFFSETY + (VERTICAL_GAP * 2)) {
					selector = OFFSETY;					
					repaint();
					}
				else {
					selector = selector + VERTICAL_GAP;
					repaint();
				}
			}	
			else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (selector == OFFSETY) {
					//Start
					System.out.println("startgame");
				}
				else if (selector == OFFSETY + VERTICAL_GAP) {
					//Settings
					System.out.println("settings");
				}
				else if (selector == OFFSETY + (VERTICAL_GAP * 2)){
					//Exit
					System.out.println("exit");		
				}
			}			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
}
