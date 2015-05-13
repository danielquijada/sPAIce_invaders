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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.Timer;

import vista.EnemigoBasicoDibujable;
import vista.ProyectilBasicoDibujable;


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
	private int estadoEnemigos;
	private boolean direccionEnemigos;
	private Timer bucleJuego;
	private Timer movimientoEnemigos;
	public Timer smoothmoveTimer;
	public int dir;

	private static final int M = 10;
	private static final int N = 6;
   public static final int TOTAL_X = 1000;
   public static final int TOTAL_Y = 1000;
   public static final int ALTURA_INICIAL_ENEMIGOS = 500;
   public static final int ALTURA_SUELO = 50;
   public static final int NAVES = 1;
   public static final int VELOCIDAD_BASE = 5;
	
   public static final int IZQUIERDA = 0;
   public static final int DERECHA = 1;
   private static final int MOVIMIENTO = 5;
   private static final int MOVIMIENTO_ENEMIGOS = 50;
   
   /**
    * 
    */
   public Juego () {
      setEnemigos (new Tabla (M, N, TOTAL_X, TOTAL_Y - ALTURA_INICIAL_ENEMIGOS));
      inicializarNaves (NAVES);
      setProyectiles (new ArrayList<Proyectil> ());
      setEstadoEnemigos(1);
      setDireccionEnemigos(false);
      
      bucleJuego = new Timer(10, new ActionListener () 
			{ 
			    public void actionPerformed(ActionEvent e) 
			    { 
			    	step();
			     } 
			});
      
      movimientoEnemigos = new Timer(1600, new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    { 
		    	moverEnemigos();
		     } 
		});
      
      bucleJuego.start();
      movimientoEnemigos.start();
      
      smoothmoveTimer = new Timer(30, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			moverNave(0, dir);
			
		}
    	  
      });
     
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
        	if(getNaves ().get (nave).getX() > (ALTURA_SUELO))
        		 getNaves ().get (nave).moverX (-MOVIMIENTO);
            break;
         case DERECHA:
        	if(getNaves ().get (nave).getX() < (TOTAL_X - ALTURA_SUELO))
        		getNaves ().get (nave).moverX (MOVIMIENTO);
            break;
      }
      setChanged ();
      notifyObservers ();
   }
   
   public void disparar (int nave) {
	   getProyectiles().add(new ProyectilBasico(getNaves ().get (nave).getX(), getNaves ().get (nave).getY(), VELOCIDAD_BASE));
	   setChanged ();
	   notifyObservers ();
   }
   
   public void moverEnemigos(){
	   Tabla t = getEnemigos ();
	      Iterator<Enemigo> iter = getEnemigos ().iterator ();

	      if(getEstadoEnemigos() % 2 == 0){
	    	  while (iter.hasNext ()) {
			         Enemigo enemy = iter.next ();
			         enemy.moverY(MOVIMIENTO_ENEMIGOS / 2);
			      }
	    	  setDireccionEnemigos(! isDireccionEnemigos());
	      }
	      
	      else if(isDireccionEnemigos()){
		      while (iter.hasNext ()) {
		         Enemigo enemy = iter.next ();
		         enemy.moverX(MOVIMIENTO_ENEMIGOS / 2);
		      }
	      }
	      else {
	    	  while (iter.hasNext ()) {
			         Enemigo enemy = iter.next ();
			         enemy.moverX(- MOVIMIENTO_ENEMIGOS / 2);
			      }
	      }
	      
	      setEstadoEnemigos(getEstadoEnemigos() + 1);
   }
   
   public void step (){
	   boolean aux = false;
		   for (Proyectil proyectil : getProyectiles() ) {
		          proyectil.setTiempo(proyectil.getTiempo() + 1);
		          proyectil.calcularNuevaPosicion();
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

	public int getEstadoEnemigos() {
		return estadoEnemigos;
	}

	public void setEstadoEnemigos(int estadoEnemigos) {
		this.estadoEnemigos = estadoEnemigos;
	}

	public Timer getBucleJuego() {
		return bucleJuego;
	}

	public void setBucleJuego(Timer bucleJuego) {
		this.bucleJuego = bucleJuego;
	}

	public Timer getMovimientoEnemigos() {
		return movimientoEnemigos;
	}

	public void setMovimientoEnemigos(Timer movimientoEnemigos) {
		this.movimientoEnemigos = movimientoEnemigos;
	}

	public boolean isDireccionEnemigos() {
		return direccionEnemigos;
	}

	public void setDireccionEnemigos(boolean direccionEnemigos) {
		this.direccionEnemigos = direccionEnemigos;
	}
	
	
	
	
}
