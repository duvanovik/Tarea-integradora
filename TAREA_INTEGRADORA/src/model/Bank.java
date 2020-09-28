package model;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import structures.Cola;

public class Bank {

	//Este HashMap hay que reemplazarla por la de implementación propia.
	private HashMap<Integer, Client> hasMBaseDatosClientes ;
	
	private Cola<Client> fila;
	private Cola<Client> filaPrioritaria;
	
	private Client previoAtender;
	private Client enAtencion;
	
	private ArrayList<Client> desertor;
	
	private ArrayList<Client> customers;
	
	public Bank() {
		customers = new ArrayList<Client>();
		hasMBaseDatosClientes=new HashMap<Integer, Client>();
		fila=new Cola<Client>();
		filaPrioritaria=new Cola<Client>();
		previoAtender=null;
		enAtencion=null;
		cargarClientes();
		desertor= new ArrayList<Client>();
	}
	
	
	
	/**
	 * Este metodo se encarga de agregar a un cliente a la fila de prioridad o no.
	 * @param prioritario - Boolean que determina si la persona necesita o no estar en la fila de prioridad
	 * @param cliente - Persona que está registrada en el sistema y a quien se le asignará un turno.
	 * @return El resultado de la operación.
     * @author Gustavo Villada
	 */
	public void asignarTurno(boolean prioritario, Client cliente) {
				
		if(prioritario==true) {
			filaPrioritaria.insertar(cliente);
		}else {
			fila.insertar(cliente);
		}
		
	}
	
	
	/**
	 * Este método retorna el cliente que sigue en la fila al cual se mostrarán sus datos previo a la atención del empleado.
	 * @return el cliente que sigue en la fila.
     * @author Gustavo Villada
	 */
	public Client siguienteTurno() {
		
		Client prevAtender=null;
		
		if(filaPrioritaria.colaVacia()) {
			prevAtender=fila.extraer();
			this.previoAtender=prevAtender;
			return prevAtender;
		}else {
			prevAtender=filaPrioritaria.extraer();
			this.previoAtender=prevAtender;
			return prevAtender;		}
		
	}
	
	
	/**
	 * Este método se encarga de convertir una cola en un ArrayList.
	 * @param c - Cola de la cual queremos pasar sus elementos.
	 * @return ArrayList con los elementos ingresados desde la cola.
     * @author Gustavo Villada
	 */
	public ArrayList<Client> convertirAArrayList(Cola<Client> c) {
		Cola<Client> auxCola=c;
		
		int tamano=c.getTamano();
		ArrayList<Client> clients=new ArrayList<Client>();
		for(int i=0;i<tamano;i++) {
			
			Client aux= (Client) auxCola.extraer();
			clients.add(aux);
			auxCola.insertar(aux);

		}

		return clients;
		
	}
	
	/**
	 * Este metodo va a subir algunos clientes al hashMap para probar.
     * @author Gustavo Villada
	 */
	public void cargarClientes() {

		BankAccount ba=new BankAccount("1213-2123", 3500000);
		Client client= new Client("Gustavo Villada", 11111, 15, ba, "12-12-2012", "18-May-2009",new CreditCard(40000));
		hasMBaseDatosClientes.put(client.getCedula(), client);
		customers.add(client);

		ba=new BankAccount("6541-0872", 4500000);
		client= new Client("Oscar Villada", 22222, 25 , ba, "12-12-2012", "18-May-2009",new CreditCard(5500));
		hasMBaseDatosClientes.put(client.getCedula(), client);
		customers.add(client);

		ba=new BankAccount("2165-4588", 1220000);
		client= new Client("Wanda Villacorte", 33333, 45, ba, "12-12-2012", "18-May-2009",new CreditCard(12222));
		hasMBaseDatosClientes.put(client.getCedula(), client);
		customers.add(client);
		
		
		ba=new BankAccount("1247-9762", 3330000);
		client= new Client("Ana Villada", 44444, 65, ba, "12-12-2012", "18-May-2009",new CreditCard(0));
		hasMBaseDatosClientes.put(client.getCedula(), client);
		
	
	}
	/**
	 * Con este método borramos la cuenta el cliente.
	 * @param 
	 * @return
	 * @author Andres Cuellar
	 */
	
	public void cancelarCuenta() {
		Client client= hasMBaseDatosClientes.get(enAtencion.getCedula());
		hasMBaseDatosClientes.remove(client.getCedula());
		setEnAtencion(null);
		desertor.add(client);
	}

	public HashMap<Integer, Client> getHm() {
		return hasMBaseDatosClientes;
	}

	public void setHm(HashMap<Integer, Client> hm) {
		this.hasMBaseDatosClientes = hm;
	}

	public Cola<Client> getFila() {
		return fila;
	}

	public void setFila(Cola<Client> fila) {
		this.fila = fila;
	}

	public Cola<Client> getFilaPrioritaria() {
		return filaPrioritaria;
	}

	public void setFilaPrioritaria(Cola<Client> filaPrioritaria) {
		this.filaPrioritaria = filaPrioritaria;
	}

	public Client getPrevioAtender() {
		return previoAtender;
	}

	public void setPrevioAtender(Client previoAtender) {
		this.previoAtender = previoAtender;
	}

	public Client getEnAtencion() {
		return enAtencion;
	}

	public void setEnAtencion(Client enAtencion) {
		this.enAtencion = enAtencion;
	}

	public ArrayList<Client> getDesertor() {
		return desertor;
	}

	public void setDesertor(ArrayList<Client> desertor) {
		this.desertor = desertor;
	}
	  public void sortById( )
	    {
	        int initial;

	        for( initial = 0; initial < customers.size( ); initial++ )
	        {
	            int minorPosition = initial;
	            Client minorCustomer = ( Client )customers.get( initial );

	            // Buscar el perro de menor edad entre inicial y final
	            for( int i = initial + 1; i < customers.size( ); i++ )
	            {
	                Client positionCustomer = ( Client )customers.get( i );

	                if( positionCustomer.compararPorId(minorCustomer ) < 0 )
	                {
	                    minorCustomer = positionCustomer;
	                    minorPosition = i;
	                }
	            }

	            if( minorPosition != initial )
	            {
	                Client temp = ( Client )customers.get( initial );
	                customers.set( initial, minorCustomer );
	                customers.set( minorPosition, temp );
	            }

	        }
	    }
	
	/**
	 * Con este método mostramos los clientes que desertaron del banco.
	 * @param 
	 * @return
	 * @author Andres Cuellar
	 */
	public void mostrarDesertores() {
		for (int i = 0; i < desertor.size(); i++) {
			System.out.println(desertor.get(i).getName());
		}
	}
	
	
	
	
	
	
	
}
