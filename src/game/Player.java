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
	private int activeShips;
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
	 * Return the number of active ships for the player
	 * @return - Number of active ships
	 */
	public int getNumActiveShips() {
		return this.shipLocationBoard.getShipCount();
	}
	
	/**
	 * Query your board to get the count of active Carriers
	 * @return - Number of active Carrier Ships
	 */
	public int getCarrierCount() {
		return this.shipLocationBoard.getCarrierCount();
	}
	
	/**
	 * Query your board to get the count of active Battleships
	 * @return - Number of active Battleship Ships
	 */
	public int getBattleshipCount() {
		return this.shipLocationBoard.getBattleshipCount();
	}
	
	/**
	 * Query your board to get the count of active Destroyers
	 * @return - Number of active Destroyer Ships
	 */
	public int getDestroyerCount() {
		return this.shipLocationBoard.getDestroyerCount();
	}
	
	/**
	 * Query your board to get the count of active Submarines
	 * @return - Number of active submarines
	 */
	public int getSubmarineCount() {
		return this.shipLocationBoard.getSubmarineCount();
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
