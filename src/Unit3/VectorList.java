package Unit3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class VectorList {
	public static void main(String[] args) {
		Random r = new Random(25);
		ArrayList<Vector> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Vector v = new Vector(r.nextInt(360), r.nextInt(50));
			System.out.println(v);
			list.add(v);
		}

		Vector v1 = new Vector(94, 41);
		//System.out.println("index: " + list.indexOf(v1));

		Collections.sort(list);
		for (Vector v : list) {
			System.out.println(v);
		}
	}
}
