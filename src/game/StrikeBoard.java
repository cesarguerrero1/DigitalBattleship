/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * The Strike board is the board that holds attacks you have made against your opponent
 * @author enginestaff
 *
 */
public class StrikeBoard extends Board{

	public void updateBoard(int[] strikeCoords, String typeOfHit) {
		if(typeOfHit.equals("HIT")) {
			this.board[strikeCoords[1]][strikeCoords[0]] = 1;
		}else if(typeOfHit.equals("MISS")) {
			this.board[strikeCoords[1]][strikeCoords[0]] = 2;
		}
	}
}
