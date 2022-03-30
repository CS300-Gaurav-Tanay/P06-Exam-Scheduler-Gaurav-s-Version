import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Schedule {

	private Room[] rooms;
	private Course[] courses;
	private int[] assignments;

	public Schedule(Room[] rooms, Course[] courses) {
		this.rooms = rooms;
		this.courses = courses;
		assignments = new int[rooms.length];
		Arrays.fill(assignments, -1);
	}

	private Schedule(Room[] rooms, Course[] courses, int[] assignments) {
		this.rooms = rooms;
		this.courses = courses;
		this.assignments = assignments;
	}

	public int getNumRooms() {
		return rooms.length;
	}

	public Room getRoom(int roomToGet) throws IndexOutOfBoundsException {
		if (roomToGet < 0 || roomToGet >= rooms.length) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return rooms[roomToGet];
	}

	public int getNumCourses() {
		return courses.length;
	}

	public Course getCourse(int courseToGet) throws IndexOutOfBoundsException {
		if (courseToGet < 0 || courseToGet >= rooms.length) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return courses[courseToGet];
	}

	public boolean isAssigned(int assigned) {
		if (assignments[assigned] != -1) {
			return true;
		}
		return false;
	}

	public Room getAssignment(int index) throws IndexOutOfBoundsException, IllegalArgumentException {
		if (index < 0 || index >= assignments.length) {
			throw new IndexOutOfBoundsException("Course index is invalid");
		}

		if (isAssigned(index) == false) {
			throw new IllegalArgumentException("The course has not been assigned a room");
		}

		int roomIndex = assignments[index];
		return rooms[roomIndex];
	}

	public boolean isComplete() {
		for (int i = 0; i < courses.length; i++) {
			if (isAssigned(i) != true) {
				return false;
			}
		}
		return true;
	}

	public Schedule assignCourse(int courseIndex, int roomIndex)
			throws IndexOutOfBoundsException, IllegalArgumentException {

		if ((courseIndex < 0 || courseIndex >= courses.length) || (roomIndex < 0 || roomIndex >= rooms.length)) {
			throw new IndexOutOfBoundsException("Given course or room index is invalid");
		}

		if (this.isAssigned(courseIndex) == true
				|| rooms[roomIndex].getCapacity() < courses[courseIndex].getNumStudents()) {
			throw new IllegalArgumentException("Given course or room index is invalid");
		}
 
		// Making deep copies
		int[] copyAssignments = Arrays.copyOf(assignments, rooms.length);
		Room [] copyRooms = Arrays.copyOf(rooms, rooms.length);

		copyAssignments[courseIndex] = roomIndex;
		copyRooms[roomIndex] = copyRooms[roomIndex].reduceCapacity(courses[courseIndex].getNumStudents());

		Schedule obj1 = new Schedule(copyRooms, courses, copyAssignments);
		// Have to do the toString() part..
		
		//obj1.toString();
		return obj1;
	}
}
