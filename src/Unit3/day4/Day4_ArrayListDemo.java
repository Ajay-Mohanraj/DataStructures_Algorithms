package Unit3.day4;

public class Day4_ArrayListDemo {
	public static void main(String[] args) {
		BCAArrayList<String> list = new BCAArrayList<>();

		list.add("Sam");
		list.add("Grace");
		list.add(0, "Sara");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("\nRemoving Sam.");
		list.remove("Sam");

		System.out.println(list);
	}
}
