package Unit3.ExceptionProgrammingExercises;

import java.util.Scanner;

public class Ex12_3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] array = new int[100];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random() * 100);
		}

		try {
			int index = in.nextInt();
			System.out.println(array[index]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Out of bounds.");
		}

	}
}
