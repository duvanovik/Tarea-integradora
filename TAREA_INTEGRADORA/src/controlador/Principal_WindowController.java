package controlador;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Principal_WindowController {

    @FXML
    private Button btnAsignarTurno;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfCedula;

    @FXML
    private TableView<?> tvClientePrevioAtender;

    @FXML
    private Button btnAtenderCliente;

    @FXML
    private Button btonSiguienteTurno;

    @FXML
    private TableView<?> tvClientes;

    @FXML
    private TableView<?> tvPrioridad;

    @FXML
    private MenuItem itemMenu;
    
    @FXML
    private CheckBox cbPrioritario;
    
    
    /**
     * Este evento es el encargado de asignar a qué fila debería ir un cliente (Clientes o prioridad), al tomar la cedula y el nombre de esta
     *  que entra al banco.
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
    	}
    }
    

    
    
    

    /**
     * Este evento está encargado de tomar un cliente de las filas, y pasarlo a un estado de "cliente pendiente", donde su información estará 
     * visible en una tableView (Solo se podrá hacer este evento si no hay ningún "cliente pendiente").
     * @param event
     */
    @FXML
    void siguiente_turno(ActionEvent event) {

    }
    
    
    /**
     * Este evento es el encargado de atender al "cliente pendiente" previo a atención (Solo funcionará si hay un cliente pendiente) el cuál 
     * pondrá el "cliente pendiente" como vacío y abrirá una nueva ventana.
     * @param event
     * @throws IOException 
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
    
    
}

