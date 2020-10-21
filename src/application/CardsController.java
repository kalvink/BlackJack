package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
	Text dealerTotal = new Text();
	@FXML
	Text handTotal = new Text();
	@FXML
	Button bet1, bet5, bet25, bet50, bet100, bet500, dealButton;
	@FXML
	ImageView card1, card2, dealercard1, dealercard2;

	int balance = MenuController.bank;
	int bet = 0;
	int suit = 0;
	int cardNum = 0;
	int yourHand = 0;
	int dealerHand = 0;

	int[] spades = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	int[] hearts = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	int[] clubs = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	int[] diamonds = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

	@FXML
	public void loadBalance() {
		Balance.setText("Bank: $" + balance);
		Balance.setFocusTraversable(false);
	}

	@FXML
	public void dealFunction() {
		if (bet == 0) {

		} else {

			yourHand = drawCard(card1, yourHand);
			yourHand = drawCard(card2, yourHand);
			dealerHand = drawCard(dealercard1, dealerHand);
			dealerHand = drawCard(dealercard2, dealerHand);
			dealButton.setDisable(true);
		}
	}

	public int drawCard(ImageView card, int hand) {
		Random rand = new Random();
		// 0-3 Suits
		suit = rand.nextInt(4);
		System.out.println("Suit:" + suit);
		// Spades
		if (suit == 0) {
			// 0-12 Cards
			cardNum = rand.nextInt(13);
			System.out.println("Spades:" + spades[cardNum]);
			createCard(card, suit, cardNum);
			hand = hand + cardNum;
		}
		// Hearts
		else if (suit == 1) {
			// 0-12 Cards
			cardNum = rand.nextInt(13);
			System.out.println("Hearts:" + hearts[cardNum]);
			createCard(card, suit, cardNum);
			hand = hand + cardNum;
		}
		// Clubs
		else if (suit == 2) {
			// 0-12 Cards
			cardNum = rand.nextInt(13);
			System.out.println("Clubs:" + clubs[cardNum]);
			createCard(card, suit, cardNum);
			hand = hand + cardNum;
		}
		// Diamonds
		else if (suit == 3) {
			// 0-12 Cards
			cardNum = rand.nextInt(13);
			System.out.println("Diamonds:" + diamonds[cardNum]);
			createCard(card, suit, cardNum);
			hand = hand + cardNum;
		}
		return hand;
	}


	public void handValues(int hand){
		//face cards
		if(cardNum == 11 || cardNum == 12 || cardNum == 13){
			hand = hand + 10;
		}
		//TODO
		//ace (check for +1 or +11)
		else if(cardNum == 1){
			hand = hand + 1;
			if (hand <21){
				hand = hand+11;
			}

		}
	}


	// Deck Matrix
	String[][] deckPath = {
			{ "ace_of_spades", "2_of_spades", "3_of_spades", "4_of_spades", "5_of_spades", "6_of_spades", "7_of_spades",
					"8_of_spades", "9_of_spades", "10_of_spades", "jack_of_spades", "queen_of_spades",
					"king_of_spades" },
			{ "ace_of_hearts", "2_of_hearts", "3_of_hearts", "4_of_hearts", "5_of_hearts", "6_of_hearts", "7_of_hearts",
					"8_of_hearts", "9_of_hearts", "10_of_hearts", "jack_of_hearts", "queen_of_hearts",
					"king_of_hearts" },
			{ "ace_of_clubs", "2_of_clubs", "3_of_clubs", "4_of_clubs", "5_of_clubs", "6_of_clubs", "7_of_clubs",
					"8_of_clubs", "9_of_clubs", "10_of_clubs", "jack_of_clubs", "queen_of_clubs", "king_of_clubs" },
			{ "ace_of_diamonds", "2_of_diamonds", "3_of_diamonds", "4_of_diamonds", "5_of_diamonds", "6_of_diamonds",
					"7_of_diamonds", "8_of_diamonds", "9_of_diamonds", "10_of_diamonds", "jack_of_diamonds",
					"queen_of_diamonds", "king_of_diamonds" } };
	/*
	 * [0][0] [0][1] [0][2] [0][3] [0][4] [0][5] [0][6] [0][7] [0][8] [0][9]
	 * [0][10] [0][11] [0][12]
	 *
	 * [1]
	 *
	 * [2]
	 *
	 * [3]
	 */

	// Sets image onto the imageview card
	public void createCard(ImageView card, int suit, int cardNum) {
		card.setImage(new Image("/" + deckPath[suit][cardNum] + ".png"));
		card.setVisible(true);
		handTotal.setText("Your Hand: " + yourHand);
		dealerTotal.setText("Dealer's Hand: " + dealerHand);
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
		MenuController.bank = 0;
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
