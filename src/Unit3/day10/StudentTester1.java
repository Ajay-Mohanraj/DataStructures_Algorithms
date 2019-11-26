package Unit3.day10;

public class StudentTester1 {

	/** Create two student objects using the parameters.
	 * Compare the two students.
	 * Print 1 of the following two messages:
	 a) xxx is less than yyy
	 b) xxx is greater than yyy
	 c) xxx and yyy are equal
	 */
	public static void compareStudents(String name1, String name2,
	                                   int age1, int age2) {
		Student s1 = new Student(name1, age1);
		Student s2 = new Student(name2, age2);
		if (s1.compareTo(s2) == 0) {
			System.out.println(s1 + " and " + s2 + " are equal");
		}
		else if (s1.compareTo(s2) < 0) {
			System.out.println(s1 + " is less than " + s2);
		}
		else {
			System.out.println(s1 + " is greater than " + s2);
		}
	}

	public static void main(String args[]) {
		compareStudents("Steven", "Grace", 16, 12);
		compareStudents("Sam", "Amanda", 11, 15);
		compareStudents("Jessica", "Mark", 13, 13);
		compareStudents("Jason", "Jason", 13, 13);
	}
}

/* Should output:

16: Steven is less than 12: Grace
15: Amanda is greater than 11: Sam
13: Jessica is less than 13: Mark
13: Jason and 13: Jason are equal

 */