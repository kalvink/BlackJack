package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CardsController implements Initializable {
	private Stage stage;

	@FXML
	Button backToPlayMenu;
	@FXML
	TextField Balance = new TextField();
	@FXML
	TextField Bet = new TextField();
	@FXML
	Button bet1, bet5, bet25, bet50, bet100, bet500;

	int balance = GameController.bank;
	int bet = 0;
	int[] clovers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	int[] hearts = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	int[] spades = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	int[] diamonds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	@FXML
	public void loadBalance() {
		Balance.setText("Bank: $" + balance);
		Balance.setFocusTraversable(false);
	}

	@FXML
	public void bet1() {
		betFunction(1, bet1);
	}

	@FXML
	public void bet5() {
		betFunction(5, bet5);
	}

	@FXML
	public void bet25() {
		betFunction(25, bet25);
	}

	@FXML
	public void bet50() {
		betFunction(50, bet50);
	}

	@FXML
	public void bet100() {
		betFunction(100, bet100);
	}

	@FXML
	public void bet500() {
		betFunction(500, bet500);
	}

	public void betFunction(int betAmount, Button btnX) {
		if (balance >= betAmount) {
			bet = bet + betAmount;
			balance = balance - betAmount;
			Balance.setText("Bank: $" + balance);
			Bet.setText("Bet: $" + bet);
		} else {
			btnX.setDisable(true);
		}
	}

	@FXML
	public void backToPlayMenu() {
		stage = (Stage) backToPlayMenu.getScene().getWindow();
		GameController.bank = 0;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadBalance();
	}

}
