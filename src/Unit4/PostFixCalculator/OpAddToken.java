package Unit4.PostFixCalculator;

public class OpAddToken extends OperatorToken {
	public OpAddToken() {
		super('+');
	}

	@Override
	public double eval(double a, double b) {
		return a + b;
	}

	@Override
	public int getPrecedence() {
		return 1;
	}



}
