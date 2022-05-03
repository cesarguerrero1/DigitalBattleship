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
		this.player1 = null;
		this.player2 = null;
		this.playerToMove = null;
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
		//We need to hold the player who called this method as we will be switching at the end
		Player currentPlayer = this.getPlayerToMove();
		
		//Launch the strike and check to see if it was valid so we can react accordingly
		
		//Update who is next
		if(this.playerToMove == player1) {
			this.playerToMove = player2;
		}else{
			this.playerToMove = player1;
		}
		
		return currentPlayer;
		
		//
		/*
		 * //Check if the game is over
		if(this.gameOver == true) {
			throw new IllegalStateException("The game is over!");
		}
		
		//Check if the move is even valid for the row and the column
		if(row < 0 || row > this.rowSize) {
			throw new IllegalArgumentException("The position is invalid! You can only use 0, 1, and 2 for the row");
		}
		
		if(column < 0 || column > this.columnSize) {
			throw new IllegalArgumentException("The position is invalid! You can only use 0, 1, and 2 for the column");
		}
		
		//Now check if the space is occupied
		Player boardValue = this.gameBoard[row][column];
		if(boardValue != null) {
			throw new IllegalArgumentException("The position is full");
		}
		
		//The space isn't full, the game isn't over, and we have valid coordinates so make
		//a move and update everything accordingly
		this.gameBoard[row][column] = this.playerToMove;
		
		//Check if the game should be over!
		//NOTE: I put this here becuase if you forget to call '.isGameOver()' after a manual
		//call then the game can technically keep going and it shouldnt!
		this.gameOver = this.isGameOver();
		
		if(this.gameOver == true) {
			return;
		}else {
			//Handle the rest
			this.turnNumber++;
			

		}
		
	}
		 */
	}
	
	/**
	 * Check if either player has no more active ships. If that is the case then the game is over
	 */
	public void checkGameOver() {
		
	}
	
}
