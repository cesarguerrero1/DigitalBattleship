/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * Players are the ones that play the game.
 */
public class Player {

	private String name;
	private StrikeBoard strikeHistoryBoard;
	private BattleshipBoard shipLocationBoard;
	
	/**
	 * Constructor for our class
	 * @param name - Name of our Player
	 */
	public Player(String name) {
		this.name = name;
		this.strikeHistoryBoard = new StrikeBoard();
		this.shipLocationBoard = new BattleshipBoard();
	}
	
	/**
	 * Return the name of the Player
	 * @return - Name of the player
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Return the BattleshipBoard object that contains the locations we have attacked
	 * @return - BattleshipBoard object with locations we have attacked
	 */
	public StrikeBoard getStrikeBoard() {
		return this.strikeHistoryBoard;
	}
	
	/**
	 * Return the BattleshipBoard object that contains our ship locations
	 * @return - BattleshipBoard object with ship locations
	 */
	public BattleshipBoard getLocationBoard() {
		return this.shipLocationBoard;
	}
	
	/**
	 * We need to verify with ourselves and our opponent whether our strike was valid or not
	 * @return - An integer represeting the type of hit that occurred
	 */
	public int attack(int[] strike, Player opponent, GameHistory gameHistory) {
		//Check your own array before anything else
		if(this.strikeHistoryBoard.getBoardValues()[strike[1]][strike[0]] != 0){
			//We hit something that we have alreayd hit before
			return 0;
		}else{
			//Check with your opponent to see if you hit a ship
			if(opponent.shipLocationBoard.getBoardValues()[strike[1]][strike[0]] == 1) {
				//We hit a ship!
				
				//Update our boards
				this.strikeHistoryBoard.updateBoard(strike, "HIT");
				//Update their boards
				opponent.shipLocationBoard.updateBoard(strike, "HIT");
				//Add to our linked list of historical nodes
				gameHistory.addToBack(this.name, "HIT", strike);
				
				return 1;
			}else {
				//We missed!
				//Update our boards
				this.strikeHistoryBoard.updateBoard(strike, "MISS");
				//Update their boards
				opponent.shipLocationBoard.updateBoard(strike, "MISS");
				
				//Add to our linked list of historical nodes
				gameHistory.addToBack(this.name, "MISS", strike);
				return 2;
			}
		}
	}
	
}
