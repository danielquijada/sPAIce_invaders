/**
 * sPAIce_invaders.modelo.Master.java
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

import java.util.Observable;
import vista.Pantalla;
import vista.PantallaJuego;
import vista.PantallaMenu;


/**
 * TODO Descripción de la clase.
 */
public class Master extends Observable {

   private Estado estado;
   private Pantalla pantalla;
   private static Master master;
   private int numEstado;
   
   public static final int MENU = 0;
   public static final int JUEGO = 1;
   
   public static final int ESTADO_INICIAL = MENU;
   
   private Master () {
      cambiarEstado (ESTADO_INICIAL);
   }
   
   public void cambiarEstado (int nuevoEstado) {
      switch (nuevoEstado) {
         case MENU:
            if (numEstado == JUEGO) {
               ((Juego)getEstado ()).getBucleJuego ().stop ();
            }
            setEstado (Menu.getInstance ());
            setPantalla (PantallaMenu.getInstance ());
            break;
         case JUEGO:
            setEstado (Juego.getInstance ());
            ((Juego)getEstado ()).getBucleJuego ().start ();
            setPantalla (PantallaJuego.getInstance ());
            break;
      }
      setChanged ();
      notifyObservers ();
      setNumEstado (nuevoEstado);
   }
   
   public static Master getInstance () {
      if (getMaster () == null)
         setMaster (new Master ());
      return getMaster ();
   }

   /**
    * @return the estado
    */
   public Estado getEstado () {
      return estado;
   }

   
   /**
    * @param estado the estado to set
    */
   public void setEstado (Estado estado) {
      this.estado = estado;
   }

   
   /**
    * @return the pantalla
    */
   public Pantalla getPantalla () {
      return pantalla;
   }

   
   /**
    * @param pantalla the pantalla to set
    */
   public void setPantalla (Pantalla pantalla) {
      this.pantalla = pantalla;
   }

   
   /**
    * @return the master
    */
   public static Master getMaster () {
      return master;
   }

   
   /**
    * @param master the master to set
    */
   public static void setMaster (Master master) {
      Master.master = master;
   }

   
   /**
    * @return the numEstado
    */
   public int getNumEstado () {
      return numEstado;
   }

   
   /**
    * @param numEstado the numEstado to set
    */
   public void setNumEstado (int numEstado) {
      this.numEstado = numEstado;
   }
}
