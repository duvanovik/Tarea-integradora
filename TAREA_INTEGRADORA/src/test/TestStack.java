package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.BankAccount;
import model.Client;
import model.CreditCard;
import structures.Stack;

class TestStack {
	private Stack<Client> s = new Stack<>();
	private Client c1;
	public void setup1() {
		c1=new Client("Andres Cuellar", 77777, 16, new BankAccount("1213-2123", 777777777), "11-11-2011", "11-feb-2001",new CreditCard(700000));

	}
	public void setup2() {
		s.push(new Client("Gustavo Villada", 11111, 15, new BankAccount("1213-2123", 3500000), "12-12-2012", "18-May-2009",new CreditCard(40000)));

	}
	public void setup3() {
		s.push(new Client("Gustavo Villada", 11111, 15, new BankAccount("1213-2123", 3500000), "12-12-2012", "18-May-2009",new CreditCard(40000)));
		s.push(new Client("Andres Cuellar", 77777, 16, new BankAccount("1213-2123", 777777777), "11-11-2011", "11-feb-2001",new CreditCard(700000)));
		s.push( new Client("Oscar Villada", 22222, 25, new BankAccount("6541-0872", 4500000), "12-12-2012", "18-May-2009",new CreditCard(5500)));
	}
	public void setup4() {
		s.push(new Client("Gustavo Villada", 11111, 15, new BankAccount("1213-2123", 3500000), "12-12-2012", "18-May-2009",new CreditCard(40000)));
		s.push(new Client("Andres Cuellar", 77777, 16, new BankAccount("1213-2123", 777777777), "11-11-2011", "11-feb-2001",new CreditCard(700000)));
		s.push( new Client("Oscar Villada", 22222, 25, new BankAccount("6541-0872", 4500000), "12-12-2012", "18-May-2009",new CreditCard(5500)));
		s.push(new Client("Wanda Villacorte", 33333, 45,  new BankAccount("2165-4588", 1220000), "12-12-2012", "18-May-2009",new CreditCard(12222)));
	}
	
	public void setup5() {
		s.push(new Client("Gustavo Villada", 11111, 15, new BankAccount("1213-2123", 3500000), "12-12-2012", "18-May-2009",new CreditCard(40000)));
		s.push(new Client("Andres Cuellar", 77777, 16, new BankAccount("1213-2123", 777777777), "11-11-2011", "11-feb-2001",new CreditCard(700000)));
		s.push( new Client("Oscar Villada", 22222, 25, new BankAccount("6541-0872", 4500000), "12-12-2012", "18-May-2009",new CreditCard(5500)));
		s.push(new Client("Wanda Villacorte", 33333, 45,  new BankAccount("2165-4588", 1220000), "12-12-2012", "18-May-2009",new CreditCard(12222)));
		s.push( new Client("Fabian Cuellar", 88888, 1,new BankAccount("1244-2144", 888888), "11-11-2011", "1-oct-2015",new CreditCard(80000)));
	}
	@Test
	void testPush() {
		setup1();
		s.push(c1);
		assertTrue(s.top().getValue().getName().equals(c1.getName()));
		assertTrue(s.top().getValue().getCedula()== c1.getCedula());
		assertTrue(s.top().getValue().getBankAccount().equals(c1.getBankAccount()));
		assertTrue(s.top().getValue().equals(c1));
	}
	@Test
	void testSize() {
		setup2();
		assertTrue(s.size() == 1);
		s.push(new Client("Andres Cuellar", 77777, 16, new BankAccount("1213-2123", 777777777), "11-11-2011", "11-feb-2001",new CreditCard(700000)));
		assertTrue(s.size() == 2);
	}
	@Test
	void testPop() {
		setup3();
		assertTrue(s.size() == 3);
		s.pop();
		assertTrue(s.size() == 2);
		s.pop();
		assertTrue(s.size() == 1);
		s.pop();
		assertTrue(s.size() == 0);

	}
	@Test
	void testIsEmpty() {
		setup4();
		assertFalse(s.isEmpty());
		s.pop();
		assertFalse(s.isEmpty());
		s.pop();
		assertFalse(s.isEmpty());
		s.pop();
		assertFalse(s.isEmpty());
		s.pop();
		assertTrue(s.isEmpty());
	}
	@Test
	void testTop() {
		setup5();
		assertTrue(s.top().getValue().getName().equals("Fabian Cuellar"));
		assertTrue(s.top().getValue().getCedula()==88888);
		s.pop();
		assertTrue(s.top().getValue().getName().equals("Wanda Villacorte"));
		assertTrue(s.top().getValue().getCedula()==33333);
		s.pop();
		assertTrue(s.top().getValue().getName().equals("Oscar Villada"));
		assertTrue(s.top().getValue().getCedula()==22222);
		s.pop();
		assertTrue(s.top().getValue().getName().equals("Andres Cuellar"));
		assertTrue(s.top().getValue().getCedula()==77777);
		s.pop();assertTrue(s.top().getValue().getName().equals("Gustavo Villada"));
		assertTrue(s.top().getValue().getCedula()==11111);
		
		
		
	}


}