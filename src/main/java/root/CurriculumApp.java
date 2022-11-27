package root;

import controller.RootController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CurriculumApp extends Application {

	static Stage primaryStage;
	private RootController rootController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		CurriculumApp.primaryStage = primaryStage;
		
		rootController = new RootController();
		
		primaryStage.setTitle("Curriculum");
		primaryStage.getIcons().add(new Image("/images/cv64x64.png"));
		primaryStage.setScene(new Scene(rootController.getView()));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
