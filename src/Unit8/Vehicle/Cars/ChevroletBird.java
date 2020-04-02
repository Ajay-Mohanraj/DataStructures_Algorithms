package Unit8.Vehicle.Cars;

public class ChevroletBird extends ElectricCar implements Flying {

	private boolean wingsOn;

	/** Chevrolet Birds have a 250 mile range on a full charge. They
	 start with their wings retracted.*/
	public ChevroletBird (double startingMileage) {
		super("Chevrolet", "Bird", startingMileage, 250);
		this.wingsOn = false;
	}

	/** Defaults mileage to 0. */
	public ChevroletBird () {
		this(0);
	}

	/** Returns whether the wings are currently extended. */
	public boolean checkWingsExtended() {
		return (this.wingsOn);
	}

	/** Drives just like all other Electric Cars, except make sure that
	 you retract your wings first (duh).
	 Coding tip: Write this method to re-use the behavior of the
	 superclass drive. Don’t copy-and-paste the same code here.*/
	public void drive(double miles) {
		this.wingsOn = false;
		super.drive(miles);
	}

	@Override
	public boolean canFly(double miles) {
		return canDrive(miles);
	}

	@Override
	public void fly(double miles) {
		if (miles < 0 || !canFly(miles)) {
			throw new IllegalArgumentException("Miles is negative or you do not have enough charge.");
		}
		this.wingsOn = true;
		decreaseCharge(miles);
	}
}
