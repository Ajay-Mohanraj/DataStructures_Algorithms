package Unit3.day10;

public class Student implements Comparable<Student>{
	private String name;
	private int age;

	public Student (String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return age + ": " + name;
	}

	/* Implement equals.
	 * Two students are equal if both name and age are equal.
	 */
	public boolean equals(Student student) {
		return (this.name.equals(student.name) && this.age == student.age);
	}

	/* Implement compareTo
	 * Older students come before younger students.
	 * Students of the same age are ordered alphabetically.
	 */
	public int compareTo(Student student) {
		if(this.age>student.age){
			return -1;
		}
		else if(this.age<student.age){
			return 1;
		}
		else{
			return this.name.compareTo(student.name);
		}
	}
}