package Unit3.Tokenizer;

public class OpAddToken extends OperatorToken {
	public OpAddToken() {
		super('+');
	}

	@Override
	public double eval(double a, double b) {
		return a + b;
	}
}
