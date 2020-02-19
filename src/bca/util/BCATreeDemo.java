package bca.util;

public class BCATreeDemo {
	public static void main(String[] args) {
		BCABinaryTree<String> tree = new BCABinaryTree<>();
		tree.insert("H");
		tree.insert("C");
		tree.insert("S");
		tree.insert("A");
		tree.insert("E");
		tree.insert("R");
		tree.insert("X");
		System.out.println("Min " + tree.getMinimum());
		System.out.println("Max " + tree.getMaximum());

		System.out.println("Preorder");
		tree.preorder();

		System.out.println("Postorder");
		tree.postorder();

		System.out.println("Inorder");
		tree.inorder();
	}
}
