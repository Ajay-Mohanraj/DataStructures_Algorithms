package Unit8.Vehicle;

public class TestFordFrivolous4_Flying extends BCATestScenario {

	@Override
	public int runTest() {
		FordFrivolous f3 = new FordFrivolous();
		assertThrows(IllegalArgumentException.class, () -> f3.canFly(-1), "Car cannot go negative miles.");
		assertTrue(f3.canFly(156), "Car should be able to fly 156 miles.");
		assertFalse(f3.canFly(158), "Car should not be able to fly 158 miles.");
		f3.fly(157.333);
		assertEquals(f3.getMileage(), 0, 0.1, "Flying should not increase mileage.");
		assertEquals(f3.getRemainingRange(), 0, 0.1, "There should be no miles left to fly or drive.");
		assertEquals(f3.getFuelLevel(), 0, 0.1, "The tank should be empty.");

		return getFailedCount();
	}
}
