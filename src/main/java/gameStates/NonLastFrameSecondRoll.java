package gameStates;

import bowlingGame.BowlingArena;
import bowlingGame.Game;
import bowlingGame.GameState;

public class NonLastFrameSecondRoll extends GameState {

	public NonLastFrameSecondRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		incrementFrameNumber();
		setRollNumber(0);
		setGameArena( new BowlingArena() );
		setGameState( new NonLastFrameFirstRoll(game) );
		if(getFrameNumber() == 9) {
			setGameState(new LastFrameFirstRoll(game));
		}
	}

	@Override
	public void updateScore(int nBallsRolled) {
		getGameScorer().updateScoreAndRespectiveBonuses(getFrameNumber(), getRollNumber(), nBallsRolled);
		if( getGameArena().allBallsCleared() )  {
			getGameScorer().setSpare(getFrameNumber(), getRollNumber());
		}
	}

}