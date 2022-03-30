
public class ExamSchedulerTester {

	public static void main(String[] args) {
		System.out.println("testCourse(): " + testCourse());
		System.out.println("testRoom(): " + testRoom());
		System.out.println("testScheduleAccessors(): " + testScheduleAccessors());
		System.out.println("testAssignCourse(): " + testAssignCourse());
	}

	public static boolean testCourse() {
		// Creating a valid Course Object to test the constructor
		Course obj1 = new Course("CS 300", 900);

		// Testing the get name method
		if (!obj1.getName().equals("CS 300")) {
			return false;
		}

		if (obj1.getNumStudents() != 900) {
			return false;
		}

		// Creating an invalid Course Object to see if an exception is thrown
		try {
			Course obj2 = new Course("CS 300", -65);
			return false;
		}
		// Returning false if an IllegalArgumentException is not thrown and caught
		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}
		// Return false if any other invalid exception other than
		// illegalArgumentException is thrown and caught
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean testRoom() {

		// Creating a valid Course Room Object to test the constructor
		Room obj1 = new Room("Van Vleck 333", 25);

		// Testing the functionality of the getLocation method
		if (!obj1.getLocation().equals("Van Vleck 333")) {
			return false;
		}

		// Testing the functionality of the getCapacity method
		if (obj1.getCapacity() != 25) {
			return false;
		}

		// Testing the functionality of the reduceCapacity method with valid arguments
		obj1 = obj1.reduceCapacity(10);
		if (obj1.getCapacity() != 15) {
			return false;
		}

		// Testing whether an appropriate exception is thrown when reduceCapacity() is
		// called with invalid arguments
		try {
			obj1.reduceCapacity(26);
		}
		// Returning false if an IllegalArgumentException is not thrown and caught
		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}
		// Return false if any other invalid exception other than
		// illegalArgumentException is thrown and caught
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Creating an invalid Room Object to see if an exception is thrown
		try {
			Room obj2 = new Room("Van Vleck 333", -56);
			return false;
		}
		// Returning false if an IllegalArgumentException is not thrown and caught
		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}
		// Return false if any other invalid exception other than
		// illegalArgumentException is thrown and caught
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean testScheduleAccessors() {
		// Creating the room objects
		Room obj1 = new Room("Van Vleck 343", 100);
		Room obj2 = new Room("Van Hise 333", 110);
		Room obj3 = new Room("Birge hall 100", 300);

		// Creating the course objects
		Course obj4 = new Course("CS 400", 105);
		Course obj5 = new Course("Math 222", 100);
		Course obj6 = new Course("English 100", 20);

		Room rooms[] = new Room[] { obj1, obj2, obj3 };
		Course courses[] = new Course[] { obj4, obj5, obj6 };

		Schedule obj7 = new Schedule(rooms, courses);

		if (obj7.getNumRooms() != 3) {
			return false;
		}

		if (obj7.getNumRooms() != 3) {
			return false;
		}

		if (obj7.getRoom(1) != obj2) {
			return false;
		}

		try {
			obj7.getRoom(-1);
			return false;
		}

		catch (IndexOutOfBoundsException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			obj7.getRoom(4);
			return false;
		}

		catch (IndexOutOfBoundsException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		if (obj7.getCourse(2) != obj6) {
			return false;
		}

		try {
			obj7.getCourse(-2);
			return false;
		}

		catch (IndexOutOfBoundsException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		try {
			obj7.getCourse(6);
			return false;
		}

		catch (IndexOutOfBoundsException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Assigning course so we can check the if the course is assigned
		Schedule obj8 = obj7.assignCourse(2, 1);

		// Testing the isAssigned method functionality on an assigned course
		if (obj8.isAssigned(2) != true) {
			return false;
		}

		// Testing the isAssigned method functionality on an unassigned course
		if (obj8.isAssigned(1) != false) {
			return false;
		}

		// Testing the getAssignment method on an assigned course
		if (!obj8.getAssignment(2).getLocation().equals("Van Hise 333")) {
			return false;
		}

		if (obj8.getAssignment(2).getLocation().equals("Van Hise 343")) {
			return false;
		}

		// Testing the getAssignment method on an unassigned course
		try {
			obj8.getAssignment(0);
			return false;
		}

		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// Testing the getAssignment method on an invalid index
		try {
			obj8.getAssignment(0);
			return false;
		}

		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			return false;
		}

		// Testing the isComplete() method
		if (obj8.isComplete() != false) {
			return false;
		}

		obj8 = obj8.assignCourse(1, 2);
		obj8 = obj8.assignCourse(0, 2);

		if (obj8.isComplete() != true) {
			return false;
		}
		return true;
	}

	public static boolean testAssignCourse() {
		// Creating the room objects
		Room obj1 = new Room("Van Vleck 343", 100);
		Room obj2 = new Room("Van Hise 333", 110);
		Room obj3 = new Room("Birge hall 100", 300);

		// Creating the course objects
		Course obj4 = new Course("CS 400", 105);
		Course obj5 = new Course("Math 222", 100);
		Course obj6 = new Course("English 100", 20);

		Room rooms[] = new Room[] { obj1, obj2, obj3 };
		Course courses[] = new Course[] { obj4, obj5, obj6 };

		Schedule obj7 = new Schedule(rooms, courses);
		Schedule obj8 = obj7.assignCourse(2, 1);

		if (obj8.isAssigned(2) != true) {
			return false;
		}

		if (obj8.getRoom(1).getCapacity() != 90) {
			return false;
		}
		// Testing if an IndexOutOfBoundsException is thrown and caught when an invalid
		// index is inputed in
		try {
			obj7.assignCourse(5, 1);
		}

		catch (IndexOutOfBoundsException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			return false;
		}

		// When course is already assigned
		try {
			obj7.assignCourse(2, 2);
		}

		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			return false;
		}

		// When capacity is full
		try {
			obj7.assignCourse(0, 0);
		}

		catch (IllegalArgumentException e) {
			if (e.getMessage() == null || e.getMessage().length() == 0) {
				return false;
			}
		}

		catch (Exception e) {
			return false;
		}
		return true;
	}
}
