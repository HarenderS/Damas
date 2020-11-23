package Damas.damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class BoardTest {

	private static Board board;
	
	@BeforeClass
	public static void test() {
		board = new Board();
	}
	
	@Test
	public void getPieceTest() {
		board.put(to(6, 1), new Pawn(Color.BLACK));
		assertEquals(new Pawn(Color.BLACK), board.getPiece(from(6, 1)));
	}

	@Test
	public void getNullPieceTest() {
		assertNull(board.getPiece(from(4, 1)));
	}

	@Test
	public void correctPutTest() {
		Piece piece1 = board.getPiece(from(5, 2));
		board.put(to(5, 2), new Pawn(Color.BLACK));
		Piece piece2 = board.getPiece(from(5, 2));

		assertNotEquals(piece1, piece2);
	}

	@Test(expected = Exception.class)
	public void putOutOfLimitsUpTest() {
		board.put(to(-1, 1), new Pawn(Color.BLACK));
	}
	
	@Test(expected = Exception.class)
	public void putOutOfLimitsLeftTest() {
		board.put(to(1, -1), new Pawn(Color.BLACK));
	}

	@Test(expected = Exception.class)
	public void putOutOfLimitsRigthTest() {
		board.put(to(1, 8), new Pawn(Color.BLACK));
	}

	@Test(expected = Exception.class)
	public void putOutOfLimitsDownTest() {
		board.put(to(8, 1), new Pawn(Color.BLACK));
	}

	@Test
	public void removeTest() {
		board.put(to(4, 2), new Pawn(Color.BLACK));
		assertNotNull(board.getPiece(from(4, 2)));
		board.remove(from(4, 2));
		assertNull(board.getPiece(from(4, 2)));
	}

	@Test(expected = AssertionError.class)
	public void removeUnexistingObjectTest() {
		board.remove(from(4, 6));
	}
	
	@Test
	public void getBetweenDiagonalPiecesTest() {
		List<Piece> piece1 = board.getBetweenDiagonalPieces(from(6,1), to(4,3)); 
		
		Board board2 = new Board();
		board2.put(to(5, 2), new Pawn(Color.BLACK));
		List<Piece> piece2 = board2.getBetweenDiagonalPieces(from(6,1), to(4,3)); 
		
		assertEquals(piece1, piece2);
	}
	
	@Test
	public void getBetweenNonDiagonalPiecesTest() {
		List<Piece> piece = board.getBetweenDiagonalPieces(from(6,1), to(6,3)); 
		assertTrue(piece.isEmpty());
	}

	@Test
	public void getAmountBetweenDiagonalNotNullPiecesTest() {
		board.put(to(5, 2), new Pawn(Color.BLACK));
		board.put(to(4, 3), new Pawn(Color.BLACK));
		assertNotEquals(board.getAmountBetweenDiagonalPieces(from(6, 1), to(3,4)), 0);
	}
	
	@Test
	public void getAmountBetweenDiagonalNullPiecesTest() {
		assertNull(board.getPiece(from(5, 3)));
		assertNull(board.getPiece(from(4, 4)));
		assertEquals(board.getAmountBetweenDiagonalPieces(from(6, 2), to(3,5)), 0);
	}
	
	@Test
	public void getAmountBetweenNonDiagonalPiecesTest() {
		board.put(to(6, 2), new Pawn(Color.BLACK));
		board.put(to(6, 3), new Pawn(Color.BLACK));
		assertEquals(board.getAmountBetweenDiagonalPieces(from(6, 1), to(6,4)), 0);
	}
	
	@Test
	public void moveExistingPieceTest() {
		board.put(to(1, 4), new Pawn(Color.WHITE));
		assertNull(board.getPiece(from(1, 5)));
		board.move(from(1, 4), to(1, 5));
		assertNotNull(board.getPiece(from(1, 5)));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void moveExistingPieceOutOfLimitUpTest() {
		board.put(to(0, 4), new Pawn(Color.WHITE));
		board.move(from(0, 4), to(-1, 5));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void moveExistingPieceOutOfLimitDownTest() {
		board.put(to(7, 4), new Pawn(Color.WHITE));
		board.move(from(7, 4), to(8, 5));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void moveExistingPieceOutOfLimitLeftTest() {
		board.put(to(1, 0), new Pawn(Color.WHITE));
		board.move(from(1, 0), to(1, -1));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void moveExistingPieceOutOfLimitULTest() {
		board.put(to(1, 7), new Pawn(Color.WHITE));
		board.move(from(1, 7), to(1, 8));
	}
	
	@Test
	public void getCorrectColor() {
		board.put(to(3, 6), new Pawn(Color.BLACK));
		assertEquals(Color.BLACK, board.getColor(from(3, 6)));
    }
	
	@Test
	public void getIncorrectColor() {
		board.put(to(3, 6), new Pawn(Color.BLACK));
		assertNotEquals(Color.WHITE, board.getColor(from(3, 6)));
    }

	@Test
	public void isNotEmpty() {
       assertNotNull(board.getPiece(from(5, 2)));
    }
	
	@Test
	public void isEmpty() {
       assertNull(board.getPiece(from(5, 5)));
    }
	
	private Coordinate from(int x, int y) {
		return new Coordinate(x, y);
	}

	private Coordinate to(int x, int y) {
		return new Coordinate(x, y);
	}
}
