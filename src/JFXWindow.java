import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text; 
import javafx.stage.Stage; 

public class JFXWindow extends Application {

	//allows for scene to be used inside of buttons inside of another scene
	public Scene scene;

	@Override public void start(Stage primaryStage) {

		//hBox is created
		HBox hBox = new HBox();

		//Create Exit Button
		Button btnExit = new Button();
		btnExit.setText("Exit Game");
		//Change Exit Button Color, padding, font
		btnExit.setStyle("-fx-background-color: #ffffff; -fx-padding: 10; -fx-font-size: 2em;"
				+ 
				//change border color & width
				"-fx-border-color: #ffffff; -fx-border-width: 5px; ");

		/**
		 *  
		 * What Happens when Exit is pressed
		 * 
		 */
		//create action for Exit button
		btnExit.setOnAction(new EventHandler<ActionEvent>() {

			//What Button Exit Does
			@Override 
			public void handle(ActionEvent e) {
				primaryStage.close();
			}
		});

		/**
		 * End Exit button
		 */

		//Create Start Game Button
		Button btnStartGame = new Button();
		btnStartGame.setText("Start Game");
		//Change Start Game Button Color, padding, font
		btnStartGame.setStyle("-fx-background-color: #ffffff; -fx-padding: 10; -fx-font-size: 2em;"
				+ 
				//change border color & width
				"-fx-border-color: #ffffff; -fx-border-width: 5px; ");


		
		HBox hBox2 = new HBox();

		//create border for after button pressed
		BorderPane pane2 = new BorderPane();

		//create scene2
		Scene scene2 = new Scene(pane2, 800,800);
		
		//create Test button
		Button btnMainMenu = new Button("Main Menu");
		btnMainMenu.setText("Main Menu");
		btnMainMenu.setStyle("-fx-background-color: #ffffff; -fx-padding: 10; -fx-font-size: 2em;-fx-border-color: #ffffff; -fx-border-width: 5px; ");
		
		//add button to hbox2
		hBox2.getChildren().add(btnMainMenu);

		//set pane2 (hBox2) to center
		pane2.setCenter(hBox2);
		
		//align button to top right
		hBox2.setAlignment(Pos.TOP_RIGHT);
		
		//set background color
		hBox2.setStyle("-fx-background-color: #000000;");

		/**
		 * What Main Menu button does
		 */
		btnMainMenu.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override 
			public void handle(ActionEvent e) {
				
				primaryStage.setScene(scene);
				
		}});
		/**
		 * end Main Menu button
		 */
		
		/**
		 * Start Game button
		 */

		//create action for Start Game button
		btnStartGame.setOnAction(new EventHandler<ActionEvent>() {
			//What Button Start Game Does
			@Override 
			public void handle(ActionEvent e) {

				//set scene to scene when button pressed
				primaryStage.setScene(scene2);
				primaryStage.show();

			}});

		/**
		 * End Start Game button
		 */
		
		/**
		 * Start Menu
		 */
		//add button(s) to hBox
		hBox.getChildren().add(btnStartGame);
		hBox.getChildren().add(btnExit);

		//align buttons to center
		hBox.setAlignment(Pos.CENTER);

		//set background color
		hBox.setStyle("-fx-background-color: #000000;");

		//set spacing between buttons
		hBox.setSpacing(100);

		//create BorderPane with hBox
		BorderPane pane = new BorderPane();
		pane.setCenter(hBox);

		//make Scene with pane, width, height
		scene = new Scene(pane, 800, 800); 


		//create final stage for scene to be displayed
		primaryStage.setTitle("Game Menu");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene(); 
		primaryStage.show(); 


	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
