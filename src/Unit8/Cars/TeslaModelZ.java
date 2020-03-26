package Unit8.Cars;

public class TeslaModelZ extends ElectricCar implements SelfDriving {

	private int modelNum;

	/** modelNum specifies the model number. Tesla cares about that
	 stuff. Tesla Model Z’s have a 340 mile range on a full charge.*/
	public TeslaModelZ(double startingMileage, int modelNum) {
		super("Tesla", "Model Z", startingMileage, 340);
		this.modelNum = modelNum;
	}

	/** Defaults mileage to 0. */
	public TeslaModelZ(int modelNum) {
		this(0, modelNum);
	}

	/** Returns the model number.*/
	public int getModelNum() {
		return this.modelNum;
	}

	@Override
	public void driveAutonomously(double miles) {
		if (miles > getRemainingRange()) {
			super.drive(getRemainingRange());
		}
		else {
			super.drive(miles);
		}
	}
}
