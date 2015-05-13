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
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;


/**
 * Pantalla que muestra el menú con distintas opciones:
 *    * Nuevo Juego
 *    * Cargar Juego
 *    * Settings
 *    * Salir
 *    etc..
 */
@SuppressWarnings("serial")
public class PantallaMenu extends Pantalla implements Observer {

	private static final int OFFSETX = 100;
	private static final int OFFSETY  = 30;
	private static final int SEPARACION = 50; //Separacion vertical entre las opciones
	
	private static final int OFFSETX_SELECTOR = 20;
	private static final int OFFSETY_SELECTOR = 17;
	private static final int DIAMETRO = 15; //Tama�o del selector
	
	private static final String RUTA = "./res/main_background.jpg";
	
	private BufferedImage image;
	
   /**
    * 
    */
   public PantallaMenu () {
	   setBackground(Color.BLACK);

	   setImage(RUTA);
   }


	protected void paintComponent(Graphics g) {
	
			super.paintComponent(g);
			
			int mitad_ancho = getWidth() / 2 - OFFSETX;
			int mitad_alto = getHeight() / 2 - OFFSETY;
			
			g.drawImage(getImage().getScaledInstance(getWidth(), getHeight() / 2, Image.SCALE_SMOOTH), 0, 0, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Monospaced", Font.PLAIN, 30));
			g.drawString("Nuevo Juego", mitad_ancho, mitad_alto);
			g.drawString("Cargar partida", mitad_ancho, mitad_alto + SEPARACION);
			g.drawString("Opciones", mitad_ancho, mitad_alto + (SEPARACION * 2));
			g.drawString("Salir", mitad_ancho, mitad_alto + (SEPARACION * 3));
		   
			g.fillOval(mitad_ancho - OFFSETX_SELECTOR, mitad_alto - OFFSETY_SELECTOR, DIAMETRO, DIAMETRO);
		   
	}


	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		repaint();
		
	}
	
	
	public BufferedImage getImage() {
		return image;
	}
	
	
	public void setImage(String ruta) {
		
		try {
			this.image = ImageIO.read(new File(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
