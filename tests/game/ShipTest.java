/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Ship Class
 */
public class ShipTest {

	Ship ship;
	
	@Before
	public void setUp() throws Exception {
		int[][] arr = {{0,0}, {0,1}, {0,2}, {0,3}, {0,4}};
		ship = new Ship("Carrier", 5, arr);
	}
	
	/**
	 * Testing the getters
	 */
	@Test
	public void testGetters() {
		assertEquals(ship.getShipSize(), 5);
		//We haven't hit it with anything so should be afloat
		assertEquals(ship.isFloating(), true);
	}
	
	/**
	 * Testing the toString Override
	 */
	@Test
	public void testToString() {
		String string = "The Carrier has a ship size of 5";
		assertEquals(ship.toString(), string);
	}

	/**
	 * Testing the resolve strike method
	 */
	@Test
	public void testResolveStrike() {
		ship.resolveStrike(new int[]{0,0});
		//The ship should still be standing
		assertTrue(ship.isFloating());
		ship.resolveStrike(new int[]{0,1});
		assertTrue(ship.isFloating());
		ship.resolveStrike(new int[]{0,2});
		assertTrue(ship.isFloating());
		ship.resolveStrike(new int[]{0,3});
		assertTrue(ship.isFloating());
		ship.resolveStrike(new int[]{0,4});
		assertFalse(ship.isFloating());
	}
	

}
