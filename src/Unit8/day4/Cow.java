package Unit8.day4;

public class Cow extends Mammal implements WalkingAnimal {
	public String toString() {
		return "I'm a cow, " + super.toString();
	}
	public void walk() {
		System.out.println("Cow walking.");
	}
}
