package gameStates;

import bowlingGame.BowlingArena;
import bowlingGame.Game;
import bowlingGame.GameState;

public class LastFrameFirstRoll extends GameState {

	public LastFrameFirstRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		if(getGameArena().allBallsCleared()) {
			enableExtraBall();
			setRollNumber(1);
			setGameArena( new BowlingArena() );
			setGameState(new LastFrameSecondRollNewArena(game));
		} else {
			setRollNumber(1);
			setGameState(new LastFrameSecondRollUnfinishedArena(game));
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
