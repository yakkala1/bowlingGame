package gameStates;

import bowlingGame.Game;

public class LastFrameSecondRollNewArena extends LastFrameSecondRoll {

	public LastFrameSecondRollNewArena(Game game) {
		super(game);
	}

	@Override
	public void updateScore(int nBallsRolled) {
		getGameScorer().updateScoreAndRespectiveBonuses(getFrameNumber(), getRollNumber(), nBallsRolled);
		if(getGameArena().allBallsCleared()) {
			getGameScorer().setStrike(getFrameNumber(), getRollNumber());
		}
	}

}
