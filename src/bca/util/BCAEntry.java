package bca.util;

public class BCAEntry implements Comparable {
	public String key = null;
	public Object value = null;
	public BCAEntry next = null;

	public BCAEntry(String key, Object value)
	{
		this.key = key;
		this.value = value;
	}

	public BCAEntry(String key, Object value, BCAEntry next)
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}

	public boolean equals (Object o)
	{
		if (o instanceof String)
			return key.equals(o);
		
		else if (o instanceof BCAEntry)
			return key.equals(((BCAEntry)o).key);

		return false;
	}

	public int compareTo (Object o)
	{
		if (o instanceof String) {
			return key.compareTo((String)o);			
		}
		else {
			return key.compareTo(((BCAEntry)o).key);
		}
	}

	public String toString ()
	{
		return key + ": " + value;
	}
}