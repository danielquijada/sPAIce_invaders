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

import java.util.ArrayList;
import java.util.Observable;

/**
 * Contiene las opciones del menu principal
 * Nuevo juego, continar, opciones, salir.
 */
public class Menu extends Observable implements Estado {

	private static final String NEW = "Nuevo Juego";
	private static final String LOAD = "Continuar";
	private static final String OPC = "Opciones";
	private static final String EXIT = "Salir";
	private ArrayList<String> opciones;
	private int seleccionada;

	private static Menu menu;

	private Menu() {
		setSeleccionada(0);
		setOpciones(new ArrayList<String>());
		getOpciones().add(NEW);
		getOpciones().add(LOAD);
		getOpciones().add(EXIT);
	}

	public static Menu getInstance() {
		if (getMenu() == null)
			setMenu(new Menu());
		return getMenu();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#izquierda()
	 */
	@Override
	public void izquierda() {
		// No hace nada
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#derecha()
	 */
	@Override
	public void derecha() {
		seleccionar();
		setChanged();
		notifyObservers();
	}

	/**
    * 
    */
	private void seleccionar() {
		// TODO Añadir todas las opciones, o quitar las que no sean
		// implementadas por ahora
		switch (getOpciones().get(seleccionada)) {
		case NEW:
			Juego.getInstance().nuevo();
			Master.getInstance().cambiarEstado(Master.JUEGO);
			break;
		case LOAD:
			Master.getInstance().cambiarEstado(Master.JUEGO);
			break;
		case EXIT:
			System.exit(0);
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#arriba()
	 */
	@Override
	public void arriba() {
		setSeleccionada((getSeleccionada() - 1 + getOpciones().size())
				% getOpciones().size());
		setChanged();
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#abajo()
	 */
	@Override
	public void abajo() {
		setSeleccionada((getSeleccionada() + 1) % getOpciones().size());
		setChanged();
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#accion()
	 */
	@Override
	public void accion() {
		seleccionar();
		setChanged();
		notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#salir()
	 */
	@Override
	public void salir() {
		setSeleccionada(getOpciones().size() - 1);
		setChanged();
		notifyObservers();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#paraIzquierda()
	 */
	@Override
	public void paraIzquierda() {
		// Nada
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#paraDerecha()
	 */
	@Override
	public void paraDerecha() {
		// Nada
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#paraArriba()
	 */
	@Override
	public void paraArriba() {
		// Nada
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#paraAbajo()
	 */
	@Override
	public void paraAbajo() {
		// Nada
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#paraAccion()
	 */
	@Override
	public void paraAccion() {
		// Nada
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modelo.Estado#paraSalir()
	 */
	@Override
	public void paraSalir() {
		// Nada
	}

	public static Menu getMenu() {
		return menu;
	}

	public static void setMenu(Menu menu) {
		Menu.menu = menu;
	}
}
