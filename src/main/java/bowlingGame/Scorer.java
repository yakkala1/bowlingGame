package bowlingGame;

public class Scorer {
	
	Scorecard scorecard = new Scorecard();

	public int getScore() {
		return scorecard.computeScore();
	}

	public void insertScore(int frameNumber, int rollNumber,int nBallsRolled) {
		scorecard.setScore(frameNumber, rollNumber, nBallsRolled);
		
		int[] previousLocation = scorecard.getPreviousLocation(new int[]{frameNumber, rollNumber});
		if(previousLocation == null)
			return;
		int previousFrame = previousLocation[0];
		int previousRoll = previousLocation[1];
		if( scorecard.getValue(previousFrame,previousRoll,1)==Scorecard.UPDATE_BONUS )
			scorecard.setFirstBonus(previousFrame, previousRoll, nBallsRolled);
		
		int[] doublePreviousLocation = scorecard.getPreviousLocation(previousLocation);
		if(doublePreviousLocation == null)
			return;
		int doublePreviousFrame = doublePreviousLocation[0];
		int doublePreviousRoll = doublePreviousLocation[1];
		if( scorecard.getValue(doublePreviousFrame, doublePreviousRoll, 2) == Scorecard.UPDATE_BONUS )
			scorecard.setSecondBonus(doublePreviousFrame, doublePreviousRoll, nBallsRolled);
	}

	public void setSpare(int frameNumber, int rollNumber) {
		scorecard.setFirstBonus(frameNumber, rollNumber, Scorecard.UPDATE_BONUS);
	}

	public void setStrike(int frameNumber, int rollNumber) {
		scorecard.setFirstBonus(frameNumber, rollNumber, Scorecard.UPDATE_BONUS);
		scorecard.setSecondBonus(frameNumber, rollNumber, Scorecard.UPDATE_BONUS);
	}

	public int[] getPreviousLocation(int[] location) {
		return scorecard.getPreviousLocation(location);
	}
	
}
