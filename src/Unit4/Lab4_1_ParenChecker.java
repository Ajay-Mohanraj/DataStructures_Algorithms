package Unit4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class Lab4_1_ParenChecker {

	public static void main(String[] args) {
		String[] files = {"data/lab4_1/invalid1.in","data/lab4_1/invalid2.in","data/lab4_1/invalid3.in",
				"data/lab4_1/invalid4.in","data/lab4_1/invalid5.in",
				"data/lab4_1/valid1.in","data/lab4_1/valid2.in"};

		for (String filename: files) {
			System.out.println("\nTesting file: " + filename);
			try {
				checkParens(filename);
			}
			catch (FileNotFoundException ex) {
				System.err.println("File not found");
			}
			catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}



	public static void checkParens(String fileName) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(fileName));
		ArrayList<Character> openSymbols = new ArrayList<>(Arrays.asList('[', '{', '('));
		ArrayList<Character> closeSymbols = new ArrayList<>(Arrays.asList(']', '}', ')'));

		//
		// Declare any other variables you need here.
		//
		Stack<Character> stack = new Stack<Character>();
		int lineCount = 0;


		// Read through the file one line at a time.
		while (in.hasNextLine()) {
			int pos = 0;
			String line = in.nextLine();
			lineCount++;
			char[] lineArray = line.toCharArray();
			for (int i = 0; i < lineArray.length; i++) {
				char compareChar = lineArray[i];
				pos++;

				if (compareChar == '(') {
					stack.push(')');
				}
				else if (compareChar == '[') {
					stack.push(']');
				}
				else if (compareChar == '{'){
					stack.push('}');
				}

				if (closeSymbols.contains(compareChar)) {

					if (stack.isEmpty()) {
						throw new InputMismatchException("On line " + lineCount + " @ pos " + pos + " found " + compareChar + " there is no matching symbol.");
					}
					else if (compareChar != stack.peek()) {
						char topOfStack = stack.pop();
						throw new InputMismatchException("On line " + lineCount + " @ pos " + pos + " found " + compareChar + " expected: " + topOfStack); //  + closeSymbols.get(openSymbols.indexOf(topOfStack))
					}
					else {
						stack.pop();
					}
				}
			}
		}
		// checking to see if stack is empty after parsing entire file
		if (!(stack.isEmpty())) {
			throw new InputMismatchException("At end of input -- expecting " + stack.pop());
		}
		else {
			System.out.println("The parenthesis in the file are valid!");
		}
	}
}
