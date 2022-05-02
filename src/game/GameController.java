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

	/**
	 * Constructor for our class
	 * @param gameModel - The Model Class is in charge of all of the game logic and functionality
	 * @param gameView - The View Class is in charge of displaying the infromation provided by the Model
	 */
	public GameController(GameModel gameModel, GameView gameView) {
		this.gameView = gameView;
		this.gameModel = gameModel;
	}
	
	/**
	 * Start the game flow
	 */
	public void run() {
		//Display the created JFrame
		this.gameView.createGUI();
		
		//Allow the Controller to listen to events
		this.gameView.setMouseListener(this);
		this.gameView.setActionListener(this);
		
	}
	
	/**
	 * This needs to keep running until both players have placed all of their ships
	 */
	public void setup() {
		
	}
	
	/**
	 * This is the main game loop. So long as a player has ships the game will
	 * keep running
	 */
	private void gameCycle() {
		
	}
	
	/**
	 * This method allows us to display the winner and their stats
	 */
	private void gameOver() {
		
	}

	/**
	 * We need to handle what happens when a button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//We need to know what button was clicked
		switch(e.getActionCommand()) {
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
		}
	}

	/**
	 * We need to handle what happens when a mouse is pressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		Player player;
		
		//We need to differentiate between clicks and we know that the only items initiating this event are the JTables
		JTable table = (JTable)e.getSource();
		
		if(table.getName().equals("Placement Table")) {
			//We are placing ships
			player = this.gameModel.getPlayerToPlaceShips();
			if(player == null) {
				//Update the view after an attempted ship placement
				this.gameView.placeShips(player, null, "...");
			}else {
				//The player clicked on a square so we need to react accordingly
				String returnValue = this.gameModel.attemptShipPlacement(player, this.gameView.getShiptype(), this.gameView.getOrientation(), this.gameView.getStrikeCoordinates());
				
				//Update the view after an attempted ship placement
				this.gameView.placeShips(player, player.getLocationBoard().getBoardValues(), returnValue);
			}
			
		}else {
			//We are actively playing
			player = this.gameModel.getPlayerToMove();
			//player.getStrikeBoard().updateBoard();
			//Update the enemies shipLocation Board as well
			
			//Now update the GUI
			this.gameView.refreshStrikeBoard(player, player.getLocationBoard().getBoardValues());
			this.gameView.refreshShipBoard(player, player.getStrikeBoard().getBoardValues());
			
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
