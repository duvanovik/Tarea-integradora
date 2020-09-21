package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Attention_WindowController {

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

    @FXML
    void buscarClienteParaAtender(ActionEvent event) {

    }

}
