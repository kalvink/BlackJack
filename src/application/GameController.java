package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {
    private Stage stage;


	@FXML
	Button playButton;
	@FXML
	Button aboutButton;
	@FXML
	Button quitButton;

	int [] clovers = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	int [] hearts = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	int [] spades = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	int [] diamonds = {1,2,3,4,5,6,7,8,9,10,11,12,13};


	@FXML
	public void playButton() {
	    playButton.getScene().setRoot(game.getRootPane());

	}


	@FXML
	public void aboutButton() {


	}



	@FXML
	public void quitButton() {
	    Stage stage = (Stage) quitButton.getScene().getWindow();
	    stage.close();
	}




}
