package Unit3;

import java.util.ArrayList;
import java.util.Scanner;

public class Day03_Reverse {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter a list of numbers.");

		ArrayList<Integer> ints = new ArrayList<>();

		int n = in.nextInt();
		while (n != 0) {
			ints.add(n);
			n = in.nextInt();
		}

		for (int i = ints.size()-1; i >= 0; i--) {
			System.out.println(ints.get(i));
		}
	}
}
