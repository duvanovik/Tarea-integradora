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
import javafx.scene.control.TableView;

	public class Sort_WindowController implements Initializable {


	    @FXML
	    private ComboBox<String> cboxParametrosOrdenar;

	    @FXML
	    private TableView<?> tvClientes;

	    @FXML
	    private Button btnOrdenar;

	    @FXML
	    void ordenarClientes(ActionEvent event) {

	    }

	    /**
	     * Inicializa la ventana con el ComboBox ya lleno.
	     */
		@Override
		public void initialize(URL location, ResourceBundle resources) {

			agregarParametrosOrdenar();
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
