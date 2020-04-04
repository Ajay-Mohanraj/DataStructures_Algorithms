package Unit8.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFordFrivolous2_Driving extends BCATestScenario {

	@Override
	public int runTest() {
		FordFrivolous f2 = new FordFrivolous(1);
		assertThrows(IllegalArgumentException.class, () -> f2.drive(-1), "Negative miles cannot be driven.");
		f2.drive(30);
		assertEquals(f2.getMileage(), 31, DELTA, "Mileage should be 31.");
		f2.drive(200);
		assertEquals(f2.getMileage(), 231, DELTA, "Mileage should be 231.");
		assertEquals(f2.getRemainingRange(), 242, DELTA, "Remaining range should be 242.");
		assertFalse(f2.canDrive(243), "Ford should not be able to 243 miles.");
		assertTrue(f2.canDrive(241), "Ford should be able to drive 241 miles.");
		f2.drive(242);
		assertEquals(f2.getMileage(), 473, DELTA, "Mileage should be 473.");
		assertThrows(IllegalArgumentException.class, () -> f2.addMileage(-1), "You cannot add negative miles to the odometer.");
		List<Double> checkpoints = new ArrayList<>(Arrays.asList(1.0));
		assertEquals(f2.roadTrip(checkpoints), 0, "Ford should not be able to drive any days at all.");
		f2.refillTank();
		assertEquals(f2.getFuelLevel(), f2.getFuelCapacity(), DELTA, "Fuel level should be 20 after refilling.");
		checkpoints = Arrays.asList(236.0, 236.0);
		assertEquals(f2.roadTrip(checkpoints), 2, "Ford should be able to drive 2 days.");
		checkpoints = Arrays.asList(-1.0);
		List<Double> finalCheckpoints = checkpoints;
		assertThrows(IllegalArgumentException.class, () -> f2.roadTrip(finalCheckpoints), "No day can be negative miles on a roadtrip.");
		assertThrows(IllegalArgumentException.class, () -> f2.drive(473), "Max range is 472 miles.");

		return getFailedCount();
	}


}
