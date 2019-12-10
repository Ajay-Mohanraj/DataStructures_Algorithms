package Unit4.PostFixCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Tokenizer {
	private char[] tokenStr = null;
	private int pos;
	ArrayList<Character> opArr = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
	public Tokenizer(String str) {
		tokenStr = str.toCharArray();
	}

	private void skipSpaces() {
		while (pos < tokenStr.length && Character.isSpaceChar(tokenStr[pos])) {
			pos += 1;
		}
	}
	/** Returns next token in str, returns null if no tokens remain*/
	private NumberToken readNumberToken() {
		int val = 0;
		while (pos < tokenStr.length && Character.isDigit(tokenStr[pos])) {
			int a = tokenStr[pos] - '0';
			val = val * 10 + a;
			pos++;
		}
		return new NumberToken(val);
	}

	private OperatorToken readOperatorToken() throws InvalidExpressionException {
		char op = tokenStr[pos];
		pos++;
		if (op == '+') {
			return new OpAddToken();
		}
		else if (op == '-') {
			return new OpMinToken();
		}
		else if (op == '*') {
			return new OpMultToken();
		}
		else if (op == '/') {
			return new OpDivToken();
		}
		else {
			throw new InvalidExpressionException("Found " + op + " expecting an operator character @ position " + pos + ".");
		}
	}
	public boolean hasMoreTokens() {
		skipSpaces();
		return (pos < tokenStr.length);
	}

	private ParenToken readParenToken() throws InvalidExpressionException {
		char paren = tokenStr[pos];
		pos++;
		if (paren == '(') {
			return new LeftParenToken();
		}
		else if (paren == ')') {
			return new RightParenToken();
		}
		else {
			throw new InvalidExpressionException();
		}
	}


	public Token nextToken() throws InvalidExpressionException {
		skipSpaces();
		if (pos >= tokenStr.length) {
			throw new NoSuchElementException("No more tokens remaining.");
		}

		if (Character.isDigit(tokenStr[pos])) {
			return readNumberToken();
		}
		else if (opArr.contains(tokenStr[pos])){
			return readOperatorToken();
		}
		else {
			return readParenToken();
		}
	}
}
