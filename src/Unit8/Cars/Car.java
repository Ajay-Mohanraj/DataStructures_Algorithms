package Unit8.Cars;

import java.util.List;

abstract class Car {
	/**
	 * Creates a car with a starting mileage on the odometer.
	 *
	 * @throws IllegalArgumentException if startingMileage is negative
	 */
	private String make;
	private String model;
	private double mileage;

	public Car(String make, String model, double startingMileage) {
		this.make = make;
		this.model = model;
		if (startingMileage < 0) {
			throw new IllegalArgumentException();
		}
		this.mileage = startingMileage;
	}

	/** Starting mileage is 0. */
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
		this.mileage = 0;
	}

	/** If able to drive the full given number of miles, returns true.
	 If not, returns false.
	 @throws IllegalArgumentException if miles is negative.*/
	public boolean canDrive(double miles) {
		if (miles < 0) {
			throw new IllegalArgumentException();
		}
		return getRemainingRange() >= miles;
	}

	/** Drives the full given number of miles.
	 @throws IllegalArgumentException if miles is negative or if miles
	 is too high given the current fuel.*/
	public abstract void drive(double miles);

	/** Gives String representation of Car as
	 "< make and model> (<mileage> mi) "*/
	public String toString() {
		return this.make + " " + this.model + "(" + this.mileage + ")";
	}

	/** Returns how many miles have been driven so far (odometer). */
	public double getMileage() {
		return this.mileage;
	}

	/** Returns how many more miles the car can currently go given the
	 remaining fuel/energy reserves. */
	public abstract double getRemainingRange();

	/** Adds mileage to the odometer.
	 @throws IllegalArgumentException if miles is negative. */
	protected void addMileage(double miles) {
		if (miles < 0) {
			throw new IllegalArgumentException();
		}
		this.mileage = this.mileage + miles;
	}

	/** The car attempts to drive, in order, each of the daily number
	 of miles in the list milesEachDay. Once the car cannot drive one of
	 the day’s distance, no more days are attempted. Returns the number
	 of days successfully driven.
	 @throws IllegalArgumentException if miles is negative for any of
	 the attempted days.*/
	public int roadTrip(List<Double> milesEachDay) {
		int days = 0;
		for (double miles : milesEachDay) {
			if (miles < 0) {
				throw new IllegalArgumentException();
			}
			if (canDrive(miles)) {
				days++;
			}
			else {
				return days;
			}
		}
		return days;
	}
}

abstract class GasPoweredCar extends Car {
	private double mpg;
	private double fuelCapacityGallons;
	private double tank;

	/** Note: Start with a full tank of gas
	 @throws IllegalArgumentException if mpg or fuelCapacityGallons are
	 nonpositive. */
	public GasPoweredCar(String make, String model, double
			startingMileage, double mpg, double fuelCapacityGallons) {
		super(make, model, startingMileage);
		if (mpg < 0 || fuelCapacityGallons < 0) {
			throw new IllegalArgumentException();
		}
		this.mpg = mpg;
		this.fuelCapacityGallons = fuelCapacityGallons;
		this.tank = fuelCapacityGallons;

	}

	/** Defaults mileage to 0.
	 @throws IllegalArgumentException if mpg or fuelCapacityGallons are
	 nonpositive. */
	public GasPoweredCar (String make, String model, double mpg, double
			fuelCapacityGallons) {
		this(make, model, 0, mpg, fuelCapacityGallons);
	}

	/** Drives the full given number of miles.
	 @throws IllegalArgumentException if miles is negative.
	 @throws IllegalArgumentException if miles is too high given the
	 current fuel.*/
	public void drive(double miles) {
		if (miles < 0 || !canDrive(miles)) {
			throw new IllegalArgumentException("Miles is negative or you do not have enough fuel.");
		}
		addMileage(miles);
		decreaseFuelLevel(miles);
	}

	/** Returns how many miles can be driven on one gallon of gas. */
	public double getMPG() {
		return this.mpg;
	}

	/** Returns how many gallons of fuel are currently in the car. */
	public double getFuelLevel() {
		return this.tank;
	}

	/** Returns how many gallons of fuel the car can hold at max. */
	public double getFuelCapacity() {
		return this.fuelCapacityGallons;
	}

	/** Refuels the car to max fuel capacity. */
	public void refillTank() {
		this.tank = this.fuelCapacityGallons;
	}

	/** Returns how many more miles the car can currently go without
	 refueling. */
	public double getRemainingRange() {
		return this.tank * mpg;
	}

	/** Attempt to refuel the car with additional gallons.
	 @throws IllegalArgumentException if gallons is negative OR gallons
	 would overfill the tank. */
	public void refillTank(double gallons) {
		if (gallons < 0 || this.tank + gallons > fuelCapacityGallons) {
			throw new IllegalArgumentException("Gallons is negative or you are overflowing the tank!");
		}
		this.tank += gallons;
	}

	/** Decreases the amount of fuel in the gas tank based upon
	 mpg and the number of miles passed as an argument. */
	protected void decreaseFuelLevel(double miles) {
		this.tank -= (miles / mpg);
	}
}
abstract class ElectricCar extends Car {
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
			throw new IllegalArgumentException("Miles is negative or you do not have enough fuel.");
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
