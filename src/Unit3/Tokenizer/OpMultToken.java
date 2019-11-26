package Unit3.Tokenizer;

public class OpMultToken extends OperatorToken {
	public OpMultToken() {
		super('+');
	}

	@Override
	public double eval(double a, double b) {
		return a * b;
	}
}
