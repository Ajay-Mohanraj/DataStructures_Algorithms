package Unit8.Vehicle;

public class TestChevyBird1_CoreProperties extends BCATestScenario {

    @Override
    public int runTest(){

        assertThrows(IllegalArgumentException.class, () -> new ChevroletBird(-1), "Mileage can not be a negative number.");

        ChevroletBird c1 = new ChevroletBird(0);
        assertEquals(c1.getMileage(), 0, 0.1, "Mileage should be 0 at creation.");
        assertEquals(c1.getMaxRange(), 250, 0.1, "The max range of the car should be equal to the value of miles on max charge.");
        assertEquals(c1.getRemainingRange(), c1.getMaxRange(), 0.1, "The remaining range should be still be the maximum range ");
        assertEquals(c1.toString(), "Chevrolet Bird (0.0 mi)", "toStrings do not match.");

        return getFailedCount();
    }
}
