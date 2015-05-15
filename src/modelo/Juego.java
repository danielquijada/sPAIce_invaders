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
import javax.swing.Timer;
import vista.EnemigoBasicoDibujable;
import controlador.OyenteTimers;


/**
 * Esta clase agrupa todos los elementos que participan en el juego o influyen en estos. En nuestro caso son la nave,
 * enemigos, proyectiles, temporizadores...
 */
public class Juego extends Observable implements Estado {

   /**
    * 
    */

   private Timer                bucleJuego;
   private Tabla                enemigos;
   private ArrayList<Nave>      naves;
   private ArrayList<Proyectil> proyectiles;
   private int                  estadoEnemigos;
   private int                  direccionEnemigos;
   private int                  dir;
   private static Juego         juego;
   private int                  contadorMovimientoEnemigos;

   private static final int     M                       = 10;
   private static final int     N                       = 6;
   public static final int      TOTAL_X                 = 1000;
   public static final int      TOTAL_Y                 = 1000;
   public static final int      ALTURA_INICIAL_ENEMIGOS = 500;
   public static final int      ALTURA_SUELO            = 50;
   public static final int      MARGEN_LATERAL            = 40;
   public static final int      NAVES                   = 1;
   public static final int      VELOCIDAD_BASE          = 5;

   public static final int      IZQUIERDA               = 1;
   public static final int      DERECHA                 = 2;
   public static final int      INMOVIL                 = 0;
   private static final int     MOVIMIENTO              = 5;
   private static final int     MOVIMIENTO_ENEMIGOS     = 15;
   private static final int     DELAY                   = 15;
   private static final int     RETRASO_ENEMIGOS        = 10;

   /**
    * 
    */
   private Juego (OyenteTimers timerListener) {
      nuevo ();
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
         Nave nave = new NaveBasica (TOTAL_X / (numeroNaves + 1) * i, TOTAL_Y - ALTURA_SUELO - NaveBasica.ALTO);
         getNaves ().add (nave);
      }
   }

   public void moverNave (int nave, int direccion) {
      switch (direccion) {
         case IZQUIERDA:
            if (getNaves ().get (nave).getX () > (MARGEN_LATERAL))
               getNaves ().get (nave).moverX (-MOVIMIENTO);
            break;
         case DERECHA:
            if (getNaves ().get (nave).getX () < (TOTAL_X - MARGEN_LATERAL - getNaves ().get (nave).getSize ().x))
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
         if (getEnemigos ().izquierda ().getX () - MOVIMIENTO_ENEMIGOS < MARGEN_LATERAL) { // Caso especial, llega al borde
            getEnemigos ().moverAbajo (MOVIMIENTO_ENEMIGOS);
            setDireccionEnemigos (DERECHA);
         } else {
            getEnemigos ().moverIzquierda (MOVIMIENTO_ENEMIGOS);
         }
      } else {
         if (getEnemigos ().derecha ().getX () + MOVIMIENTO_ENEMIGOS >= TOTAL_X - MARGEN_LATERAL - getEnemigos ().derecha ().getSize ().x) {
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
      if (getContadorMovimientoEnemigos () == RETRASO_ENEMIGOS) {
         setContadorMovimientoEnemigos (0);
         moverEnemigos ();
      } else {
         setContadorMovimientoEnemigos (getContadorMovimientoEnemigos () + 1);
      }

      if (getDir () == Juego.IZQUIERDA)
         moverNave (0, Juego.IZQUIERDA);

      if (getDir () == Juego.DERECHA)
         moverNave (0, Juego.DERECHA);

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
   public int getContadorMovimientoEnemigos () {
      return contadorMovimientoEnemigos;
   }


   /**
    * @param contador
    *           the contador to set
    */
   public void setContadorMovimientoEnemigos (int contador) {
      this.contadorMovimientoEnemigos = contador;
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#izquierda()
    */
   @Override
   public void izquierda () {
      setDir (Juego.IZQUIERDA);
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#derecha()
    */
   @Override
   public void derecha () {
      setDir (Juego.DERECHA);
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#arriba()
    */
   @Override
   public void arriba () {
      // No hace nada
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#abajo()
    */
   @Override
   public void abajo () {
      // No hace nada
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#accion()
    */
   @Override
   public void accion () {
      disparar (0);
   }


   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#salir()
    */
   @Override
   public void salir () {
      Master.getInstance ().cambiarEstado (Master.MENU);
   }

   public int getDir () {
      return dir;
   }

   public void setDir (int dir) {
      this.dir = dir;
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraIzquierda()
    */
   @Override
   public void paraIzquierda () {
      if (getDir () == Juego.IZQUIERDA) {
         setDir (Juego.INMOVIL);
      }

   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraDerecha()
    */
   @Override
   public void paraDerecha () {
      if (getDir () == Juego.DERECHA) {
         setDir (Juego.INMOVIL);
      }
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraArriba()
    */
   @Override
   public void paraArriba () {
      // Falta por implementar

   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraAbajo()
    */
   @Override
   public void paraAbajo () {
      // Falta por implementar
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraAccion()
    */
   @Override
   public void paraAccion () {
      // Falta por implementar

   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraSalir()
    */
   @Override
   public void paraSalir () {
      // Falta por implementar
   }

   /**
    * @param timerListener
    * 
    */
   public void nuevo () {
      setEnemigos (new Tabla (M, N, TOTAL_X, TOTAL_Y - ALTURA_INICIAL_ENEMIGOS));
      inicializarNaves (NAVES);
      setProyectiles (new ArrayList<Proyectil> ());
      setEstadoEnemigos (1);
      setDireccionEnemigos (IZQUIERDA);

      Timer bucleJuego = new Timer (DELAY, new OyenteTimers ());
      setBucleJuego (bucleJuego);
      getBucleJuego ().start ();
   }


   /**
    * @return the bucleJuego
    */
   public Timer getBucleJuego () {
      setChanged ();
      notifyObservers ();
      return bucleJuego;
   }


   /**
    * @param bucleJuego
    *           the bucleJuego to set
    */
   public void setBucleJuego (Timer bucleJuego) {
      this.bucleJuego = bucleJuego;
   }
}
