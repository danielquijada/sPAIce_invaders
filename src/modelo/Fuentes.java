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

	private final String path_arcade = "./res/font/ARCADECLASSIC.TTF";
	private final String path_chess = "./res/font/ChessType.ttf";
	private final String path_invaders = "./res/font/invadersfont.ttf";
	private final String path_safety = "./res/font/SafetyMedium.ttf";
	
	private Font arcadeFont;
	private Font chessFont;
	private Font invadersFont;
	private Font safetyFont;
	
	public Fuentes() {
	    File filearcade = new File(path_arcade);
	    File filechess = new File(path_chess);
	    File fileinvaders = new File(path_invaders);
	    File filesafety = new File(path_safety);
	    
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
