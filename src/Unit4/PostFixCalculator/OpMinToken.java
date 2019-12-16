package Unit4.PostFixCalculator;

public class OpMinToken extends OperatorToken {
	public OpMinToken() {
		super('-');
	}

	@Override
	public double eval(double a, double b) {
		return a - b;
	}


}
