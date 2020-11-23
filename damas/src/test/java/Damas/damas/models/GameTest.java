package Damas.damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {

	private Game game;

	@Test
	public void moveAndGetEOErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ").build();
		
		Error error = this.game.move(from(5, 5), to(6, 6));
		assertEquals(Error.EMPTY_ORIGIN, error);
	}
	
	@Test
	public void moveAndGetOPErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				" n      ",
				"        ",
				"        ").build();
		
		Error error = this.game.move(from(5, 1),to(4,2));
		assertEquals(Error.OPPOSITE_PIECE, error);
	}
	
	@Test
	public void moveAndGetNETErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				" n      ",
				"  b     ",
				"        ").build();
		
		Error error = this.game.move(from(6, 2), to(5, 1));
		assertEquals(Error.NOT_EMPTY_TARGET, error);
	}
	
	@Test
	public void moveAndGetWOEErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				" n      ",
				"  b     ",
				"        ").build();
		
		Error error = this.game.move(from(6, 2), to(4, 4));
		assertEquals(Error.WITHOUT_EATING, error);
	}
	
	@Test
	public void moveAndGetTMAErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"    n   ",
				"   n    ",
				"  b     ",
				"        ").build();
		
		Error error = this.game.move(from(6, 2), from(3, 5));
		assertEquals(Error.TOO_MUCH_ADVANCED, error);
	}
	
	@Test
	public void moveAndGetTMEErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"    n   ",
				"   n    ",
				"  B     ",
				"        ").build();
		
		Error error = this.game.move(from(6, 2), to(3, 5));
		assertEquals(Error.TOO_MUCH_EATINGS, error);
	}
	
	@Test
	public void moveAndGetCEErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"   b    ",
				"  b     ",
				"        ").build();
		
		Error error = this.game.move(from(6, 2), to(4, 4));
		assertEquals(Error.COLLEAGUE_EATING, error);
	}
	
	@Test
	public void moveAndGetTMJErrorTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"  B     ",
				"        ").build();
		
		Error error = this.game.move(from(6, 2), to(5, 3), to(4, 4));
		assertEquals(Error.TOO_MUCH_JUMPS, error);
	}

	@Test
	public void correctMoveTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"  b     ",
				"        ").build();
		
		assertNull(this.game.move(from(6, 2), to(5, 3)));
	}
	
	@Test
	public void eatCorrectPieceTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"   n    ",
				"  b     ",
				"        ").build();
		
		assertNotNull(this.game.getPiece(from(5, 3)));
		this.game.move(from(6, 2), to(4, 4));
		assertNull(this.game.getPiece(from(5, 3)));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void moveOutLimitTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				" b      ").build();
		
		this.game.move(from(7, 1), to(8, 0));
	}
	
	@Test
	public void cancelTest() {
		this.game = new Game();
		Color turnBefore = this.game.getTurnColor();
		this.game.cancel();
		Color turnAfter = this.game.getTurnColor();
		
		assertNotEquals(turnBefore, turnAfter);
	}
	
	@Test
	public void notBlockedTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				" n      ",
				"b       ").build();
		assertFalse(this.game.isBlocked());
	}
	
	@Test
	public void yesBlockedTest() {
		this.game = new GameBuilder().createBoard(
				"        ",
				"        ",
				"        ",
				"        ",
				"        ",
				"  n     ",
				" n      ",
				"b       ").build();
		assertTrue(this.game.isBlocked());
	}

	private Coordinate from(int x, int y) {
		return new Coordinate(x, y);
	}

	private Coordinate to(int x, int y) {
		return new Coordinate(x, y);
	}
}
