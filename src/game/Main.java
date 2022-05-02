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
	 * Our entry point into the entire program
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
