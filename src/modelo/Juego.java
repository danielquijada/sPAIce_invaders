/**
 * sPAIce_invaders.modelo.Juego.java
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
 * Esta clase agrupa todos los elementos que participan en el juego o influyen en estos.
 * En nuestro caso son la nave, enemigos, proyectiles, temporizadores...
 */
public class Juego extends Observable {

   /**
    * 
    */
	
	private Tabla enemigos;
	private ArrayList<Nave> naves;
	private ArrayList<Proyectil> proyectiles;

	private static final int M = 10;
	private static final int N = 6;
   public static final int TOTAL_X = 1000;
   public static final int TOTAL_Y = 1000;
   public static final int ALTURA_INICIAL_ENEMIGOS = 500;
   public static final int ALTURA_SUELO = 50;
   public static final int NAVES = 1;
	
   public static final int IZQUIERDA = 0;
   public static final int DERECHA = 1;
   private static final int MOVIMIENTO = 30;
   
   /**
    * 
    */
   public Juego () {
      setEnemigos (new Tabla (M, N, TOTAL_X, TOTAL_Y - ALTURA_INICIAL_ENEMIGOS));
      inicializarNaves (NAVES);
      setProyectiles (new ArrayList<Proyectil> ());
   }
	
	/**
    * 
    */
   private void inicializarNaves (int numeroNaves) {
      setNaves (new ArrayList<Nave> ());
      for (int i = 1; i <= numeroNaves; i++) {
         getNaves ().add (new NaveBasica (TOTAL_Y / (numeroNaves + 1) * i, TOTAL_X - ALTURA_SUELO));
      }
   }

   public void moverNave (int nave, int direccion) {
      switch (direccion) {
         case IZQUIERDA:
            getNaves ().get (nave).moverX (-MOVIMIENTO);
            break;
         case DERECHA:
            getNaves ().get (nave).moverX (MOVIMIENTO);
            break;
      }
      setChanged ();
      notifyObservers ();
   }
   
   public Tabla getEnemigos() {
		return enemigos;
	}
	
	public void setEnemigos(Tabla enemigos) {
		this.enemigos = enemigos;
	}
	
	public ArrayList<Nave> getNaves() {
		return naves;
	}
	
	public void setNaves(ArrayList<Nave> naves) {
		this.naves = naves;
	}
	
	public ArrayList<Proyectil> getProyectiles() {
		return proyectiles;
	}
	
	public void setProyectiles(ArrayList<Proyectil> proyectiles) {
		this.proyectiles = proyectiles;
	}
}
