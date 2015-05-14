/**
 * sPAIce_invaders.modelo.Fuente.java
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

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 * TODO Descripción de la clase.
 */
public class Fuentes {

	private static final String RUTA_ARCADE_FONT = "./res/font/ARCADECLASSIC.TTF";
	private static final String RUTA_CHESS_FONT = "./res/font/ChessType.ttf";
	private static final String RUTA_INVADERS_FONT = "./res/font/invadersfont.ttf";
	private static final String RUTA_SAFETY_FONT = "./res/font/SafetyMedium.ttf";
	
	private Font arcadeFont;
	private Font chessFont;
	private Font invadersFont;
	private Font safetyFont;
	
	public Fuentes() {
	    File filearcade = new File(RUTA_ARCADE_FONT);
	    File filechess = new File(RUTA_CHESS_FONT);
	    File fileinvaders = new File(RUTA_INVADERS_FONT);
	    File filesafety = new File(RUTA_SAFETY_FONT);
	    
	    try {
	    	setArcadeFont(Font.createFont(Font.TRUETYPE_FONT, filearcade));
	    	setChessFont(Font.createFont(Font.TRUETYPE_FONT, filechess));
	    	setInvadersFont(Font.createFont(Font.TRUETYPE_FONT, fileinvaders));
	    	setSafetyFont(Font.createFont(Font.TRUETYPE_FONT, filesafety));
	    }
	    catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}


	public Font getSafetyFont() {
		return safetyFont;
	}

	public void setSafetyFont(Font safety) {
		this.safetyFont = safety;
	}

	public Font getInvadersFont() {
		return invadersFont;
	}

	public void setInvadersFont(Font invadersFont) {
		this.invadersFont = invadersFont;
	}

	public Font getChessFont() {
		return chessFont;
	}

	public void setChessFont(Font chessFont) {
		this.chessFont = chessFont;
	}

	public Font getArcadeFont() {
		return arcadeFont;
	}

	public void setArcadeFont(Font arcadeFont) {
		this.arcadeFont = arcadeFont;
	}
}
