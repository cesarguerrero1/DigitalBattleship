/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.GameHistory;

/**
 * Testing the Linked List Class
 */
public class GameHistoryTest {

	GameHistory gameHistory;
	
	@Before
	public void setUp() throws Exception {
		gameHistory = new GameHistory();
	}

	/**
	 * Testing Empty Node
	 */
	@Test
	public void testRecursiveGetters() {
		assertEquals(0, gameHistory.getNumberOfAttacks());
		assertEquals(0, gameHistory.getNumberOfHits());
		assertEquals(0, gameHistory.getNumberOfMisses());
	}
	
	/**
	 * Adding a node to the back
	 */
	@Test
	public void testAddToBack() {
		gameHistory.addToBack("Cesar", "HIT", new int[]{0,0});
		gameHistory.addToBack("Cesar", "HIT", new int[]{1,1});
		assertEquals(2, gameHistory.getNumberOfAttacks());
		assertEquals(2, gameHistory.getNumberOfHits());
		assertEquals(0, gameHistory.getNumberOfMisses());
	}
	
}
