package controlador;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import excepciones.StackVacioException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
	private Tab tpRetiro, tpConsignaci�n, tpPagoTarjeta, tpCancelacion;

	@FXML
	private Text txtNumeroTarjeta, txtNombreTarjeta, noCuentaBancaria, dineroCuentaBancaria;

	@FXML
	private TextField tfRetirarDinero, tfConsignarDinero ;

	@FXML
	private Button btnConsignarDinero, btnRetirarDinero;

	private Bank bank;

	@FXML
	private Button btnPagar;

	@FXML
	private TextField txtTarjeta;

	@FXML
	private Text txtDinero;

	@FXML
	private ToggleGroup Metodo;

	@FXML
	private RadioButton cuenta;

	@FXML
	private RadioButton efectivo;
	
	@FXML
    private Button btCancelar;


	@FXML
	void buscarClienteParaAtender(ActionEvent event) {

		actualizarInformacionCliente(bank.getEnAtencion());


	}



	/**
	 * Este evento est� encargado de consignar dinero a la cuenta bancaria de la persona que est� siendo atendida.
	 * @param event
	 * @author Gustavo Villada
	 */
	@FXML
	void consignarDinero(ActionEvent event) {
		try {
			int consignacion=Integer.parseInt(tfConsignarDinero.getText().toString());
			tfConsignarDinero.setText("");
			int consignado=bank.getEnAtencion().consignarDinero(consignacion);

			DecimalFormat formato = new DecimalFormat("$#,###.###");
			String valorFormateado = formato.format(consignado);

			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("Transacci�n realizada");
			alert.setContentText("Consignaci�n exitosa, ahora tienes "+valorFormateado);
			alert.showAndWait();

			actualizarInformacionCliente(bank.getEnAtencion());
		}catch (NumberFormatException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Digitaste mal");
			alert.setContentText("SE HA DIGITADO UN VALOR ERRONEO, REVISA LO QUE ESCRIBISTE ");
			alert.showAndWait();
		}
	}


	/**
	 * Este evento est� encargado de retirar dinero a la cuenta bancaria de la persona que est� siendo atendida.
	 * @param event
	 * @author Gustavo Villada
	 */
	@FXML
	void retirarDinero(ActionEvent event) {
		try {
			int dineroARetirar=Integer.parseInt(tfRetirarDinero.getText().toString());
			tfRetirarDinero.setText("");
			boolean retirado=bank.getEnAtencion().retirarDinero(dineroARetirar);
			if(retirado==false) {
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Transacci�n fallida");
				alert.setContentText("FONDOS INSUFICIENTES");
				alert.showAndWait();
			}else {
				DecimalFormat formato = new DecimalFormat("$#,###.###");
				String valorFormateado = formato.format(bank.getEnAtencion().getBankAccount().getAmmount());

				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Transacci�n realizada");
				alert.setContentText("Retiro exitoso, ahora tienes "+valorFormateado);
				alert.showAndWait();

				actualizarInformacionCliente(bank.getEnAtencion());
			}
		}catch (NumberFormatException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Digitaste mal");
			alert.setContentText("SE HA DIGITADO UN VALOR ERRONEO, REVISA LO QUE ESCRIBISTE ");
			alert.showAndWait();
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
	 * Este evento est� encargado de tomar un cliente de las filas, y pasarlo a un estado de "cliente pendiente", donde su informaci�n estar� 
	 * visible en una tableView (Solo se podr� hacer este evento si no hay ning�n "cliente pendiente").
	 * @param Cliente cuya informaci�n se va a mostrar en la tableView
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
		tcCuentaBancaria.setCellValueFactory(new PropertyValueFactory<>("bankAccount1"));
		tcTarjeta.setCellValueFactory(new PropertyValueFactory<>("tarjetaDeCredito1"));
		tcFechaPago.setCellValueFactory(new PropertyValueFactory<>("datePaymentCard"));
		tcIncorporacion.setCellValueFactory(new PropertyValueFactory<>("dateIncorporation"));

		txtNombreTarjeta.setText(c.getName());
		txtNumeroTarjeta.setText(c.getBankAccount().getId());
		noCuentaBancaria.setText(c.getBankAccount().getId());
		DecimalFormat formato = new DecimalFormat("$#,###.###");
		String valorFormateado = formato.format(c.getBankAccount().getAmmount());
		dineroCuentaBancaria.setText(valorFormateado);

	}

	/**
	 * Este evento est� encargado de Pagar el dinero que debe el cliente por el uso de la tarjeta.
	 * @param event
	 * @author Andres Cuellar
	 */
	@FXML
	void PagarConTarjeta(ActionEvent event)  {
		try {
		int dinero = Integer.parseInt(txtTarjeta.getText());
		txtDinero.setText("$"+dinero);
		
		if(bank.getEnAtencion().getTarjetaDeCredito().getDeuda()< dinero) {

			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Pasaste el cupo");
			alert.setContentText("PASASTE EL VALOR MAXIMO DE TU DEUDA EN LA TARJETA  TU DEUDA ES: " + bank.getEnAtencion().getTarjetaDeCredito().getDeuda());
			alert.showAndWait();
			txtTarjeta.clear();

		}
		else {
			
			if(efectivo.isSelected()) {
				int cual=0;
				cual=1;
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Has realizado tu pago");
				alert.setContentText("SE HA REALIZADO TU PAGO TU DEUDA AHORA ES : " + bank.getEnAtencion().pagarTarjeta(dinero , cual));
				alert.showAndWait();
				actualizarInformacionCliente(bank.getEnAtencion());
				txtTarjeta.clear();
			}
			if(cuenta.isSelected()) {
				int cual=0;
				cual=2;

				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Has realizado tu pago");
				alert.setContentText("SE HA REALIZADO TU PAGO TU DEUDA AHORA ES : " + bank.getEnAtencion().pagarTarjeta(dinero,cual) 
						+" Y TU CUENTA DE AHORROS AHORA TIENE: " + bank.getEnAtencion().getBankAccount().getAmmount());
				alert.showAndWait();
				actualizarInformacionCliente(bank.getEnAtencion());
				txtTarjeta.clear();
			}
			if(!cuenta.isSelected() && !efectivo.isSelected()) {
				Alert alert=new Alert(AlertType.ERROR);
				alert.setTitle("No selecciono");
				alert.setContentText("POR FAVOR SELECCIONE UNA DE LAS OPCIONES" );
				alert.showAndWait();
				txtTarjeta.clear();
			}
		}
		}catch (NumberFormatException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("No hay nada");
			alert.setContentText("POR FAVOR DIGITE LA CANTIDAD QUE DESEA PAGAR" );
			alert.showAndWait();
			txtTarjeta.clear();
		}


	}
	
	/**
	 * Este evento est� encargado de deshacer las acciones del cliente.
	 * @param event
	 * @author Andres Cuellar
	 */
	@FXML
	void Deshacer(ActionEvent event) throws StackVacioException {
		try {
		Client aux = bank.getEnAtencion().darCopia();
		bank.setEnAtencion(aux);
		actualizarInformacionCliente(bank.getEnAtencion());
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("Se deshizo la operacion");
		alert.setContentText("SE DESHIZO LA ULTIMA OPERACION " );
		alert.showAndWait();
		}catch (StackVacioException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Sin operaciones");
			alert.setContentText("NO SE HAN REGISTRADO OPERACIONES " );
			alert.showAndWait();
		}catch (NullPointerException e) {
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("Se han borrado");
			alert.setContentText("NO SE HAN REGISTRADO CLIENTES " );
			alert.showAndWait();
		}
		
	
	}
	
	
	/**
	 * Este evento est� encargado de borrar los datos de cuenta bancaria del cliente.
	 * @param event
	 * @author Andres Cuellar
	 */
    @FXML
    void Cancelar(ActionEvent event) {

    	try {
    	bank.cancelarCuenta();
    	noCuentaBancaria.setText("$ 0,000");
    	dineroCuentaBancaria.setText("$ 0,000");
    	actualizarInformacionCliente(bank.getEnAtencion());
    	
    	}catch (NullPointerException e) {
    		Alert alert=new Alert(AlertType.INFORMATION);
    		alert.setTitle("Borrar Cliente");
    		alert.setContentText("SE HA BORRADO EL CLIENTE " );
    		alert.showAndWait();
		}
    }

}
