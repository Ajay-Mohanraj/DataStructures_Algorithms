package Unit8.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTeslaModelZ2_Driving extends BCATestScenario {

	@Override
	public int runTest() {
		TeslaModelZ car2 = new TeslaModelZ(1);
		assertThrows(IllegalArgumentException.class, () -> car2.drive(-1), "Negative miles cannot be driven.");
		car2.drive(30);
		assertEquals(car2.getMileage(), 30, DELTA, "Mileage should be 30.");
		car2.drive(200);
		assertEquals(car2.getMileage(), 230, DELTA, "Mileage should be 230.");
		assertEquals(car2.getRemainingRange(), 110, DELTA, "Remaining range should be 110.");
		assertFalse(car2.canDrive(111), "Tesla should not be able to 111 miles.");
		assertTrue(car2.canDrive(105), "Tesla should be able to drive 110 miles.");
		car2.drive(105);
		assertEquals(car2.getMileage(), 335, DELTA, "Mileage should be 335.");
		assertThrows(IllegalArgumentException.class, () -> car2.addMileage(-1), "You cannot add negative miles to the odometer.");
		List<Double> checkpoints = new ArrayList<>(Arrays.asList(6.0));
		assertEquals(car2.roadTrip(checkpoints), 0, "Tesla should not be able to drive any days at all.");
		car2.recharge();
		assertEquals(car2.getRemainingRange() / car2.getMaxRange() * 100, car2.getMaxRange() / car2.getMaxRange() * 100, DELTA, "Charge should be 100 after recharging.");
		checkpoints = Arrays.asList(170.0, 170.0);
		assertEquals(car2.roadTrip(checkpoints), 2, "Tesla should be able to drive 2 days.");
		checkpoints = Arrays.asList(-1.0);
		List<Double> finalCheckpoints = checkpoints;
		assertThrows(IllegalArgumentException.class, () -> car2.roadTrip(finalCheckpoints), "No day can have negative miles on a road trip.");
		assertThrows(IllegalArgumentException.class, () -> car2.drive(341), "Max range is 340 miles.");

		return getFailedCount();
	}


}
