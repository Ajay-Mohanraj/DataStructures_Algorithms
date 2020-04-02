package Unit8.Vehicle.Cars;

public abstract class ElectricCar extends Car {
	private double milesOnMaxCharge;
	private double charge = 100;

	/** Note: Car begins with a full charge (and thus range).
	 @throws IllegalArgumentException if milesOnMaxCharge is
	 nonpositive.*/
	public ElectricCar(String make, String model, double startingMileage,
	                   double milesOnMaxCharge) {
		super(make, model, startingMileage);
		if (milesOnMaxCharge < 0) {
			throw new IllegalArgumentException("Miles on max charge is negative.");
		}
		this.milesOnMaxCharge = milesOnMaxCharge;

	}

	/** Defaults mileage to 0.
	 @throws IllegalArgumentException if milesOnMaxCharge is
	 nonpositive.*/
	public ElectricCar (String make, String model, double
			milesOnMaxCharge) {
		this(make, model, 0, milesOnMaxCharge);
	}

	/** Drives the full given number of miles.
	 @throws IllegalArgumentException if miles is negative.
	 @throws IllegalArgumentException if miles is too high given the
	 current charge.*/
	public void drive(double miles) {
		if (miles < 0 || !canDrive(miles)) {
			throw new IllegalArgumentException("Miles is negative or you do not have enough charge.");
		}
		addMileage(miles);
		decreaseCharge(miles);
	}

	/** Returns how many more miles the car can currently go without
	 recharging. */
	public double getRemainingRange () {
		return this.charge * this.milesOnMaxCharge/100;
	}

	/** Returns how many miles the car could go on a full charge. */
	public double getMaxRange() {
		return this.milesOnMaxCharge;
	}

	/** Recharges the car to max range capability. */
	public void recharge() {
		this.charge = 100;
	}

	/** Decreases the amount of energy in the battery based by the
	 number of miles passed as an argument. */
	protected void decreaseCharge(double miles) {
		this.charge -= (miles/this.milesOnMaxCharge);
	}
}
