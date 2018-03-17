package bowlingGame;

public class LastFrameFirstRoll extends GameState {

	public LastFrameFirstRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		if(game.arena.allBallsCleared()) {
			game.enableExtraBall();
			game.setRollNumber(1);
			game.arena = new BowlingArena();
			game.setGameState(new LastFrameSecondRollNewArena(game));
		} else {
			game.setRollNumber(1);
			game.setGameState(new LastFrameSecondRollUnfinishedArena(game));
		}
	}

	@Override
	public void updateScore(int nBallsRolled) {
		game.scorer.insertScore(game.frameNumber, game.rollNumber, nBallsRolled);
		if(game.arena.allBallsCleared()) {
			game.scorer.setStrike(game.frameNumber, game.rollNumber);
		}
	}

}
