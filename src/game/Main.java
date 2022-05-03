/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * The Main Class will create each component of the MVC and then relinquish control to the Controller
 */
public class Main {

	/**
	 * Our entry point into the entire program. Notice that this is where our MVC Architecture takes over. The Controller holds both an instance of 
	 * the GameView and the GameModel so that when interaction occurs with the Vew then the controller can tell the Model and the Model can respond and
	 * give information to the Controller to then give to the View
	 */
	public static void main(String[] args) {
		
		//Create the View
		GameView gameView = new GameView();
		
		//Create the Model
		GameModel gameModel = new GameModel();
		
		//Create the Coontroller and assign it the View and Model
		GameController gameController = new GameController(gameModel, gameView);
		
		//Give control to the controller
		gameController.run();
	}

}
