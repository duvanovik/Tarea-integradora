package structures;

import excepciones.StackVacioException;
import interfaces.IStack;

public class Stack<E> implements IStack<E> {
	private NodoStack<E> top;
	private int size;
	
	public Stack() {
		super();
		this.top = null;
		this.size = 0;
	}
	
	public void setTop(NodoStack<E> top) {
		this.top = top;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void push(E newElement) {
		NodoStack<E> n = new NodoStack<E>(newElement); 
		
		if(size == 0) {
			top = n; 
			size++; 
		}
		else {
			top.setNext(n);
			top.getNext().setLast(top);
			this.top = n; 
			size++; 
		}
		
		
	}
	
	@Override
	public void pop() {
		if(size == 0) {
			new StackVacioException("Stack is Empty");
		}
		else if(size == 1) {
			top = null; 
			size--; 
		}
		else {
			NodoStack<E> temp = top; 
			this.top = temp.getLast();
			temp.setLast(null);
			this.top.setNext(null);
			size--; 
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else 
			return false; 
	}

	@Override
	public NodoStack<E> top() {
		return this.top;
		
	}

}
