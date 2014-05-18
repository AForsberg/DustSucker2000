/**
 * @author Anton
 */
public class Room {

	int[][] dimensions = new int[2][2];
	
	
	/**
	 * Constructor sets room dimensions
	 * @param x X-dimension
	 * @param y Y-dimension
	 */
	public Room(int x, int y) {
		dimensions[0] = new int[x];
		dimensions[1] = new int[y];
	}
	
	//Getters & Setters
	public int[][] getRoom() {
		return dimensions;
	}

	public void setRoom(int[][] room) {
		this.dimensions = room;
	}	
	
}
