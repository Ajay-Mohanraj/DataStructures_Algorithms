package Unit8.Vehicle;

public class TestTeslaModelZ3_SelfDriving extends BCATestScenario {

	@Override
	public int runTest() {
		TeslaModelZ car3 = new TeslaModelZ(1);
		assertThrows(IllegalArgumentException.class, () -> car3.driveAutonomously(-1), "Cannot drive a negative distance.");
		car3.driveAutonomously(170);
		assertEquals(car3.getRemainingRange() / car3.getMaxRange() * 100, 50, 0.1, "Charge should be 50.");
		car3.driveAutonomously(340);
		assertEquals(car3.getRemainingRange() / car3.getMaxRange() * 100, 0, 0.1, "Fuel level should be 0.");
		assertEquals(car3.getMileage(), 340, 0.1, "Mileage should be 340.");
		return getFailedCount();
	}
}
