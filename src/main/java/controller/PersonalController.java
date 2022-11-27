package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Nacionalidad;
import model.PersonalModel;

public class PersonalController implements Initializable {

	//model
	PersonalModel personalModel = new PersonalModel();
	private ListProperty<String> nacionalidadesTop = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private IntegerProperty nacionalidadSeleccionada = new SimpleIntegerProperty();
	
	//view
	@FXML private Button addNacionalidadButton;

    @FXML private Label apellidosLabel;

    @FXML private TextField apellidosTextField;

    @FXML private Label codPostalLabel;

    @FXML private TextField codPostalTextField;

    @FXML private Label direccionLabel;

    @FXML private TextField direccionTextField;

    @FXML private Label dniLabel;

    @FXML private TextField dniTextField;

    @FXML private DatePicker fechaNacDatePicker;

    @FXML private Label fechaNacLabel;

    @FXML private Label localidadLabel;

    @FXML private TextField localidadTextField;

    @FXML private Label nacionalidadLabel;

    @FXML private ListView<String> nacionalidadesListView;

    @FXML private Label nombreLabel;

    @FXML private TextField nombreTextField;

    @FXML private ComboBox<String> paisComboBox;

    @FXML private Label paisLabel;

    @FXML private GridPane personalGridPane;

    @FXML private Button subtractNacionalidadButton;
	
	
    public PersonalController() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//bindings
		nacionalidadesListView.itemsProperty().bind(nacionalidadesTop);
		nacionalidadSeleccionada.bind(nacionalidadesListView.getSelectionModel().selectedIndexProperty());
		subtractNacionalidadButton.disableProperty().bind(nacionalidadSeleccionada.lessThan(0));

		//load data
		ArrayList<String> paises = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(getClass().getResource("/csv/paises.csv").getPath()))) {
                String pais;
                while ((pais = br.readLine()) != null) {
                    paises.add(pais);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		paisComboBox.getItems().addAll(paises);
	}
	
	@FXML
    void onInsertarNacionalidad(ActionEvent event) {

		ArrayList<String> nacionalidades = new ArrayList<String>();
		try {
            try (BufferedReader br = new BufferedReader(new FileReader(getClass().getResource("/csv/nacionalidades.csv").getPath()))) {
                String nacionalidad;
                while ((nacionalidad = br.readLine()) != null) {
                	nacionalidades.add(nacionalidad);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		ChoiceDialog<String> dialog = new ChoiceDialog<>("Selecciona una nacionalidad", nacionalidades);
		dialog.setTitle("Nueva nacionalidad");
		dialog.setHeaderText("Añadir nacionalidad");
		dialog.setContentText("Seleccione una nacionalidad:");
		
		Optional<String> eleccion = dialog.showAndWait();
		
		if (eleccion.isPresent()){
		    nacionalidadesTop.add(eleccion.get().trim()); // No funciona esto
		}
		
    }
	
	@FXML
    void onEliminarNacionalidad(ActionEvent event) {

		nacionalidadesTop.remove(nacionalidadSeleccionada.get());
    }

    
    public GridPane getView() {
    	return personalGridPane;
    }

}
