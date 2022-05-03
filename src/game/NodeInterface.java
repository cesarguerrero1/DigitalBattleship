/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * This allows us to implement polymorphism with our Linked List Structure 
 */
public interface NodeInterface {
	
	/**
	 * Allow our node to see if it is the last node and if it is, point it to our new node
	 * @param node - The node to be added to the back of the list
	 * @return - A node implementing the NodeInterface 
	 */
	public NodeInterface addToBack(NodeInterface node);
	
	/**
	 * Allow our node to count itself and then recursively call
	 * the next node
	 * @return - The current count of valid attacks made during the game
	 */
	public int countAttacks();
	
	/**
	 * Iterate over the nodes and count hte number of misses
	 * @return - The number of misses
	 */
	public int countMisses();
	
	/**
	 * Iterate over the nodes and count the number of hits
	 * @return - The number of hits
	 */
	public int countHits();
	
	
	/**
	 * We want to allow our nodes to return their contents and allow us to create a full string
	 * @return - String representation for our sentence
	 */
	public String toString();
}
