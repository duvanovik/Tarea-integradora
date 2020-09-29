package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Bank;
import model.BankAccount;
import model.Client;

	public class Sort_WindowController implements Initializable {


	    @FXML
	    private ComboBox<String> cboxParametrosOrdenar;

	    @FXML
	    private TableView<Client> tvClientes;

	    @FXML
	    private Button btnOrdenar;
	    
	    private Bank b;
	    
	    private ObservableList<Client> filaClientes;
	    

	    @FXML
	    private TableColumn<Client, String> tcName;

	    @FXML
	    private TableColumn<Client, Integer> tcCedula;

	    @FXML
	    private TableColumn<Client, Integer> tcAmount;
	 

	    /**
	     * Inicializa la ventana con el ComboBox ya lleno.
	     */
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			b = new Bank();	


			agregarParametrosOrdenar();
		}
		
		   @FXML
		public void ordenarClientes(ActionEvent event) {
			   if(cboxParametrosOrdenar.getValue().equals("CEDULA")) {
				   b.sortById();
				   ordenarPorCedula();
				   System.out.println("xd");
			   }
			   else if(cboxParametrosOrdenar.getValue().equals("NOMBRE")) {
				   b.sortClientsByName();
				   ordenarPorNombre();
				   System.out.println("xd2");
			   }
			   else if(cboxParametrosOrdenar.getValue().equals("MONTO")) {
				   b.sortByAmount();
				   ordenarPorMonto();
				   System.out.println("xd3");
			   }
		}
		   
		public void ordenarPorCedula() {
			ArrayList<Client> customers = b.getCustomers();
			filaClientes = FXCollections.observableArrayList(customers);
			tvClientes.setItems(filaClientes);
	    	tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	tcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
	    	tcAmount.setCellValueFactory(new PropertyValueFactory<>("monto"));

		}
		public void ordenarPorNombre() {
			ArrayList<Client> customers = b.getCustomers();
			filaClientes = FXCollections.observableArrayList(customers);
			tvClientes.setItems(filaClientes);
			tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	tcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
	    	tcAmount.setCellValueFactory(new PropertyValueFactory<>("monto"));
		}
		public void ordenarPorMonto() {
			ArrayList<Client> customers = b.getCustomers();
			filaClientes = FXCollections.observableArrayList(customers);
			tvClientes.setItems(filaClientes);
			tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
	    	tcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
	    	tcAmount.setCellValueFactory(new PropertyValueFactory<>("monto"));
		}

		/**
		 * Este método llena el ComboBox con las opciones para ordenar.
		 */
		public void agregarParametrosOrdenar() {
			
			List<String> parametros=new ArrayList<String>();
			ObservableList<String> te;
			parametros.add("CEDULA");
			parametros.add("TIEMPO");
			parametros.add("NOMBRE");
			parametros.add("MONTO");
			te=FXCollections.observableArrayList(parametros);
			cboxParametrosOrdenar.setItems(te);
			
		}


	}
