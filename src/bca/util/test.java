package bca.util;

public class test {
	public static void main(String[] args) {
		String s = "lol";
		String b = s;
		b = "Not lol";
		System.out.println(s);
		System.out.println(b);
		System.out.println(b.compareTo(s));
	}
}
