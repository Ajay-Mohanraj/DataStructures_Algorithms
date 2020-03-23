package Unit8.day4;

public class Dolphin extends Mammal implements SwimmingAnimal {
	public String toString() {
		return "I'm a dolphin; " + super.toString();
	}
	public void swim() {
		System.out.println("Dolphin swimming.");
	}
}
