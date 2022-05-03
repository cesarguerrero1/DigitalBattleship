/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.BattleshipBoard;

public class BattleshipBoardTest {

	BattleshipBoard battleshipBoard;
	
	@Before
	public void setUp() throws Exception {
		battleshipBoard = new BattleshipBoard();
	}

	/**
	 * Testing all of the GETTERS for this class
	 */
	@Test 
	public void testGetters() {
		assertEquals(0, battleshipBoard.getBattleshipCount());
		assertEquals(1, battleshipBoard.getBattleshipLimit());
		assertEquals(0, battleshipBoard.getCarrierCount());
		assertEquals(1, battleshipBoard.getCarrierLimit());
		assertEquals(0, battleshipBoard.getDestroyerCount());
		assertEquals(1, battleshipBoard.getDestroyerLimit());
		assertEquals(0, battleshipBoard.getSubmarineCount());
		assertEquals(1, battleshipBoard.getSubmarineLimit());
		assertEquals(0, battleshipBoard.getShipCount());
		assertEquals(4, battleshipBoard.getShipLimit());
	}
	
	/**
	 * Testing that the arraylist is being populated correctly
	 */
	@Test
	public void testShipsArrayList() {
		assertEquals(0, battleshipBoard.getFloatingShips());
		//Add some ships!
		battleshipBoard.placeShip("Carrier", "North", new int[]{7,7});
		assertEquals(1, battleshipBoard.getFloatingShips());
		assertEquals(1, battleshipBoard.getShipCount());
		assertEquals(1, battleshipBoard.getCarrierCount());
		battleshipBoard.placeShip("Destroyer", "South", new int[]{8,4});
		battleshipBoard.placeShip("Battleship", "South", new int[]{9,0});
		battleshipBoard.placeShip("Submarine", "West", new int[]{4,3});
		assertEquals(4, battleshipBoard.getFloatingShips());
	}

}
