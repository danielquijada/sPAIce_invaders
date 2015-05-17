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
import java.util.Observable;
import java.util.Observer;
import modelo.Fuentes;
import modelo.Menu;


/**
 * Pantalla que muestra el menú inicial con distintas opciones:
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
	
	private Font fontinv = Fuentes.getInvadersFont().deriveFont(Font.PLAIN, 80);
	private Font fontchess = Fuentes.getChessFont().deriveFont(Font.PLAIN, 80);
	private Font fontarcade = Fuentes.getArcadeFont().deriveFont(Font.PLAIN, 30);
	private Font fontsafety = Fuentes.getSafetyFont().deriveFont(Font.PLAIN, 70);
	
	private static PantallaMenu pantallaMenu;
	private Menu menu;
	
   /**
    * 
    */
   private PantallaMenu () {
	   setBackground(Color.BLACK);
	   setMenu (Menu.getInstance ());
   }

   public static PantallaMenu getInstance () {
      if (getPantallaMenu () == null)
         setPantallaMenu (new PantallaMenu ());
      return getPantallaMenu ();
   }

	protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int mitadAncho = getWidth() / 2 - OFFSETX;
			int mitadAlto = getHeight() / 2 - OFFSETY;
			
			g.setColor(Color.WHITE);
			g.setFont(fontinv);
			g.drawString("BDFL", mitadAncho - 80, 100);
			g.setFont(fontchess);
			g.drawString("SPAICE", mitadAncho - 60, 170);
			g.setFont(fontsafety);
			g.drawString("INVADERS", mitadAncho - 80, 250);		
			g.setFont(fontarcade);
			
			for (int i = 0; i < getMenu ().getOpciones ().size (); i++) {
			   g.drawString (getMenu ().getOpciones ().get (i), mitadAncho, mitadAlto + SEPARACION * i);
			}
			
			g.setColor(Color.RED);
			g.fillOval(mitadAncho - OFFSETX_SELECTOR, mitadAlto + (SEPARACION * getMenu ().getSeleccionada ()) - OFFSETY_SELECTOR, DIAMETRO, DIAMETRO);
		   
	}


	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
		
   
   /**
    * @return the pantallaMenu
    */
   public static PantallaMenu getPantallaMenu () {
      return pantallaMenu;
   }

   
   /**
    * @param pantallaMenu the pantallaMenu to set
    */
   public static void setPantallaMenu (PantallaMenu pantallaMenu) {
      PantallaMenu.pantallaMenu = pantallaMenu;
   }

   
   /**
    * @return the menu
    */
   public Menu getMenu () {
      return menu;
   }

   
   /**
    * @param menu the menu to set
    */
   public void setMenu (Menu menu) {
      this.menu = menu;
   }


}
