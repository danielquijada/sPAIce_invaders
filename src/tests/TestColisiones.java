/**
 * sPAIce_invaders.tests.TestColisiones.java
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
package tests;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import modelo.EnemigoBasico;
import modelo.NaveBasica;
import modelo.ProyectilBasico;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * TODO Descripción de la clase.
 */
public class TestColisiones {

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testColisionProyectilNaveTrue() {
		ProyectilBasico proyectil = new ProyectilBasico(0, 0, 0);
		NaveBasica nave = new NaveBasica(0, 0);
				
		Rectangle proyect = new Rectangle (proyectil.getX (), proyectil.getY (), proyectil.getSize ().x, proyectil.getSize ().y);
	    Rectangle element = new Rectangle (nave.getX (), nave.getY (), nave.getSize ().x,nave.getSize ().y);
	    	    
		assertTrue(proyect.intersects(element));	
	}

	@Test
	public void testColisionProyectilNaveFalse() {
		ProyectilBasico proyectil = new ProyectilBasico(200, 200, 0);
		NaveBasica nave = new NaveBasica(0, 0);
				
		Rectangle proyect = new Rectangle (proyectil.getX (), proyectil.getY (), proyectil.getSize ().x, proyectil.getSize ().y);
	    Rectangle element = new Rectangle (nave.getX (), nave.getY (), nave.getSize ().x,nave.getSize ().y);
	    	    
		assertFalse(proyect.intersects(element));	
	}
	
	@Test
	public void testColisionProyectilProyectil() {
		ProyectilBasico proyectil1 = new ProyectilBasico(0, 0, 0);
		ProyectilBasico proyectil2 = new ProyectilBasico(0, 0, 0);
		
		Rectangle proyect1 = new Rectangle (proyectil1.getX (), proyectil1.getY (), proyectil1.getSize ().x, proyectil1.getSize ().y);
		Rectangle proyect2 = new Rectangle (proyectil2.getX (), proyectil2.getY (), proyectil2.getSize ().x, proyectil2.getSize ().y);	    
		
		assertTrue(proyect1.intersects(proyect2));
	}
	
	@Test
	public void testColisionProyectilEnemigo() {
		ProyectilBasico proyectil = new ProyectilBasico(0, 0, 0);
		EnemigoBasico enemigo = new EnemigoBasico(0, 0, 0);
		
		Rectangle proyect = new Rectangle (proyectil.getX (), proyectil.getY (), proyectil.getSize ().x, proyectil.getSize ().y);
		Rectangle enemy = new Rectangle (enemigo.getX (), enemigo.getY (), enemigo.getSize ().x, enemigo.getSize ().y);	    
		
		assertTrue(proyect.intersects(enemy));
	}	

}
