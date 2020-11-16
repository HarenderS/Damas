package Damas.damas.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class CoordinateTest {
    
	private static Coordinate coordinate;
	
	@BeforeClass
	public static void test() {
		coordinate = new Coordinate(4, 5);
	}
	
	@Test
	public void getDirectionNE() {
		assertEquals(Direction.valueOf("NE"), coordinate.getDirection(new Coordinate(5, 6)));
	}
	
	@Test
	public void getDirectionNW() {
		assertEquals(Direction.valueOf("NW"), coordinate.getDirection(new Coordinate(5, 4)));
	}
	
	@Test
	public void getDirectionSW() {
		assertEquals(Direction.valueOf("SW"), coordinate.getDirection(new Coordinate(3, 4)));
	}
	
	@Test
	public void getDirectionSE() {
		assertEquals(Direction.valueOf("SE"), coordinate.getDirection(new Coordinate(3, 6)));
	}
	
	@Test
	public void getDirectionNotDialonal() {
		assertNull(coordinate.getDirection(new Coordinate(4, 6)));
	}
	
	@Test
    public void isOnDiagonalTest() {
        assertTrue(coordinate.isOnDiagonal(to(3, 4)));
    }
	
	@Test(expected = AssertionError.class)
    public void isOnDiagonalOutOfLimitUpTest() {
        coordinate.isOnDiagonal(to(-2, -1));	//must get error because it's out of limit but not
    }
	
	@Test(expected = AssertionError.class)
    public void isOnDiagonalOutOfLimitDownTest() {
        coordinate.isOnDiagonal(to(8, 9));	//must get error because it's out of limit but not
    }

	@Test
    public void onNotDiagonalTest() {
        assertFalse(coordinate.isOnDiagonal(to(4, 4)));
    }
	
	@Test
    public void getDiagonalDistanceTest() {
		assertEquals(2, coordinate.getDiagonalDistance(to(2, 3)));
    }
	
	@Test(expected = AssertionError.class)
    public void getNotDiagonalDistanceTest() {
		coordinate.getDiagonalDistance(to(4, 2));
    }

	//Method not used
	@Test
    public void getBetweenDiagonalCoordinateTest() {
		assertEquals(new Coordinate(3, 4), coordinate.getBetweenDiagonalCoordinate(to(2, 3)));
    }
	
	@Test
	public void getCorrdinatesBetweenDiagonalCoordinatesTest() {
		List<Coordinate> coordinates1 = coordinate.getBetweenDiagonalCoordinates(to(1, 2));
		
		List<Coordinate> coordinates2 = new ArrayList<Coordinate>();
		coordinates2.add(new Coordinate(2, 3));
		coordinates2.add(new Coordinate(3, 4));
		
		assertTrue(coordinates1.containsAll(coordinates2));
	}
    
	@Test(expected = AssertionError.class)
	public void getCorrdinatesBetweenNonDiagonalCoordinatesTest() {
		coordinate.getBetweenDiagonalCoordinates(to(1, 5));
	}
	
	@Test
	public void getCorrdinatesBetweenDiagonalCoordinatesOutOfLimitTest() {
		List<Coordinate> coordinates1 = coordinate.getBetweenDiagonalCoordinates(to(8, 9));
		
		List<Coordinate> coordinates2 = new ArrayList<Coordinate>();
		coordinates2.add(new Coordinate(5, 6));
		coordinates2.add(new Coordinate(6, 7));
		coordinates2.add(new Coordinate(7, 8));
		
		assertFalse(coordinates1.containsAll(coordinates2));// the limit is not controled
	}
	
	@Test
    public void getDiagonalCoordinatesTest() {
		List<Coordinate> coordinates1 = coordinate.getDiagonalCoordinates(3);
		Coordinate coordinate2 = new Coordinate(4, 5);
		List<Coordinate> coordinates2 = coordinate2.getDiagonalCoordinates(3);
		
        assertEquals(coordinates1, coordinates2);
    }
	
	@Test
    public void getDiagonalCoordinatesoutOfLimitUpTest() {
		assertTrue(coordinate.getDiagonalCoordinates(5).isEmpty());
    }
	
	//isLast	
	@Test
	public void checkLastOutBoardLimitToUpTest() {
		Coordinate coordinate = new Coordinate(-1, -1);
		assertFalse(coordinate.isLast());
    }
	
	@Test
	public void checkLastUnderBoardLimitTest() {
		Coordinate coordinate = new Coordinate(2, 3);
		assertFalse(coordinate.isLast());
    }
	
	@Test
	public void checkLastOutBoardLimitToDownTest() {
		Coordinate coordinate = new Coordinate(8, 8);
		assertFalse(coordinate.isLast());
    }

	@Test
	public void checkLastCorrectTest() {
		Coordinate coordinate = new Coordinate(7, 7);
		assertTrue(coordinate.isLast());
    }
	
	//isFirst
	@Test
	public void checkFirstOutBoardLimitToUpTest() {
		Coordinate coordinate = new Coordinate(-1, -1);
		assertFalse(coordinate.isFirst());
    }
	
	@Test
	public void checkFirstUnderBoardLimitTest() {
		Coordinate coordinate = new Coordinate(2, 3);
		assertFalse(coordinate.isFirst());
    }
	
	@Test
	public void checkFirstOutBoardLimitToDownTest() {
		Coordinate coordinate = new Coordinate(8, 8);
		assertFalse(coordinate.isFirst());
    }

	@Test
    public void checkFirstCorrectTest() {
		Coordinate coordinate = new Coordinate(0, 0);
		assertTrue(coordinate.isFirst());
    }
	
	/*
	 * 
	 * 
	 * assertThat prubea si es junit 5
	 */
	
	private Coordinate to(int x, int y) {
		return new Coordinate(x, y);
	}
}
