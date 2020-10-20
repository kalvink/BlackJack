package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {
    private Stage stage;

    //Main Menu
	@FXML
	Button playButton;
	@FXML
	Button aboutButton;
	@FXML
	Button quitButton;
	//Play Screen
	@FXML
	Button backToMenu;
	@FXML
	Button resetBank;
	@FXML
	Button plus1,plus5,plus25,plus50,plus100,plus500;
	@FXML
	Button startGame;
	@FXML
	Button backToPlayMenu;

	//

	int [] clovers = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	int [] hearts = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	int [] spades = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	int [] diamonds = {1,2,3,4,5,6,7,8,9,10,11,12,13};



	@FXML
	public void playButton() {

            stage = (Stage) playButton.getScene().getWindow();

			try {
				VBox root = (VBox) FXMLLoader.load(getClass().getResource("playmenu.fxml"));
				Scene scene = new Scene(root, 1280, 800);
	            stage.setScene(scene);
	            stage.show();
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@FXML
	public void backToMenu() {

            stage = (Stage) backToMenu.getScene().getWindow();

			try {
				VBox root = (VBox) FXMLLoader.load(getClass().getResource("menu.fxml"));
				Scene scene = new Scene(root, 1280, 800);
	            stage.setScene(scene);
	            stage.show();
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}


	@FXML
	public void startGame() {

            stage = (Stage) startGame.getScene().getWindow();

			try {
				VBox root = (VBox) FXMLLoader.load(getClass().getResource("cards.fxml"));
				Scene scene = new Scene(root, 1280, 800);
	            stage.setScene(scene);
	            stage.show();
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				stage.setScene(scene);
				stage.setResizable(false);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@FXML
	public void plus1() {


	}

	@FXML
	public void plus5() {


	}
	@FXML
	public void plus25() {


	}

	@FXML
	public void plus50() {


	}

	@FXML
	public void plus100() {


	}
	@FXML
	public void plus500() {


	}
	@FXML
	public void resetBank() {


	}
	@FXML
	public void backToPlayMenu(){
        stage = (Stage) backToPlayMenu.getScene().getWindow();

		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("playmenu.fxml"));
			Scene scene = new Scene(root, 1280, 800);
            stage.setScene(scene);
            stage.show();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void aboutButton() {
        stage = (Stage) playButton.getScene().getWindow();

		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("cards.fxml"));
			Scene scene = new Scene(root, 1280, 800);
            stage.setScene(scene);
            stage.show();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	@FXML
	public void quitButton() {
	    Stage stage = (Stage) quitButton.getScene().getWindow();
	    stage.close();
	}




}
