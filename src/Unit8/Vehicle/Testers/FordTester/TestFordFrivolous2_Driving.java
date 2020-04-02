package Unit8.Vehicle.Testers.FordTester;

import Unit8.Vehicle.Cars.FordFrivolous;
import Unit8.Vehicle.Testers.BCATestScenario;

public class TestFordFrivolous2_Driving extends BCATestScenario {

	@Override
	public int runTest() {
		FordFrivolous f2 = new FordFrivolous();

		return getFailedCount();
	}


}
