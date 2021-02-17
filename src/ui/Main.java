package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ContactManager;

public class Main extends Application {

	public ContactManager cm;
	public ContactManagerUI cMGUI;
	
	public Main () {
		cm = new ContactManager();
		cMGUI = new ContactManagerUI(cm);
				
				
	}
	
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	//Parent root= FXMLLoader.load(getClass().getResource("Welcome.fxml"));
	FXMLLoader loader= new FXMLLoader(getClass().getResource("Welcome.fxml"));
		loader.setController(cMGUI);
		Parent root = loader.load();
		
	Scene scene = new Scene(root);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Contact Manager");
	primaryStage.show();
	}

}
