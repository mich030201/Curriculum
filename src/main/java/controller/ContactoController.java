package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import model.ContactoModel;
import model.Email;
import model.Telefono;
import model.TipoTelefono;
import model.Web;
import ui.NuevoTelefonoDialog;

public class ContactoController implements Initializable {

	//model
	ContactoModel contactoModel = new ContactoModel();
	
	private ListProperty<Email> emails = new SimpleListProperty<Email>(FXCollections.observableArrayList());
	private IntegerProperty selectedEmail = new SimpleIntegerProperty();
	
	private ListProperty<Web> webs = new SimpleListProperty<Web>(FXCollections.observableArrayList());
	private IntegerProperty selectedWeb = new SimpleIntegerProperty();
	
	//view
	@FXML private BorderPane ContactoBorderPane;

    @FXML private Button addEmailButton;

    @FXML private Button addTelefButton;

    @FXML private Button addUrlButton;

    @FXML private SplitPane datosSplitPane;

    @FXML private TableColumn<Email, String> emailColumn;

    @FXML private TableView<Email> emailsTable;

    @FXML private TitledPane emailsTitledPane;

    @FXML private TableColumn<Telefono, String> numeroColumn;

    @FXML private TableView<Telefono> numerosTable;

    @FXML private Button subtractEmailButton;

    @FXML private Button subtractTelefButton;

    @FXML private Button subtractUrlButton;

    @FXML private TitledPane telefonosTitledPane;

    @FXML private TableColumn<Telefono, TipoTelefono> tipoColumn;

    @FXML private TableColumn<Web, String> urlColumn;

    @FXML private TableView<Web> websTable;

    @FXML private TitledPane websTitledPane;

	
    public ContactoController() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//bindings
		emailsTable.itemsProperty().bind(emails);
		websTable.itemsProperty().bind(webs);
		
		selectedEmail.bind(emailsTable.getSelectionModel().selectedIndexProperty());
		selectedWeb.bind(websTable.getSelectionModel().selectedIndexProperty());
		
		subtractEmailButton.disableProperty().bind(selectedEmail.lessThan(0));
		subtractUrlButton.disableProperty().bind(selectedWeb.lessThan(0));
		
		//Cell value factory (Le asigna el valor a las columnas de la tabla)
		emailColumn.setCellValueFactory(v -> v.getValue().direccionProperty());
		urlColumn.setCellValueFactory(v -> v.getValue().urlProperty());
	}

    @FXML
    void onInsertarTelefono(ActionEvent event) {
    	NuevoTelefonoDialog ntd = new NuevoTelefonoDialog();	/*---------- Esto no funciona ----------*/
    }

    @FXML
    void onEliminarTelefono(ActionEvent event) {

    }

    @FXML
    void onInsertarEmail(ActionEvent event) {

    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Nuevo Email");
    	dialog.setHeaderText("Añadir nueva dirección de correo");
    	dialog.setContentText("Introduzca un correo por favor:");
    	
    	Optional<String> emailEntrada = dialog.showAndWait();
    	if (emailEntrada.isPresent() && !emailEntrada.get().isBlank()){
    	    Email email = new Email();
    	    email.setDireccion(emailEntrada.get().trim());
    	    emails.add(email);
    	}
    }
    
	@FXML
    void onEliminarEmail(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar Email");
		alert.setHeaderText("Eliminar esta direccion de correo");
		alert.setContentText("¿Estas seguro que desea borrar este email?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			emails.remove(selectedEmail.get());
		} else {
		    alert.close();
		}
    }

    @FXML
    void onInsertarUrl(ActionEvent event) {

    	TextInputDialog dialog = new TextInputDialog("http://");
    	dialog.setTitle("Nueva Web");
    	dialog.setHeaderText("Añadir nueva página web");
    	dialog.setContentText("Introduzca la URL por favor:");
    	
    	Optional<String> urlEntrada = dialog.showAndWait();
    	if (urlEntrada.isPresent() && !urlEntrada.get().isBlank()){
    	    Web web = new Web();
    	    web.setUrl(urlEntrada.get().trim());
    	    webs.add(web);
    	}
    }
	
    @FXML
    void onEliminarUrl(ActionEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Eliminar Web");
    	alert.setHeaderText("Eliminar esta URL");
    	alert.setContentText("¿Estas seguro que desea borrar esta URL?");

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == ButtonType.OK){
    		webs.remove(selectedWeb.get());
    	} else {
    	    alert.close();
    	}
    }

    
    public BorderPane getView() {
    	return ContactoBorderPane;
    }

}
