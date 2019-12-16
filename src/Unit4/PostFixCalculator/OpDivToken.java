package Unit4.PostFixCalculator;

public class OpDivToken extends OperatorToken {
	public OpDivToken() {
		super('/');
	}

	@Override
	public double eval(double a, double b) {
		return a / b;
	}

}
