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
	private GameHistory gameHistory;
	
	/**
	 * Constructor for our Game Model Class
	 */
	public GameModel() {
		this.gameOver = false;
		this.winner = null;
		this.player1 = null;
		this.player2 = null;
		this.playerToMove = null;
		this.gameHistory = new GameHistory();
	}
	
	/**
	 * Create our player objects with the names provided via the GUI. THIS SHOULD NOT BE USED! 
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
	 * Return whether or not game over scenario has occurred
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
		if(player1.getLocationBoard().getShipCount() < player1.getLocationBoard().getShipLimit()) {
			return player1;
		}
		
		if(player2.getLocationBoard().getShipCount() < player2.getLocationBoard().getShipLimit()) {
			return player2;
		}
		
		//Otherwise return null
		return null;
	}
	
	/**
	 * Return the Linked List containing nodes of each player's attacking phase
	 * @return - The Linked List Implementation
	 */
	public GameHistory getGameHistory() {
		return this.gameHistory;
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
	
	/**
	 * Given a player clicking on a cell to strike, handle that attack
	 * @param strikeCoordinates - The coordinates the player chose to attack
	 * @return - The player who launched the attack
	 */
	public Player handleMove(int[] strikeCoordinates) {
		//We need to hold the player who called this method as we will possibly be switching at the end
		Player currentPlayer = this.getPlayerToMove();
		int result;
		
		if(currentPlayer == player1) {
			result = this.player1.attack(strikeCoordinates, this.player2, this.gameHistory);
			if(result == 0) {
				//Dont change to the next player!
				return currentPlayer;
			}
			this.playerToMove = player2;
			if(result == 1) {
				//We need to update the ship that was struck
				this.player2.getLocationBoard().checkShips(strikeCoordinates);
			}
		}else{
			result = this.player2.attack(strikeCoordinates, this.player1, this.gameHistory);
			if(result == 0) {
				//Dont change to the next player!
				return currentPlayer;
			}
			this.playerToMove = player1;
			if(result == 1) {
				//We need to update the ship that was struck
				this.player1.getLocationBoard().checkShips(strikeCoordinates);
			}
		}
	
		//Check on whether the game is over
		this.gameOver = this.checkGameOver();
		return currentPlayer;
		
	}
	
	/**
	 * Check if either player has no more active ships. If that is the case then the game is over
	 */
	public boolean checkGameOver() {
		if(this.player1.getLocationBoard().getFloatingShips() == 0) {
			this.winner = this.player2;
			return true;
		}
		
		if(this.player2.getLocationBoard().getFloatingShips() == 0) {
			this.winner = this.player1;
			return true;
		}
		
		//Otherwise flase
		return false;
		
	}
	
}
