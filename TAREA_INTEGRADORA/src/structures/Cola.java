package structures;

import javax.swing.JOptionPane;

public class Cola<T> {

	private NodoCola inicioCola,finalCola;
	private int tamano;
	
	private String cola="";
	public Cola() {
		inicioCola=null;
		finalCola=null;
		tamano=0;
	}
	
	public boolean colaVacia() {
		
		if(inicioCola==null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	//Este m�todo inserta al final.
	public void insertar(T elemento) {
		
		NodoCola nuevo_nodo = new NodoCola(elemento);
		
		if(colaVacia()==true) {
			
			inicioCola=nuevo_nodo;
			finalCola=nuevo_nodo;	
			
		}else {
			
			finalCola.siguiente = nuevo_nodo;
			finalCola = nuevo_nodo;
		
		}
		
		tamano++;
	}
	
	
	public T extraer() {
		
		if(colaVacia()==false) {
			T elemento=(T) inicioCola.elemento;
		
			if(inicioCola ==finalCola) {
				inicioCola=null;
				finalCola=null;
			}else {
				inicioCola=inicioCola.siguiente;
			}
		
			tamano--;
			return elemento;
		}else {
			return null;
		}
	}
	
	//Imprimir en pantalla el comportamiento.
	public void mostrarContenido() {
		NodoCola recorrido= inicioCola;
		String colaInvertida="";
		
		while(recorrido!=null) {
			cola+=recorrido.elemento+" ";
			recorrido=recorrido.siguiente;
		}
		
		String cadena[] = cola.split(" ");
		
		for(int i=cadena.length-1;i>=0;i--) {
			colaInvertida+=" "+cadena[i];
		}
		
		JOptionPane.showMessageDialog(null, colaInvertida);
		cola="";
	}

	public NodoCola getInicioCola() {
		return inicioCola;
	}

	public void setInicioCola(NodoCola inicioCola) {
		this.inicioCola = inicioCola;
	}

	public NodoCola getFinalCola() {
		return finalCola;
	}

	public void setFinalCola(NodoCola finalCola) {
		this.finalCola = finalCola;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	
	
	
}
