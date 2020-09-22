package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Bank;
import model.Client;
import structures.Cola;


public class Principal_WindowController implements Initializable{

    @FXML
    private Button btnAsignarTurno;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfCedula;

    @FXML
    private TableView<Client> tvClientePrevioAtender;

    @FXML
    private TableColumn<Client, String> tvClientePrevioAtenderNombre;

    @FXML
    private TableColumn<Client, Integer> tvClientePrevioAtenderCedula;

    @FXML
    private TableColumn<Client, String> tvClientePrevioAtenderCuentaBancaria;

    @FXML
    private TableColumn<Client, Integer> tvClientePrevioAtenderTarjetas;

    @FXML
    private TableColumn<Client, String> tvClientePrevioAtenderFechaPago;

    @FXML
    private TableColumn<Client, String> tvClientePrevioAtenderIncorporacion;
    
    @FXML
    private Button btnAtenderCliente;

    @FXML
    private Button btonSiguienteTurno;

    @FXML
    private TableView<Client> tvClientes;

    @FXML
    private TableView<Client> tvPrioridad;

    @FXML
    private MenuItem itemMenu;
    
    @FXML
    private CheckBox cbPrioritario;
    @FXML
    
    private TableColumn<Client, String> tcFilaClientesNombre;

    @FXML
    private TableColumn<Client,Integer> tcFilaClientesCedula;

    @FXML
    private TableColumn<Client, String> tcFilaClientesPNombre;

    @FXML
    private TableColumn<Client, Integer> tcFilaClientesPCedula;

    
    
    private Bank bank;
    
    private ObservableList<Client> filaPrioritarios;
    private ObservableList<Client> filaClientes;

    
    /**
     * Este evento es el encargado de asignar a qué fila debería ir un cliente (Clientes o prioridad), al tomar la cedula y el nombre de esta
     *  que entra al banco.
     * @author Gustavo Villada
     * @param event
     */
    @FXML
    void asignar_turno(ActionEvent event) {

    	boolean clientePrioritario=false;
    	if(cbPrioritario.isSelected()) {
    		clientePrioritario=true;
    	}
    	
    	if(tfNombre.getText().equals("")||tfCedula.getText().equals("")) {
    		
        	Alert alert=new Alert(AlertType.ERROR);
        	alert.setTitle("Lo sentimos");
        	alert.setContentText("Rellena todos los campos");
        	alert.showAndWait();
    	}else {
    		
    		if(bank.getHm().containsKey(Integer.parseInt(tfCedula.getText()))) {
    			int key=Integer.parseInt(tfCedula.getText().toString());
    			Client client=bank.getHm().get(key);
    			
    			bank.asignarTurno(clientePrioritario, client);

    			actualizarFilas();
    		}else {
            	Alert alert=new Alert(AlertType.INFORMATION);
            	alert.setTitle("Lo sentimos");
            	alert.setContentText("La cédula ingresada no está registrada en el sistema");
            	alert.showAndWait();
    		}
    		
    	}
    	
    }
    

    
    
    
    /**
     * Este método actualiza las tableView de filas con el nuevo cliente cada vez que se asigna un turno.
     * @author Gustavo Villada
     */
    private void actualizarFilas() {
    	
		ArrayList<Client> clientesFPrioritario=bank.convertirAArrayList(bank.getFilaPrioritaria());
		ArrayList<Client> clientesF=bank.convertirAArrayList(bank.getFila());

    	filaClientes = FXCollections.observableArrayList(clientesF);
    	tvClientes.setItems(filaClientes);
    	
    	tcFilaClientesNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
    	tcFilaClientesCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
   
	
    	filaPrioritarios = FXCollections.observableArrayList(clientesFPrioritario);
    	tvPrioridad.setItems(filaPrioritarios);
    	
    	tcFilaClientesPNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
    	tcFilaClientesPCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
		
		JOptionPane.showMessageDialog(null, "El cliente ha sido agregado a la fila satisfactoriamente");
    	tfCedula.setText("");
    	tfNombre.setText("");
    	cbPrioritario.setSelected(false);
	}






	/**
     * Este evento está encargado de tomar un cliente de las filas, y pasarlo a un estado de "cliente pendiente", donde su información estará 
     * visible en una tableView (Solo se podrá hacer este evento si no hay ningún "cliente pendiente").
     * @param event
     * @author Gustavo Villada
     */
    @FXML
    void siguiente_turno(ActionEvent event) {

    	Client preAtender=bank.siguienteTurno();
    	actualizarFilas();
    	actualizarInformacionCliente(preAtender);
    	
    }
    
	/**
     * Este evento está encargado de tomar un cliente de las filas, y pasarlo a un estado de "cliente pendiente", donde su información estará 
     * visible en una tableView (Solo se podrá hacer este evento si no hay ningún "cliente pendiente").
     * @param Cliente cuya información se va a mostrar en la tableView
     * @author Gustavo Villada
     */
    private void actualizarInformacionCliente(Client c) {

		ArrayList<Client> clientPrev=new ArrayList<Client>();
		clientPrev.add(c);
	    ObservableList<Client> clientePr;

    	clientePr = FXCollections.observableArrayList(clientPrev);
    	tvClientePrevioAtender.setItems(clientePr);
    	
    	tvClientePrevioAtenderNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
    	tvClientePrevioAtenderCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
    	tvClientePrevioAtenderCuentaBancaria.setCellValueFactory(new PropertyValueFactory<>("bankAccount"));
    	tvClientePrevioAtenderTarjetas.setCellValueFactory(new PropertyValueFactory<>("creditCards"));
    	tvClientePrevioAtenderFechaPago.setCellValueFactory(new PropertyValueFactory<>("datePaymentCard"));
    	tvClientePrevioAtenderIncorporacion.setCellValueFactory(new PropertyValueFactory<>("dateIncorporation"));
   
    	
	}





	/**
     * Este evento es el encargado de atender al "cliente pendiente" previo a atención (Solo funcionará si hay un cliente pendiente) el cuál 
     * pondrá el "cliente pendiente" como vacío y abrirá una nueva ventana.
     * @param event
     * @throws IOException 
     * @author Gustavo Villada
     */
    @FXML
    void atender_turno(ActionEvent event) throws IOException {

    	FXMLLoader open= new FXMLLoader(getClass().getResource("/vista/Attention_Window.fxml")); 
    	Parent root =open.load();
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("ATENCIÓN CLIENTES");
    	stage1.showAndWait();  
    	
    }


    /**
     * Este es el evento del item ubicado en el menu, el cual nos permite abrir otra ventana donde podamos ordenar a los clientes de acuerdo
     * a un parametro deseado.
     * @param event
     * @throws IOException 
     * @author Gustavo Villada
     */
    @FXML
    void abrirTablaOrdenar(ActionEvent event) throws IOException {

    	FXMLLoader open= new FXMLLoader(getClass().getResource("/vista/Sort_Window.fxml")); 
    	Parent root =open.load();
       	Scene scene1 =new Scene(root);
    	Stage stage1 = new Stage();
    	stage1.initModality(Modality.APPLICATION_MODAL);// PARA QUE NO ME PERMITA VOLVER A LA VENTANA ANTERIOR SIN CERRAR LA ACTUAL
    	stage1.setScene(scene1);
    	stage1.setTitle("ORDENAR CLIENTES");
    	stage1.showAndWait();   
    	
    }






    /**
     * Este método inicializa la clase banco. 
     */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		bank=new Bank();
		bank.cargarClientes();
		
		
	}
    
    
}

