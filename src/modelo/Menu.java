/**
 * sPAIce_invaders.modelo.Menu.java
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Contiene las opciones del menu principal Nuevo juego, continar, opciones,
 * salir.
 */
public class Menu extends Observable implements Estado {

	private static final String NEW = "Nuevo Juego";
	private static final String LOAD = "Continuar";
	private static final String HIS = "High Scores";
	private static final String EXIT = "Salir";
	private ArrayList<String> opciones;
	private int seleccionada;
	private static Clip musicaFondo;

	private static Menu menu;

	/**
	 * Crea una lista de opciones para el menu principal
	 */
	private Menu() {
		sonidoMenu();
		setSeleccionada(0);
		setOpciones(new ArrayList<String>());
		getOpciones().add(NEW);
      getOpciones().add(LOAD);
      getOpciones().add(HIS);
		getOpciones().add(EXIT);
	}

	/**
	 * Crea una instancia de Menu
	 * @return
	 */
	public static Menu getInstance() {
		if (getMenu() == null)
			setMenu(new Menu());
		return getMenu();
	}

	/**
	 * Elige la opcion actualmente marcada y cambia la pantalla de menu por la elegida
	 */
	private void seleccionar() {
		musicaFondo.stop();
		sonidoSeleccionarOpcion();
		switch (getOpciones().get(seleccionada)) {
		case NEW:
			Juego.getInstance().nuevo();
			Master.getInstance().cambiarEstado(Master.JUEGO);
			break;
      case LOAD:
         Master.getInstance().cambiarEstado(Master.JUEGO);
         break;
      case HIS:
         Master.getInstance().cambiarEstado(Master.HISCORES);
         break;
		case EXIT:
			System.exit(0);
			break;
		}
	}

	/**
	 * Selecciona la opcion actual
	 */
	@Override
	public void derecha() {
		seleccionar();
		setChanged();
		notifyObservers();
	}

	/**
	 * Mueve el selector a la opcion de arriba
	 */
	@Override
	public void arriba() {
		sonidoCambiarOpcion();
		setSeleccionada((getSeleccionada() - 1 + getOpciones().size())
				% getOpciones().size());
		setChanged();
		notifyObservers();
	}

	/**
	 * Mueve el selector al a opcion de abajo
	 */
	@Override
	public void abajo() {
		sonidoCambiarOpcion();
		setSeleccionada((getSeleccionada() + 1) % getOpciones().size());
		setChanged();
		notifyObservers();
	}

	/**
	 * Elige la opcion actual
	 */
	@Override
	public void accion() {
		seleccionar();
		setChanged();
		notifyObservers();
	}

	/**
	 * Selecciona la opcion salir
	 */
	@Override
	public void salir() {
		setSeleccionada(getOpciones().size() - 1);
		setChanged();
		notifyObservers();
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void izquierda() {
		// No hace nada
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void paraIzquierda() {
		// Nada
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void paraDerecha() {
		// Nada
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void paraArriba() {
		// Nada
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void paraAbajo() {
		// Nada
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void paraAccion() {
		// Nada
	}

	/**
	 * Este metodo no tiene funcionalidad en el menu
	 */
	@Override
	public void paraSalir() {
		// Nada
	}

	/**
	 * Carga y reproduce la musica de fondo en el menu principal
	 */
	private void sonidoMenu() {
		File soundFile = new File("./res/sounds/menusoundtrack.wav");
		AudioInputStream audioIn;

		try {
			audioIn = AudioSystem.getAudioInputStream(soundFile);
			musicaFondo = AudioSystem.getClip();
			musicaFondo.open(audioIn);
			FloatControl gainControl = (FloatControl) musicaFondo
					.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f); // Baja el volumen
			musicaFondo.start();
		} catch (UnsupportedAudioFileException | LineUnavailableException
				| IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reproduce un sonido al mover el selector
	 */
	private void sonidoCambiarOpcion() {
		File soundFile = new File("./res/sounds/optionmove.wav");
		AudioInputStream audioIn;
		Clip clip;

		try {
			audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
         FloatControl gainControl = (FloatControl) clip
               .getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(-15.0f); // Baja el volumen
			clip.start();
		} catch (UnsupportedAudioFileException | LineUnavailableException
				| IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reproduce un sonido al elegir una opcion
	 */
	private void sonidoSeleccionarOpcion() {
		File soundFile = new File("./res/sounds/optionselect.wav");
		AudioInputStream audioIn;
		Clip clip;

		try {
			audioIn = AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
         FloatControl gainControl = (FloatControl) clip
               .getControl(FloatControl.Type.MASTER_GAIN);
         gainControl.setValue(-15.0f); // Baja el volumen
			clip.start();
		} catch (UnsupportedAudioFileException | LineUnavailableException
				| IOException e) {
			e.printStackTrace();
		}
	}

	public static Menu getMenu() {
		return menu;
	}

	public static void setMenu(Menu menu) {
		Menu.menu = menu;
	}

	public ArrayList<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}

	public int getSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(int seleccionada) {
		this.seleccionada = seleccionada;
	}
}
