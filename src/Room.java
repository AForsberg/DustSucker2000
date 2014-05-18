/**
 * @author Anton
 */
public class Room {

	int[] dimensions = new int[2];
	
	
	/**
	 * Constructor sets room dimensions
	 * @param x X-dimension
	 * @param y Y-dimension
	 */
	public Room(int x, int y) {
		dimensions[0] = x;
		dimensions[1] = y;
	}
	
	//Getters & Setters
	public int[] getRoom() {
		return dimensions;
	}

	public void setRoom(int[] room) {
		this.dimensions = room;
	}	
	
}
