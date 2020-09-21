package model;

public class Client {

	private String name;
	private int cedula;
	private int time;
	private int amount;
	
	public Client(String name, int cedula, int time, int amount) {
		super();
		this.name = name;
		this.cedula = cedula;
		this.time = time;
		this.amount = amount;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
