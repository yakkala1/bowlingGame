package bowlingGame;

public class Scorecard {
	
	int[][] array;
	static int NULL_SCORE = -1;
	static int UPDATE_BONUS = -2;
	
	public Scorecard() {
		array = new int[3][21];
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
				if(score!=NULL_SCORE && score!=UPDATE_BONUS) {
					totalScore += score;
				}
			}
		}
		return totalScore;
	}

	public int[] getPreviousLocation(int[] location) {
		int frameNumber = location[0];
		int rollNumber = location[1];
		int column = getColumn(frameNumber, rollNumber);
		int returnColumn = column-1;
		while(returnColumn>=0 && array[0][returnColumn]==NULL_SCORE) {
			returnColumn--;
		}
		if(returnColumn >= 0) {
			int[] ret = new int[2];
			ret[0] = getFrame(returnColumn);
			ret[1] = getRoll(returnColumn);
			return ret;
		} else 
			return null;
	}

	private int getRoll(int returnColumn) {
		if(returnColumn == 21)
			return 2;
		return returnColumn%2;
	}

	private int getFrame(int returnColumn) {
		if(returnColumn == 21)
			return 10;
		return returnColumn/2;
	}

	public int getValue(int frame, int roll, int row) {
		int column = getColumn(frame, roll);
		return array[row][column];
	}
	
}