package test;

import static org.junit.Assert.*;

import org.junit.Test;

import structures.Cola;
import structures.HashMap;

public class HashMapTest {

	private HashMap<Integer,String> hashMap; 
	
	
	private void setupScenary1() {

		hashMap=new HashMap<Integer,String>();		
	}
	
	private void setupScenary2() {
		hashMap=new HashMap<Integer,String>();
		hashMap.put(14,"FA");
		hashMap.put(6, "MI");
		hashMap.put(2, "DO");

	}
	
	
	@Test
	public void put() {
		setupScenary1();
		String value="SOL";
		int key=28;
		
		hashMap.put(key,value);
		
		assertTrue(hashMap.contains(key)==true);
		
	}
	
	
	@Test
	public void contains() {
		setupScenary1();
		int keyInsertar=196;
		String valueInsertar="CALI";
		
		hashMap.put(keyInsertar, valueInsertar);
		boolean contiene=hashMap.contains(keyInsertar);
		
		assertTrue(contiene==true);
		
		
		
		int keyQueNoEsta=56;
		contiene=hashMap.contains(keyQueNoEsta);
		
		assertTrue(contiene==false);
		
	}
	

	@Test
	public void get() {
		setupScenary2();
		int keyInsertar=196;
		String dataInsertar="CALI";
		
		hashMap.put(keyInsertar, dataInsertar);
		
		String obtenerDataInsertada=hashMap.get(keyInsertar);
		
		assertTrue(dataInsertar==obtenerDataInsertada);
		
	}
	

	@Test
	public void delete() {
		setupScenary2();
		int keyInsertar=196;
		String dataInsertar="CALI";
		
		hashMap.put(keyInsertar, dataInsertar);
		
		boolean agregada=hashMap.contains(keyInsertar);
		assertTrue(agregada==true);
		
		
		boolean eliminada=hashMap.delete(keyInsertar);
		assertTrue(eliminada==true);
		
		agregada=hashMap.contains(keyInsertar);
		assertTrue(agregada==false);
				
	}
	
}
