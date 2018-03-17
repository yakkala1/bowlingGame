package bowlingGame;

public abstract class GameState {
	
	protected Game game;
	
	public GameState(Game game) {
		this.game = game;
	}

	public abstract void changeGameState();

	public abstract void updateScore(int nBallsRolled);

}
