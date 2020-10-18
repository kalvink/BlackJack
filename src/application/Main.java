package application;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {
	public static Window publicStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox) FXMLLoader.load(getClass().getResource("cards.fxml"));
			Scene scene = new Scene(root, 1280, 800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage publicStage = primaryStage;
			publicStage.setScene(scene);
			//todo add resizable canvas later?
			publicStage.setResizable(false);
			publicStage.setTitle("Black Jack by Kalvin Kao");
			//publicStage.getIcons().add(new Image("logo.png"));
			publicStage.show();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
