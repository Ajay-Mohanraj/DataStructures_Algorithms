package bca.util;

import bca.util.BCAArrayList;
import bca.util.BCAEntry;
import bca.util.BCAMap;
import bca.util.BCAMapBaseline;
import bca.util.BCAMapByHashedArrayList;
import bca.util.BCAMapByHashedLinkedList;
import bca.util.CompareBCAEntryByValue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

	public static String cleanWord(String w) {
		char[] in = w.toLowerCase().toCharArray();
		StringBuilder buf = new StringBuilder(in.length);

		for (int i = 0; i < in.length; i++)
			if (Character.isAlphabetic(in[i]))
				buf.append(in[i]);

		return buf.toString();
	}

	public static BCAArrayList parseFile() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("data/u8/TaleOfTwoCities.txt"));
		BCAArrayList a = new BCAArrayList();
		
		while (in.hasNext()) {
			String w = cleanWord(in.next());
			if (w.length()>0) {
				a.add(w);
			}
			
		}
		in.close();
		return a;
	}
	
	public static void wordCount(BCAArrayList a, BCAMap map) {
		System.out.println(map.getClass() + ":");

		long start = System.currentTimeMillis();
		for(int i=0; i<a.size();i++) {
			String w = (String)a.get(i);
				Integer wc = (Integer) map.getOrDefault(w, 0);
				map.put(w, wc+1);
			}

		long end = System.currentTimeMillis();
		
		System.out.printf("Total seconds: %.3f\n", (end-start)/1000.0);
//		System.out.println(map.size());
		
		BCAEntry[] array = map.toArray();
		Arrays.sort(array, new CompareBCAEntryByValue());

/*		for (int i=1; i<=3; i++){
			BCAEntry e = array[array.length-i];
			System.out.println(e.key + ": " + e.value);
		}*/
	}	
	
	public static void main(String[] args) throws FileNotFoundException {
		/* In this implementation, we parse the file first so that the time
		required for file parsing does not count against the map algorithms.
		This change further illuminates the efficiency differences between
		the algorithms.
		 */

		BCAArrayList list = parseFile();

		System.out.println();
		wordCount(list, new BCAMapBaseline());

		/*
		System.out.println();
		wordCount(list, new BCAMapByArrayList());

		System.out.println("\n1 Bucket");
		wordCount(list, new BCAMapByHashedArrayList(1));
		wordCount(list, new BCAMapByHashedLinkedList(1));
*/
		System.out.println("\n5 Buckets");
		wordCount(list, new BCAMapByHashedArrayList(5));
		wordCount(list, new BCAMapByHashedLinkedList(5));

		System.out.println("\n10 Buckets");
		wordCount(list, new BCAMapByHashedArrayList(10));
		wordCount(list, new BCAMapByHashedLinkedList(10));

		System.out.println("\n100 Buckets");
		wordCount(list, new BCAMapByHashedArrayList(100));
		wordCount(list, new BCAMapByHashedLinkedList(100));

		System.out.println("\n1000 Buckets");
		wordCount(list, new BCAMapByHashedArrayList(1000));
		wordCount(list, new BCAMapByHashedLinkedList(1000));

		System.out.println("\n5000 Buckets");
		wordCount(list, new BCAMapByHashedArrayList(5000));
		wordCount(list, new BCAMapByHashedLinkedList(5000));

	}
}
