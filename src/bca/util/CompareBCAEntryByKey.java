package bca.util;

import java.util.Comparator;

public class CompareBCAEntryByKey implements Comparator<BCAEntry> {

	@Override
	public int compare(BCAEntry o1, BCAEntry o2) {
		return ((Comparable)o1.key).compareTo(o2.key);
	}

}
