/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

/**
 * Game Controller is part of the MVC Design. The Controller is responsbile for calling on the Model for
 * information and then sending that information to the View to show the user
 */
public class GameController implements ActionListener, MouseListener{
	
	private GameView gameView;
	private GameModel gameModel;
	private GameState gameState; 

	/**
	 * Constructor for our class
	 * @param gameModel - The Model Class is in charge of all of the game logic and functionality
	 * @param gameView - The View Class is in charge of displaying the infromation provided by the Model
	 */
	public GameController(GameModel gameModel, GameView gameView) {
		this.gameView = gameView;
		this.gameModel = gameModel;
		this.gameState = GameState.preGame;
	}
	
	/**
	 * Start the game flow
	 */
	public void run() {
		if(this.gameState != GameState.preGame) {
			return;
		}
		
		//Display the created JFrame
		this.gameView.createGUI();
		
		//Allow the Controller to listen to events
		this.gameView.setMouseListener(this);
		this.gameView.setActionListener(this);
		
		//Change the GameState
		this.gameState = GameState.midGame;
		
	}
	
	/**
	 * This method allows us to display the winner and their stats
	 */
	private void gameOver() {
		if(this.gameState != GameState.endGame) {
			return;
		}
		this.gameView.advanceCard();
		this.gameView.updateGameOverScreen(this.gameModel.getWinner(), this.gameModel.getGameHistory());
	}

	/**
	 * We need to handle what happens when a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//We need to know what button was clicked
		switch(e.getActionCommand()) {
			//We click the start Button
			case "START":
				//Now we advance to the next card
				this.gameView.advanceCard();
				break;
			//We clicked the setup button which should create then have our Model create our player objects
			case "SETUP":
				//We need to create our two players
				String[] names = this.gameView.getPlayerNames();
				
				//Error correct the names
				if(names[0].strip().equals("")) {
					names[0] = "Player1";
				}
				
				if(names[1].strip().equals("")) {
					names[1] = "Player2";
				}
				
				this.gameModel.createPlayers(names[0], names[1]);;
				
				//Now we advance to the next card
				this.gameView.advanceCard();
				break;
			case "BEGIN":
				Player player = this.gameModel.getPlayerToMove();
				this.gameView.refreshStrikeBoard(player, player.getStrikeBoard().getBoardValues(), player.getName() + " click one of the squares empty squares above to launch an attack!");
				this.gameView.refreshShipBoard(player, player.getLocationBoard().getBoardValues());
				break;
				
		}
	}

	/**
	 * We need to handle what happens when a mouse is pressed. Note that this event handler is in charge of
	 * most of the core functionality of the game.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Player player;
		
		//We need to differentiate between clicks and we know that the only items initiating this event are the JTables
		JTable table = (JTable)e.getSource();
		
		//Two events! Either we are placing ships or sending strikes.
		if(table.getName().equals("Placement Table")) {
			//We are placing ships
			player = this.gameModel.getPlayerToPlaceShips();
			if(player == null) {
				//Update the view after an attempted ship placement
				this.gameView.advanceCard();
				return;
			}else {
				//The player clicked on a square so we need to react accordingly
				String returnValue = this.gameModel.attemptShipPlacement(player, this.gameView.getShipType(), this.gameView.getOrientation(), this.gameView.getStrikeCoordinates());
				
				//Update the view after an attempted ship placement
				this.gameView.placeShips(player, player.getLocationBoard().getBoardValues(), returnValue);
				return;
			}
		}
		
		if(table.getName().equals("Game Table")){
			player = this.gameModel.handleMove(this.gameView.getStrikeCoordinates());
			this.gameView.refreshStrikeBoard(player, player.getStrikeBoard().getBoardValues(), player.getName() + ", click one of the squares empty squares above to launch an attack!");
			this.gameView.refreshShipBoard(player, player.getLocationBoard().getBoardValues());
			
			//Check if the game is over before we continue
			if(this.gameModel.isGameOver() == true) {
				//You have to change the GameState or this won't run
				this.gameState = GameState.endGame;
				this.gameOver();
				return;
			}
			
			player = this.gameModel.getPlayerToMove();
			this.gameView.refreshStrikeBoard(player, player.getStrikeBoard().getBoardValues(), player.getName() + ", click one of the squares empty squares above to launch an attack!");
			this.gameView.refreshShipBoard(player, player.getLocationBoard().getBoardValues());
		}
	}
	
	//Not used but must exist
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//Not used but must exist
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Not used but must exist
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Not used but must exist
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
