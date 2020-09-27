package model;

public class CreditCard implements Cloneable{
	private int deuda;
	
	
	public CreditCard(int laDeuda) {
		this.deuda =laDeuda ;
		
	}

	public int getDeuda() {
		return deuda;
	}

	

	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}
	
	/**
	 * Con este método clonamos la tarjeta.
	 * @param 
	 * @return
	 * @author Andres Cuellar
	 */
	public CreditCard clone() {
		return new CreditCard(deuda);
	}
}
