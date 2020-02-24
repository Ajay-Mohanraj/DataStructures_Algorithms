package Unit7.Anagrams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LookupList {
	private ArrayList<String> wordlist;

	public LookupList() {
		wordlist = new ArrayList<String>();
	}

	public LookupList (String fileName) throws FileNotFoundException {
		wordlist = new ArrayList<String>();
		Scanner file = new Scanner(new FileReader(fileName));
		while (file.hasNextLine())
		{
			String word = file.nextLine();
			if (word.length() == 0 || word.charAt(0) == '#') {//skip blank lines or starting with #, treating them as comments
				continue;
			}
			wordlist.add(word);
      /*
      // Track how quickly the wordlist is forming...
      if (wordlist.size() % 5000 == 0)
        System.out.println("Added " + numWords + " words.");
      */
		}
		file.close();
		wordlist = mergeSort(wordlist);


	}

	public int size(){
		return wordlist.size();
	}

	public String get(int index){
		return wordlist.get(index);
	}

	public int indexOf(String word){
		return binarySearch(wordlist, word);
	}

	public boolean contains(String word){
		return binarySearch(wordlist, word) != -1;
	}

	public List<String> toList(){
		return wordlist;
	}

	public void print() {
		int maxdigits = String.valueOf(wordlist.size()).length();;
		String format = "%" + maxdigits +"d: %s\n";

		System.out.printf("Wordlist (%d total):\n", wordlist.size());
		for (int i = 0; i < wordlist.size(); i++){
			System.out.printf(format,i,wordlist.get(i));
		}
	}

	public void insert(String word){
		//This inserts a word into the list in sorted position,
		//assuming that the list is already sorted.

		for (int i = wordlist.size(); i > 0; i--){ //work backwards
			String w = wordlist.get(i - 1);
			if (word.compareTo(w) >= 0){ //if >= item in list (w),
				wordlist.add(i, word); //insert at correct place, which is right after the item
				return; //done!
			}
		}
		wordlist.add(0, word); //if < all items in list, add to front of list

		//TODO Optional?? Rewrite to work a little bit faster! Hint: Use binarySearch to know WHERE to insert...
	}


	private static ArrayList<String> mergeSort(ArrayList<String> wordList) {

		int n = wordList.size();

		if (n == 1) {
			return wordList;
		}

//		int[] halfA = Arrays.copyOfRange(list, 0, n/2);
//		int[] halfB = Arrays.copyOfRange(list, n/2, n);
		ArrayList<String> halfA = new ArrayList<>(wordList.subList(0, n/2));
		ArrayList<String> halfB = new ArrayList<>(wordList.subList(n/2, n));

		ArrayList<String> sortedA = mergeSort(halfA);
		ArrayList<String> sortedB = mergeSort(halfB);

		ArrayList<String> sorted = mergeLists(sortedA, sortedB);

		return sorted;
	}

	private static ArrayList<String> mergeLists(ArrayList<String> listA, ArrayList<String> listB) {
		ArrayList<String> merged = new ArrayList<String>(listA.size() + listB.size());
		
		int a = 0;
		int b = 0;

		while (a < listA.size() && b < listB.size()) {
			if (listA.get(a).compareTo(listB.get(b)) < 0) {
				merged.add(listA.get(a++));
			}
			else {
				merged.add(listB.get(b++));
			}
		}

		while (a < listA.size()) {
			merged.add(listA.get(a++));
		}

		while (b < listB.size()) {
			merged.add(listB.get(b++));
		}

		return merged;
	}

	public static int binarySearch(ArrayList<String> list, String word) {
		return binarySearch(0, list.size()-1, list, word);
	}

	private static int binarySearch(int minPos, int maxPos, ArrayList<String> list, String word) {
		if (minPos > maxPos) {
			return -1;
		}

		int pos = (minPos + maxPos) / 2;
		if (list.get(pos).equals(word)) {
			return pos;
		}

		else if (word.compareTo(list.get(pos)) > 0) {
			return binarySearch(pos+1, maxPos, list, word);
		}

		else {
			return binarySearch(minPos, pos-1, list, word);
		}
	}

}
