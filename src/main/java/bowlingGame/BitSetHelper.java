package bowlingGame;

import java.util.BitSet;

public class BitSetHelper {

	public static BitSet getBitSet(String str) {
		try {
			BitSet ret = new BitSet(10);
			for(char c : str.toCharArray()) {
				int pin = Integer.parseInt(""+c);
				ret.set(pin);
			}
			return ret;
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}

}
