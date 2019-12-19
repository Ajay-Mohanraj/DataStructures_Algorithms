package Unit4.PostFixCalculator;

public class OpMultToken extends OperatorToken {
	public OpMultToken() {
		super('*');
	}

	@Override
	public double eval(double a, double b) {
		return a * b;
	}

	public int getPrecedence() {
		return 2;
	}


}
