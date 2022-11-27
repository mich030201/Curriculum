package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.FormacionModel;

public class FormacionController implements Initializable {

	//model
	FormacionModel formacionModel = new FormacionModel();
	
	//view
	@FXML private BorderPane formacionBorderPane;
	
	@FXML private VBox botoneraVBox;

    @FXML private TableColumn<?, ?> denominacionButton;

    @FXML private TableColumn<?, ?> desdeColumn;

    @FXML private Button eliminarButton;

    @FXML private TableView<?> formacionTable;

    @FXML private TableColumn<?, ?> hastaColumn;

    @FXML private Button insertarButton;

    @FXML private TableColumn<?, ?> organizadorButton;
    
	
	public FormacionController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    void onEliminarFormacion(ActionEvent event) {

    }

    @FXML
    void onInsertarFormacion(ActionEvent event) {

    }
    
    public BorderPane getView() {
    	return formacionBorderPane;
    }

}
