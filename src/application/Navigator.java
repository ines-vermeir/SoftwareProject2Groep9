package application;

import java.io.IOException;

import controller.MainController;
import javafx.fxml.FXMLLoader;

public class Navigator {
	
	/*
	 * Navigator Framework
	 * Source: https://gist.github.com/jewelsea/6460130
	 * 
	 */

    /**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN    = "view/";
    public static final String VISTA_1 = "vista1.fxml";
    public static final String VISTA_2 = "vista2.fxml";
    
	public static String MainView    = "/view/MainView.fxml";
	public static String UserSectionView = "/view/UserSectionView.fxml";
	public static String EmptyView = "/view/EmptyView.fxml";
	public static String MenuSectionView = "/view/MenuSectionView.fxml";
	
	public static String LoginView = "/view/LoginView.fxml";
	
	public static String HomeView = "/view/HomeView.fxml";
	public static String StudentView = "/view/StudentView.fxml";
	public static String CourseView = "/view/CourseView.fxml";
	
	
    /** The main application layout controller. */
    private static MainController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MainController mainController) {
        Navigator.mainController = mainController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
     *
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
        
    	try {
            mainController.setContent(FXMLLoader.load(Navigator.class.getResource(fxml)));    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadMenuVista(String fxml) {
    	
    	try {
            mainController.setContentMenu(FXMLLoader.load(Navigator.class.getResource(fxml)));  
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    public static void loadUserVista(String fxml) {
    	
    	try {
            mainController.setContentUser(FXMLLoader.load(Navigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }

}