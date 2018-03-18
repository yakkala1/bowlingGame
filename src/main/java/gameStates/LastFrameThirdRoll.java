package gameStates;

import bowlingGame.Game;
import bowlingGame.GameState;

public class LastFrameThirdRoll extends GameState {

	public LastFrameThirdRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		setGameState(new GameEnded(game));
	}

	@Override
	public void updateScore(int nBallsRolled) {
		getGameScorer().updateScoreAndRespectiveBonuses(getFrameNumber(), getRollNumber(), nBallsRolled);
	}

}