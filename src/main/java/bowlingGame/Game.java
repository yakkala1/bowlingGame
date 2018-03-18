package bowlingGame;

import gameStates.NonLastFrameFirstRoll;

public class Game {
	
	private GameState gameState = new NonLastFrameFirstRoll(this);
	private BowlingArena arena = new BowlingArena();
	private Scorer scorer = new Scorer();
	private int frameNumber = 0;
	private int rollNumber = 0;
	private boolean extraBallEnabled = false;

	public int getScore() {
		return scorer.getScore();
	}

	public void roll(String string) throws IllegalArgumentException {
		arena.removePins(string);
		int nBallsRolled = string.length();
		gameState.updateScore(nBallsRolled);
		gameState.changeGameState();
	}
	
	//getters and setters
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
	
	public Scorer getScorer() {
		return scorer;
	}
	
	public void setBowlingArena(BowlingArena arena) {
		this.arena = arena;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public void enableExtraBall() {
		extraBallEnabled = true;
	}
	
	public boolean isExtraBallEnabled() {
		return extraBallEnabled;
	}

}