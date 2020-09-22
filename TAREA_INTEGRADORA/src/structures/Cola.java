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
	
	/**
	 * Este método se encarga de insertar un elemento a una Cola de tipo T.
	 * @param El lemento a insertar en la Cola.
     * @author Gustavo Villada
	 */
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
	
	
	/**
	 * Este método se encarga de eliminar el primer elemento agregado a la estructura de datos, y después lo retorna
	 * @return El elemento en la primera posición en la Cola.
     * @author Gustavo Villada
	 */
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
