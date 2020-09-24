package interfaces;

import structures.NodoStack;

public interface IStack<E>{
	int size();
	boolean isEmpty();
	void push(E e);
	NodoStack<E> top();
	void pop();
}

