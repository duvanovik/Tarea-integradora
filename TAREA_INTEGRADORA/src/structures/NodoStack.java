package structures;


public class NodoStack<E>{
	private NodoStack<E> next;
	private NodoStack<E> last;
	private E value;
	
	public NodoStack(E value){
		super();
		this.next = null;
		this.last = null;
		this.value = value;
	}
	public NodoStack<E> getLast() {
		return last;
	}

	public void setLast(NodoStack<E> last) {
		this.last = last;
	}
	
	public NodoStack<E> getNext() {
		return next;
	}

	public void setNext(NodoStack<E> next) {
		this.next = next;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}
}
