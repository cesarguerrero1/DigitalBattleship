/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * The turn node will hold the data we want to eventually display
 */
public class TurnNode implements NodeInterface{

		//Word nodes have the string they represent and a pointer to the next node
		NodeInterface nextNode;
		String playerName;
		String attackOutcome;
		int[] strikeLocation;
		
		/**
		 * Constructor to make a WordNode and then point it to another node
		 * @param string - String for the node to store
		 * @param node - Node that our created node should point to
		 */
		public TurnNode(String playerName, String attackOutcome, int[] strikeLocation, NodeInterface node) {
			this.playerName = playerName;
			this.attackOutcome = attackOutcome;
			this.nextNode = node;
			this.strikeLocation = strikeLocation;
		}
		
		//Getters
		public String getName() {
			return this.playerName;
		}
		
		public String getAttackOutcome(){
			return this.attackOutcome;
		}
		
		public int[] getStrikeLocation() {
			return this.strikeLocation;
		}
	
		
		public NodeInterface addToBack(NodeInterface node) {
			this.nextNode = this.nextNode.addToBack(node);
			return this;
		}
		
		public int countAttacks() {
			return 1 + this.nextNode.countAttacks();
		}
		
		public int countMisses() {
			if(attackOutcome.equals("MISS")) {
				return 1 + this.nextNode.countMisses();
			}else {
				return 0 + this.nextNode.countMisses();
			}
		}

		public int countHits() {
			if(attackOutcome.equals("HIT")) {
				return 1 + this.nextNode.countHits();
			}else {
				return 0 + this.nextNode.countHits();
			}
		}
		
		
		public String toString() {
			return "On this turn the attack outcome for " + this.playerName + " was " + this.attackOutcome;
		}

}
