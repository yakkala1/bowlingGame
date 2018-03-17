package bowlingGame;

public class LastFrameThirdRoll extends GameState {

	public LastFrameThirdRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		game.setGameState(new GameEnded(game));
	}

	@Override
	public void updateScore(int nBallsRolled) {
		game.scorer.insertScore(game.frameNumber, game.rollNumber, nBallsRolled);
	}

}