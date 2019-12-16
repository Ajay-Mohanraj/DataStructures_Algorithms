package Unit4.PostFixCalculator;

public abstract class OperatorToken extends Token {
	public final char operator;

	public OperatorToken(char operator) {
		this.operator = operator;
	}
	public String toString() {
		return "" + operator;
	}
	public abstract double eval(double a, double b);

	public int getPrecedence() {
		if (operator == '*' || operator == '/') {
			return 2;
		}
		else {
			return 1;
		}
	}
}
