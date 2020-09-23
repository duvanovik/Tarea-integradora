package model;

public class Client {

	private String name;
	private int cedula;
	private int time;
	private BankAccount bankAccount;
	private int creditCards;
	private String datePaymentCard;
	private String dateIncorporation;
	
	public Client(String name, int cedula, int time, BankAccount bankAccount, int creditCards,
			String datePaymentCard, String dateIncorporation) {
		super();
		this.name = name;
		this.cedula = cedula;
		this.time = time;
		this.bankAccount = bankAccount;
		this.creditCards = creditCards;
		this.datePaymentCard = datePaymentCard;
		this.dateIncorporation = dateIncorporation;
		
	}
	
	/**
	 * con este método retiramos dinero de la cuenta bancaria del cliente
	 * @param dinero
	 * @return
	 * @author Gustavo Villada
	 */
	public boolean retirarDinero(int dinero) {
		
		if((bankAccount.getAmmount()-dinero)>0) {
			int amm=bankAccount.getAmmount();
			bankAccount.setAmmount(amm-dinero);
			return true;
		}else {
			return false;
		}
		
	}
	
	
	/**
	 * Con este método consignamos dinero a la cuenta bancaria del cliente.
	 * @param dinero
	 * @return
	 * @author Gustavo Villada
	 */
	public int consignarDinero(int dinero) {
		
		int dineroCuenta=bankAccount.getAmmount();
		bankAccount.setAmmount(dineroCuenta+dinero);
		
		return bankAccount.getAmmount();
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	public int getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(int creditCards) {
		this.creditCards = creditCards;
	}
	public String getDatePaymentCard() {
		return datePaymentCard;
	}
	public void setDatePaymentCard(String datePaymentCard) {
		this.datePaymentCard = datePaymentCard;
	}
	public String getDateIncorporation() {
		return dateIncorporation;
	}
	public void setDateIncorporation(String dateIncorporation) {
		this.dateIncorporation = dateIncorporation;
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

	
	
	
	
}
