package bca.util;

public class BCAMapByHashedArrayList implements BCAMap {
	protected BCAArrayList[] buckets = null;

	public BCAMapByHashedArrayList(int numBuckets) {
		buckets = new BCAArrayList[numBuckets];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new BCAArrayList();
		}
	}

	@Override
	public int size() {
		int size = 0;
		for (int i = 0; i < buckets.length; i++) {
			size += buckets[i].size();
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < buckets.length; i++) {
			if (!buckets[i].isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean containsKey(String key) {
		return (get(key) != null);
	}

	@Override
	public boolean containsValue(Object value) {
		checkNullParam(value);
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				BCAEntry e = (BCAEntry)(buckets[i].get(j));
				if (e.value.equals(value)) {
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public Object get(String key) {
		checkNullParam(key);
		int bucket = getBucket(key);
		BCAArrayList list = buckets[bucket];
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)(list.get(i));
			if (entry.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	@Override
	public Object getOrDefault(String key, Object defaultValue) {
		checkNullParam(key);
		Object val = get(key);
		return val == null ? defaultValue : val;
	}

	@Override
	public Object put(String key, Object value) {
		checkNullParam(key);
		checkNullParam(value);
		int bucket = getBucket(key);
		BCAArrayList list = buckets[bucket];
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)list.get(i);
			if (entry.equals(key)) {
				Object previousVal = entry.value;
				entry.value = value;
				return previousVal;
			}
		}
		list.add(new BCAEntry(key, value));
		return null;
	}

	@Override
	public Object remove(String key) {
		checkNullParam(key);
		int bucket = getBucket(key);
		BCAArrayList list = buckets[bucket];
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)list.get(i);
			if (entry.equals(key)) {
				Object previousVal = entry.value;
				list.remove(i);
				return previousVal;
			}
		}
		return null;
	}

	@Override
	public void clear() {
		for (int i = 0; i < buckets.length; i++) {
			buckets[i].clear();
		}
	}

	@Override
	public BCAEntry[] toArray() {
		BCAEntry[] entryList = new BCAEntry[size()];
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				BCAEntry e = (BCAEntry)(buckets[i].get(j));
				entryList[index++] = new BCAEntry(e.key, e.value);
			}
		}
		return entryList;
	}

	@Override
	public String[] keys() {
		String[] array = new String[size()];
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				BCAEntry e = (BCAEntry)(buckets[i].get(j));
				array[index++] = e.key;
			}
		}
		return array;
	}

	@Override
	public Object[] values() {
		Object[] array = new Object[size()];
		int index = 0;
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				BCAEntry e = (BCAEntry)(buckets[i].get(j));
				array[index++] = e.value;
			}
		}
		return array;
	}

	protected void checkNullParam(Object param) {
		if (param == null) {
			throw new NullPointerException("Specified param is null.");
		}
	}

	protected int getBucket(String key) {
		return Math.abs(key.hashCode()) % buckets.length;
	}
}
