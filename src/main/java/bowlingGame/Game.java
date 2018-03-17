package bowlingGame;

import java.util.BitSet;

public class Game {
	
	GameState gameState = new NonLastFrameFirstRoll(this);
	BowlingArena arena = new BowlingArena();
	Scorer scorer = new Scorer();
	int frameNumber = 0;
	int rollNumber = 0;
	boolean extraBallEnabled = false;

	public int getScore() {
		return scorer.getScore();
	}

	public void roll(String string) throws IllegalArgumentException {
		arena.roll(string);
		int nBallsRolled = string.length();
		gameState.updateScore(nBallsRolled);
		gameState.changeGameState();
	}
	
	public void setFrameNumber(int frameNumber) {
		this.frameNumber = frameNumber;
	}
	
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public int getFrameNumber() {
		return this.frameNumber;
	}
	
	public int getRollNumber() {
		return this.rollNumber;
	}

	public BowlingArena getBowlingArena() {
		return arena;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public void enableExtraBall() {
		extraBallEnabled = true;
	}
	
	public int[] getPreviousLocation(int[] location) {
		return scorer.getPreviousLocation(location);
	}

}