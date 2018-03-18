package gameStates;

import bowlingGame.Game;
import bowlingGame.GameState;

public class GameEnded extends GameState {

	public GameEnded(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateScore(int nBallsRolled) {
		throw new UnsupportedOperationException();
	}

}
