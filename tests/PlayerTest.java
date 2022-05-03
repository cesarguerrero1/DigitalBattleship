/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.Player;

/**
 * Testing the Player class
 */
public class PlayerTest {

	Player player;
	@Before
	public void setUp() throws Exception {
		player = new Player("Cesar");
	}

	/**
	 * Testing rudimentary Getters
	 */
	@Test
	public void testGetters() {
		assertEquals("Cesar", player.getName());
		//Just making sure these two run
		player.getStrikeBoard().getBoardValues();
		player.getLocationBoard().getBoardValues();
	}

}
