package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	ImageView card1, card2;
	@FXML
	ImageView dealercard1, dealercard2;
	@FXML
	Button hitButton, standButton;

	ImageView currCard;
	ImageView prevCard;
	ImageView prevCardDealer;

	@FXML
	AnchorPane mainPane;

	@FXML
	Group cardGroup;

	int balance = MenuController.bank;
	int bet = 0;
	int suit = 0;
	int cardNum = 0;
	int yourHand = 0;
	int dealerHand = 0;
	int aceTempHand = 0;
	int aceDealerTempHand = 0;

	boolean deal = false;
	boolean dealerTurn = false;
	boolean ace = false;
	boolean dealerAce = false;

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
			// Initiate card draws
			// Your cards
			startGame();

			yourHand = drawCard(card1, yourHand) + drawCard(card2, yourHand);
			handTotal.setText("Your Hand: " + yourHand);
			prevCard = card2;
			// Dealer
			dealerTurn = true;
			dealerHand = drawCard(dealercard1, dealerHand);
			System.out.println("\nyour hand: " + yourHand);
			System.out.println("\ndealer hand: " + dealerHand);

			// Dealer Ace
			if (dealerAce) {
				dealerTotal.setText("Dealer's Hand: " + dealerHand + " or " + 11);
			} else {
				dealerTotal.setText("Dealer's Hand: " + dealerHand);
			}
			dealercard2.setImage(new Image("/back_cards.png"));
			dealercard2.setVisible(true);
			prevCardDealer = dealercard1;
		}
	}

	public void startGame() {

		deal = true;

		// Disable all chip buttons
		bet1.setDisable(true);
		bet5.setDisable(true);
		bet25.setDisable(true);
		bet50.setDisable(true);
		bet100.setDisable(true);
		bet500.setDisable(true);
		dealButton.setDisable(true);

	};

	public void resetGame() {
		bet1.setDisable(false);
		bet5.setDisable(false);
		bet25.setDisable(false);
		bet50.setDisable(false);
		bet100.setDisable(false);
		bet500.setDisable(false);

		bet = 0;
		Bet.setText("Bet: $"+bet);
		deal = false;
		dealButton.setDisable(false);

		// Removing group the contains all the hitCards/standCards
		cardGroup.getChildren().clear();

		card1.setVisible(false);
		card2.setVisible(false);
		dealercard1.setVisible(false);
		dealercard2.setVisible(false);

		yourHand = 0;
		dealerHand = 0;

	};

	public int drawCard(ImageView card, int hand) {
		Random rand = new Random();
		// 0-3 Suits
		suit = rand.nextInt(4);
		if (suit == 0) { // Spades
			cardNum = rand.nextInt(13); // 0-12 Cards
			createCard(card, suit, cardNum);
			hand = handValues(hand, cardNum);
		} else if (suit == 1) { // Hearts
			cardNum = rand.nextInt(13); // 0-12 Cards
			createCard(card, suit, cardNum);
			hand = handValues(hand, cardNum);
		} else if (suit == 2) { // Clubs
			cardNum = rand.nextInt(13); // 0-12 Cards
			createCard(card, suit, cardNum);
			hand = handValues(hand, cardNum);
		} else if (suit == 3) { // Diamonds
			cardNum = rand.nextInt(13); // 0-12 Cards
			createCard(card, suit, cardNum);
			hand = handValues(hand, cardNum);
		}
		return hand;
	}

	// TODO fix aces
	public int handValues(int hand, int cardNum) {
		// face cards
		if (cardNum == 10 || cardNum == 11 || cardNum == 12) {
			hand = hand + 10;
		}
		// ace (check for +1 or +11)
		else if (cardNum == 0 && dealerTurn == false) {
			System.out.println("ace: true");
			int aceHand = hand;
			hand = hand + 1;
			if (aceHand + 11 == 21) {
				System.out.println("Black Jack");
				hand = 21;
				ace = true;
			} else if (aceHand + 11 < 21) {
				aceHand = aceHand + 11;
				ace = true;
			}

		} else if (cardNum == 0 && dealerTurn == true) {

			int aceHand = hand;
			hand = hand + 1;

			if (hand + 11 <= 21) {
				aceTempHand = aceHand + 11;
				dealerAce = true;
				System.out.println("dealer ace: true");
			}
		}

		else if (cardNum == 1) {
			hand = hand + 2;
		} else if (cardNum == 2) {
			hand = hand + 3;
		} else if (cardNum == 3) {
			hand = hand + 4;
		} else if (cardNum == 4) {
			hand = hand + 5;
		} else if (cardNum == 5) {
			hand = hand + 6;
		} else if (cardNum == 6) {
			hand = hand + 7;
		} else if (cardNum == 7) {
			hand = hand + 8;
		} else if (cardNum == 8) {
			hand = hand + 9;
		} else if (cardNum == 9) {
			hand = hand + 10;
		}
		return hand;
	}

	@FXML
	public void hitAction() {

		if (deal) {

			// create imageview card for player
			ImageView hitCard = new ImageView();
			Image image1 = new Image("/3_of_hearts.png");
			hitCard.setImage(image1);
			hitCard.setFitWidth(150);
			hitCard.setFitHeight(225);
			hitCard.setPreserveRatio(true);
			yourHand = drawCard(hitCard, yourHand);
			hitCard.relocate(prevCard.getLayoutX() + 30, 407);
			cardGroup.getChildren().add(hitCard);
			prevCard = hitCard;
			hitCard.setVisible(true);
			handTotal.setText("Your Hand: " + yourHand);

			// bust check
			if (yourHand > 21) {
				System.out.println("BUST");
				Bust();
			}
		}

	}

	public void Bust() {
		// play some animation or popup window telling them bust
		// then reset
		resetGame();
	}

	@FXML
	public void standAction() {
		// hit for dealer
		if (deal) {

			hitButton.setDisable(true);
			// create imageview card for dealer
			ImageView standCard = new ImageView();
			Image image1 = new Image("/3_of_hearts.png");
			standCard.setImage(image1);
			standCard.setFitWidth(150);
			standCard.setFitHeight(225);
			standCard.setPreserveRatio(true);
			dealerHand = drawCard(standCard, dealerHand);
			standCard.relocate(prevCardDealer.getLayoutX() + 30, 85);
			prevCardDealer = standCard;
			standCard.setVisible(true);

			cardGroup.getChildren().add(standCard);
			dealerTotal.setText("Dealer's Hand: " + dealerHand);
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

	// Sets image onto the imageview card
	public void createCard(ImageView card, int suit, int cardNum) {
		card.setImage(new Image("/" + deckPath[suit][cardNum] + ".png"));
		card.setVisible(true);
		// if Ace
		if (ace && !dealerTurn) {
			handTotal.setText("Your Hand: " + yourHand + " or " + aceTempHand);
		} else if (dealerAce && dealerTurn) {
			dealerTotal.setText("Dealer's Hand: " + dealerHand + " or " + aceDealerTempHand);
		} else if (!ace && !dealerTurn) {
			handTotal.setText("Your Hand: " + yourHand);
		} else if (!ace && dealerTurn) {
			dealerTotal.setText("Dealer's Hand: " + dealerHand);
		}

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
