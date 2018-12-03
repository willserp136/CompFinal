import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text; 
import javafx.stage.Stage; 



public class SlotMachineGUI extends Application {

	//create playAgain for button
	public static boolean playAgain = false;

	//create text fields for GUI
	public static TextField tfResult = new TextField();
	public static TextField tfWon = new TextField();
	public static TextField tfToken = new TextField();

	//create text boxes for GUI
	public static Label labelResult =  new Label();
	public static Label labelCombos = new Label();


	//allows for scene to be used inside of buttons inside of another scene
	public Scene scene;

	@Override public void start(Stage primaryStage) {


		//set text fields so they cannot have text input
		tfResult.setEditable(false);
		tfWon.setEditable(false);
		tfToken.setEditable(false);

		//set properties of text fields
		tfResult.setPrefSize(400, 10);
		tfResult.setAlignment(Pos.CENTER);
		tfWon.setAlignment(Pos.CENTER);
		tfToken.setAlignment(Pos.CENTER);

		//set text for text fields
		labelResult.setText("Slot Combo" + 
				"\n 0, -1 equals Blank" +
				"\n -2 equals Cherry" +
				"\n -3 equals Bar" +
				"\n -4 equals Double Bar" +
				"\n -5 equals Triple Bar" +
				"\n -6 equals Red 7" +
				"\n -7 equals Jackpot");
		labelResult.setStyle("-fx-font-size: 1em;");
		
		labelCombos.setText("Slot Combo" + 
		"\n Blanks cannot win you anything" +
		"\n Three cherries win 12 tokens" +
		"\n Two cherries win 6 tokens" +
		"\n One cherry wins 3 tokens" +
		"\n Three Bars win 25 tokens" +
		"\n Any combo of three different bars win 12 tokens" +
		"\n Three double bars win 50 tokens" +
		"\n Three triple bars win 100 tokens" +
		"\n Three red 7's win 300 tokens" +
		"\n Three Jackpots win 1,667 tokens");


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


		/**
		 * Game Scene
		 */


		VBox vboxGameOutput = new VBox();

		vboxGameOutput.getChildren().add(tfResult);

		tfToken.setAlignment(Pos.TOP_CENTER);

		//create Test button
		Button btnMainMenu = new Button("Main Menu");
		btnMainMenu.setText("Main Menu");
		btnMainMenu.setStyle("-fx-background-color: #ffffff; -fx-padding: 10; -fx-font-size: 2em;-fx-border-color: #ffffff; -fx-border-width: 5px; ");
		btnMainMenu.setAlignment(Pos.CENTER);

		//create roll button
		Button btnRoll = new Button("Roll");
		btnRoll.setText("Roll");
		btnRoll.setStyle("-fx-background-color: #ffffff; -fx-padding: 10; -fx-font-size: 2em;-fx-border-color: #ffffff; -fx-border-width: 5px; ");
		btnRoll.setAlignment(Pos.CENTER);

		/**
		 * WHat button Roll does
		 */
		btnRoll.setOnAction(new EventHandler<ActionEvent>() {

			@Override 
			public void handle(ActionEvent e) {

				tfWon.clear();
				playAgain = true;
				SlotMachine.startGame();

			}});


		GridPane gridPane = new GridPane();
		gridPane.setMinSize(1000, 800);
		//Setting the padding  
		gridPane.setPadding(new Insets(20, 20, 20, 20)); 

		//Setting the vertical and horizontal gaps between the columns 
		gridPane.setVgap(100); 
		gridPane.setHgap(50);       

		//Setting the Grid alignment 
		gridPane.setAlignment(Pos.CENTER); 

		//Arranging all the nodes in the grid 
		gridPane.add(labelResult, 0, 0);
		gridPane.add(labelCombos, 2, 0);
		gridPane.add(tfResult, 1, 0); 
		gridPane.add(tfWon, 1, 1); 
		gridPane.add(tfToken, 1, 2); 
		gridPane.add(btnRoll, 2, 2); 
		gridPane.add(btnMainMenu, 0, 2); 


		Scene gridScene = new Scene(gridPane, 1000,800);

		/**
		 * End Game Scene
		 */
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
				//SlotMachine sm = new SlotMachine();
				primaryStage.setScene(gridScene);
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
		scene = new Scene(pane, 1000, 800); 


		//create final stage for scene to be displayed
		primaryStage.setTitle("Game Menu");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene(); 
		primaryStage.show(); 


	}

	public static void main(String[] args) {
		Application.launch(args);
	}


	/**
	 * 
	 * Slot Machine Code
	 *
	 */


	public static class SlotMachine {


		static int tokens = 100;
		public static void startGame(){		
			
			int wheel[][] = new int[3][2];

			while (playAgain == true)
			{
				do
				{
					wheel[0][0] = (int) (Math.random() * ((128 - 1) + 1)) + 1;
					wheel[1][0] = (int) (Math.random() * ((128 - 1) + 1)) + 1;
					wheel[2][0] = (int) (Math.random() * ((128 - 1) + 1)) + 1;

					//Play the game
					for(int i = 0; i < wheel.length;i++)
					{
						if(wheel[i][0] >=0 && wheel[1][0] <=73)
						{
							wheel[i][1] = -1;
						}
						else if(wheel[i][0] >= 74 && wheel[i][0] <=78)
						{
							wheel[i][1] = -2;
						}
						else if(wheel[i][0] >= 79 && wheel[i][0] <=94)
						{
							wheel[i][1] = -3;
						}
						else if(wheel[i][0] >= 95 && wheel[i][0] <=107)
						{
							wheel[i][1] = -4;
						}
						else if(wheel[i][0] >= 108 && wheel[i][0] <=118)
						{
							wheel[i][1] = -5;
						}
						else if(wheel[i][0] >= 119 && wheel[i][0] <=126)
						{
							wheel[i][1] = -6;
						}
						else if(wheel[i][0] >= 127 && wheel[i][0] <=128)
						{
							wheel[i][1] = -7;
						}	
						playAgain = false;
					}
					
					tokens--;

					//Checking if all three slots are the same number.
					
					if(wheel[0][1] == wheel[1][1] && wheel[1][1] == wheel[2][1])
					{

						if(wheel[1][1] == -2)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
							playAgain = false;
						}
						else if(wheel[1][1] == -3)
						{
							tokens += 25;
							tfWon.setText("Congratulations! You've won 25 tokens!");
							playAgain = false;
						}
						else if(wheel[1][1] == -4)
						{
							tokens += 50;
							tfWon.setText("Congratulations! You've won 50 tokens!");
							playAgain = false;
						}
						else if(wheel[1][1] == -5)
						{
							tokens += 100;
							tfWon.setText("Congratulations! You've won 100 tokens!");
							playAgain = false;
						}
						else if(wheel[1][1] == -6)
						{
							tokens += 300;
							tfWon.setText("Congratulations! You've won 300 tokens!");
							playAgain = false;
						}
						else if(wheel[1][1] == -7)
						{
							tokens += 1667;
							tfWon.setText("Congratulations! You've won 1666 tokens!");
							playAgain = false;
						}
					}
					
					//Checks if you have a pair of the same numbers.
					else if (wheel[0][1] == wheel[1][1] || wheel[1][1] == wheel[2][1] || wheel[0][1] == wheel[2][1])
					{
						if(wheel[0][1] == -2 && wheel[1][1] == -2)
						{
							tokens += 6;
							tfWon.setText("Congratulations! You've won 6 tokens!");
							playAgain = false;
						}
						else if(wheel[1][1] == -2 && wheel[2][1] == -2)
						{
							tokens += 6;
							tfWon.setText("Congratulations! You've won 6 tokens!");
							playAgain = false;
						}
						else if(wheel[0][1] == -2 && wheel[2][1] == -2)
						{
							tokens += 6;
							tfWon.setText("Congratulations! You've won 6 tokens!");
							playAgain = false;
						}
					}
					
					else if (wheel[0][1] == wheel[0][1] || wheel[1][1] == wheel[1][1] || wheel[2][1] == wheel[2][1])
					{
						if(wheel[0][1] == -3 && wheel[0][1] == -4 && wheel[0][1] == -5)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
						}

						else if(wheel[0][1] == -3 && wheel[0][1] == -5 && wheel[0][1] == -4)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
						}
						else if(wheel[0][1] == -4 && wheel[0][1] == -5 && wheel[0][1] == -3)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
						}
						else if(wheel[0][1] == -4 && wheel[0][1] == -3 && wheel[0][1] == -5)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
						}
						else if(wheel[0][1] == -5 && wheel[0][1] == -4 && wheel[0][1] == -3)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
						}
						else if(wheel[0][1] == -5 && wheel[0][1] == -4 && wheel[0][1] == -3)
						{
							tokens += 12;
							tfWon.setText("Congratulations! You've won 12 tokens!");
						}
					}
					//Checks if all the numbers are different
					if (wheel[0][1] != wheel[1][1] && wheel[0][1] != wheel[2][1] && wheel[1][1] != wheel[2][1])
					{

						if(wheel[0][1] == -2)
						{
							tokens += 3;
							tfWon.setText("Congratulations! You've won 3 tokens!");
							playAgain = false;
						}
						if(wheel[1][1] == -2)
						{
							tokens += 3;
							tfWon.setText("Congratulations! You've won 3 tokens!");
							playAgain = false;
						}
						if(wheel[2][1] == -2)
						{
							tokens += 3;
							tfWon.setText("Congratulations! You've won 3 tokens!");
							playAgain = false;
						}
					}
					tfResult.setText(wheel[0][1] + " " + wheel[1][1] + " " + wheel[2][1]);
					tfToken.setText("Would you like to play again? You have " + tokens + " tokens.");
					

					
				}while(playAgain == true);	

				if (playAgain == true);
				{
					tfToken.setText("Thanks for playing! You ended with " + tokens + " tokens!");
					playAgain = false;
				}

			}

		}
		public void endProgram() {
			System.exit(0);
		}
	}
}

