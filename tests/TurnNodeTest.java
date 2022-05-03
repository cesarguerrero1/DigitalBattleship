/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.TurnNode;

/**
 * Testing the nodes that living within our Linked List
 */
public class TurnNodeTest {

	TurnNode turnNode;
	
	@Before
	public void setUp() throws Exception {
		turnNode = new TurnNode("Cesar", "MISS", new int[]{3,6}, null);
	}

	/**
	 * Testing Getters
	 */
	@Test
	public void testGetters() {
		assertEquals("Cesar", turnNode.getName());
		assertEquals("MISS", turnNode.getAttackOutcome());
		assertEquals(3, turnNode.getStrikeLocation()[0]);
		assertEquals(6, turnNode.getStrikeLocation()[1]);
	}

}
