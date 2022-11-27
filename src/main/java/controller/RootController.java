package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {

	//view
	 @FXML
	    private ImageView abrirImagen;

	    @FXML
	    private MenuItem abrirMenuItem;

	    @FXML
	    private MenuItem acercaDeMenuItem;

	    @FXML
	    private Menu archivoMenu;

	    @FXML
	    private Menu ayudaMenu;

	    @FXML
	    private MenuBar barraMenu;

	    @FXML
	    private Tab conocimientosTab;

	    @FXML
	    private Tab contactoTab;

	    @FXML
	    private Tab experienciaTab;

	    @FXML
	    private Tab formacionTab;

	    @FXML
	    private MenuItem guardarComoMenuItem;

	    @FXML
	    private ImageView guardarImagen;

	    @FXML
	    private MenuItem guardarMenuItem;

	    @FXML
	    private SeparatorMenuItem menuSeparator;

	    @FXML
	    private ImageView nuevoImagen;

	    @FXML
	    private MenuItem nuevoMenuItem;

	    @FXML
	    private Tab personalTab;

	    @FXML
	    private TabPane pestañasTabpane;

	    @FXML
	    private BorderPane root;

	    @FXML
	    private MenuItem salirMenuItem;
	
	//model
	
	
	//controllers
	private ConocimientosController conocimientoController = new ConocimientosController();
	private ContactoController contactoController = new ContactoController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private FormacionController formacionController = new FormacionController();
	private PersonalController personalController = new PersonalController();
	
	public RootController() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RaizView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//tabs
		personalTab.setContent(personalController.getView());
		contactoTab.setContent(contactoController.getView());
		formacionTab.setContent(formacionController.getView());
		experienciaTab.setContent(experienciaController.getView());
		conocimientosTab.setContent(conocimientoController.getView());
	}

	public BorderPane getView() {
		return root;
	}
}
