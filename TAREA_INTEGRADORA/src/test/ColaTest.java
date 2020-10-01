package test;

import static org.junit.Assert.*;

import org.junit.Test;

import structures.Cola;

public class ColaTest {

	private Cola<Integer> cola; 
	
	
	private void setupScenary1() {

		cola=new Cola<Integer>();
		
	}
	
	private void setupScenary2() {

		cola=new Cola<Integer>();
		cola.insertar(9);
		cola.insertar(2);
		cola.insertar(5);
		cola.insertar(4);
		
	}
	
	
	@Test
	public void insertar() {
		setupScenary1();
		int numero=9;
		int sizeAntes=cola.getTamano();
		cola.insertar(numero);
		
		int sizeNow=cola.getTamano();
		assertTrue(sizeAntes==0);
		assertTrue(sizeNow==1);
		assertTrue(numero==(Integer)cola.getFinalCola().getElemento());
		
		
		setupScenary2();
		numero=3;
		cola.insertar(numero);
		assertTrue(numero==(Integer)cola.getFinalCola().getElemento());
		
		
		
	}
	
	
	@Test
	public void extraer() {
		setupScenary2();
		int primeroEnEntrar=(Integer)cola.getInicioCola().getElemento();
		int extraerPrimero=cola.extraer();
				
		assertTrue(primeroEnEntrar==extraerPrimero);
		
		
		setupScenary1();
		Object extraido=cola.extraer();
		assertTrue(extraido==null);
	}
	


}
