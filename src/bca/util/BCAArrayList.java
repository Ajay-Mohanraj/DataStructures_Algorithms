package bca.util;

public class BCAArrayList implements BCAList, Cloneable {
	protected Object[] array = new Object[5];
	protected int listSize = 0;
	
	public BCAArrayList() {}
	
	private void expand()
	{
		Object[] newArray = new Object[array.length * 2];
		
		for (int i=0; i<array.length; i++)
			newArray[i] = array[i];
		
		array = newArray;
	}
	
	@Override
	public void add(Object o) {
		if (listSize >= array.length)
			expand();
		array[listSize++] = o;
	}

	@Override
	public void add(int index, Object o) {
		if (index > listSize)
			throw new IndexOutOfBoundsException ("Index of " + index + " out of bounds.");
		
		if (listSize >= array.length)
			expand();

		for (int i=listSize-1; i>=index; i--)
			array[i+1] = array[i];
		
		array[index] = o;
		listSize++;
	}

	@Override
	public void clear() {
		for (int i=0; i<listSize; i++)
			array[i] = null;		
		listSize = 0;
	}
	
	/** Returns a shallow copy of the BCAArrayList.  That is, only references to the 
	 * elements in the list are copied.  The objects themselves are not copied.
	 * @return A new copy of the list.
	 */
	public Object clone()
	{
		BCAArrayList newList = new BCAArrayList();
		for (int i=0; i<listSize; i++) {
			newList.add(array[i]);
		}
		return newList;
	}

	@Override
	public boolean contains(Object o) {
		for (int i=0; i<listSize; i++) {
			if (array[i].equals(o))
				return true;
		}
		
		return false;
	}

	@Override
	public Object get(int index) {
		if (index >= listSize)
			throw new IndexOutOfBoundsException ("Index of " + index + " out of bounds.");

		return array[index];
	}

	@Override
	public int indexOf(Object o) {
		for (int i=0; i<listSize; i++) {
			if (array[i].equals(o))
				return i;
		}
		
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return listSize == 0 ? true : false;
	}

	@Override
	public int lastIndexOf(Object o) {
		for (int i=listSize-1; i>=0; i--) {
			if (array[i].equals(o))
				return i;
		}
		
		return -1;
	}

	@Override
	public Object remove(int index) {
		if (index >= listSize)
			throw new IndexOutOfBoundsException ("Index of " + index + " out of bounds.");

		Object o = array[index];
		
		for (int i=index; i<listSize-1; i++)
			array[i] = array[i+1];
		
		array[listSize - 1] = null;
		listSize--;
		
		return o;
	}

	@Override
	public boolean remove(Object o) {
		int i = indexOf (o);
		
		if (i == -1)
			return false;
		
		remove (i);
		return true;	
	}

	@Override
	public int size() {
		return listSize;
	}

	public String toString() {
		String out = "";

		for (int i=0; i<listSize; i++) {
			out += i + ": " + array[i] + "; ";
		}
		return out;
	}
}
