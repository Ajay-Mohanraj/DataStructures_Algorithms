package Unit8.Vehicle;

public class TestFordFrivolous1_CoreProperties extends BCATestScenario {

	@Override
	public int runTest() {

		assertThrows(IllegalArgumentException.class, () -> new FordFrivolous(-1), "Mileage cannot be negative at creation.");
		FordFrivolous f1 = new FordFrivolous(1);
		assertEquals(f1.getMileage(), 1, DELTA, "Mileage should be 0 at creation.");
		assertEquals(f1.getFuelCapacity(), 20, DELTA, "Fuel capacity should be 20.");
		assertEquals(f1.getFuelLevel(), f1.getFuelCapacity(), DELTA, "Fuel level should equal fuel capacity at creation.");
		assertEquals(f1.getMPG(), 23.6, DELTA, "MPG should equal 23.6");
		assertEquals(f1.getRemainingRange(), f1.getFuelLevel()*f1.getMPG(), DELTA, "Range should equal 472.");
		assertEquals(f1.toString(), "Ford Frivolous (1.0 mi)", "toStrings do not match.");
		return getFailedCount();
	}
}
