public class Course {

	private String name;
	private int numStudents;
	
	public Course(String name, int numStudents) throws IllegalArgumentException {
		
		if (numStudents < 0) {
			throw new IllegalArgumentException("The number of Students is negative");
		}
		
		this.name = name;
		this.numStudents = numStudents;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumStudents() {
		return this.numStudents;
	}
}
