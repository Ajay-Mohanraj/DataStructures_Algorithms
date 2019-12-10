package Unit4.PostFixCalculator;

public abstract class ParenToken extends Token {
	public final char paren;

	public ParenToken(char paren) {
		this.paren = paren;
	}

	public String toString() {
		return "" + paren;
	}


}
