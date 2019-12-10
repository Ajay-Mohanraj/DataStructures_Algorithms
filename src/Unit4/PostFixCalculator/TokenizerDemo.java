package Unit4.PostFixCalculator;

import java.util.Scanner;

public class TokenizerDemo {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string");
		String line = input.nextLine();

		Tokenizer tk = new Tokenizer(line);
		while (tk.hasMoreTokens()) {
			Token t = tk.nextToken();

			if (t instanceof  OperatorToken) {
				OperatorToken op = (OperatorToken) t;
				System.out.print(op.operator + ": ");
				System.out.println(op.eval(42, 12));
			}
			else if (t instanceof NumberToken){
				System.out.println("Num token: " + t);
			}
			else if (t instanceof ParenToken){
				System.out.println("Paren token: " + t);
			}

		}
	}
}
