package Unit8.day4;

public class Penguin extends Bird implements WalkingAnimal, SwimmingAnimal{
	public String toString() {
		return "I'm a penguin, " + super.toString();
	}
	public void walk() {
		System.out.println("Penguin walking.");
	}
	public void swim() {
		System.out.println("Penguin swimming.");
	}
}
