package Damas.damas.models;

import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class TurnTest {

	private static Turn turn;
	
	@BeforeClass
	public static void test() {
		turn = new Turn();
	}
	
	@Test
	public void changeTurnTest() {
		Color actualTurn = turn.getColor();
		turn.change();
		assertNotEquals(actualTurn, turn.getColor());
	}
	
	@Test
	public void getOppositeColorTest() {
		Color actualTurn = turn.getColor();
		
		assertNotEquals(actualTurn, turn.getOppositeColor());
	}
}
