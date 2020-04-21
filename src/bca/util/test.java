package bca.util;

import Unit8.Vehicle.FordFrivolous;

public class test {
	public static void main(String[] args) {

		FordFrivolous obj = new FordFrivolous(25);
		BCAEntry e = new BCAEntry("b", obj);
		System.out.println(obj.getMileage());
		((FordFrivolous)(e.value)).drive(5);
		System.out.println(((FordFrivolous)(e.value)).getMileage());
		System.out.println(obj.getMileage());
	}
}
