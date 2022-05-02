/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

import java.util.ArrayList;

/**
 * This class holds the arrays that we will use to populate our GUI
 */
public class BattleshipBoard extends Board{

	//Ship Limits
	private int carrierLimit;
	private int battleshipLimit;
	private int destroyerLimit;
	private int submarineLimit;
	private int totalShipLimit;
	
	//Ship Counts
	private int carrierCount;
	private int battleshipCount;
	private int destroyerCount;
	private int submarineCount;
	private int totalShipCount;
	
	//Ship Array
	ArrayList<Ship> ships;
	
	/**
	 * Setup the defaults for this board
	 */
	public BattleshipBoard() {
		
		this.carrierLimit = 1;
		this.battleshipLimit = 1;
		this.destroyerLimit = 1;
		this.submarineLimit = 1;
		this.totalShipLimit = this.carrierLimit + this.battleshipLimit + this.destroyerLimit + this.submarineLimit;
		
		this.carrierCount = 0;
		this.battleshipCount = 0;
		this.destroyerCount = 0;
		this.submarineCount = 0;
		this.totalShipCount = 0;
		
		this.ships = new ArrayList<Ship>();
	}
	
	/**
	 * Get the total ship count
	 * @return - Total Ship Count
	 */
	public int getShipCount() {
		return this.totalShipCount;
	}
	
	/**
	 * Get the total allowed ships on the board
	 * @return - total number of ships allowed on the board
	 */
	public int getShipLimit() {
		return this.totalShipLimit;
	}
	
	/**
	 * Get the number of carriers still active on the board
	 * @return - Number of carriers
	 */
	public int getCarrierCount() {
		return this.carrierCount;
	}
	
	/**
	 * Get the number of Battleships still active on the board
	 * @return - Number of carriers
	 */
	public int getBattleshipCount() {
		return this.battleshipCount;
	}
	
	/**
	 * Get the number of Destroyers still active on the board
	 * @return - Number of carriers
	 */
	public int getDestroyerCount() {
		return this.destroyerCount;
	}
	
	/**
	 * Get the number of Submarines still active on the board
	 * @return - Number of carriers
	 */
	public int getSubmarineCount() {
		return this.submarineCount;
	}
	
	/**
	 * Get the number of carriers allowed on the board
	 * @return - number of carriers allowed on the board
	 */
	public int getCarrierLimit() {
		return this.carrierLimit;
	}
	
	/**
	 * Get the number of battleships allowed on the board
	 * @return - number of battleships allowed on the board
	 */
	public int getBattleshipLimit() {
		return this.battleshipLimit;
	}
	
	/**
	 * Get the number of Destroyers allowed on the board
	 * @return - number of Destroyers allowed on the board
	 */
	public int getDestroyerLimit() {
		return this.destroyerLimit;
	}
	
	/**
	 * Get the number of Submarines allowed on the board
	 * @return - number of Submarines allowed on the board
	 */
	public int getSubmarineLimit() {
		return this.submarineLimit;
	}
	
	/**
	 * Attempt to place a ship on the board
	 * @param shipName - The type of ship attempting to be placed
	 * @param orientation - The direction the ship will grow from the anchored point
	 * @param startingCoord - The location at hich the ship is anchored
	 * @return - Boolean as to whetehr the ship palcement was succesful or not
	 */
	public boolean placeShip(String shipName, String orientation, int[] startingCoord) {
		System.out.printf("(%d,%d)", startingCoord[0], startingCoord[1]);
		int[][] fullShipCoords = null; //This will house the full coordinate for our ship
		int shipSize = 0;
		switch(shipName) {
			case "Carrier":
				//We need to do several checks before placement is allowed
				if(carrierCount == carrierLimit) {
					return false;
				}
				
				switch(orientation) {
					case "North": 
						//(column, row){{5,0},{5, -1), {5, -2} ,etc}
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] - 1}, {startingCoord[0], startingCoord[1] - 2}, {startingCoord[0], startingCoord[1] - 3}, {startingCoord[0], startingCoord[1] - 4}};
						break;
					case "East":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] + 1, startingCoord[1]}, {startingCoord[0] + 2, startingCoord[1]}, {startingCoord[0] + 3, startingCoord[1]}, {startingCoord[0] + 4, startingCoord[1]}};
						break;
					case "South":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] + 1}, {startingCoord[0], startingCoord[1] + 2}, {startingCoord[0], startingCoord[1] + 3}, {startingCoord[0], startingCoord[1] + 4}};
						break;
					case "West":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] - 1, startingCoord[1]}, {startingCoord[0] - 2, startingCoord[1]}, {startingCoord[0] - 3, startingCoord[1]}, {startingCoord[0] - 4, startingCoord[1]}};
						break;
					default:
						//If we have bad input then just return
						return false;
				}
				
				shipSize = 5;
				break;
			case "Battleship":
				//We need to do several checks before placement is allowed
				if(battleshipCount == battleshipLimit) {
					return false;
				}
				
				switch(orientation) {
					case "North":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] - 1}, {startingCoord[0], startingCoord[1] - 2}, {startingCoord[0], startingCoord[1] - 3}};
						break;
					case "East":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] + 1, startingCoord[1]}, {startingCoord[0] + 2, startingCoord[1]}, {startingCoord[0] + 3, startingCoord[1]}};
						break;
					case "South":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] + 1}, {startingCoord[0], startingCoord[1] + 2}, {startingCoord[0], startingCoord[1] + 3}};
						break;
					case "West":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] - 1, startingCoord[1]}, {startingCoord[0] - 2, startingCoord[1]}, {startingCoord[0] - 3, startingCoord[1]}};
						break;
					default:
						//If we have bad input then just return
						return false;
				}
				
				shipSize = 4;
				break;
			case "Destroyer":
				//We need to do several checks before placement is allowed
				if(destroyerCount == destroyerLimit) {
					break;
				}
				
				switch(orientation) {
					case "North":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] - 1}, {startingCoord[0], startingCoord[1] - 2}, {startingCoord[0], startingCoord[1] - 3}};
						break;
					case "East":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] + 1, startingCoord[1]}, {startingCoord[0] + 2, startingCoord[1]}, {startingCoord[0] + 3, startingCoord[1]}};
						break;
					case "South":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] + 1}, {startingCoord[0], startingCoord[1] + 2}, {startingCoord[0], startingCoord[1] + 3}};
						break;
					case "West":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] - 1, startingCoord[1]}, {startingCoord[0] - 2, startingCoord[1]}, {startingCoord[0] - 3, startingCoord[1]}};
						break;
					default:
						//If we have bad input then just return
						return false;
				}
				
				shipSize = 4;
				break;
			case "Submarine":
				//We need to do several checks before placement is allowed
				if(submarineCount == submarineLimit) {
					return false;
				}
				
				switch(orientation) {
					case "North":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] - 1}, {startingCoord[0], startingCoord[1] - 2}};
						break;
					case "East":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] + 1, startingCoord[1]}, {startingCoord[0] + 2, startingCoord[1]}};
						break;
					case "South":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0], startingCoord[1] + 1}, {startingCoord[0], startingCoord[1] + 2}};
						break;
					case "West":
						fullShipCoords = new int[][]{{startingCoord[0], startingCoord[1]}, {startingCoord[0] - 1, startingCoord[1]}, {startingCoord[0] - 2, startingCoord[1]}};
						break;
					default:
						//If we have bad input then just return
						return false;
				}
				
				shipSize = 3;
				break;
			default:
				//If we have bad input then just return
				return false;
		}

		//If we got this far it means we have valid ship placement coordinates we now have to check those coordinates against our board
		if(this.checkShipCoords(fullShipCoords) == true) {
			//Create a ship and place it in our array
			Ship newShip = new Ship(shipName, shipSize, fullShipCoords);
			switch(shipName) {
				case "Carrier":
					this.carrierCount++;
					break;
				case "Battleship":
					this.battleshipCount++;
					break;
				case "Destroyer":
					this.destroyerCount++;
					break;
				case "Submarine":
					this.submarineCount++;
					break;
			}
			ships.add(newShip);
			this.totalShipCount++;
			this.addShipToBoard(fullShipCoords);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Check to see if the ship is allowed to be placed in the desired location
	 * @param shipCoords - The coordinates we want to check
	 */
	private boolean checkShipCoords(int[][] shipCoords) {
		try {
			//Iterate over the desired nested array to test our coordinates against the ship coordinates
			for(int i = 0; i < shipCoords.length; i++) {
				//We know there are only 2 values in each subarray
				if(super.board[shipCoords[i][1]][shipCoords[i][0]] == 1) {
					//If any any point we get a 1 then we are overlapping on a ship
					return false;
				}
			}
		}catch(Exception exception){
			System.out.println("Error!");
			//We went out of bounds
			return false;
		}
		
		//If we get here it means our coordintes are valid1
		return true;
	}
	
	/**
	 * Add a ship to the board
	 * @param shipCoords - The coordinates used to update our board
	 */
	private void addShipToBoard(int[][] shipCoords) {
		for (int[] shipCoordinate : shipCoords) {
			super.board[shipCoordinate[1]][shipCoordinate[0]] = 1;
		}
	}
}
