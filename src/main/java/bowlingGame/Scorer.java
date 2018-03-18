package bowlingGame;

public class Scorer {
	
	Scorecard scorecard = new Scorecard();

	public int getScore() {
		return scorecard.computeScore();
	}

	public void updateScoreAndRespectiveBonuses(int frameNumber, int rollNumber,int nBallsRolled) {
		scorecard.setScore(frameNumber, rollNumber, nBallsRolled);
	
		int[] previousFrameAndRoll = scorecard.getPreviousFrameAndRoll(new int[]{frameNumber, rollNumber});
		if(previousFrameAndRoll == null)
			return;
		int previousFrame = previousFrameAndRoll[0];
		int previousRoll = previousFrameAndRoll[1];
		if( scorecard.getFirstBonus(previousFrame,previousRoll) == Scorecard.TO_BE_UPDATED )
			scorecard.setFirstBonus(previousFrame, previousRoll, nBallsRolled);
		
		int[] doublePreviousFrameAndRoll = scorecard.getPreviousFrameAndRoll(previousFrameAndRoll);
		if(doublePreviousFrameAndRoll == null)
			return;
		int doublePreviousFrame = doublePreviousFrameAndRoll[0];
		int doublePreviousRoll = doublePreviousFrameAndRoll[1];
		if( scorecard.getSecondBonus(doublePreviousFrame, doublePreviousRoll) == Scorecard.TO_BE_UPDATED )
			scorecard.setSecondBonus(doublePreviousFrame, doublePreviousRoll, nBallsRolled);
	}

	public void setSpare(int frameNumber, int rollNumber) {
		scorecard.setFirstBonus(frameNumber, rollNumber, Scorecard.TO_BE_UPDATED);
	}

	public void setStrike(int frameNumber, int rollNumber) {
		scorecard.setFirstBonus(frameNumber, rollNumber, Scorecard.TO_BE_UPDATED);
		scorecard.setSecondBonus(frameNumber, rollNumber, Scorecard.TO_BE_UPDATED);
	}

}
