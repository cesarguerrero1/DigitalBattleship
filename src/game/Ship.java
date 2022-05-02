/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

import java.util.HashMap;

/**
 * Boards have ships on them and each ship is its own entity
 */
public class Ship {
	
	private String shipName;
	private int shipSize;
	private boolean isFloating;
	private HashMap<Boolean, Integer[]> shipParts; //This houses all the parts of the ship
	
	/**
	 * Constructor for our ship
	 * @param shipSize - How big is the ship
	 * @param positionCoords - The coordinates for each part of the ship
	 */
	public Ship(String shipName, int shipSize, int[][] positionCoords) {
		
		this.shipName = shipName;
		this.shipSize = shipSize;
		this.shipParts = new HashMap<Boolean, Integer[]>();
		
		for(int i = 0; i < shipSize; i++) {
			//Each subarray only contains two items
			shipParts.put((Boolean)true, new Integer[]{positionCoords[i][0], positionCoords[i][1]});
		}
		
		this.isFloating = true;
	}
	
	public int getShipSize() {
		return this.shipSize;
	}
	
	/**
	 * Inform the user if the ship is floating
	 * @return - Whether the ship sunk or is alive
	 */
	public boolean isFloating() {
		return this.isFloating;
	}
	
	/**
	 * Check to see if all of your ship parts have been struck
	 * @return - Whether all parts have been struck
	 */
	public void handleStrike() {
		
	}
}
