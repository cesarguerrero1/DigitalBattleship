/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * Game Model is part of the MVC Design. The Model is in charge of implementing the functionality and logic behind our program
 */
public class GameModel {
	
	private boolean gameOver;
	private Player winner;
	private Player player1;
	private Player player2;
	private Player playerToMove;
	
	/**
	 * Constructor for our Game Model Class
	 */
	public GameModel() {
		this.gameOver = false;
		this.winner = null;
		this.playerToMove = null;
	}
	
	/**
	 * Create our player objects with the names provided via the GUI
	 * @param playerOneName - Name of Player One
	 * @param playerTwoName - Name of Player Two
	 */
	public void createPlayers(String playerOneName, String playerTwoName) {
		this.player1 = new Player(playerOneName);
		this.player2 = new Player(playerTwoName);
		
		//Player1 always goes first
		this.playerToMove = this.player1;
	}
	
	/**
	 * Return whether or not the game is over
	 * @return - A boolean informing us if the game is over
	 */
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	/**
	 * Return the winning player
	 * @return - The winning player
	 */
	public Player getWinner() {
		return this.winner;
	}
	
	/**
	 * Get the player whose turn it is to move
	 * @return - The player to make the next move
	 */
	public Player getPlayerToMove() {
		return this.playerToMove;
	}
	
	/**
	 * Return the player who still needs to place their ships on the board
	 * @return - The player who still needs to place ships
	 */
	public Player getPlayerToPlaceShips() {
		if(player1.getNumActiveShips() < player1.getLocationBoard().getShipLimit()) {
			return player1;
		}
		
		if(player2.getNumActiveShips() < player2.getLocationBoard().getShipLimit()) {
			return player2;
		}
		
		//Otherwise return null
		return null;
	}
	
	/**
	 * Given coordinates and other information, have the given player attempt to put a ship down
	 * @param player - The player whose board we want access to
	 * @param shipType - The type of ship being placed
	 * @param orientation - 
	 * @param strikeCoords
	 */
	public String attemptShipPlacement(Player player, String shipType, String orientation, int[] strikeCoords) {
		boolean returnValue = player.getLocationBoard().placeShip(shipType, orientation, strikeCoords);
		if(returnValue == false) {
			return new String("Your ship was unsuccessfully added! Please check the given ship limit, whether you are overlapping with another ship, or your ship is out of bounds.");
		}else {
			return new String("Your ship was successfully added!");
		}
	}
	
}
