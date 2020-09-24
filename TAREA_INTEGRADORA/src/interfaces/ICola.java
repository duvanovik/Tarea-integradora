package interfaces;

import model.Client;

public interface ICola {

	public void enqueue(Client e);
	
	public void dequeue(); 
	
	public Client getFront(); 
	
	public int size(); 
	
	public boolean isEmpty(); 
	
}