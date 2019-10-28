package Unit3.day4;

public class BCAArrayList<E> implements BCAList<E> {
	protected Object[] array = new Object[5];
	protected int listSize = 0;

	private void expand() {
		Object[] newArray = new Object[array.length * 2];

		for (int i=0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		array = newArray;
	}
	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e
	 */
	@Override
	public void add(E e) {
		if (listSize >= array.length)
			expand();
		array[listSize++] = e;
	}

	/**
	 * Inserts the specified element at the specified position in this list.
	 * Existing elements in the list are shifted right. If the specified index is
	 * at the end of list, the specified element is appended to the end of the
	 * list.
	 *
	 * @param index
	 * @param e
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	@Override
	public void add(int index, E e) {
		if ((index < 0) || (index > listSize)) {
			throw new IndexOutOfBoundsException("Illegal index");
		}

		if (listSize >= array.length)
			expand();

		for (int i = listSize - 1; i >= index; i--) {
			array[i+1] = array[i];
		}
		array[index] = e;
		listSize++;
	}

	/**
	 * Removes all of the elements from this list. This method releases all
	 * references to elements stored in the list so that they can be garbage
	 * collected.
	 */
	@Override
	public void clear() {
		listSize = 0;
//        array = new Object[5];

		for (int i=0; i<array.length; i++) {
			array[i] = null;
		}

	}

	/**
	 * Returns true if this list contains the specified element.
	 *
	 * @param e
	 */
	@Override
	public boolean contains(E e) {
		return indexOf(e) >= 0;
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E get(int index) {
		if ((index < 0) || (index >= listSize)) {
			throw new IndexOutOfBoundsException("Illegal index");
		}

		return (E)array[index];
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.  Returns the value previously stored at the location.
	 *
	 * @param index
	 * @param e
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	@Override
	public E set(int index, E e) {
		if ((index < 0) || (index >= listSize)) {
			throw new IndexOutOfBoundsException("Illegal index");
		}

		E ret =  (E)array[index];

		array[index]  = e;
		return ret;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element.
	 *
	 * @param e
	 */
	@Override
	public int indexOf(E e) {
		for (int i = 0; i < listSize; i++) {
			if (array[i].equals(e))
				return i;
		}
		return -1;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return listSize == 0;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 *
	 * @param e
	 */
	@Override
	public int lastIndexOf(E e) {
		for (int i = listSize-1; i >= 0; i--) {
			if (array[i].equals(e))
				return i;
		}
		return -1;
	}

	/**
	 * Removes the element at the specified position in this list.
	 *
	 * @param index
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public E remove(int index) {
		if ((index < 0) || (index >= listSize)) {
			throw new IndexOutOfBoundsException("Illegal index");
		}

		E ret = (E)array[index];

		for (int i = index; i < listSize - 1; i++) {
			array[i] = array[i+1];
		}
		listSize--;
		return ret;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present.
	 *
	 * @param e
	 * @return true if an element is removed, false otherwise.
	 */
	@Override
	public boolean remove(E e) {
		int index = indexOf(e);

		if (index == -1) {
			return false;
		}

		remove(index);
		return true;
	}

	/**
	 * Returns the number of elements in this list.
	 */
	@Override
	public int size() {
		return listSize;
	}

	public String toString() {
		String s = "";

		for (int i=0; i < listSize; i++) {
			s += i + ": " + array[i] + "; ";
		}
		return s;
	}
}