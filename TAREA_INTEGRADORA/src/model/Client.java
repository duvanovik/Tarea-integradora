package model;


import excepciones.StackVacioException;
import model.Client;
import structures.Stack;

public class Client implements Cloneable{

	private String name;
	private int cedula;
	private int time;
	private BankAccount bankAccount;
	private String datePaymentCard;
	private String dateIncorporation;
	private CreditCard tarjetaDeCredito;
	private Stack<Client> copiaOperaciones;
	private int monto;

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
		copiaOperaciones = new Stack<Client>();
		this.monto= bankAccount.getAmmount();
	}

	/**
	 * con este método retiramos dinero de la cuenta bancaria del cliente
	 * @param dinero
	 * @return
	 * @author Gustavo Villada
	 */
	public boolean retirarDinero(int dinero) {

		if((bankAccount.getAmmount()-dinero)>0) {
			copiaOperaciones.push(this.clone());
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
		
		copiaOperaciones.push(this.clone());
		int dineroCuenta=bankAccount.getAmmount();
		bankAccount.setAmmount(dineroCuenta+dinero);

		return bankAccount.getAmmount();
	}

	/**
	 * Con este método pagamos con la tarjeta de credito del cliente.
	 * @param dinero, cual
	 * @return la deuda con la que el cliente queda
	 * @author Andres Cuellar
	 */
	public int pagarTarjeta(int dinero, int cual) {
		int v=0;
		copiaOperaciones.push(this.clone());
		if(cual ==1) {
		int dineroAPagar = tarjetaDeCredito.getDeuda();
		tarjetaDeCredito.setDeuda(dineroAPagar-dinero);
		v= tarjetaDeCredito.getDeuda();
		}
		else if(cual == 2) {
			int valorDeLaCuenta = bankAccount.getAmmount();
			this.getBankAccount().setAmmount(valorDeLaCuenta-dinero);
			int dineroAPagar = tarjetaDeCredito.getDeuda();
			tarjetaDeCredito.setDeuda(dineroAPagar-dinero);
			v= tarjetaDeCredito.getDeuda();
		}
		return v;
	}

	/**
	 * Con este método damos  la copia del cliente antes de la  operacion .
	 * @param 
	 * @return
	 * @author Andres Cuellar
	 */
	public Client darCopia() throws StackVacioException {
		Client c;
		if(copiaOperaciones.isEmpty()) {
			throw new StackVacioException("NO SE HAN REGISTRADO OPERACIONES");
		}
		else {
		 c = copiaOperaciones.top().getValue();
		copiaOperaciones.pop();
		return c;
		}
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}
	public int getBankAccount1() {
		return bankAccount.getAmmount();
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
	public int getTarjetaDeCredito1() {
		return tarjetaDeCredito.getDeuda();
	}
	public void setTarjetaDeCredito(CreditCard tarjetaDeCredito) {
		this.tarjetaDeCredito = tarjetaDeCredito;
	}

	public Stack<Client> getCopiaOperaciones() {
		return copiaOperaciones;
	}

	public void setCopiaOperaciones(Stack<Client> copiaOperaciones) {
		this.copiaOperaciones = copiaOperaciones;
	}
	public int compararPorId(Client c) {
		if(cedula == c.getCedula())
			return 0;
		else if(cedula > c.getCedula())
			return 1;
		else
			return -1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "	" + monto + "\n";
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	/**
	 * Con este método clonamos el cliente.
	 * @param 
	 * @return
	 * @author Andres Cuellar
	 */
	public Client clone() {
		return new Client( name,  cedula,  time,  bankAccount.clone(),
				 datePaymentCard,  dateIncorporation, tarjetaDeCredito.clone());
	}


}
