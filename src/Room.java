public class Room {

	private String location;
	private int capacity;

	public Room(String location, int capacity) throws IllegalArgumentException {

		if (capacity < 0) {
			throw new IllegalArgumentException("The capacity provided is negative");
		}

		this.location = location;
		this.capacity = capacity;
	}

	public String getLocation() {
		return this.location;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public Room reduceCapacity(int capacityToReduce) throws IllegalArgumentException {
		if (capacityToReduce > this.getCapacity()) {
			throw new IllegalArgumentException("The capacity of the room to reduce has exceeded the rooms capacity");	
		}
		
		Room obj1 = new Room(location, this.capacity - capacityToReduce);
		return obj1;
	}
}
