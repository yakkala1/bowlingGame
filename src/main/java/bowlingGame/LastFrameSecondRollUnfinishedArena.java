package bowlingGame;

public class LastFrameSecondRollUnfinishedArena extends LastFrameSecondRoll {

	public LastFrameSecondRollUnfinishedArena(Game game) {
		super(game);
	}

	@Override
	public void updateScore(int nBallsRolled) {
		game.scorer.insertScore(game.frameNumber, game.rollNumber, nBallsRolled);
		if(game.arena.allBallsCleared()) {
			game.scorer.setSpare(game.frameNumber, game.rollNumber);
		}
	}

}
