package Damas.damas.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BoardTest.class,
	CoordinateTest.class,
	StateTest.class,
	TurnTest.class
})
public class AllModelTests {

}
