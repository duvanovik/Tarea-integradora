package interfaces;

import model.Client;

public interface IStack<E>{
	int size();
	boolean isEmpty();
	void push(E e);
	Client top();
	void pop();
}

