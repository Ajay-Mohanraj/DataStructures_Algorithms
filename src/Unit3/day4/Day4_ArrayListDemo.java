package Unit3.day4;

import java.util.ArrayList;

public class Day4_ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<>();

		strs.add("Sam");
		strs.add("Grace");
		strs.add(0, "Sara");

		for (String s : strs) {
			System.out.println(s);
		}
		for (int i = 0; i < strs.size(); i++) {
			System.out.println(strs.get(i));
		}
		System.out.println("\nRemoving Sam.");
		strs.remove("Sam");

		System.out.println(strs);


	}
}
