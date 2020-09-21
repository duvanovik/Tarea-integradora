package structures;

public class NodoHash<T> {

	private NodoHash next;
	T valor;
	int key;
	int position;
	
	public NodoHash(T valor, int key) {
		this.next=null;
		this.valor=valor;
		this.key=key;
		this.position=0;
	
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public NodoHash getPrev() {
		return next;
	}

	public void setPrev(NodoHash prev) {
		this.next = prev;
	}

	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
	
	
	
	
	
}
