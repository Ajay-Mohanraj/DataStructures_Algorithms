package bca.util;

import java.util.Comparator;

public class CompareBCAEntryByValue implements Comparator<BCAEntry> {

	@Override
	public int compare(BCAEntry o1, BCAEntry o2) {
		return ((Comparable)o1.value).compareTo(o2.value);
	}

}
