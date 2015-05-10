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
 * Tabla que contiene todos los enemigos, dispuestos en una matriz bidimensional.
 * Incluye métodos para acceder a coordenadas i,j de la matriz.
 */
public class Tabla implements Iterable {

   /**
    * 
    */
	private Enemigo[][] matrizEnemigos;
	private final static int SEPARACION = 50;
	private int ancho;
	private int alto;
   
   public Tabla (int tamanioX, int tamanioY, int totalX, int totalY) {
	      setMatrizEnemigos(new Enemigo[tamanioX][tamanioY]);
	      setAncho (tamanioX);
	      setAlto (tamanioY);
	      
	      int inicialX = (int)((double)totalX / (double)(2 * tamanioX));
	      int inicialY = (int)((double)totalY / (double)(2 * tamanioY));
	      
	      int posX = inicialX;
	      int posY = inicialY;
	      int separacionX = (int)(((double)totalX / (double)(tamanioX)));
         int separacionY = (int)(((double)totalY / (double)(tamanioY)));
	      for(int i = 0; i < tamanioX; i++){
	    	  for(int j = 0; j < tamanioY; j++){
	    		  setEnemigo(i, j, new EnemigoBasico(posX, posY));
	    		  posY += separacionY;
	    	  }
	    	  posY = inicialY;
	    	  posX += separacionX;
	      }
   }

	public Enemigo[][] getMatrizEnemigos() {
		return matrizEnemigos;
	}
	
	public void setMatrizEnemigos(Enemigo[][] matrizEnemigos) {
		this.matrizEnemigos = matrizEnemigos;
	}
	
	public Enemigo getEnemigo(int i, int j) {
		return getMatrizEnemigos()[i][j];
	}
	
	public void setEnemigo(int i, int j, Enemigo enemigo) {
		getMatrizEnemigos()[i][j] = enemigo;
	}

   /* (non-Javadoc)
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
    * @param ancho the ancho to set
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
    * @param alto the alto to set
    */
   public void setAlto (int alto) {
      this.alto = alto;
   }
   
   

}
