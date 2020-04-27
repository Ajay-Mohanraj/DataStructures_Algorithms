package bca.util;

import java.util.Arrays;

public class BCAMapByHashedLinkedList implements BCAMap{
	protected BCAEntry[] buckets = null;
	protected int size;

	public BCAMapByHashedLinkedList(int numBuckets) {
		buckets = new BCAEntry[numBuckets];
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
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
		for (BCAEntry bucket : buckets) {
			BCAEntry node = bucket;
			while (node != null) {
				if (node.value.equals(value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;

	}

	@Override
	public Object get(String key) {
		checkNullParam(key);
		int bucket = getBucket(key);
		BCAEntry node = buckets[bucket];
		while (node != null) {
			if (node.equals(key)) {
				return node.value;
			}
			node = node.next;
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
		BCAEntry node = buckets[bucket];
		while (node != null) {
			if (node.equals(key)) {
				Object prevVal = node.value;
				node.value = value;
				return prevVal;
			}
			node = node.next;
		}
		BCAEntry head = new BCAEntry(key, value);
		if (buckets[bucket] != null) {
			head.next = buckets[bucket];
		}
		buckets[bucket] = head;
		size++;
		return null;
	}

	@Override
	public Object remove(String key) {
		checkNullParam(key);
		int bucket = getBucket(key);
		BCAEntry lagger = buckets[bucket];
		BCAEntry node = buckets[bucket];
		boolean firstTime = true;
		while (node != null) {
			if (node.equals(key)) {
				if (firstTime) {
					buckets[bucket] = node.next;
				}
				else {
					lagger.next = node.next;

				}
				size--;
				return node.value;
			}
			node = node.next;
			if (!firstTime) {
				lagger = lagger.next;
			}
			firstTime = false;
		}

		return null;
	}


	@Override
	public void clear() {
		//for (int i = 0; i < buckets.length; i++) {
		//	buckets[i] = null;
		//}
		Arrays.fill(buckets, null);
		size = 0;
	}

	@Override
	public BCAEntry[] toArray() {
		BCAEntry[] entryList = new BCAEntry[size];
		int index = 0;
		for (BCAEntry bucket : buckets) {
			BCAEntry node = bucket;
			while (node != null) {
				entryList[index++] = new BCAEntry(node.key, node.value);
				node = node.next;
			}
		}
		return entryList;
	}

	@Override
	public String[] keys() {
		String[] keys = new String[size];
		int index = 0;
		for (BCAEntry bucket : buckets) {
			BCAEntry node = bucket;
			while (node != null) {
				keys[index++] = node.key;
				node = node.next;
			}
		}
		return keys;
	}

	@Override
	public Object[] values() {
		Object[] array = new Object[size];
		int index = 0;
		for (BCAEntry bucket : buckets) {
			BCAEntry node = bucket;
			while (node != null) {
				array[index++] = node.value;
				node = node.next;
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
