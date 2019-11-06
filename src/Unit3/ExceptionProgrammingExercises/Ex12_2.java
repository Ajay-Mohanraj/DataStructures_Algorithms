package Unit3.ExceptionProgrammingExercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex12_2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean sumCompleted = false;

		while (!sumCompleted) {
			System.out.println("Please enter 2 integers.");
			try {
				int num1 = in.nextInt();
				int num2 = in.nextInt();

				System.out.println(num1 + num2);

				sumCompleted = true;

			}
			catch (InputMismatchException iME) {
				System.out.println("\nYour input was not an integer.");
				in.nextLine();
			}
		}
	}
}
