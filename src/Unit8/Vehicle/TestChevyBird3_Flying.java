package Unit8.Vehicle;

public class TestChevyBird3_Flying extends BCATestScenario {


    public int runTest() {
        ChevroletBird c3 = new ChevroletBird();
        assertThrows(IllegalArgumentException.class, () -> c3.canFly(-1), "Car cannot go negative miles.");
        assertFalse(c3.checkWingsExtended(), "The wings should be closed when objected is created");
        assertTrue(c3.canFly(250), "Car should be able to fly 250 miles.");
        assertFalse(c3.canFly(255), "Car should not be able to fly 255 miles.");
        c3.fly(250);
        assertTrue(c3.checkWingsExtended(), "The wings should be extended if the car flies.");
        assertEquals(c3.getMileage(), 0, 0.1, "Flying should not increase mileage.");
        assertEquals(c3.getRemainingRange(), 0, 0.1, "There should be no miles left to fly or drive.");
        assertEquals(c3.getRemainingRange(), 0, 0.1, "The tank should be empty.");
        c3.recharge();
        c3.drive(100);
        assertFalse(c3.checkWingsExtended(), "The wings should be closed when the car starts to drive.");

        return getFailedCount();
    }

}
