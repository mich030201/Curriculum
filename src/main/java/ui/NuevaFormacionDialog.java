package ui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.FormacionModel;

public class NuevaFormacionDialog extends Dialog<FormacionModel> implements Initializable {

	
	//model
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	private ObjectProperty<LocalDateTime> desde = new SimpleObjectProperty<>();
	private ObjectProperty<LocalDateTime> hasta = new SimpleObjectProperty<>();
	
	private FormacionModel nuevaFormacion = new FormacionModel();
	
	//view
	@FXML private HBox botoneraHBox;

    @FXML private Button cancelarButton;

    @FXML private Button crearButton;

    @FXML private TextField denominacionTextField;

    @FXML private DatePicker desdeDatePicker;

    @FXML private DatePicker hastaDatePicker;

    @FXML private BorderPane nuevaFormacionView;

    @FXML private TextField organizadorTextField;

	
	public NuevaFormacionDialog() {
		
		super();
		setTitle("Nueva formación");
		
		loadContent();
		getDialogPane().setContent(nuevaFormacionView);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//bindings 
		//Long local = desdeDatePicker.to;
		
		denominacion.bind(denominacionTextField.textProperty());
		organizador.bind(organizadorTextField.textProperty());
//		desde.bind(LocalDateTime.ofEpochSecond(desdeDatePicker,
//											   0, 
//											   OffsetDateTime.now().getOffset()));
		hasta.bind(hasta);
		
		
		//disable button
		crearButton.disabledProperty().bind(denominacion.isEmpty().or(organizador.isEmpty()));
	}
	
	  @FXML
	    void onCancelarButtton(ActionEvent event) {

	    }

	    @FXML
	    void onCrearFormacion(ActionEvent event) {

	    }
	    
	    private void loadContent() {
			try { 
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevaFormacion.fxml"));
				loader.setController(this);
				loader.load();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

}
