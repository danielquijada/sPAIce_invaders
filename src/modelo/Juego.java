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
import controlador.OyenteTimers;
import vista.EnemigoBasicoDibujable;
import vista.ProyectilBasicoDibujable;


/**
 * Esta clase agrupa todos los elementos que participan en el juego o influyen en estos. En nuestro caso son la nave,
 * enemigos, proyectiles, temporizadores...
 */
public class Juego extends Observable {

   /**
    * 
    */

   private Tabla                enemigos;
   private ArrayList<Nave>      naves;
   private ArrayList<Proyectil> proyectiles;
   private int                  estadoEnemigos;
   private int                  direccionEnemigos;
   public int                   dir;
   private static Juego         juego;
   private int                  contador;

   private static final int     M                       = 5;
   private static final int     N                       = 5;
   public static final int      TOTAL_X                 = 1000;
   public static final int      TOTAL_Y                 = 1000;
   public static final int      ALTURA_INICIAL_ENEMIGOS = 500;
   public static final int      ALTURA_SUELO            = 50;
   public static final int      NAVES                   = 1;
   public static final int      VELOCIDAD_BASE          = 5;

   public static final int      IZQUIERDA               = 0;
   public static final int      DERECHA                 = 1;
   private static final int     MOVIMIENTO              = 5;
   private static final int     MOVIMIENTO_ENEMIGOS     = 50;
   private static final int     DELAY                   = 15;
   private static final int RETRASO_ENEMIGOS = 40;

   /**
    * 
    */
   private Juego (OyenteTimers timerListener) {
      setEnemigos (new Tabla (M, N, TOTAL_X, TOTAL_Y - ALTURA_INICIAL_ENEMIGOS));
      inicializarNaves (NAVES);
      setProyectiles (new ArrayList<Proyectil> ());
      setEstadoEnemigos (1);
      setDireccionEnemigos (IZQUIERDA);

      Timer bucleJuego = new Timer (DELAY, timerListener);
      bucleJuego.start ();
   }

   public static Juego getInstance () {
      if (getJuego () == null)
         setJuego (new Juego (new OyenteTimers ()));
      return getJuego ();
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
            if (getNaves ().get (nave).getX () > (ALTURA_SUELO))
               getNaves ().get (nave).moverX (-MOVIMIENTO);
            break;
         case DERECHA:
            if (getNaves ().get (nave).getX () < (TOTAL_X - ALTURA_SUELO))
               getNaves ().get (nave).moverX (MOVIMIENTO);
            break;
      }
   }

   public void disparar (int nave) {
      getProyectiles ().add (
            new ProyectilBasico (getNaves ().get (nave).getX (), getNaves ().get (nave).getY (), VELOCIDAD_BASE));
      setChanged ();
      notifyObservers ();
   }

   public void moverEnemigos () {

      if (getDireccionEnemigos () == IZQUIERDA) {
         if (getEnemigos ().izquierda ().getX () - MOVIMIENTO_ENEMIGOS < 0) { // Caso especial, llega al borde
            getEnemigos ().moverAbajo (MOVIMIENTO_ENEMIGOS);
            setDireccionEnemigos (DERECHA);
         } else {
            getEnemigos ().moverIzquierda (MOVIMIENTO_ENEMIGOS);
         }
      } else {
         if (getEnemigos ().derecha ().getX () + MOVIMIENTO_ENEMIGOS >= TOTAL_X) {
            getEnemigos ().moverAbajo (MOVIMIENTO_ENEMIGOS);
            setDireccionEnemigos (IZQUIERDA);
         } else {
            getEnemigos ().moverDerecha (MOVIMIENTO_ENEMIGOS);
         }
      }
   }

   public void step () {
      for (Proyectil proyectil : getProyectiles ()) {
         proyectil.setTiempo (proyectil.getTiempo () + 1);
         proyectil.calcularNuevaPosicion ();
      }
      if (getContador () == RETRASO_ENEMIGOS) {
         setContador (0);
         moverEnemigos ();
      } else {
         setContador (getContador() + 1);
      }
      setChanged ();
      notifyObservers ();
   }

   public Tabla getEnemigos () {
      return enemigos;
   }

   public void setEnemigos (Tabla enemigos) {
      this.enemigos = enemigos;
   }

   public ArrayList<Nave> getNaves () {
      return naves;
   }

   public void setNaves (ArrayList<Nave> naves) {
      this.naves = naves;
   }

   public ArrayList<Proyectil> getProyectiles () {
      return proyectiles;
   }

   public void setProyectiles (ArrayList<Proyectil> proyectiles) {
      this.proyectiles = proyectiles;
   }

   public int getEstadoEnemigos () {
      return estadoEnemigos;
   }

   public void setEstadoEnemigos (int estadoEnemigos) {
      this.estadoEnemigos = estadoEnemigos;
   }

   public int getDireccionEnemigos () {
      return direccionEnemigos;
   }

   public void setDireccionEnemigos (int direccionEnemigos) {
      this.direccionEnemigos = direccionEnemigos;
   }


   /**
    * @return the juego
    */
   private static Juego getJuego () {
      return juego;
   }


   /**
    * @param juego
    *           the juego to set
    */
   public static void setJuego (Juego juego) {
      Juego.juego = juego;
   }


   /**
    * @return the contador
    */
   public int getContador () {
      return contador;
   }


   /**
    * @param contador
    *           the contador to set
    */
   public void setContador (int contador) {
      this.contador = contador;
   }
}
