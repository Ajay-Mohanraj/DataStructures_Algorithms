package bca.util;

import sun.java2d.pipe.NullPipe;

public class BCAMapByArrayList implements BCAMap {
	protected BCAArrayList list = new BCAArrayList();

	public BCAMapByArrayList() {
		// no arg constructor
	}

	/**
	 * Returns the number of key-value mappings in this map.
	 *
	 * @return the number of key-value mappings in this map
	 */
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Returns <tt>true</tt> if this map contains no key-value mappings.
	 *
	 * @return <tt>true</tt> if this map contains no key-value mappings
	 */
	@Override
	public boolean isEmpty() {
		return (list.size() == 0);
	}

	/**
	 * Returns <tt>true</tt> if this map contains a mapping for the specified
	 * key.
	 *
	 * @param key key whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map contains a mapping for the specified
	 * key
	 * @throws NullPointerException if the specified key is null.
	 */
	@Override
	public boolean containsKey(String key) {
		checkNullParam(key);
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)list.get(i);
			if (entry.equals(key)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns <tt>true</tt> if this map maps one or more keys to the specified
	 * value.
	 *
	 * @param value value whose presence in this map is to be tested
	 * @return <tt>true</tt> if this map maps one or more keys to the specified
	 * value
	 * @throws NullPointerException if the specified value is null.
	 */
	@Override
	public boolean containsValue(Object value) {
		checkNullParam(value);
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)list.get(i);
			if (entry.value.equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the value to which the specified key is mapped.
	 *
	 * @param key the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped or null if the key
	 * is not in the map.
	 * @throws NullPointerException if the specified key is null.
	 */
	@Override
	public Object get(String key) {
		checkNullParam(key);
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)list.get(i);
			if (entry.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	// my own method that throws NullPointerException if param is null
	protected void checkNullParam(Object param) {
		if (param == null) {
			throw new NullPointerException("Specified param is null.");
		}
	}

	/**
	 * Returns the value to which the specified key is mapped. Or the
	 * defaultValue if the key is not already in the map.
	 *
	 * @param key          the key whose associated value is to be returned
	 * @param defaultValue the value to return if the key is not in the map.
	 * @return the value to which the specified key is mapped or the
	 * defaultValue
	 * @throws NullPointerException if the specified key is null.
	 */
	@Override
	public Object getOrDefault(String key, Object defaultValue) {
		return get(key) == null ? defaultValue : get(key);
	}

	/**
	 * Associates the specified value with the specified key in this map. If the
	 * map previously contained a mapping for the key, the old value is replaced
	 * by the specified value.
	 *
	 * @param key   key with which the specified value is to be associated
	 * @param value value to be associated with the specified key
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
	 * if there was no mapping for <tt>key</tt>.
	 * @throws NullPointerException if the specified key or value is null.
	 */
	@Override
	public Object put(String key, Object value) {
		checkNullParam(key);
		checkNullParam(value);
		Object previousVal;
		for (int i = 0; i < list.size(); i++) {
			BCAEntry entry = (BCAEntry)list.get(i);
			if (entry.equals(key)) {
				previousVal = entry.value;
				entry.value = value;
				return previousVal;
			}
		}
		list.add(new BCAEntry(key, value));
		return null;
	}

	/**
	 * Removes the mapping for a key from this map if it is present.
	 *
	 * <p>
	 * Returns the value to which this map previously associated the key, or
	 * <tt>null</tt> if the map contained no mapping for the key.
	 *
	 * @param key key whose mapping is to be removed from the map
	 * @return the previous value associated with <tt>key</tt>, or <tt>null</tt>
	 * if there was no mapping for <tt>key</tt>.
	 * @throws NullPointerException if the specified key is null.
	 */
	@Override
	public Object remove(String key) {
		checkNullParam(key);
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

	/**
	 * Removes all of the mappings from this map.
	 */
	@Override
	public void clear() {
		list.clear();
	}

	/**
	 * Returns an array containing the current key,value pairs in the map.
	 */
	@Override
	public BCAEntry[] toArray() {
		BCAEntry[] arr = new BCAEntry[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = (BCAEntry)(list.get(i));
		}
		return arr;

	}

	/**
	 * Returns an array containing the keys in the map.
	 */
	@Override
	public String[] keys() {
		String[] keys = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			keys[i] = ((BCAEntry)(list.get(i))).key;
		}
		return keys;
	}

	/**
	 * Returns an array containing the values in the map.
	 */
	@Override
	public Object[] values() {
		Object[] vals = new Object[list.size()];
		for (int i = 0; i < list.size(); i++) {
			vals[i] = ((BCAEntry)(list.get(i))).value;
		}
		return vals;
	}
}
