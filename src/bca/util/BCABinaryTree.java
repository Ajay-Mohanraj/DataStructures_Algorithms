package bca.util;

public class BCABinaryTree<E extends Comparable<E>> {
	BCATreeNode<E> root = null;
	public BCABinaryTree() {

	}
	public boolean insert(E e) {
		BCATreeNode<E> newNode = new BCATreeNode<>(e);

		if (root == null) {
			root = newNode;
			return true;
		}

		BCATreeNode<E> current = root;
		BCATreeNode<E> parent = root;
		while (current != null) {
			int compare = e.compareTo(current.element);
			if (compare == 0) {
				return false;
			}
			else if (compare < 0) {
				parent = current;
				current = current.left;
			}
			else {
				parent = current;
				current = current.right;
			}
		}
		if (e.compareTo(parent.element) < 0) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}
		return true;
	}

	public E getMinimum() {
		BCATreeNode<E> c = root;
		BCATreeNode<E> p = root;
		while (c != null) {
			p = c;
			c = c.left;
		}
		return p.element;
	}

	public E getMaximum() {
		BCATreeNode<E> c = root;
		while (true) {
			if (c.right == null) {
				return c.element;
			}
			c = c.right;
		}
	}

	public void preorder() {
		preorder(root);
	}

	private void preorder(BCATreeNode<E> n) {
		System.out.println(n.element);
		if (n.left != null) {
			preorder(n.left);
		}
		if (n.right != null) {
			preorder(n.right);
		}
	}
	public void postorder() {
		postorder(root);
	}
	private void postorder(BCATreeNode<E> n) {

		if (n.left != null) {
			postorder(n.left);
		}
		if (n.right != null) {
			postorder(n.right);
		}
		System.out.println(n.element);
	}

	public void inorder() {
		inorder(root);
	}
	public void inorder(BCATreeNode<E> n) {
		if (n.left != null) {
			inorder(n.left);
		}
		System.out.println(n.element);
		if (n.right != null) {
			inorder(n.right);
		}
	}
	public void printTree() {
		printTree(root, ": ", "");
	}
	private void printTree(BCATreeNode<E> n, String side, String indent) {
		System.out.println(indent + side + n.element);
		if (n.left != null) {
			printTree(n.left, "L: ", indent+"  ");
		}
		if (n.right != null) {
			printTree(n.right, "R: ", indent+"  ");
		}
	}
}
