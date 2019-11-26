package bca.util;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class BCAStack<E> {
	private ArrayList<E> list = new ArrayList<>();

	public void push(E e) {
		list.add(e);
	}

	public E pop() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return(list.remove(list.size()-1));
	}

	public E peek() {
		if (list.isEmpty()) {
			throw new EmptyStackException();
		}
		return list.get(list.size()-1);
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void clear() {
		list.clear();
	}
}
