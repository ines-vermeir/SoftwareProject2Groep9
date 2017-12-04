package application;

import java.io.IOException;

import controller.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	public static Stage mainStage;
	
	@Override
	public void start(Stage stage) throws Exception {
		 
		mainStage = stage;
		mainStage.setTitle("Human Resource Team 9");
		mainStage.setScene(createScene(loadMainPane()));
		mainStage.setMaximized(true);
		
		mainStage.show();
		
		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
		
	}

    /**
     * Loads the main fxml layout.
     * Sets up the vista switching VistaNavigator.
     * Loads the first vista into the fxml layout.
     *
     * @return the loaded pane.
     * @throws IOException if the pane could not be loaded.
     */

    private Pane loadMainPane() throws IOException {
        
		FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Navigator.MainView));

        MainController mainController = loader.getController();

        Navigator.setMainController(mainController);

        Navigator.loadVista(Navigator.LoginView);

        return mainPane;
    }
	

    /**
     * Creates the main application scene.
     *
     * @param mainPane the main application layout.
     *
     * @return the created scene.
     */
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );
        
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
