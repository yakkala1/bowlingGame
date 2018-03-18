package gameStates;

import bowlingGame.Game;

public class LastFrameSecondRollUnfinishedArena extends LastFrameSecondRoll {

	public LastFrameSecondRollUnfinishedArena(Game game) {
		super(game);
	}

	@Override
	public void updateScore(int nBallsRolled) {
		getGameScorer().updateScoreAndRespectiveBonuses(getFrameNumber(), getRollNumber(), nBallsRolled);
		if(getGameArena().allBallsCleared()) {
			getGameScorer().setSpare(getFrameNumber(), getRollNumber());
		}
	}

}
