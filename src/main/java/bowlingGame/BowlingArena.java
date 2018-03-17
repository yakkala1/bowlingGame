package bowlingGame;

import java.util.BitSet;

public class BowlingArena {
	
	BitSet standingPins;
	
	public BowlingArena() {
		int nPins = 10;
		standingPins = new BitSet(nPins);
		standingPins.set(0, nPins, true);
	}

	public void roll() {
	}
	
	public BitSet getStandingPins() {
		return standingPins;
	}
	
	public String getStandingPinsAsString() {
		String ret = "";
		int standingPin = standingPins.nextSetBit(0);
		while(standingPin != -1) {
			ret += standingPin;
			standingPin = standingPins.nextSetBit(standingPin);
		}
		return ret;
	}

	public void roll(String string) {
		BitSet rolledPins = PinsArrangementFactory.getBitSet(string);
		roll(rolledPins);
	}
	
	private void roll(BitSet rolledPins) throws IllegalArgumentException {
		int rolledPin = rolledPins.nextSetBit(0);
		while(rolledPin != -1) {
			if(standingPins.get(rolledPin) == true) {
				standingPins.set(rolledPin, false);
			} else {
				throw new IllegalArgumentException();
			}
			rolledPin = rolledPins.nextSetBit(rolledPin+1);
		}
	}

	public boolean allBallsCleared() {
		return standingPins.isEmpty();
	}

}