package Unit3;

import java.util.ArrayList;

public class tester {
	public static boolean prefixAgain(String str, int n) {
		String comparing = str.substring(0, n);
		int comparingLength = comparing.length();
		for (int i = n; i <= str.length()- comparingLength; i++) {
			String compareTo = str.substring(i, i+comparingLength) ;
			System.out.println(compareTo);
			if (compareTo.equals(comparing)) {
				return true;
			}
		}
		return false;
	}



	public static void main(String[] args) {
		prefixAgain("abXYabc", 1);

	}
}