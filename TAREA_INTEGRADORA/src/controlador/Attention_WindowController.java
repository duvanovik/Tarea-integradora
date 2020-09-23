package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Bank;


public class Attention_WindowController{

    @FXML
    private TextField tfCedulaBusqueda;

    @FXML
    private Button btnBuscar;

    @FXML
    private TableView<?> tvInfoCliente;

    @FXML
    private Tab tpRetiro;

    @FXML
    private Tab tpConsignación;

    @FXML
    private Tab tpPagoTarjeta;

    @FXML
    private Tab tpCancelacion;

    
    private Bank bank;
    
    
    
    @FXML
    void buscarClienteParaAtender(ActionEvent event) {

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
		}
	}
}
