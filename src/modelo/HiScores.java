/**
 * sPAIce_invaders.modelo.HiScores.java
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Clase que define la tabla de puntuaciones como un estado.
 */
public class HiScores implements Estado {

   private ArrayList<Integer> puntuaciones;
   private ArrayList<String>  jugadores;
   private static HiScores    hiScores;

   private static final int   LIMITE = 10;

   private HiScores () {
      try {
         FileInputStream in = new FileInputStream (new File ("./res/HiScores/puntuaciones"));
         ObjectInputStream ois = new ObjectInputStream (in);
         setPuntuaciones ((ArrayList<Integer>) ois.readObject ());
         ois.close ();
         in = new FileInputStream (new File ("./res/HiScores/jugadores"));
         ois = new ObjectInputStream (in);
         setJugadores ((ArrayList<String>) ois.readObject ());
         ois.close ();
      } catch (Exception e) {
         setPuntuaciones (new ArrayList<Integer> ());
         setJugadores (new ArrayList<String> ());
         try {
            FileOutputStream out = new FileOutputStream (new File ("./res/HiScores/puntuaciones"));
            ObjectOutputStream oos = new ObjectOutputStream (out);
            oos.writeObject (getPuntuaciones ());
            oos.close ();
            out = new FileOutputStream (new File ("./res/HiScores/jugadores"));
            oos = new ObjectOutputStream (out);
            oos.writeObject (getJugadores ());
            oos.close ();
         } catch (Exception e1) {
            e1.printStackTrace ();
         }
      }
   }

   public static HiScores getInstance () {
      if (getHiScores () == null)
         setHiScores (new HiScores ());
      return getHiScores ();
   }

   public boolean entra (int puntuacion) {
      return getPuntuaciones ().size () < LIMITE || getPuntuaciones ().get (LIMITE - 1) < puntuacion;
   }

   public void add (int puntuacion, String nombre) {
      nombre = nombre.replace (" ", "");
      if (nombre.length () > 3)
         nombre = nombre.substring (0, 3);
      if (getPuntuaciones ().size () < LIMITE || entra (puntuacion)) {
         int pos = buscarPosicion (puntuacion);
         if (pos < LIMITE) {
            if (getPuntuaciones ().size () < pos) {
               getPuntuaciones ().add (puntuacion);
               getJugadores ().add (nombre);
            } else {
               getPuntuaciones ().add (pos, puntuacion);
               getJugadores ().add (pos, nombre);
            }
            for (int i = LIMITE; i < getPuntuaciones ().size (); i++) {
               getPuntuaciones ().remove (i);
               getJugadores ().remove (i);
               i--;
            }
            try {
               guardar ();
            } catch (IOException e) {
               e.printStackTrace ();
            }
         }
      }
   }

   /**
    * @param puntuacion
    * @return
    */
   private int buscarPosicion (int puntuacion) {
      int pos = 1000;
      if (getPuntuaciones ().size () == 0)
         pos = 1;
      for (int i = 0; i < getPuntuaciones ().size (); i++) {
         if (getPuntuaciones ().get (i) < puntuacion) {
            pos = i;
            break;
         }
      }
      return pos;
   }

   /**
    * @throws IOException
    * 
    */
   private void guardar () throws IOException {
      FileOutputStream out = new FileOutputStream (new File ("./res/HiScores/puntuaciones"));
      ObjectOutputStream oos = new ObjectOutputStream (out);
      oos.writeObject (getPuntuaciones ());
      oos.close ();
      out = new FileOutputStream (new File ("./res/HiScores/jugadores"));
      oos = new ObjectOutputStream (out);
      oos.writeObject (getJugadores ());
      oos.close ();
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#izquierda()
    */
   @Override
   public void izquierda () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#derecha()
    */
   @Override
   public void derecha () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#arriba()
    */
   @Override
   public void arriba () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#abajo()
    */
   @Override
   public void abajo () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#accion()
    */
   @Override
   public void accion () {
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

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraIzquierda()
    */
   @Override
   public void paraIzquierda () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraDerecha()
    */
   @Override
   public void paraDerecha () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraArriba()
    */
   @Override
   public void paraArriba () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraAbajo()
    */
   @Override
   public void paraAbajo () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraAccion()
    */
   @Override
   public void paraAccion () {
   }

   /*
    * (non-Javadoc)
    * 
    * @see modelo.Estado#paraSalir()
    */
   @Override
   public void paraSalir () {
   }

   /**
    * @return the hiScores
    */
   public static HiScores getHiScores () {
      return hiScores;
   }


   /**
    * @param hiScores
    *           the hiScores to set
    */
   public static void setHiScores (HiScores hiScores) {
      HiScores.hiScores = hiScores;
   }


   /**
    * @return the jugadores
    */
   public ArrayList<String> getJugadores () {
      return jugadores;
   }


   /**
    * @param jugadores
    *           the jugadores to set
    */
   public void setJugadores (ArrayList<String> jugadores) {
      this.jugadores = jugadores;
   }


   /**
    * @param puntuaciones
    *           the puntuaciones to set
    */
   public void setPuntuaciones (ArrayList<Integer> puntuaciones) {
      this.puntuaciones = puntuaciones;
   }


   /**
    * @return the puntuaciones
    */
   public ArrayList<Integer> getPuntuaciones () {
      return puntuaciones;
   }

}
