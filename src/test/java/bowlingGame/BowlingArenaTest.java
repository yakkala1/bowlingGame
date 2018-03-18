package bowlingGame;

import static org.junit.Assert.*;

import java.util.BitSet;

import org.junit.Test;

public class BowlingArenaTest {

	@Test
	public void testInitialization() {
		BowlingArena arena = new BowlingArena();
		BitSet allSet = getAllSetBits();
		assertEquals(allSet, arena.getStandingPins());
	}
	
	@Test
	public void testRolling() {
		BowlingArena arena = new BowlingArena();
		arena.removePins("1234");
		assertEquals("056789", arena.getStandingPinsAsString());
	}

	private BitSet getAllSetBits() {
		BitSet allSet = new BitSet();
		allSet.set(0, 10, true);
		return allSet;
	}

}
