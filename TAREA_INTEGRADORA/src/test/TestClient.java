package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.StackVacioException;
import model.BankAccount;
import model.Client;
import model.CreditCard;

class TestClient {
	private Client client1;
	private BankAccount ba1;
	private Client client2;
	private BankAccount ba2;


	public void setup1() {
		ba1=new BankAccount("1213-2123", 3500000);
		client1 = new Client("Gustavo Villada", 11111, 15, ba1, "12-12-2012", "18-May-2009",new CreditCard(40000));
		ba2=new BankAccount("6541-0872", 4500000);
		client2= new Client("Oscar Villada", 22222, 25, ba2, "12-12-2012", "18-May-2009",new CreditCard(5500));

	}

	public void setup2(){
		ba1=new BankAccount("2165-4588", 1220000);
		client1= new Client("Wanda Villacorte", 33333, 45,  ba1, "12-12-2012", "18-May-2009",new CreditCard(12222));
		ba2=new BankAccount("1247-9762", 3330000);
		client2= new Client("Ana Villada", 44444, 65, ba2, "12-12-2012", "18-May-2009",new CreditCard(0));
	}

	public void setup3() {
		ba1=new BankAccount("1213-2123", 777777777);
		client1 = new Client("Andres Cuellar", 77777, 16, ba1, "11-11-2011", "11-feb-2001",new CreditCard(700000));
		ba2=new BankAccount("1244-2144", 888888);
		client2 = new Client("Fabian Cuellar", 88888, 1, ba2, "11-11-2011", "1-oct-2015",new CreditCard(80000));
	}
	
	public void setup4() {
		ba1=new BankAccount("1213-2123", 3500000);
		client1 = new Client("Gustavo Villada", 11111, 15, ba1, "12-12-2012", "18-May-2009",new CreditCard(40000));
	}

	@Test
	void testRetirarDinero() {
		setup1();

		int cuenta1 = ba1.getAmmount();

		client1.retirarDinero(1000);


		assertTrue(client1.getBankAccount().getAmmount() == cuenta1-1000);

		int cuenta2 = ba2.getAmmount();

		client2.retirarDinero(4000000);

		assertTrue(client2.getBankAccount().getAmmount() == cuenta2-4000000);
	}

	@Test
	void testConsignarDinero() {
		setup2();

		int cuenta1 = ba1.getAmmount();

		client1.consignarDinero(777777);

		assertTrue(client1.getBankAccount().getAmmount() == cuenta1+777777);

		int cuenta2 = ba2.getAmmount();

		client2.consignarDinero(50000);

		assertTrue(client2.getBankAccount().getAmmount() == cuenta2+50000);

	}


	@Test
	void testPagarTarjeta() {
		setup3();
		int deuda1 = client1.getTarjetaDeCredito().getDeuda();

		int cuenta1 = ba1.getAmmount();

		client1.pagarTarjeta(10000, 1);

		assertTrue(client1.getTarjetaDeCredito().getDeuda() == deuda1-10000);

		client1.pagarTarjeta(10000, 2);

		assertTrue(client1.getBankAccount().getAmmount() == cuenta1-10000 &&client1.getTarjetaDeCredito().getDeuda() == deuda1-10000*2);

		int deuda2 = client2.getTarjetaDeCredito().getDeuda();

		int cuenta2 = ba2.getAmmount();

		client2.pagarTarjeta(5555, 1);

		assertTrue(client2.getTarjetaDeCredito().getDeuda() == deuda2-5555);

		client2.pagarTarjeta(5555, 2);

		assertTrue(client2.getBankAccount().getAmmount() == cuenta2-5555 &&client2.getTarjetaDeCredito().getDeuda() == deuda2-5555*2);
	}


	@Test
	void testDarCopia() throws StackVacioException {
		
		setup4();
		int antesDeRetirar = client1.getBankAccount().getAmmount();
		
		client1.retirarDinero(10000);
		
		assertTrue(client1.darCopia().getBankAccount().getAmmount() == antesDeRetirar);
		
		int antesDeConsignar= client1.getBankAccount().getAmmount();
		
		client1.consignarDinero(1000);
		
		assertTrue(client1.darCopia().getBankAccount().getAmmount() == antesDeConsignar);
		
		int antesDePagar=client1.getTarjetaDeCredito().getDeuda();
		
		client1.pagarTarjeta(10000, 1);

		assertTrue(client1.darCopia().getTarjetaDeCredito().getDeuda() == antesDePagar);
		
		int cuentaDeespuesDeOperacion= client1.getBankAccount().getAmmount();
		
		int tarjetaDespuesDeOperacion =client1.getTarjetaDeCredito().getDeuda();
		
		client1.pagarTarjeta(10000, 2);
		
		Client aux =client1.darCopia();
		
		assertTrue(aux.getBankAccount().getAmmount() == cuentaDeespuesDeOperacion &&aux.getTarjetaDeCredito().getDeuda() == tarjetaDespuesDeOperacion);


		
	}
}
