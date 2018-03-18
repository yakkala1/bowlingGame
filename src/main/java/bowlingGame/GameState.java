package bowlingGame;

public abstract class GameState {
	
	protected Game game;
	
	public GameState(Game game) {
		this.game = game;
	}
	
	protected BowlingArena getGameArena() {
		return this.game.getBowlingArena();
	}
	
	protected Scorer getGameScorer() {
		return this.game.getScorer();
	}
	
	protected int getFrameNumber() {
		return this.game.getFrameNumber();
	}
	
	protected int getRollNumber() {
		return this.game.getRollNumber();
	}
	
	protected void setRollNumber(int rollNumber) {
		this.game.setRollNumber( rollNumber );
	}
	
	protected void incrementFrameNumber() {
		this.game.setFrameNumber(this.game.getFrameNumber() + 1);
	}
	
	protected void setGameState(GameState state) {
		this.game.setGameState(state);
	}
	
	protected void setGameArena(BowlingArena arena) {
		this.game.setBowlingArena(arena);
	}
	
	protected void enableExtraBall() {
		this.game.enableExtraBall();
	}
	
	protected boolean isExtraBallEnabled() {
		return this.game.isExtraBallEnabled();
	}

	public abstract void changeGameState();

	public abstract void updateScore(int nBallsRolled);

}
