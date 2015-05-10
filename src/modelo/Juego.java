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


/**
 * Esta clase agrupa todos los elementos que participan en el juego o influyen en estos.
 * En nuestro caso son la nave, enemigos, proyectiles, temporizadores...
 */
public class Juego {

   /**
    * 
    */
	
	Tabla enemigos;
	ArrayList<Nave> naves;
	ArrayList<Proyectil> proyectiles;
	
   public Juego () {
      // TODO Auto-generated constructor stub
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
   
   

}
