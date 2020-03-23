package Unit8.day4;

import java.util.ArrayList;

public class Farm {
	public static void main(String[] args) {
		Cow c = new Cow();
		Penguin p = new Penguin();
		Mammal m = new Dolphin();

		// crete objects of type interface
		WalkingAnimal w = c;

		ArrayList<Vertebrate> verts = new ArrayList<>();
		verts.add(c);
		verts.add(p);
		verts.add(m);

		ArrayList<WalkingAnimal> walkers = new ArrayList<>();
		walkers.add(c);
		walkers.add(p);

		
	}
}
