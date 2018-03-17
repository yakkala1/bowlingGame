package bowlingGame;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

public class BowlingGameTest {

	@Test
	public void test() {
		Game game = new Game();
		game.roll( "1234" );
		assertEquals(4, game.getScore());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongInputForRoll() {
		Game game = new Game();
		game.roll( "1234" );
		game.roll( "564" );
	}
	
	@Test
	public void testScoreForTwoRolls() {
		Game game = new Game();
		game.roll( "1234" );
		game.roll( "568" );
		assertEquals(7, game.getScore());
	}
	
	@Test
	public void testScoreForThreeRolls() {
		Game game = new Game();
		game.roll( "12347" );
		game.roll( "05689" );
		assertEquals(10, game.getScore());
		game.roll("123");
		assertEquals(16, game.getScore());
	}

	@Test
	public void testScoreForTenRolls() {
		Game game = new Game();
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );;
		assertEquals(45, game.getScore());
	}

	@Test
	public void testScoreForTwentyRolls() {
		Game game = new Game();
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		assertEquals(90, game.getScore());
	}

	@Test
	public void testScoreForTwentyRollsWithSpare() {
		Game game = new Game();
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		game.roll( "12347" );
		game.roll( "0568" );
		assertEquals(96, game.getScore());
	}		

	@Test
	public void testScoreForTwentyOneRollsWithAllSpares() {
		Game game = new Game();
		game.roll( "12347" );
		game.roll( "05689" );//10+5
		game.roll( "12347" );
		game.roll( "05689" );//10+5
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );
		game.roll( "12347" );
		game.roll( "05689" );//10+5
		game.roll( "05689" );//5
		assertEquals(155, game.getScore());
	}

	@Test
	public void testScoreWithTwelveStrikes() {
		Game game = new Game();
		game.roll( "0123456789" );//10 + 10 + 10
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );
		game.roll( "0123456789" );//10 + 10 + 10
		game.roll( "0123456789" );//10 + 10
		game.roll( "0123456789" );//10
		assertEquals(330, game.getScore());
	}	
}