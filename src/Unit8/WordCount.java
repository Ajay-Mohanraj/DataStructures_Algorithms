package Unit8;

import bca.util.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {
	public static ArrayList<String> parseFile() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("data/u8/TaleOfTwoCities.txt"));

		ArrayList<String> a = new ArrayList<>();
		while (in.hasNext()) {
			String w = cleanWord(in.next());
			a.add(w);
		}
		in.close();
		return a;
	}
	public static void wordCount(BCAMap map, ArrayList<String> words) {
		System.out.println(map.getClass() + ":");


		long start = System.currentTimeMillis();
		for (String w : words) {
			Integer wc = (Integer) map.getOrDefault(w, 0);
			map.put(w, wc + 1);
		}
		long end = System.currentTimeMillis();

		System.out.printf("Total Seconds: %.3f\n", ((end-start)/1000.0));

		BCAEntry[] array = map.toArray();
		Arrays.sort(array, new CompareBCAEntryByValue());

		for (int i = 1; i <= 3; i++) {
			BCAEntry e = array[array.length-i];
			System.out.println(e.key + " : " + e.value + " time(s)");
		}

	}

	public static String cleanWord(String w) {
		char[] in = w.toLowerCase().toCharArray();
		StringBuilder buf = new StringBuilder(in.length);

		for (int i = 0; i < in.length; i++) {
			if (Character.isAlphabetic(in[i])) {
				buf.append(in[i]);
			}
		}
		return buf.toString();
	}

	public static void main(String[] args) throws FileNotFoundException{
		ArrayList<String> words = parseFile();

		System.out.println();
		wordCount(new BCAMapBaseline(), words);

		System.out.println();
		wordCount(new BCAMapByArrayList(), words);

		System.out.println();
		System.out.println("Testing with 100 buckets.");
		wordCount(new BCAMapByHashedArrayList(100), words);
	}
}
