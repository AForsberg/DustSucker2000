/**
 * @author Anton
 *
 */
public class Room {

	int[][] dimensions;
	
	
	/**
	 * Constructor sets room dimensions
	 * @param x X-dimension
	 * @param y Y-dimension
	 */
	public Room(int x, int y) {
		dimensions = new int[x][y];
	}
	
	//Getters & Setters
	public int[][] getRoom() {
		return dimensions;
	}

	public void setRoom(int[][] room) {
		this.dimensions = room;
	}	
	
}
