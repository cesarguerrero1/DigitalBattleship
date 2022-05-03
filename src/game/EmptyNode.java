/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;


/**
 * Empty nodes allow us to implement recursion
 * @author enginestaff
 */
public class EmptyNode implements NodeInterface{

	public NodeInterface addToBack(NodeInterface node) {
		return node;
	}
	
	public int countAttacks() {
		return 0;
	}

	public int countMisses() {
		return 0;
	}

	public int countHits() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}

}
