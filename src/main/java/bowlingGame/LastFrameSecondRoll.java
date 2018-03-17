package bowlingGame;

public abstract class LastFrameSecondRoll extends GameState {

	public LastFrameSecondRoll(Game game) {
		super(game);
	}

	@Override
	public void changeGameState() {
		if(game.arena.allBallsCleared()) {
			game.enableExtraBall();
			game.arena = new BowlingArena();
		}
		
		if(game.extraBallEnabled) {
			game.setRollNumber(2);
			game.setGameState(new LastFrameThirdRoll(game));
		} else {
			game.setGameState(new GameEnded(game));
		}
	}

}