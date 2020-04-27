package bca.util;

import Unit8.Vehicle.FordFrivolous;

public class test {

	static String newSeq;
	public static String removeSeg(String oldSeq, String segment) {

		int index = oldSeq.indexOf(segment);
		String part2 = oldSeq.substring(index+segment.length());
		String part1 = oldSeq.substring(0, index);
		newSeq = part1+part2;
		return (part1+part2);
	}
	public static void main(String[] args) {

		String hello = "hello";
		System.out.println(removeSeg(hello, "ll"));
	}
}
