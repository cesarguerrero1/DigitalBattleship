/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * Players are the ones that play the game.
 */
public class Player {

	private String name;
	private StrikeBoard strikeHistoryBoard;
	private BattleshipBoard shipLocationBoard;
	
	/**
	 * Constructor for our class
	 * @param name - Name of our Player
	 */
	public Player(String name) {
		this.name = name;
		this.strikeHistoryBoard = new StrikeBoard();
		this.shipLocationBoard = new BattleshipBoard();
	}
	
	/**
	 * Return the name of the Player
	 * @return - Name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the BattleshipBoard object that contains the locations we have attacked
	 * @return - BattleshipBoard object with locations we have attacked
	 */
	public StrikeBoard getStrikeBoard() {
		return this.strikeHistoryBoard;
	}
	
	/**
	 * Return the BattleshipBoard object that contains our ship locations
	 * @return - BattleshipBoard object with ship locations
	 */
	public BattleshipBoard getLocationBoard() {
		return this.shipLocationBoard;
	}
	
	
}
