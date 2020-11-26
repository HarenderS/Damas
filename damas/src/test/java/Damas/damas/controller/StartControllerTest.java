package Damas.damas.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Damas.damas.controllers.StartController;
import Damas.damas.models.Game;
import Damas.damas.models.State;
import Damas.damas.models.StateValue;

public class StartControllerTest {

	public State state;
	
	@Before
	public void test() {
		this.state = new State();
	}
	
	@Test
	public void checkIfStateChangeTest() {
		this.state.reset();
		new StartController(new Game(), this.state).control();
		
		assertEquals(StateValue.IN_GAME, this.state.getValueState());
	}
}
