package gameStates;

import bowlingGame.BowlingArena;
import bowlingGame.Game;
import bowlingGame.GameState;

public abstract class LastFrameSecondRoll extends GameState {

	public LastFrameSecondRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		if(getGameArena().allBallsCleared()) {
			enableExtraBall();
			setGameArena( new BowlingArena() );
		}
		if(isExtraBallEnabled()) {
			setRollNumber(2);
			setGameState(new LastFrameThirdRoll(game));
		} else {
			setGameState(new GameEnded(game));
		}
	}

}