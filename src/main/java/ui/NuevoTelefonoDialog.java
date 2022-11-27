package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Telefono;
import model.TipoTelefono;
 
public class NuevoTelefonoDialog extends Dialog<Telefono> implements Initializable {
 
	// model
 
	private StringProperty numero = new SimpleStringProperty();
	private ObjectProperty<TipoTelefono> tipo = new SimpleObjectProperty<>();
 
	// view
 
    @FXML
    private TextField numeroText;
 
    @FXML
    private ComboBox<TipoTelefono> tipoCombo;
 
    @FXML
    private GridPane view;
 
    private Button addButton;
 
	public NuevoTelefonoDialog() {
		super();
		setTitle("Nuevo teléfono");
		setHeaderText("Introduzca el nuevo número de teléfono.");
 
		ButtonType addButtonType = new ButtonType("Añadir", ButtonData.OK_DONE);		
		getDialogPane().getButtonTypes().setAll(addButtonType, ButtonType.CANCEL);
 
		addButton = (Button) getDialogPane().lookupButton(addButtonType);
 
		loadContent();
		getDialogPane().setContent(view);
 
		setResultConverter(this::onResultConverter);
	}
 
	private Telefono onResultConverter(ButtonType button) {
		if (button.getButtonData() == ButtonData.OK_DONE) {
			Telefono telefono = new Telefono();
			telefono.setNumero(numero.get());
			telefono.setTipoTelefono(tipo.get());
			return telefono;
		}		
		return null;
	}
 
	private void loadContent() {
		try { 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NuevoTelefonoView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
 
		// load combo
		tipoCombo.getItems().setAll(TipoTelefono.values());
 
		// bindings
 
		numero.bind(numeroText.textProperty());
		tipo.bind(tipoCombo.getSelectionModel().selectedItemProperty());
 
		// disable add button
 
		addButton.disableProperty().bind(numero.isEmpty().or(tipo.isNull()));
 
 
	}
 
}
