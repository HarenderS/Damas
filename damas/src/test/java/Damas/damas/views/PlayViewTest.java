package Damas.damas.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import Damas.damas.controllers.PlayController;
import Damas.damas.models.Coordinate;
import Damas.damas.models.Game;
import Damas.damas.models.GameBuilder;
import Damas.damas.models.State;
import Damas.damas.models.StateValue;
import Damas.damas.utils.Console;

public class PlayViewTest {

	private PlayView playView;
	private PlayController controller;
	private State state; 
	private Game game;
	
	@Before
	public void test() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.playView = new PlayView();
		this.playView.console = mock(Console.class);
		this.state = new State();
		
//		this.controller = new PlayController(new Game(), this.state);
//		this.controller.setPlayView(playView);
		
//		FieldSetter.setField(controller, controller.getClass().getDeclaredField("myService"), playView);
//		PowerMockito.whenNew(Person.class).withNoArguments().thenReturn(person);

//		Whitebox.setInternalState(controller.getClass(), "playView", playView);
//		Field f = this.controller.getClass().getDeclaredField("playView");
//		f.setAccessible(true);
//		f.set(controller, playView);
	}
	/*
	@Test
	public void putIncorrectCoordinateValueTest() {
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("6253");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ").build();
		this.controller = new PlayController(this.game, this.state);
		this.controller.control();
	}*/
	
	@Test
	public void putCorrectCoordinateValueTest(){
		System.out.println("putCorrectCoordinateValueTest");
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("62.53");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				" b      ",
				"        ",
				"        ").build();
		
		assertNull(this.game.getPiece(from(4, 2)));

		this.controller = new PlayController(this.game, this.state);
		this.controller.setPlayView(this.playView);
		
		this.controller.writeGame(controller);
		this.controller.control();
		
		assertNotNull(this.game.getPiece(from(4, 2)));
	}
	
	@Test
	public void putCorrectAndEatPieceTest() {
		System.out.println("putCorrectAndEatPieceTest");
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("62.44");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"  n     ",
				" b      ",
				"        ",
				"        ").build();
		assertEquals("n", this.game.getPiece(from(4, 2)).getCode());
		
		this.controller = new PlayController(this.game, this.state);
		this.controller.setPlayView(this.playView);
		
		this.controller.writeGame(controller);
		this.controller.control();

		assertNull(this.game.getPiece(from(4, 4)));
	}
	
	@Test
	public void putCorrectAndPromoveTest() {
		System.out.println("putCorrectAndPromoveTest");
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("22.13");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				" b      ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ").build();
		assertNull(this.game.getPiece(from(0, 2)));
		
		this.controller = new PlayController(this.game, this.state);
		this.controller.setPlayView(this.playView);
		
		this.controller.writeGame(controller);
		this.controller.control();
		
		assertEquals("B", this.game.getPiece(from(0, 2)).getCode());
	}
	
	@Test
	public void putCorrectAndMultipleMoveTest() {
		System.out.println("putCorrectAndMultipleMoveTest");
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("22.55");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				" B      ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ").build();
		assertNull(this.game.getPiece(from(4, 4)));
		
		this.controller = new PlayController(this.game, this.state);
		this.controller.setPlayView(this.playView);
		
		this.controller.writeGame(controller);
		this.controller.control();
		
		assertNotNull(this.game.getPiece(from(4, 4)));
	}
	
	@Test
	public void putCorrectAndMultipleMoveEatTest() {
		System.out.println("putCorrectAndMultipleMoveEatTest");
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("22.55");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				" B      ",
				"  n     ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ").build();
		assertNull(this.game.getPiece(from(4, 4)));
		assertEquals("n", this.game.getPiece(from(2, 2)).getCode());
		
		this.controller = new PlayController(this.game, this.state);
		this.controller.setPlayView(this.playView);
		
		this.controller.writeGame(controller);
		this.controller.control();
		
		assertNotNull(this.game.getPiece(from(4, 4)));
		assertNull(this.game.getPiece(from(2, 2)));
	}
	
	@Test
	public void putCorrectAndWinTest() {
		System.out.println("putCorrectAndWinTest");
		this.state.reset();
		this.state.next();
		
		when(this.playView.console.readString(anyString())).thenReturn("34.12");
		
		this.game = new GameBuilder().createBoard(
				"        ",
				"  n     ",
				"   b    ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ").build();
		assertEquals(StateValue.IN_GAME, this.state.getValueState());
		
		this.controller = new PlayController(this.game, this.state);
		this.controller.setPlayView(this.playView);
		
		this.controller.writeGame(controller);
		this.controller.control();
		
		assertEquals(StateValue.FINAL, this.state.getValueState());
	}
	
	private Coordinate from(int x, int y) {
		return new Coordinate(x, y);
	}
	
}
