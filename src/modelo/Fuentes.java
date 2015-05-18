/**
 * sPAIce_invaders.modelo.Fuente.java
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

package modelo;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 * Carga y almacena de manera est�tica todos los tipos de fuentes usados en la aplicacion
 */
public class Fuentes {

   private static final String RUTA_ARCADE_FONT   = "./res/font/ARCADECLASSIC.TTF";
   private static final String RUTA_CHESS_FONT    = "./res/font/ChessType.ttf";
   private static final String RUTA_INVADERS_FONT = "./res/font/invadersfont.ttf";
   private static final String RUTA_SAFETY_FONT   = "./res/font/SafetyMedium.ttf";

   private static Font         arcadeFont;
   private static Font         chessFont;
   private static Font         invadersFont;
   private static Font         safetyFont;

   /**
    * Constructor por defecto, almacena las fuentes a utilizar.
    */
   public Fuentes () {
      File filearcade = new File (RUTA_ARCADE_FONT);
      File filechess = new File (RUTA_CHESS_FONT);
      File fileinvaders = new File (RUTA_INVADERS_FONT);
      File filesafety = new File (RUTA_SAFETY_FONT);

      try {
         setArcadeFont (Font.createFont (Font.TRUETYPE_FONT, filearcade));
         setChessFont (Font.createFont (Font.TRUETYPE_FONT, filechess));
         setInvadersFont (Font.createFont (Font.TRUETYPE_FONT, fileinvaders));
         setSafetyFont (Font.createFont (Font.TRUETYPE_FONT, filesafety));

      } catch (FontFormatException | IOException e) {
         e.printStackTrace ();
      }
   }


   public static Font getSafetyFont () {
      return safetyFont;
   }

   public void setSafetyFont (Font safety) {
      safetyFont = safety;
   }

   public static Font getInvadersFont () {
      return invadersFont;
   }

   public void setInvadersFont (Font invaders) {
      invadersFont = invaders;
   }

   public static Font getChessFont () {
      return chessFont;
   }

   public void setChessFont (Font chess) {
      chessFont = chess;
   }

   public static Font getArcadeFont () {
      return arcadeFont;
   }

   public void setArcadeFont (Font arcade) {
      arcadeFont = arcade;
   }

}
