/*
 * Cesar Guerrero
 * CS5004 - Spring 2022
 * 05/01/22
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import game.GameController;
import game.GameModel;
import game.GameView;

/**
 * Testing the GameController - Specifically the GameState
 */
public class GameControllerTest {

	GameController gameController;
	
	/**
	 * Ensuring we can create each object
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		gameController = new GameController(new GameModel(), new GameView());
	}



}
