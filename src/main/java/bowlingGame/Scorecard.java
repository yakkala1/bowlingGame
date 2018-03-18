package bowlingGame;

public class Scorecard {
	
	int[][] array = new int[3][21];
	//21 columns one for each roll
	//row 0 for storing score for that roll without bonus
	//row 1 for storing first bonus
	//row 2 for storing second bonus
	
	static int NULL_SCORE = -1;
	static int TO_BE_UPDATED = -2;
	
	public Scorecard() {
		initializeToNullScore();
	}

	private void initializeToNullScore() {
		int nRows = array.length;
		int nColumns = array[0].length;
		for(int i=0; i<nRows; i++) {
			for(int j=0; j<nColumns; j++) {
				array[i][j] = NULL_SCORE;
			}
		}
	}
	
	public void setScore(int frame, int roll, int score) {
		setScore(frame, roll, 0, score);
	}

	public void setFirstBonus(int frame, int roll, int score) {
		setScore(frame, roll, 1, score);
	}
	
	public void setSecondBonus(int frame, int roll, int score) {
		setScore(frame, roll, 2, score);
	}

	private void setScore(int frame, int roll, int row, int score) {
		int column = getColumn(frame, roll);
		array[row][column] = score;
	}

	private int getColumn(int frame, int roll) {
		return frame*2 + roll;
	}

	public int computeScore() {
		int totalScore = 0;
		for(int[] row : array) {
			for(int score : row) {
				if(score!=NULL_SCORE && score!=TO_BE_UPDATED) {
					totalScore += score;
				}
			}
		}
		return totalScore;
	}

	public int[] getPreviousFrameAndRoll(int[] frameAndRoll) {
		int frameNumber = frameAndRoll[0];
		int rollNumber = frameAndRoll[1];
		int column = getColumn(frameNumber, rollNumber);
		int returnColumn = column-1;
		while(returnColumn>=0 && array[0][returnColumn]==NULL_SCORE) {
			returnColumn--;
		}
		if(returnColumn >= 0) {
			int[] ret = new int[2];
			ret[0] = getFrameFromColumn(returnColumn);
			ret[1] = getRollFromColumn(returnColumn);
			return ret;
		} else 
			return null;
	}
	
	public int getFirstBonus(int frame, int roll) {
		return getValue(frame, roll, 1);
	}
	
	public int getSecondBonus(int frame, int roll) {
		return getValue(frame, roll, 2);
	}
	
	private int getRollFromColumn(int returnColumn) {
		if(returnColumn == 21)
			return 2;
		return returnColumn%2;
	}

	private int getFrameFromColumn(int returnColumn) {
		if(returnColumn == 21)
			return 10;
		return returnColumn/2;
	}

	private int getValue(int frame, int roll, int row) {
		int column = getColumn(frame, roll);
		return array[row][column];
	}


}