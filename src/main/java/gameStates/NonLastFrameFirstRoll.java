package gameStates;

import bowlingGame.BowlingArena;
import bowlingGame.Game;
import bowlingGame.GameState;

public class NonLastFrameFirstRoll extends GameState {

	public NonLastFrameFirstRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		if( getGameArena().allBallsCleared() ) {
			incrementFrameNumber();
			setRollNumber(0);
			setGameArena( new BowlingArena() );
			setGameState(new NonLastFrameFirstRoll(game));
			if(getFrameNumber() == 9) {
				setGameState(new LastFrameFirstRoll(game));
			}
		} else {
			setRollNumber(1);
			setGameState(new NonLastFrameSecondRoll(game));
		}
	}

	@Override
	public void updateScore(int nBallsRolled) {
		getGameScorer().updateScoreAndRespectiveBonuses(getFrameNumber(), getRollNumber(), nBallsRolled);
		if( getGameArena().allBallsCleared() )  {
			getGameScorer().setStrike(getFrameNumber(), getRollNumber());
		}
	}

}
