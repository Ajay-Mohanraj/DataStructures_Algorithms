package Unit3;

import Unit3.day4.BCAList;

public class BCALinkedList<E> implements BCAList<E> {
	protected Node<E> head = null;
	protected Node<E> tail = null;
	protected int listSize = 0;
	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e
	 */
	@Override
	public void add(E e) {
		add(listSize, e);
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
		Node n = new Node(e);

		if (index == 0) {
			n.next = head;
			head = n;

			if (listSize == 0) {
				tail = n;
			}
		}
		else if (index == listSize) {
			tail.next = n;
			tail = n;
		}

		else {
			Node<E> p = head;
			for (int i = 1; i < index; i++) {
				p = p.next;
			}
			n.next = p.next;
			p.next = n;
		}
		listSize++;
	}

	/**
	 * Removes all of the elements from this list. This method releases all
	 * references to elements stored in the list so that they can be garbage
	 * collected.
	 */
	@Override
	public void clear() {
		head = null;
		tail = null;
		listSize = 0;
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
	public E get(int index) {
		if (index < 0 || index >= listSize) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		Node<E> n = head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.data;
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
		if (index < 0 || index >= listSize) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
		Node<E> n = head;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		E ret = n.data;
		// e is not a node, it is a data
		n.data = e;
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
		Node<E> n = head;
		int i = 0;
		while (n != null) {
			if (n.data.equals(e)) {
				return i;
			}
			n = n.next;
			i++;
		}
		return -1;
	}

	/**
	 * Returns true if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return (listSize == 0);
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element.
	 *
	 * @param e
	 */
	@Override
	public int lastIndexOf(E e) {
		Node<E> n = head;
		int i = 0;
		int pos = -1;
		while (n != null) {
			if (n.data.equals(e)) {
				pos = i;
			}
			n = n.next;
			i++;
		}
		return pos;
	}


	/**
	 * Removes the element at the specified position in this list.
	 *
	 * @param index
	 * @throws IndexOutOfBoundsException if index is invalid.
	 */
	@Override
	public E remove(int index) {
		if (index < 0 || index >= listSize) {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		E retVal = null;
		if (listSize == 1) {
			retVal = head.data;
			head = null;
			tail = null;
		}

		else if (index == 0) {
			retVal = head.data;
			head = head.next;
		}

		else {
			Node<E> p = head;
			for (int i = 1; i < index; i++) {
				p = p.next;
			}

			retVal = p.next.data;
			p.next = p.next.next;

			if (p.next == null) {
				tail = p;
			}
		}
		listSize--;
		return retVal;
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
		Node<E> n = head;
		String s = "";

		for (int i=0; i < listSize; i++) {
			s += i + ": " + n.data + "; ";
			n = n.next;
		}
		return s;
	}
}

class Node<E> {
	E data = null;
	Node<E> next = null;

	public Node(E e) {
		data = e;
	}
}
