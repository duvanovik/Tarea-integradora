package model;

public class BankAccount {

	private String id;
	private int ammount;
		
	public BankAccount(String id, int ammount) {
		super();
		this.id = id;
		this.ammount = ammount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAmmount() {
		return ammount;
	}
	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}
	
	
	
}
