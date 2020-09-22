package model;

public class Client {

	private String name;
	private int cedula;
	private int time;
	private int amount;
	private String bankAccount;
	private int creditCards;
	private String datePaymentCard;
	private String dateIncorporation;

	
	
	public Client(String name, int cedula, int time, int amount, String bankAccount, int creditCards,
			String datePaymentCard, String dateIncorporation) {
		super();
		this.name = name;
		this.cedula = cedula;
		this.time = time;
		this.amount = amount;
		this.bankAccount = bankAccount;
		this.creditCards = creditCards;
		this.datePaymentCard = datePaymentCard;
		this.dateIncorporation = dateIncorporation;
	}
	
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
