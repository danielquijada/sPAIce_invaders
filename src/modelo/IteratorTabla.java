/**
 * sPAIce_invaders.modelo.IteratorTabla.java
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

import java.util.Iterator;


/**
 * Iterador que recorre la tabla.
 */
public class IteratorTabla implements Iterator<Enemigo> {

   private int   i;
   private int   j;
   private Tabla tabla;


   /**
    * 
    */
   public IteratorTabla (Tabla tabla) {
      setI (-1);
      setJ (0);
      setTabla (tabla);
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.util.Iterator#hasNext()
    */
   @Override
   public boolean hasNext () {
      boolean hayMas = true;
      hayMas = hayMas && ((getTabla ().getAncho () - 1 > getI ()) || (getTabla ().getAlto () - 1 > getJ ()));
      return hayMas;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.util.Iterator#next()
    */
   @Override
   public Enemigo next () {
      if (getI () == getTabla ().getAncho () - 1) {
         setI (0);
         setJ (getJ () + 1);
      } else {
         setI (getI () + 1);
      }
      return getTabla ().getEnemigo (getI (), getJ ());
   }

   /**
    * @return the i
    */
   public int getI () {
      return i;
   }


   /**
    * @param i
    *           the i to set
    */
   public void setI (int i) {
      this.i = i;
   }


   /**
    * @return the j
    */
   public int getJ () {
      return j;
   }


   /**
    * @param j
    *           the j to set
    */
   public void setJ (int j) {
      this.j = j;
   }


   /**
    * @return the tabla
    */
   public Tabla getTabla () {
      return tabla;
   }


   /**
    * @param tabla
    *           the tabla to set
    */
   public void setTabla (Tabla tabla) {
      this.tabla = tabla;
   }

}
