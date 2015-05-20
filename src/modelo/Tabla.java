/**
 * sPAIce_invaders.modelo.Tabla.java
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
 * Tabla que contiene todos los enemigos, dispuestos en una matriz bidimensional. Incluye métodos para acceder a
 * coordenadas i,j de la matriz.
 */
public class Tabla implements Iterable {

   /**
    * 
    */
   private Enemigo[][]      matrizEnemigos;
   private final static int SEPARACION = 10;
   private int              ancho;
   private int              alto;

   /**
    * Crea la matriz de enemigos
    * @param tamanioX filas
    * @param tamanioY columnas
    * @param totalX ancho de ventana
    * @param totalY alto de ventana
    */
   public Tabla (int tamanioX, int tamanioY, int totalX, int totalY) {
      setMatrizEnemigos (new Enemigo[tamanioX][tamanioY]);
      setAncho (tamanioX);
      setAlto (tamanioY);

      int inicialX = (int) ((double) totalX / (double) (2 * tamanioX));
      int inicialY = (int) ((double) totalY / (double) (2 * tamanioY));

      int posX = inicialX;
      int posY = inicialY;
      int separacionX = EnemigoBasico.ANCHO * 2;
      int separacionY = EnemigoBasico.ALTO + EnemigoBasico.ALTO / 2;
      int tipo = 0;
      for (int i = 0; i < tamanioX; i++) {
         for (int j = 0; j < tamanioY; j++) {
        	 
        	 if (j == 0) {
        		 tipo = Enemigo.TRIANGULAR;
        	 }
        	 else if (j == 1)  {
        		 tipo = Enemigo.ANTENAS;
        	 }
        	 else  if (j == 3) {
        		 tipo = Enemigo.REDONDO;
        	 }
    		         	 
             setEnemigo (i, j, new EnemigoBasico (posX, posY, tipo));
             posY += separacionY;        		 

         }
         posY = inicialY;
         posX += separacionX;
      }
   }

   public Enemigo izquierda () {
      Iterator<Enemigo> iter = this.iterator ();
      Enemigo limite = null;
      
      while (iter.hasNext ()) {
         limite = iter.next ();
         if (limite.isVivo ()) {
            break;
         }
      }
      
      while (iter.hasNext ()) {
         Enemigo aux = iter.next ();
         if (aux.isVivo ()) {
            if (aux.getX () < limite.getX ()) {
               limite = aux;
            }
         }
      }
      return limite;
   }

   public Enemigo derecha () {
      Iterator<Enemigo> iter = this.iterator ();
      Enemigo limite = null;
      
      while (iter.hasNext ()) {
         limite = iter.next ();
         if (limite.isVivo ()) {
            break;
         }
      }
      
      while (iter.hasNext ()) {
         Enemigo aux = iter.next ();
         if (aux.isVivo ()) {
            if (aux.getX () > limite.getX ()) {
               limite = aux;
            }
         }
      }
      return limite;
   }

   public Enemigo arriba () {
      Iterator<Enemigo> iter = this.iterator ();
      Enemigo limite = iter.next ();
      while (iter.hasNext ()) {
         Enemigo aux = iter.next ();

         if (aux.isVivo () && aux.getY () < limite.getY ()) {
            limite = aux;
         }
      }
      return limite;
   }

   public Enemigo abajo () {
      Iterator<Enemigo> iter = this.iterator ();
      Enemigo limite = iter.next ();
      while (iter.hasNext ()) {
         Enemigo aux = iter.next ();
         if (aux.isVivo () && aux.getY () > limite.getY ()) {
            limite = aux;
         }
      }
      return limite;
   }

   public Enemigo[][] getMatrizEnemigos () {
      return matrizEnemigos;
   }

   public void setMatrizEnemigos (Enemigo[][] matrizEnemigos) {
      this.matrizEnemigos = matrizEnemigos;
   }

   public Enemigo getEnemigo (int i, int j) {
      return getMatrizEnemigos ()[i][j];
   }

   public void setEnemigo (int i, int j, Enemigo enemigo) {
      getMatrizEnemigos ()[i][j] = enemigo;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Iterable#iterator()
    */
   @Override
   public Iterator<Enemigo> iterator () {
      return new IteratorTabla (this);
   }


   /**
    * @return the ancho
    */
   public int getAncho () {
      return ancho;
   }


   /**
    * @param ancho
    *           the ancho to set
    */
   public void setAncho (int ancho) {
      this.ancho = ancho;
   }


   /**
    * @return the alto
    */
   public int getAlto () {
      return alto;
   }


   /**
    * @param alto
    *           the alto to set
    */
   public void setAlto (int alto) {
      this.alto = alto;
   }

   /**
    * @param movimiento
    */
   public void moverAbajo (int movimiento) {
      Iterator<Enemigo> iter = iterator ();
      while (iter.hasNext ()) {
         iter.next ().moverY (movimiento);
      }
   }

   /**
    * @param movimiento
    */
   public void moverArriba (int movimiento) {
      Iterator<Enemigo> iter = iterator ();
      while (iter.hasNext ()) {
         iter.next ().moverY (-movimiento);
      }
   }

   /**
    * @param movimiento
    */
   public void moverIzquierda (int movimiento) {
      Iterator<Enemigo> iter = iterator ();
      while (iter.hasNext ()) {
         iter.next ().moverX (-movimiento);
      }
   }

   /**
    * @param movimiento
    */
   public void moverDerecha (int movimiento) {
      Iterator<Enemigo> iter = iterator ();
      while (iter.hasNext ()) {
         iter.next ().moverX (movimiento);
      }
   }

   /**
    * @return
    */
   public boolean isEmpty () {
      boolean vacia = true;
      
      Iterator<Enemigo> iter = iterator ();
      while (iter.hasNext ()) {
         if (iter.next ().isVivo ())
            vacia = false;
      }
      
      return vacia;
   }
}
