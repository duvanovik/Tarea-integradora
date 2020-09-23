package controlador;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Bank;
import model.Client;


public class Attention_WindowController{

    @FXML
    private TextField tfCedulaBusqueda;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<Client> tvInfoCliente;

    @FXML
    private TableColumn<Client, String> tcNombre;

    @FXML
    private TableColumn<Client, Integer> tcCedula;

    @FXML
    private TableColumn<Client, String> tcCuentaBancaria;

    @FXML
    private TableColumn<Client, Integer> tcTarjeta;

    @FXML
    private TableColumn<Client, String> tcFechaPago;

    @FXML
    private TableColumn<Client, String> tcIncorporacion;
    
    @FXML
    private Tab tpRetiro, tpConsignación, tpPagoTarjeta, tpCancelacion;
    
    @FXML
    private Text txtNumeroTarjeta, txtNombreTarjeta, noCuentaBancaria, dineroCuentaBancaria;

    @FXML
    private TextField tfRetirarDinero, tfConsignarDinero ;
    
    @FXML
    private Button btnConsignarDinero, btnRetirarDinero;
    
    private Bank bank;
    
    
    
    @FXML
    void buscarClienteParaAtender(ActionEvent event) {

		actualizarInformacionCliente(bank.getEnAtencion());

    	
    }


    
	/**
     * Este evento está encargado de consignar dinero a la cuenta bancaria de la persona que está siendo atendida.
     * @param event
     * @author Gustavo Villada
     */
    @FXML
    void consignarDinero(ActionEvent event) {

    	int consignacion=Integer.parseInt(tfConsignarDinero.getText().toString());
    	tfConsignarDinero.setText("");
    	int consignado=bank.getEnAtencion().consignarDinero(consignacion);
    	
    	DecimalFormat formato = new DecimalFormat("$#,###.###");
    	String valorFormateado = formato.format(consignado);
    	
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Transacción realizada");
    	alert.setContentText("Consignación exitosa, ahora tienes "+valorFormateado);
    	alert.showAndWait();
    	
    	actualizarInformacionCliente(bank.getEnAtencion());
    }

    
	/**
     * Este evento está encargado de retirar dinero a la cuenta bancaria de la persona que está siendo atendida.
     * @param event
     * @author Gustavo Villada
     */
    @FXML
    void retirarDinero(ActionEvent event) {

    	int dineroARetirar=Integer.parseInt(tfRetirarDinero.getText().toString());
    	tfRetirarDinero.setText("");
    	boolean retirado=bank.getEnAtencion().retirarDinero(dineroARetirar);
    	if(retirado==false) {
        	Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Transacción fallida");
        	alert.setContentText("FONDOS INSUFICIENTES");
        	alert.showAndWait();
    	}else {
        	DecimalFormat formato = new DecimalFormat("$#,###.###");
        	String valorFormateado = formato.format(bank.getEnAtencion().getBankAccount().getAmmount());
        	
        	Alert alert=new Alert(AlertType.INFORMATION);
        	alert.setTitle("Transacción realizada");
        	alert.setContentText("Retiro exitoso, ahora tienes "+valorFormateado);
        	alert.showAndWait();
        	
        	actualizarInformacionCliente(bank.getEnAtencion());
    	}

    }

    /**
     * Este metodo recibe la clase principal del banco que viene de la ventana inicial.
     * @param bank
     * @author Gustavo Villada
     */
	public void transferMainClass(Bank bank) {

		this.bank=bank;
		if(bank==null) {

		}else {
			tfCedulaBusqueda.setText(bank.getEnAtencion().getCedula()+"");
			actualizarInformacionCliente(bank.getEnAtencion());
		}
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
    	tvInfoCliente.setItems(clientePr);

       	tcNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
    	tcCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
    	tcCuentaBancaria.setCellValueFactory(new PropertyValueFactory<>("bankAccount"));
    	tcTarjeta.setCellValueFactory(new PropertyValueFactory<>("creditCards"));
    	tcFechaPago.setCellValueFactory(new PropertyValueFactory<>("datePaymentCard"));
    	tcIncorporacion.setCellValueFactory(new PropertyValueFactory<>("dateIncorporation"));
    	
    	txtNombreTarjeta.setText(c.getName());
    	txtNumeroTarjeta.setText(c.getBankAccount().getId());
    	noCuentaBancaria.setText(c.getBankAccount().getId());
    	DecimalFormat formato = new DecimalFormat("$#,###.###");
    	String valorFormateado = formato.format(c.getBankAccount().getAmmount());
    	dineroCuentaBancaria.setText(valorFormateado);
    	
	}
	
}
