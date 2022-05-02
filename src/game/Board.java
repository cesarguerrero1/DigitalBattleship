/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
package game;

/**
 * Boards are whate drive this game. However, one board has ships and the other does not
 */
public abstract class Board {

	//This nested array is what informs our game of what is where
	protected int[][] board;
	private int boardHeight;
	private int boardWidth;
	
	/**
	 * Constructor for our board. This class can never be instantiated but we do
	 * still need to initialize variables
	 */
	public Board() {
		this.boardHeight = 10;
		this.boardWidth = 10;
		
		//Our array is 10x10 and it should all be zeroes! 
		board = new int[this.boardHeight][this.boardWidth];
		for(int i = 0; i < this.boardHeight; i++) {
			for(int j = 0; j < this.boardWidth; j++) {
				this.board[i][j] = 0;
			}
		}
		
	}
	
	/**
	 * Get the stored array values for this board
	 * @return
	 */
	public int[][] getBoardValues(){
		return this.board;
	}
	
}
