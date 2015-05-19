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

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

import vista.EnemigoBasicoDibujable;
import vista.NaveBasicaDibujable;
import controlador.OyenteTimers;

/**
 * Esta clase agrupa todos los elementos que participan en el juego o influyen en estos. En nuestro caso son la nave,
 * enemigos, proyectiles, temporizadores...
 */
public class Juego extends Observable implements Estado {

   private Timer                  bucleJuego;
   private Tabla                  enemigos;
   private ArrayList<Nave>        naves;
   private ArrayList<Proyectil>   proyectiles;
   private ArrayList<EnemigoOvni> enemigosEspeciales;
   private int                    estadoEnemigos;
   private int                    direccionEnemigos;
   private int                    dir;
   private static Juego           juego;
   private int                    contadorMovimientoEnemigos;
   private int                    ovniTimer;
   private int                    playing;
   private boolean                gameOver;
   private boolean                win;
   private int                    preStart;
   private int                    contadorPreStart;
   private int                    contadorDisparosEnemigos;
   private int                    contadorDisparos;

   private static final int       M                                      = 10;
   private static final int       N                                      = 6;
   public static final int        TOTAL_X                                = 1000;
   public static final int        TOTAL_Y                                = 1000;
   public static final int        ALTURA_INICIAL_ENEMIGOS                = 50;
   public static final int        ALTURA_SUELO                           = 50;
   public static final int        MARGEN_LATERAL                         = 40;
   public static final int        NAVES                                  = 1;
   public static final int        VELOCIDAD_BASE                         = 5;
   public static final int        OVNI_SPAWN                             = 12000;

   public static final int        IZQUIERDA                              = 1;
   public static final int        DERECHA                                = 2;
   public static final int        INMOVIL                                = 0;
   private static final int       MOVIMIENTO                             = 5;
   private static final int       MOVIMIENTO_ENEMIGOS                    = 15;
   private static final int       DELAY                                  = 15;
   private static final int       RETRASO_ENEMIGOS                       = 30;
   private static final int       RETRASO_PRESTART                       = 60;
   private static final int       RETRASO_DISPAROS_NAVE                  = 20;
   private static final int       RETRASO_DISPAROS_ENEMIGOS_TRIANGULARES = 90;
   private static final int       RETRASO_DISPAROS_ENEMIGOS_ANTENAS      = 300;
   private static final int       RETRASO_DISPAROS_ENEMIGOS_REDONDOS     = 600;

   /**
    * Constructor por defecto. Inicializa el juego creando un juego nuevo. Es privado debido a que utilizamos el patrón
    * Singleton.
    */
   private Juego () {
      nuevo ();
   }

   /**
    * Crea una nueva partida. Inicializa los valores a los iniciales.
    */
   public void nuevo () {
      setEnemigos (new Tabla (M, N, TOTAL_X, TOTAL_Y - ALTURA_INICIAL_ENEMIGOS));
      inicializarNaves (NAVES);
      setProyectiles (new ArrayList<Proyectil> ());
      setEnemigosEspeciales (new ArrayList<EnemigoOvni> ());
      setEstadoEnemigos (1);
      setDireccionEnemigos (IZQUIERDA);
      setOvniTimer (0);
      setPreStart (3);
      setWin (false);

      setGameOver (false);
      Timer bucleJuego = new Timer (DELAY, new OyenteTimers ());
      setBucleJuego (bucleJuego);
   }

   /**
    * Método utilizado para obtener una instancia de Juego. Devuelve siempre la misma instancia.
    * 
    * @return Instancia única de la clase Juego.
    */
   public static Juego getInstance () {
      if (getJuego () == null)
         setJuego (new Juego ());
      return getJuego ();
   }

   /**
    * Inicializa las naves con el número de naves a ser colocadas.
    * 
    * @param numeroNaves
    */
   private void inicializarNaves (int numeroNaves) {
      setNaves (new ArrayList<Nave> ());
      for (int i = 1; i <= numeroNaves; i++) {
         Nave nave = new NaveBasica (TOTAL_X / (numeroNaves + 1) * i, TOTAL_Y - ALTURA_SUELO - NaveBasica.ALTO);
         getNaves ().add (nave);
      }
   }

   /**
    * Mueve la nave seleccionada en la direccion indicada.
    * 
    * @param nave
    *           nave a mover.
    * @param direccion
    *           direccion en la que se mueve.
    */
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

   /**
    * Crea un proyectil disparado por la nave seleccionada.
    * 
    * @param nave
    *           nave a disparar.
    */
   public void disparar (int nave) {
      getProyectiles ().add (
            new ProyectilBasico (getNaves ().get (nave).getX () + NaveBasica.ANCHO * 3 / 10, getNaves ().get (nave)
                  .getY ()
                  - NaveBasica.ALTO / 2, VELOCIDAD_BASE));
      setChanged ();
      notifyObservers ();
   }

   /**
    * Hace que los enemigos den un "paso" en la dirección que toque.
    */
   public void moverEnemigos () {
      if (getPlaying () == 4) {
         setPlaying (0);
      }
      playFondo (getPlaying ());
      setPlaying (getPlaying () + 1);
      ;
      EnemigoBasicoDibujable.setAnimacion (!EnemigoBasicoDibujable.isAnimacion ());

      if (getDireccionEnemigos () == IZQUIERDA) {
         if (getEnemigos ().izquierda ().getX () - MOVIMIENTO_ENEMIGOS < MARGEN_LATERAL) { // Caso
            // especial,
            // llega
            // al
            // borde
            getEnemigos ().moverAbajo (MOVIMIENTO_ENEMIGOS);
            setDireccionEnemigos (DERECHA);
         } else {
            getEnemigos ().moverIzquierda (MOVIMIENTO_ENEMIGOS);
         }
      } else {
         if (getEnemigos ().derecha ().getX () + MOVIMIENTO_ENEMIGOS >= TOTAL_X - MARGEN_LATERAL
               - getEnemigos ().derecha ().getSize ().x) {
            getEnemigos ().moverAbajo (MOVIMIENTO_ENEMIGOS);
            setDireccionEnemigos (IZQUIERDA);
         } else {
            getEnemigos ().moverDerecha (MOVIMIENTO_ENEMIGOS);
         }
      }
   }

   /**
    * Realiza una iteración del bucle de juego. Se calculan todas las acciones aquí y movimientos.
    */
   public void step () {
      if (getContadorPreStart () >= RETRASO_PRESTART) {
         setContadorPreStart (0);
         setPreStart (getPreStart () - 1);
         setChanged ();
         notifyObservers ();
      } else
         setContadorPreStart (getContadorPreStart () + 1);
      if (getPreStart () >= 0)
         return;
      if (isGameOver () || isWin ()) {
         getBucleJuego ().stop ();
         return;
      }

      setContadorDisparos (getContadorDisparos () + 1);
      setContadorDisparosEnemigos (getContadorDisparosEnemigos () + 1);
      dispararEnemigos ();
      Random rand = new Random ();
      if (getOvniTimer () == OVNI_SPAWN) {
         if (rand.nextBoolean ()) {
            sonidoOvni ();
            EnemigoOvni enemigo = new EnemigoOvni (MARGEN_LATERAL, ALTURA_INICIAL_ENEMIGOS);
            getEnemigosEspeciales ().add (enemigo);
            if (rand.nextBoolean ()) {
               enemigo.setVelocidad (-1 * enemigo.getVelocidad ());
               enemigo.setX (TOTAL_X);
            }
         }
         setOvniTimer (0);

      } else
         setOvniTimer (getOvniTimer () + DELAY + 5);

      moverProyectiles ();
      moverOvnis ();
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

      calcularColisiones ();

      if (getNaves ().get (0).getVidas () == 0) {
    	  sonidoGameOver ();
    	  setGameOver (true);
      }

      setChanged ();
      notifyObservers ();
   }

   /**
    * 
    */
   private void dispararEnemigos () {
      if (getContadorDisparosEnemigos () % RETRASO_DISPAROS_ENEMIGOS_ANTENAS == 0)
         dispararAntenas ();
      if (getContadorDisparosEnemigos () % RETRASO_DISPAROS_ENEMIGOS_REDONDOS == 0)
         dispararRedondos ();
      if (getContadorDisparosEnemigos () % RETRASO_DISPAROS_ENEMIGOS_TRIANGULARES == 0)
         dispararTriangulares ();
   }

   /**
    * @param triangular
    * @return
    */
   private ArrayList<Enemigo> obtenerEnemigos (int tipo) {
      ArrayList<Enemigo> enemigos = new ArrayList<> ();
      Iterator<Enemigo> iter = getEnemigos ().iterator ();
      while (iter.hasNext ()) {
         Enemigo enemy = iter.next ();
         if (enemy.getTipo () == tipo && enemy.isVivo ())
            enemigos.add (enemy);
      }

      return enemigos;
   }



   /**
    * @param seleccionado
    */
   private void dispararEnemigo (Enemigo seleccionado) {
      getProyectiles ().add (new ProyectilEnemigo (seleccionado.getX () + seleccionado.getSize ().x / 2, seleccionado.getY (), VELOCIDAD_BASE));
      setChanged ();
      notifyObservers ();
   }

   /**
    * 
    */
   private void dispararTriangulares () {
      ArrayList<Enemigo> validos = obtenerEnemigos (Enemigo.TRIANGULAR);
      if (validos.size () == 0)
         return;
      Enemigo seleccionado = validos.get (new Random ().nextInt (validos.size ()));
      dispararEnemigo (seleccionado);
   }

   /**
    * 
    */
   private void dispararRedondos () {
      ArrayList<Enemigo> validos = obtenerEnemigos (Enemigo.REDONDO);
      if (validos.size () == 0)
         return;
      Enemigo seleccionado = validos.get (new Random ().nextInt (validos.size ()));
      dispararEnemigo (seleccionado);
   }

   /**
    * 
    */
   private void dispararAntenas () {
      ArrayList<Enemigo> validos = obtenerEnemigos (Enemigo.ANTENAS);
      if (validos.size () == 0)
         return;
      Enemigo seleccionado = validos.get (new Random ().nextInt (validos.size ()));
      dispararEnemigo (seleccionado);
   }

   /**
    * Mueve el ovni.
    */
   private void moverOvnis () {

      Iterator<EnemigoOvni> iterOvnis = getEnemigosEspeciales ().iterator ();
      while (iterOvnis.hasNext ()) {
         EnemigoOvni ovni = iterOvnis.next ();
         ovni.setX (ovni.getX () + ovni.getVelocidad ());
         if (ovni.getX () < 0 || ovni.getX () > TOTAL_X)
            iterOvnis.remove ();
      }
   }

   /**
    * 
    */
   private void calcularColisiones () {
      for (Proyectil proyectil : getProyectiles ()) {
         for (Proyectil proyectil2 : getProyectiles ()) {
            if (!proyectil.equals (proyectil2))
               comprobarColisiones (proyectil, proyectil2);
         }
         Iterator<Enemigo> iter = getEnemigos ().iterator ();
         if (proyectil.getVelocidad () < 0) {
            while (iter.hasNext ()) {
               Enemigo enemigo = iter.next ();
               comprobarColisiones (proyectil, enemigo);
            }
            for (Enemigo ovni : getEnemigosEspeciales ()) {
               comprobarColisiones (proyectil, ovni);
            }
         }
         Iterator<Nave> iterN = getNaves ().iterator ();
         if (proyectil.getVelocidad () > 0) {
            while (iterN.hasNext ()) {
               Nave nave = iterN.next ();
               comprobarColisiones (proyectil, nave);
            }
         }
      }
      limpiarProyectiles ();
   }

   /**
    * 
    */
   private void limpiarProyectiles () {
      Iterator<Proyectil> iter = getProyectiles ().iterator ();
      while (iter.hasNext ()) {
         if (iter.next ().getColision () <= 0) {
        	 iter.remove ();    	 
         }
      }
   }

   /**
    * Comprueba las colisiones entre 2 Elementos, y realiza las acciones correspondientes en su caso. El primero es un
    * proyectil, pero el segundo puede cualquier tipo de Elemento.
    * 
    * @param proyectil
    *           proyectil que se quiere comprobar.
    * @param elemento
    *           elemento que puede o no chocar con el proyectil.
    */
   private void comprobarColisiones (Proyectil proyectil, Elemento elemento) {
      if (elemento instanceof Proyectil)
         if ((proyectil.getVelocidad () * ((Proyectil) elemento).getVelocidad ()) > 0) {
            return;
         }
      if (elemento instanceof Enemigo) {
         if (!((Enemigo) elemento).isVivo ()) {
            return;
         }
      }
      if (chocan (proyectil, elemento)) {
         int a = Math.min (proyectil.getColision (), elemento.getColision ());
         proyectil.setColision (proyectil.getColision () - a);
         elemento.setColision (elemento.getColision () - a);
         

         if (elemento.getColision () <= 0) {
            if (elemento.getTipo () == Enemigo.TRIANGULAR) {
            	sonidoMatado ();
               getNaves ().get (0).setPuntuacion (getNaves ().get (0).getPuntuacion () + 40);
            } else if (elemento.getTipo () == Enemigo.ANTENAS) {
            	sonidoMatado ();
               getNaves ().get (0).setPuntuacion (getNaves ().get (0).getPuntuacion () + 20);
            } else if (elemento.getTipo () == Enemigo.REDONDO) {
            	sonidoMatado ();
               getNaves ().get (0).setPuntuacion (getNaves ().get (0).getPuntuacion () + 10);
            } else if (elemento.getTipo () == Enemigo.NODRIZA) {
            	sonidoMatado ();
            	getNaves ().get (0).setPuntuacion (getNaves ().get (0).getPuntuacion () + 100);
            }
            if (getEnemigos ().isEmpty () && getEnemigosEspeciales ().isEmpty ()) {
            	setWin (true);
            	sonidoVictoria ();
            }
         }
      }
   }

   /**
    * Booleano que comprueba si 2 elementos chocan.
    * 
    * @param proyectil
    *           proyectil a comprobar.
    * @param elemento
    *           elemento a comprobar.
    * @return si esos elementos chocan o no.
    */
   private boolean chocan (Proyectil proyectil, Elemento elemento) {
      Rectangle proyect = new Rectangle (proyectil.getX (), proyectil.getY (), proyectil.getSize ().x, proyectil
            .getSize ().y);
      Rectangle element = new Rectangle (elemento.getX (), elemento.getY (), elemento.getSize ().x,
            elemento.getSize ().y);
      
      if ((proyectil.getX() > getNaves().get(0).getX()) && (proyectil.getX() < getNaves().get(0).getX() + getNaves().get(0).getSize().x)) {  	 
    	  if(proyectil.getY() > getNaves().get(0).getY() - 10) {
    		  sonidoPerderVida(); //Si la posicion del proyectil esta en el rango de impacto reproduce un sonido
    		  NaveBasicaDibujable.setHit(true);
    		  
    		  System.out.println(proyectil.getY());
    		  System.out.println(getProyectiles().size());
    	  }
      }

      return proyect.intersects (element);
   }

   /**
    * Mueve los proyectiles.
    */
   private void moverProyectiles () {
      for (Proyectil proyectil : getProyectiles ()) {
         proyectil.setY (proyectil.getY () + proyectil.getVelocidad ());
      }
   }

   /*
    * Mueve la nave al presionar la tecla de movimiento
    */
   @Override
   public void izquierda () {
      setDir (Juego.IZQUIERDA);
   }

   /*
    * Mueve la nave al presionar la tecla de movimiento
    */
   @Override
   public void derecha () {
      setDir (Juego.DERECHA);
   }

   /*
    * Este metodo no tiene funcionalidad en el juego
    */
   @Override
   public void arriba () {
   }

   /*
    * Este metodo no tiene funcionalidad en el juego
    */
   @Override
   public void abajo () {
   }

   /*
	 * 
	 */
   @Override
   public void accion () {
      if (getPreStart () >= 0)
         return;
      if (getContadorDisparos () < RETRASO_DISPAROS_NAVE)
         return;
      disparar (0);
      sonidoDisparo ();
      setContadorDisparos (0);
   }

   /*
    * Cambia la pantalla al menu principal
    */
   @Override
   public void salir () {
      Master.getInstance ().cambiarEstado (Master.MENU);
   }

   /*
    * Detiene la nave al soltar la tecla de movimiento
    */
   @Override
   public void paraIzquierda () {
      if (getDir () == Juego.IZQUIERDA) {
         setDir (Juego.INMOVIL);
      }

   }

   /*
    * Detiene la nave al soltar la tecla de movimiento
    */
   @Override
   public void paraDerecha () {
      if (getDir () == Juego.DERECHA) {
         setDir (Juego.INMOVIL);
      }
   }

   /*
    * Este metodo no tiene funcionalidad en el juego
    */
   @Override
   public void paraArriba () {
   }

   /*
    * Este metodo no tiene funcionalidad en el juego
    */
   @Override
   public void paraAbajo () {
   }

   /*
    * Este metodo no tiene funcionalidad en el juego
    */
   @Override
   public void paraAccion () {
   }

   /*
    * Este metodo no tiene funcionalidad en el juego
    */
   @Override
   public void paraSalir () {
   }

   /**
    * Reproduce el sonido de disparo.
    */
   private void sonidoDisparo () {
      File soundFile = new File ("./res/sounds/disparo.wav");
      AudioInputStream audioIn;
      Clip clip;
      try {
         audioIn = AudioSystem.getAudioInputStream (soundFile);
         clip = AudioSystem.getClip ();
         clip.open (audioIn);
         clip.start ();
      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
         e.printStackTrace ();
      }
   }

   /**
    * Reproduce un sonido cuando aparece el ovni
    */
   private void sonidoOvni () {
      File soundFile = new File ("./res/sounds/ovni.wav");
      AudioInputStream audioIn;
      Clip clip;
      try {
         audioIn = AudioSystem.getAudioInputStream (soundFile);
         clip = AudioSystem.getClip ();
         clip.open (audioIn);
         clip.start ();
      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
         e.printStackTrace ();
      }
   }

   /**
    * Reproduce el sonido de que un enemigo sea asesinado.
    */
   private void sonidoMatado () {
      File soundFile = new File ("./res/sounds/invasorMuerto.wav");
      AudioInputStream audioIn;
      Clip clip;
      try {
         audioIn = AudioSystem.getAudioInputStream (soundFile);
         clip = AudioSystem.getClip ();
         clip.open (audioIn);
         clip.start ();
      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
         e.printStackTrace ();
      }
   }

   /**
    * Reproduce un sonido cuando muere la nave
    */
   private void sonidoGameOver () {
	      File soundFile = new File ("./res/sounds/lost.wav");
	      AudioInputStream audioIn;
	      Clip clip;
	      try {
	         audioIn = AudioSystem.getAudioInputStream (soundFile);
	         clip = AudioSystem.getClip ();
	         clip.open (audioIn);
	         clip.start ();
	      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
	         e.printStackTrace ();
	      }
	   }
   
   /**
    * Reproduce un sonido cuando se gana una partida
    */
   private void sonidoVictoria () {
	      File soundFile = new File ("./res/sounds/win.wav");
	      AudioInputStream audioIn;
	      Clip clip;
	      try {
	         audioIn = AudioSystem.getAudioInputStream (soundFile);
	         clip = AudioSystem.getClip ();
	         clip.open (audioIn);
	         clip.start ();
	      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
	         e.printStackTrace ();
	      }
	   }
   
   /**
    * Reproduce un sonido cuando la nave es golpeada
    */
   private void sonidoPerderVida () {
	      File soundFile = new File ("./res/sounds/vidaPerdida.wav");
	      AudioInputStream audioIn;
	      Clip clip;
	      try {
	         audioIn = AudioSystem.getAudioInputStream (soundFile);
	         clip = AudioSystem.getClip ();
	         clip.open (audioIn);
	         clip.start ();
	      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
	         e.printStackTrace ();
	      }
	   }
   
   /**
    * Reproduce el sonido de fondo.
    * @param playing reproduce 1 de los 4 sonidas
    */
   private void playFondo (int playing) {
      File soundFile1 = new File ("./res/sounds/playing1.wav");
      File soundFile2 = new File ("./res/sounds/playing2.wav");
      File soundFile3 = new File ("./res/sounds/playing3.wav");
      File soundFile4 = new File ("./res/sounds/playing4.wav");

      AudioInputStream audioIn0;
      AudioInputStream audioIn1;
      AudioInputStream audioIn2;
      AudioInputStream audioIn3;

      Clip clip0;
      Clip clip1;
      Clip clip2;
      Clip clip3;

      try {
         audioIn0 = AudioSystem.getAudioInputStream (soundFile1);
         audioIn1 = AudioSystem.getAudioInputStream (soundFile2);
         audioIn2 = AudioSystem.getAudioInputStream (soundFile3);
         audioIn3 = AudioSystem.getAudioInputStream (soundFile4);
         clip0 = AudioSystem.getClip ();
         clip1 = AudioSystem.getClip ();
         clip2 = AudioSystem.getClip ();
         clip3 = AudioSystem.getClip ();

         clip0.open (audioIn0);
         clip1.open (audioIn1);
         clip2.open (audioIn2);
         clip3.open (audioIn3);

         if (playing == 0) {
            clip0.start ();
         } else if (playing == 1) {
            clip1.start ();
         } else if (playing == 2) {
            clip2.start ();
         } else if (playing == 3) {
            clip3.start ();
         }

      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
         e.printStackTrace ();
      }
   }

   public Timer getBucleJuego () {
      setChanged ();
      notifyObservers ();
      return bucleJuego;
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

   public int getDir () {
      return dir;
   }

   public void setDir (int dir) {
      this.dir = dir;
   }

   private static Juego getJuego () {
      return juego;
   }

   public static void setJuego (Juego juego) {
      Juego.juego = juego;
   }

   public int getContadorMovimientoEnemigos () {
      return contadorMovimientoEnemigos;
   }

   public void setContadorMovimientoEnemigos (int contador) {
      this.contadorMovimientoEnemigos = contador;
   }

   public void setBucleJuego (Timer bucleJuego) {
      this.bucleJuego = bucleJuego;
   }

   public ArrayList<EnemigoOvni> getEnemigosEspeciales () {
      return enemigosEspeciales;
   }

   public void setEnemigosEspeciales (ArrayList<EnemigoOvni> enemigosEspeciales) {
      this.enemigosEspeciales = enemigosEspeciales;
   }

   public int getOvniTimer () {
      return ovniTimer;
   }

   public void setOvniTimer (int ovniTimer) {
      this.ovniTimer = ovniTimer;
   }

   public int getPlaying () {
      return playing;
   }

   public void setPlaying (int playing) {
      this.playing = playing;
   }


   /**
    * @return the gameOver
    */
   public boolean isGameOver () {
      return gameOver;
   }


   /**
    * @param gameOver
    *           the gameOver to set
    */
   public void setGameOver (boolean gameOver) {
      this.gameOver = gameOver;
   }


   /**
    * @return the preStart
    */
   public int getPreStart () {
      return preStart;
   }


   /**
    * @param preStart
    *           the preStart to set
    */
   public void setPreStart (int preStart) {
      this.preStart = preStart;
   }


   /**
    * @return the contadorPreStart
    */
   public int getContadorPreStart () {
      return contadorPreStart;
   }


   /**
    * @param contadorPreStart
    *           the contadorPreStart to set
    */
   public void setContadorPreStart (int contadorPreStart) {
      this.contadorPreStart = contadorPreStart;
   }


   /**
    * @return the win
    */
   public boolean isWin () {
      return win;
   }


   /**
    * @param win
    *           the win to set
    */
   public void setWin (boolean win) {
      this.win = win;
   }


   /**
    * @return the contadorDisparosEnemigos
    */
   public int getContadorDisparosEnemigos () {
      return contadorDisparosEnemigos;
   }


   /**
    * @param contadorDisparosEnemigos
    *           the contadorDisparosEnemigos to set
    */
   public void setContadorDisparosEnemigos (int contadorDisparosEnemigos) {
      this.contadorDisparosEnemigos = contadorDisparosEnemigos;
   }


   /**
    * @return the contadorDisparos
    */
   public int getContadorDisparos () {
      return contadorDisparos;
   }


   /**
    * @param contadorDisparos
    *           the contadorDisparos to set
    */
   public void setContadorDisparos (int contadorDisparos) {
      this.contadorDisparos = contadorDisparos;
   }

}
