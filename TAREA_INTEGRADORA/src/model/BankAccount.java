package model;



public class BankAccount implements Cloneable {

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
	public int compareByAmount(BankAccount u) {
		if(ammount == u.getAmmount())
			return 0;
		else if(ammount > u.getAmmount())
			return 1;
		else
			return -1;
	}
	
	/**
	 * Con este método clonamos el cuenta de banco.
	 * @param 
	 * @return
	 * @author Andres Cuellar
	 */
	public BankAccount clone() {
		return new BankAccount(id, ammount);
	}
	
}
