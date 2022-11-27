package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.ConocimientoModel;

public class ConocimientosController implements Initializable {

	//model
	private ConocimientoModel conocimientoModel = new ConocimientoModel();
	
	//view
	@FXML private BorderPane conocimientosRoot;
	
	@FXML private Button addConocimientoButton;

    @FXML private Button addIdiomaButton;

    @FXML private VBox botoneraVBox;

    @FXML private TableView<?> conocimientosTable;

    @FXML private Button deleteButton;

    @FXML private TableColumn<?, ?> denominacionColumn;

    @FXML private TableColumn<?, ?> nivelColumn;
	
	
	public ConocimientosController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
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
	
	public BorderPane getView() {
		return conocimientosRoot;
	}

}
