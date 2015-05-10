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


/**
 * Tabla que contiene todos los enemigos, dispuestos en una matriz bidimensional.
 * Incluye métodos para acceder a coordenadas i,j de la matriz.
 */
public class Tabla {

   /**
    * 
    */
	private Enemigo[][] matrizEnemigos;
	private final int SEPARACION = 10;
	private final int INICIAL_X = 10;
	private final int INICIAL_Y = 10;
   
   public Tabla (int tamanioX, int tamanioY) {
	      setMatrizEnemigos(new Enemigo[tamanioX][tamanioY]);
	      int posX = INICIAL_X;
	      int posY = INICIAL_Y;
	      
	      for(int i = 0; i < tamanioX; i++){
	    	  for(int j = 0; j < tamanioY; j++){
	    		  setEnemigo(i, j, new EnemigoBasico(posX, posY));
	    		  posX += SEPARACION;
	    	  }
	    	  posY += SEPARACION;
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
   
   

}
