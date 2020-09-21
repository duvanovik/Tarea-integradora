package structures;

public class NodoCola<T> {

	T elemento;
	NodoCola siguiente;
	
	public NodoCola(T elemento) {
		this.elemento=elemento;
		this.siguiente=null;
		
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public NodoCola getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoCola siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
}
