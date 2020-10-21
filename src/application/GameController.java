package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController {
	private Stage stage;

	// Main Menu
	@FXML
	Button playButton, aboutButton, quitButton;
	// Play Screen
	@FXML
	Button backToMenu, startGame;
	@FXML
	Button plus1, plus5, plus25, plus50, plus100, plus500, resetBank;
	@FXML
	TextField theBank = new TextField();
	//
	static int bank = 0;

	@FXML
	public void playButton() {

		stage = (Stage) playButton.getScene().getWindow();

		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/application/playmenu.fxml"));
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
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/application/menu.fxml"));
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

			VBox root = (VBox) FXMLLoader.load(getClass().getResource("/application/cards.fxml"));
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
		bank++;
		theBank.setText("$" + bank);
	}

	@FXML
	public void plus5() {
		bank = bank + 5;
		theBank.setText("$" + bank);
	}

	@FXML
	public void plus25() {
		bank = bank + 25;
		theBank.setText("$" + bank);
	}

	@FXML
	public void plus50() {
		bank = bank + 50;
		theBank.setText("$" + bank);
	}

	@FXML
	public void plus100() {
		bank = bank + 100;
		theBank.setText("$" + bank);
	}

	@FXML
	public void plus500() {
		bank = bank + 500;
		theBank.setText("$" + bank);
	}

	@FXML
	public void resetBank() {
		bank = 0;
		theBank.setText("$" + bank);

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
