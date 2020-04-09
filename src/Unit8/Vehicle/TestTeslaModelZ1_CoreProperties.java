package Unit8.Vehicle;

public class TestTeslaModelZ1_CoreProperties extends BCATestScenario {

	@Override
	public int runTest() {

		assertThrows(IllegalArgumentException.class, () -> new TeslaModelZ(-1, 1), "Mileage cannot be negative at creation.");
		TeslaModelZ car1 = new TeslaModelZ(0, 1);
		assertEquals(car1.getMileage(), 0, 0.1, "Mileage should be 0.");
		assertEquals(car1.getRemainingRange() / car1.getMaxRange() * 100, 100, 0.1, "Charge should be 100.");
		assertEquals(car1.getModelNum(), 1, 0.1, "Model number should be 1.");
		assertEquals(car1.getRemainingRange(), 340, 0.1, "Remaining range should equal 340.");
		assertEquals(car1.getMaxRange(), car1.getRemainingRange(), 0.1, "Maximum range should equal remaining range.");
		assertEquals(car1.toString(), "Tesla Model Z (0.0 mi)", "toStrings do not match.");
		return getFailedCount();
	}
}
