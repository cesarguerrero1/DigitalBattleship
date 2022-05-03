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
	
	//Using a built-in ADT to house information about parts of the ship! Each part lives on its own coordinate and we need to know if that
	//coordinate has been hit or not
	private HashMap<Boolean, Integer[]> shipParts;
	
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
	
	/**
	 * Return the size of the current ship
	 * @return - The size of the ship
	 */
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
	 * Check to see if a given strike has damange our ship
	 * @return - Whether all parts have been struck
	 */
	public void checkShip(int[] strikeCoordinates) {
		if(this.isFloating == false) {
			return;
		}
		
		//Check each part of the ships for these coordinates and if you are hit then reflect that.
		
		
		//If all parts of the ship are hit then the boat is SUNK
		
		
	}
	
	/**
	 * NOTE: This is a very easy and simple way to override methods provided by Java. Method overriding is 
	 * not special to pre-built Java Methods. You can absolutely override methods that you yourself have created.
	 * 
	 * This method override is used to help us display a tidbit about the ship itself
	 */
	@Override
	public String toString(){
		return this.shipName;
	}
}
