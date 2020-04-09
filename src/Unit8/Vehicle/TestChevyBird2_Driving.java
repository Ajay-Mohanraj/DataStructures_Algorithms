package Unit8.Vehicle;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestChevyBird2_Driving extends BCATestScenario {

    @Override
    public int runTest() {
        ChevroletBird c2 = new ChevroletBird(0);
        assertThrows(IllegalArgumentException.class, () -> c2.drive(-1), "Negative miles cannot be driven.");
        c2.drive(30);
        assertEquals(c2.getMileage(), 30, 0.1, "Mileage should be 30.");
        c2.drive(100);
        assertEquals(c2.getMileage(), 130, 0.1, "Mileage should be 130.");
        assertEquals(c2.getRemainingRange(), 120, 0.1, "Remaining range should be 120.");
        assertFalse(c2.canDrive(125), "Chevrolet should not be able to 255 miles.");
        assertTrue(c2.canDrive(120), "Chevrolet should be able to drive 250 miles.");
        c2.drive(120);
        assertEquals(c2.getMileage(), 250, 0.1, "Mileage should be 473.");
        assertThrows(IllegalArgumentException.class, () -> c2.addMileage(-1), "You cannot add negative miles to the odometer.");
        c2.addMileage(5);
        assertEquals(c2.getMileage(), 255, 0.1, "Mileage should equal 255.");
        List<Double> checkpoints = new ArrayList<>(Arrays.asList(1.0));
        assertEquals(c2.roadTrip(checkpoints), 0, "The car should not be able to drive any days at all.");
        c2.recharge();
        assertEquals(c2.getRemainingRange(), c2.getMaxRange(), 0.1, "The remaining range should now equal the max range as the charge should be full.");
        checkpoints = Arrays.asList(125.0, 125.0);
        assertEquals(c2.roadTrip(checkpoints), 2, "Chevy should be able to drive 2 days.");
        checkpoints = Arrays.asList(-1.0);
        List<Double> finalCheckpoints = checkpoints;
        assertThrows(IllegalArgumentException.class, () -> c2.roadTrip(finalCheckpoints), "No day can be negative miles on a roadtrip.");
        assertThrows(IllegalArgumentException.class, () -> c2.drive(255), "Max range is 250 miles.");

        return getFailedCount();
    }
}
