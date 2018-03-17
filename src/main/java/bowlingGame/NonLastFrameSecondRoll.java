package bowlingGame;

public class NonLastFrameSecondRoll extends GameState {

	public NonLastFrameSecondRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		game.setFrameNumber(game.getFrameNumber()+1);
		game.setRollNumber(0);
		game.arena = new BowlingArena();
		game.setGameState(new NonLastFrameFirstRoll(game));
		if(game.getFrameNumber() == 9) {
			game.setGameState(new LastFrameFirstRoll(game));
		}
	}

	@Override
	public void updateScore(int nBallsRolled) {
		game.scorer.insertScore(game.frameNumber, game.rollNumber, nBallsRolled);
		if( game.arena.allBallsCleared() )  {
			game.scorer.setSpare(game.frameNumber, game.rollNumber);
		}	
	}

}