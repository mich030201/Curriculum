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
import model.ExperienciaModel;

public class ExperienciaController implements Initializable {

	//model
	ExperienciaModel experienciaModel = new ExperienciaModel();
	
	//view
	@FXML private Button añadirButton;

	@FXML private VBox botoneraVBox;

	@FXML private TableColumn<?, ?> denominacionColummn;

	@FXML private TableColumn<?, ?> desdeColumn;

	@FXML private Button eliminarButton;

	@FXML private TableColumn<?, ?> empleadorColumn;

	@FXML private BorderPane experienciaBorderPane;

	@FXML private TableView<?> experienciaTable;

	@FXML private TableColumn<?, ?> hastaColumn;
	
	
	public ExperienciaController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
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
    void onEliminarExperiencia(ActionEvent event) {

    }

    @FXML
    void onInsertarExperiencia(ActionEvent event) {

    }
    
    public BorderPane getView() {
    	return experienciaBorderPane;
    }

}
