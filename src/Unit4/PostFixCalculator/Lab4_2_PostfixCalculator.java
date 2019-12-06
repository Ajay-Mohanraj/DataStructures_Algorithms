package Unit4.PostFixCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class Lab4_2_PostfixCalculator {

    /**
     * calculatePostfix calculates and returns the value for the postfix
     * expression "postfixExp".  This method throws exceptions in the following
     * cases:
     * 1) If there are illegal characters in the input.
     * 2) If there are not enough values for a given operator.
     * 3) If there is more than 1 value remaining on the stack after the calculation completes.
     */
    public static double calculatePostfix(String postfixExp) throws InvalidExpressionException {
        Stack<Double> stack = new Stack<>();
        Tokenizer tokenizer = new Tokenizer(postfixExp);


        while (tokenizer.hasMoreTokens()) {
            Token t = tokenizer.nextToken();
            if (t instanceof  NumberToken) {
                NumberToken nt = (NumberToken)t;
                stack.push(nt.value);
            }
            else if (t instanceof OperatorToken) {
                OperatorToken op = (OperatorToken)t;
                if (stack.size() < 2) {
                    throw new InvalidExpressionException("Too few values on stack for operator " + op);
                }
                else {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    double calculation = op.eval(num1, num2);
                    stack.push(calculation);
                }
            }

        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        else {
            throw new InvalidExpressionException("Too few operators in the expression. Stack has " + stack.size() + " elements at the end of the expression.");
        }


    }

    /**
     * Main opens the file specified in the first paramenter.  It then reads
     * through the file one line at a time.  For each line, it prints the original
     * line from the input and then prints the result.  If an exception occurs when
     * evaluating a specific link, print the message for the exception (using getMessage)
     * and then continue to the next line.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("data/lab4_2/postfix.in"));

        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println("\n" + line);

            try {
                double answer = calculatePostfix(line);
                System.out.println(answer);
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
