/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * The GameHistory Class is my implementation of a Linked List.
 */
public class GameHistory{
	//HEAD of our LIST
	private NodeInterface head;
	
	/**
	 * Constructor to allow us to create an EMPTY LIST
	 * NOTE: Empty lists still have an EMPTY NODE
	 */
	public GameHistory() {
		this.head = new EmptyNode(); 
	}
	
	/**
	 * Add a new node to the back of the list. 
	 * @param playerName - Name of the player who moved this turn
	 * @param attackOutcome - Outcome of the attack
	 * @param strikeLocation - The location the attack was sent to
	 */
	public void addToBack(String playerName, String attackOutcome, int[] strikeLocation) {
		if(this.head instanceof EmptyNode) {
			this.head = new TurnNode(playerName, attackOutcome, strikeLocation, new EmptyNode());
		}else {
			this.head.addToBack(new TurnNode(playerName, attackOutcome, strikeLocation, new EmptyNode()));
		}
	}
	
	/**
	 * Count the number of attacks that were made
	 * @return - Total number of attacks made
	 */
	public int getNumberOfAttacks() {
		return this.head.countAttacks();
	}
	
	/**
	 * Count the number of attacks that were successful HITS
	 * @return - Total number of hits
	 */
	public int getNumberOfHits() {
		return this.head.countHits();
	}
	
	/**
	 * Count the number of attacks that were MISSES
	 * @return - Total number of misses
	 */
	public int getNumberOfMisses() {
		return this.head.countMisses();
	}
	
}
