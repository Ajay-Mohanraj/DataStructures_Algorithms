package Unit8.Cars;

public class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying {

	/** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6.
	 */
	public FordFrivolous(double startingMileage) {
		super("Ford", "Frivolous", startingMileage, 23.6, 20.0);
	}

	/** Defaults mileage to 0. */
	public FordFrivolous() {
		this(0);
	}

	@Override
	public void driveAutonomously(double miles) {

		if (!canDrive(miles*2)) {
			// System.out.println("Remaining range is " + getRemainingRange());
			super.drive(getRemainingRange()/2.0);
			decreaseFuelLevel(miles/2); // twice
		}
		else {
			super.drive(miles);
			decreaseFuelLevel(miles); // twice
		}

	}

	@Override
	public boolean canFly(double miles) {
		return canDrive(miles*3);
	}

	@Override
	public void fly(double miles) {
		if (!canFly(miles)) {
			throw new IllegalArgumentException("Miles is negative or you do not have enough fuel.");
		}
		decreaseFuelLevel(miles*3);
	}
}
