package Unit4.PostFixCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Lab4_3_InfixConverter {


	/* Translates the provided String "s" from infix notation to
		postfix notation.  Returns the postfix formatted string.

		This method assumes that "s" is a properly written infix expression.  It
		is not expected to detect all syntax errors in "s".  However, it may
		throw an exception for some improperly formatted inputs.
	 */
	public static String infixToPostfix(String s) throws Exception {
		Stack<OperatorToken> opstack = new Stack<OperatorToken>();
		String output = "";
		Tokenizer tk = new Tokenizer(s);

		while (tk.hasMoreTokens()) {
			Token t = tk.nextToken();
			if (t instanceof NumberToken) {
				output += ((NumberToken)t).value;
			}
			//else if ()
		}
		return "";
	}

	/**
	 * Main opens the file 'infix.in'.  It then reads
	 * through the file one line at a time.  For each line, it prints the original
	 * line from the input, then the postfix equivalent, and then prints the
	 * simplified answer.
	 *
	 * If an exception occurs when evaluating a specific line, the exception is
	 * printed and then execution continues with the next line.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("data/lab4_3/infix.in"));

		while (in.hasNextLine()) {
			String line = in.nextLine();
			System.out.println("\n" + line);

			try {
				String postfix = infixToPostfix(line);
				System.out.println("\t Postfix: " + postfix);

				double answer = Lab4_2_PostfixCalculator.calculatePostfix(postfix);
				System.out.println("\t Answer: " + answer);
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}

