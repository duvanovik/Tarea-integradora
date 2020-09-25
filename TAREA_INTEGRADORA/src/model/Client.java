package model;

public class Client {

	private String name;
	private int cedula;
	private int time;
	private BankAccount bankAccount;
	private String datePaymentCard;
	private String dateIncorporation;
	private CreditCard tarjetaDeCredito;
	
	public Client(String name, int cedula, int time, BankAccount bankAccount,
			String datePaymentCard, String dateIncorporation,CreditCard tarjeta) {
		super();
		this.name = name;
		this.cedula = cedula;
		this.time = time;
		this.bankAccount = bankAccount;
		this.datePaymentCard = datePaymentCard;
		this.dateIncorporation = dateIncorporation;
		this.tarjetaDeCredito=tarjeta;
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
	
	/**
	 * Con este método pagamos con la tarjeta de credito del cliente.
	 * @param dinero
	 * @return
	 * @author Andres Cuellar
	 */
	public int pagarTarjeta(int dinero) {
		int dineroAPagar = tarjetaDeCredito.getDeuda();
		tarjetaDeCredito.setDeuda(dineroAPagar-dinero);
		return tarjetaDeCredito.getDeuda();
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
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
	public CreditCard getTarjetaDeCredito() {
		return tarjetaDeCredito;
	}
	public void setTarjetaDeCredito(CreditCard tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	
	
	
	
}
