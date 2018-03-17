package bowlingGame;

public class LastFrameSecondRollNewArena extends LastFrameSecondRoll {

	public LastFrameSecondRollNewArena(Game game) {
		super(game);
	}

	@Override
	public void updateScore(int nBallsRolled) {
		game.scorer.insertScore(game.frameNumber, game.rollNumber, nBallsRolled);
		if(game.arena.allBallsCleared()) {
			game.scorer.setStrike(game.frameNumber, game.rollNumber);
		}
	}

}
