package Damas.damas.models;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class StateTest {

	private static State state;
	
	@BeforeClass
	public static void test() {
		state = new State();
	}

	@Test
	public void nextStateTest() {
		state.next();
		assertEquals(state.getValueState(), StateValue.IN_GAME);
		state.next();
		assertEquals(state.getValueState(), StateValue.FINAL);
		state.next();
		assertEquals(state.getValueState(), StateValue.EXIT);
	}
	
	@Test
	public void resetStateTest() {
		state.reset();
		assertEquals(state.getValueState(), StateValue.INITIAL);
	}
}
