package Unit8.day4;

abstract class Vertebrate {
	public void celebrateLife() {
		System.out.println("Yeah!");
	}
	public String toString() {
		return "I have a backbone.";
	}
}

abstract class Bird extends Vertebrate {
	public String toString() {
		return super.toString() + ", plus I have feathers, wings, and eggs.";
	}
}

abstract class Mammal extends Vertebrate {
	public String toString() {
		return super.toString() + ", plus I have hair/fur and nurse my young.";
	}
}
interface SwimmingAnimal {
	public void swim();
}

interface FlyingAnimal {
	public void fly();
}

interface WalkingAnimal {
	public void walk();
}
