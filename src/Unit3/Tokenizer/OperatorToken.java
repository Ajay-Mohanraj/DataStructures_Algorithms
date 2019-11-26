package Unit3.Tokenizer;

public abstract class OperatorToken extends Token {
	public final char operator;

	public OperatorToken(char operator) {
		this.operator = operator;
	}
	public String toString() {
		return "" + operator;
	}
	public abstract double eval(double a, double b);
}
