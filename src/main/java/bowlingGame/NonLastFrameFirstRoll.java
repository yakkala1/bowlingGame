package bowlingGame;

public class NonLastFrameFirstRoll extends GameState {

	public NonLastFrameFirstRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		if( game.arena.allBallsCleared() ) {
			game.setFrameNumber(game.getFrameNumber()+1);
			game.setRollNumber(0);
			game.arena = new BowlingArena();
			game.setGameState(new NonLastFrameFirstRoll(game));
			if(game.getFrameNumber() == 9) {
				game.setGameState(new LastFrameFirstRoll(game));
			}
		} else {
			game.setRollNumber(1);
			game.setGameState(new NonLastFrameSecondRoll(game));
		}
	}

	@Override
	public void updateScore(int nBallsRolled) {
		game.scorer.insertScore(game.frameNumber, game.rollNumber, nBallsRolled);
		if( game.arena.allBallsCleared() )  {
			game.scorer.setStrike(game.frameNumber, game.rollNumber);
		}
	}

}
