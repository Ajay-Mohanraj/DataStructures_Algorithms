package Unit8.Vehicle;

public class TestFordFrivolous1_CoreProperties extends BCATestScenario {

	@Override
	public int runTest() {

		assertThrows(IllegalArgumentException.class, () -> new FordFrivolous(-1), "Mileage cannot be negative at creation.");
		FordFrivolous f1 = new FordFrivolous(1);
		assertEquals(f1.getMileage(), 1, 0.1, "Mileage should be 0 at creation.");
		assertEquals(f1.getFuelCapacity(), 20, 0.1, "Fuel capacity should be 20.");
		assertEquals(f1.getFuelLevel(), f1.getFuelCapacity(), 0.1, "Fuel level should equal fuel capacity at creation.");
		assertEquals(f1.getMPG(), 23.6, 0.1, "MPG should equal 23.6");
		assertEquals(f1.getRemainingRange(), f1.getFuelLevel()*f1.getMPG(), 0.1, "Range should equal 472.");
		assertEquals(f1.toString(), "Ford Frivolous (1.0 mi)", "toStrings do not match.");
		return getFailedCount();
	}
}
